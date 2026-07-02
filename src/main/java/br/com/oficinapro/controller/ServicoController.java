package br.com.oficinapro.controller;

import br.com.oficinapro.model.Servico;
import br.com.oficinapro.service.ServicoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/servicos")
public class ServicoController {

    private final ServicoService service;

    public ServicoController(ServicoService service) {
        this.service = service;
    }

    @GetMapping
    public String listar(Model model) {

        model.addAttribute("servicos", service.listarTodos());

        return "servicos/lista";
    }

    @GetMapping("/novo")
    public String novo(Model model) {

        model.addAttribute("servico", new Servico());

        return "servicos/formulario";
    }

    @PostMapping
    public String salvar(@ModelAttribute Servico servico) {

        service.salvar(servico);

        return "redirect:/servicos";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id,
                         Model model) {

        model.addAttribute("servico",
                service.buscarPorId(id));

        return "servicos/formulario";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {

        service.excluir(id);

        return "redirect:/servicos";
    }

}