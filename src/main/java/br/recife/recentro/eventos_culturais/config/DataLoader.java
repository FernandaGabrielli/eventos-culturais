package br.recife.recentro.eventos_culturais.config;

import br.recife.recentro.eventos_culturais.entity.Usuario;
import br.recife.recentro.eventos_culturais.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner carregarUsuarioAdmin(UsuarioRepository usuarioRepository) {
        return args -> {
            if (usuarioRepository.findByUsername("admin").isEmpty()) {
                var encoder = new BCryptPasswordEncoder();
                Usuario admin = new Usuario();
                admin.setUsername("admin");
                admin.setPassword(encoder.encode("123456"));
                admin.setRoles("ROLE_ADMIN,ROLE_USER");
                usuarioRepository.save(admin);
                System.out.println("✅ Usuário admin criado com sucesso!");
            }
        };
    }
}
