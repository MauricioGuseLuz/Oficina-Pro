package br.com.oficinapro.controller;

import br.com.oficinapro.model.Usuario;
import br.com.oficinapro.service.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    private final UsuarioService usuarioService;

    public LoginController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/")
    public String index() {
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login(Model model) {

        model.addAttribute("usuario", new Usuario());

        return "login";
    }

    @PostMapping("/login")
    public String autenticar(@ModelAttribute("usuario") Usuario usuario,
                             Model model) {

        Usuario usuarioBanco = usuarioService.buscarPorEmail(usuario.getEmail());

        if (usuarioBanco == null) {
            model.addAttribute("erro", "Usuário não encontrado.");
            model.addAttribute("usuario", new Usuario());
            return "login";
        }

        if (!usuarioBanco.getSenha().equals(usuario.getSenha())) {
            model.addAttribute("erro", "Senha inválida.");
            model.addAttribute("usuario", new Usuario());
            return "login";
        }

        System.out.println("LOGIN REALIZADO COM SUCESSO");

        return "redirect:/dashboard";
    }

}