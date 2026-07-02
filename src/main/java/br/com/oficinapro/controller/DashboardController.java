package br.com.oficinapro.controller;

import br.com.oficinapro.service.ClienteService;
import br.com.oficinapro.service.ServicoService;
import br.com.oficinapro.service.VeiculoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    private final ClienteService clienteService;
    private final VeiculoService veiculoService;
    private final ServicoService servicoService;

    public DashboardController(ClienteService clienteService,
                               VeiculoService veiculoService,
                               ServicoService servicoService) {

        this.clienteService = clienteService;
        this.veiculoService = veiculoService;
        this.servicoService = servicoService;
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {

        model.addAttribute("totalClientes",
                clienteService.listarTodos().size());

        model.addAttribute("totalVeiculos",
                veiculoService.listarTodos().size());

        model.addAttribute("totalServicos",
                servicoService.listarTodos().size());

        return "dashboard";
    }

}