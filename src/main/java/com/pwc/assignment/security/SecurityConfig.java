package com.pwc.assignment.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    CustomUserDetailsService customUserDetailsService;

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(customUserDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
        auth.inMemoryAuthentication()
                .withUser("admin").password(passwordEncoder().encode("adminPass"))
                .authorities("ADMIN");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    public CustomUserDetailsService customUserDetailsService() {
        return new CustomUserDetailsService();
    }

    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/login", "/register", "/")
                .permitAll()
                .antMatchers("/").hasAuthority("USER")
                .anyRequest()
                .authenticated()
                .and()
                .userDetailsService(customUserDetailsService)
                //Login configurations
                .exceptionHandling()
                .accessDeniedPage("/403")
                .and()
                .formLogin().defaultSuccessUrl("/")
                .loginPage("/login")
                .failureUrl("/login?error=true")
                //Logout configurations
                .and()
                .logout()
                .logoutSuccessUrl("/");


        http.authorizeRequests().antMatchers("/admin/**").hasAuthority("ROLE_ADMIN");
        http.csrf().disable().headers().frameOptions().disable();
    }
}
