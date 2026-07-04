package br.com.oficinapro.controller;

import br.com.oficinapro.model.Cliente;
import br.com.oficinapro.service.ClienteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public String listar(Model model) {

        model.addAttribute("clientes", clienteService.listarTodos());

        return "clientes/lista";
    }

    @GetMapping("/novo")
    public String novo(Model model) {

        model.addAttribute("cliente", new Cliente());

        return "clientes/formulario";
    }

    @PostMapping
    public String salvar(@ModelAttribute Cliente cliente) {

        if (cliente.getId() != null) {

            Cliente clienteBanco = clienteService.buscarPorId(cliente.getId());

            clienteBanco.setNome(cliente.getNome());
            clienteBanco.setTelefone(cliente.getTelefone());
            clienteBanco.setCpf(cliente.getCpf());
            clienteBanco.setEmail(cliente.getEmail());

            clienteService.salvar(clienteBanco);

        } else {

            clienteService.salvar(cliente);

        }

        return "redirect:/clientes";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {

        Cliente cliente = clienteService.buscarPorId(id);

        model.addAttribute("cliente", cliente);

        return "clientes/formulario";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {

        clienteService.excluir(id);

        return "redirect:/clientes";
    }

}
