package com.r4u.security.services;

import com.r4u.security.models.User;
import com.r4u.security.models.UserPrincipal;
import com.r4u.security.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Is the Service for the Current User Details
 */
@Primary
@Service
public class MyUserDetailsService implements UserDetailsService {
    /**
     * Tells Spring to connect with
     * the UserRepository
     */
    @Autowired
    private UserRepository userRepository;

    /**
     * Gives back a Username based on a Username
     * If the Username would not be found we get an exception
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found!");
        }
        return new UserPrincipal(user);
    }
}
