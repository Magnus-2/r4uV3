package com.r4u;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * Manage what the Single Roles can See and what
 * the Roles cannot see
 */
@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {

        return new BCryptPasswordEncoder();
    }

    /**
     *Here you can adjust the access for every Page
     * Which a Role can see and what not
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/login", "/resources/**", "/css/**", "/fonts/**", "/img/**").permitAll()
                .antMatchers("/register", "/resources/**", "/css/**", "/fonts/**", "/img/**", "/js/**").permitAll()
                .antMatchers("/users/addNew").permitAll()
                .antMatchers("/security/users").hasAnyAuthority("ADMIN" )
                .antMatchers("/security/roles").hasAnyAuthority("ADMIN" )
                .antMatchers("/reservation/reservationAdd").not().hasAnyAuthority("RESTAURANT")
                .antMatchers("/restaurant/restaurantAdd").hasAnyAuthority("ADMIN", "RESTAURANT" )
                .antMatchers("/restaurant/restaurant/Edit/**").hasAnyAuthority("ADMIN", "RESTAURANT" )
                .antMatchers("/restaurant/delete/**").hasAnyAuthority("ADMIN", "RESTAURANT" )
                .antMatchers("/Alexa").not().authenticated()
                .antMatchers("/Alexa").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login").permitAll()
                .defaultSuccessUrl("/index")
                .and()
                .logout().invalidateHttpSession(true)
                .clearAuthentication(true)
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login").permitAll()
                .and()
                .exceptionHandling().accessDeniedPage("/accessDenied")

        ;
    }

    @Autowired
    private UserDetailsService userDetailsService;



    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();

        provider.setUserDetailsService(userDetailsService);

        provider.setPasswordEncoder(bCryptPasswordEncoder());
        return provider;
    }


}
