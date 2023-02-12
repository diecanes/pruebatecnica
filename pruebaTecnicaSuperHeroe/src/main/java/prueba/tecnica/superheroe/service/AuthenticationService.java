package prueba.tecnica.superheroe.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import prueba.tecnica.superheroe.model.Usuario;
import prueba.tecnica.superheroe.repository.UserRepository;

@Service
public class AuthenticationService implements UserDetailsService {

    @Autowired
    private UserRepository accountRepository;

    @Override
    public User loadUserByUsername(String userName) throws UsernameNotFoundException {
        Usuario u = accountRepository.findByNombre(userName);
        System.out.println(u.toString());
        if(u == null){
            throw new UsernameNotFoundException("Utilisateur non trouvé : " + userName);
        }

        User user = createUser(u);

        return user;
    }

    private User createUser(Usuario u) {
        return new User(u.getNombre(), u.getContrasena(), createAuthorities(u));
    }

    private Collection<GrantedAuthority> createAuthorities(Usuario u) {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_"+u.getRol()));
        return  authorities;
    }
}