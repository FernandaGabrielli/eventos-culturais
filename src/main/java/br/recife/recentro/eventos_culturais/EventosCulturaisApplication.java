package br.recife.recentro.eventos_culturais;

import br.recife.recentro.eventos_culturais.entity.Usuario;
import br.recife.recentro.eventos_culturais.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class EventosCulturaisApplication {

    public static void main(String[] args) {
        SpringApplication.run(EventosCulturaisApplication.class, args);
    }

    @Bean
    CommandLineRunner init(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            String usernameAdmin = "admin";
            if (usuarioRepository.findByUsername(usernameAdmin).isEmpty()) {
                Usuario admin = new Usuario(
                    usernameAdmin,
                    passwordEncoder.encode("admin"),  
                    "ROLE_ADMIN"
                );
                usuarioRepository.save(admin);
                System.out.println("Usuário admin criado: admin/admin");
            }
        };
    }
}
