package br.com.oficinapro.controller;

import org.springframework.ui.Model;

public abstract class BaseController {

    protected void carregarLayout(Model model) {

        model.addAttribute("nomeSistema", "OficinaPro");

    }

}