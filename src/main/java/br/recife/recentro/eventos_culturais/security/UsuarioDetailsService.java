package br.recife.recentro.eventos_culturais.security;

import br.recife.recentro.eventos_culturais.entity.Usuario;
import br.recife.recentro.eventos_culturais.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service
public class UsuarioDetailsService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado: " + username));
        return new User(
                usuario.getUsername(),
                usuario.getPassword(),
                AuthorityUtils.commaSeparatedStringToAuthorityList(usuario.getRoles())
        );
    }
}
