package cinema.security;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetailsService;
import cinema.repositories.UserRepository;

public class UserDetailsServiceImpl /*implements UserDetailsService*/ {
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private AuthenticatedUser authenticatedUser;
}
