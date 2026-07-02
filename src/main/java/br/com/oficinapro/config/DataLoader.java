package br.com.oficinapro.config;

import br.com.oficinapro.model.Usuario;
import br.com.oficinapro.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final UsuarioRepository repository;

    public DataLoader(UsuarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) {

        if (repository.count() == 0) {

            Usuario admin = new Usuario();

            admin.setNome("Administrador");
            admin.setEmail("admin@oficinapro.com");
            admin.setSenha("123456");
            admin.setAtivo(true);

            repository.save(admin);

            System.out.println("Administrador criado com sucesso.");
        }

    }

}