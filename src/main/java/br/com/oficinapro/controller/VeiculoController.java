package br.com.oficinapro.controller;

import br.com.oficinapro.model.Veiculo;
import br.com.oficinapro.service.ClienteService;
import br.com.oficinapro.service.VeiculoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/veiculos")
public class VeiculoController {

    private final VeiculoService veiculoService;
    private final ClienteService clienteService;

    public VeiculoController(VeiculoService veiculoService,
                             ClienteService clienteService) {

        this.veiculoService = veiculoService;
        this.clienteService = clienteService;
    }

    @GetMapping
    public String listar(Model model) {

        model.addAttribute("veiculos", veiculoService.listarTodos());

        return "veiculos/lista";
    }

    @GetMapping("/novo")
    public String novo(Model model) {

        model.addAttribute("veiculo", new Veiculo());
        model.addAttribute("clientes", clienteService.listarTodos());

        return "veiculos/formulario";
    }

    @PostMapping
    public String salvar(@ModelAttribute Veiculo veiculo,
                         @RequestParam("cliente") Long clienteId) {

        veiculo.setCliente(clienteService.buscarPorId(clienteId));

        veiculoService.salvar(veiculo);

        return "redirect:/veiculos";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id,
                         Model model) {

        model.addAttribute("veiculo",
                veiculoService.buscarPorId(id));

        model.addAttribute("clientes",
                clienteService.listarTodos());

        return "veiculos/formulario";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {

        veiculoService.excluir(id);

        return "redirect:/veiculos";
    }

}