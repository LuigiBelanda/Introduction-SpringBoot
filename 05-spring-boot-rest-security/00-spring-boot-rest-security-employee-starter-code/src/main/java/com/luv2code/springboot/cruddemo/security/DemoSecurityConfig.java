package com.luv2code.springboot.cruddemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class DemoSecurityConfig {
    // Add support for JDBC ... no more hardcoded users
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        /*
        *   O código abaixo serve para configurar os usuários e acessos que eles tem
        *   Pois não estamos usando o schema padrão que o Spring entende para pegar os dados
        *   Dos nossos usuário e quais os seus acessos liberado no banco de dados
        *   Então temos que adicionar o código abaixo para ele conseguir pegar as infos
        *   Das tabelas que estamos usando
        */

        // Define query to retrieve a user by username
        // Using a regular SQL
        jdbcUserDetailsManager.setUsersByUsernameQuery("select user_id, pw, active from members where user_id=?");

        // Define query to retrieve the authorities/roles by username
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("select user_id, role from roles where user_id=?");

        return jdbcUserDetailsManager;
    }

    /*
    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {

        // Criando um user para acesso as rotas
        // {noop} - salva a senha em plain text
        UserDetails john = User.builder()
                .username("john")
                .password("{noop}test123")
                .roles("EMPLOYEE")
                .build();

        UserDetails mary = User.builder()
                .username("mary")
                .password("{noop}test123")
                .roles("EMPLOYEE", "MANAGER")
                .build();

        UserDetails susan = User.builder()
                .username("susan")
                .password("{noop}test123")
                .roles("EMPLOYEE", "MANAGER", "ADMIN")
                .build();

        return new InMemoryUserDetailsManager(john, mary, susan);
    }
    */

    // Após criamos nossos users para garantir um acesso seguro as rotas
    // Agora iremos adicionar um filtro nas rotas, permitindo apenas alguns users acessar
    // Determinadas rotas
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests( configurer -> configurer
                // Neste estamos dizendo que todos as request GET, para a URL /api/employees os usuários com acesso EMPLOYEE podem acessar normalmente
                .requestMatchers(HttpMethod.GET, "/api/employees").hasRole("EMPLOYEE")
                // Usando o ** (/api/employees/**) - damos acesso a todas as sub rotas
                .requestMatchers(HttpMethod.GET, "/api/employees/**").hasRole("EMPLOYEE")
                .requestMatchers(HttpMethod.POST, "/api/employees").hasRole("MANAGER")
                .requestMatchers(HttpMethod.PUT, "/api/employees").hasRole("MANAGER")
                .requestMatchers(HttpMethod.DELETE, "/api/employees/**").hasRole("ADMIN")
        );

        // Use HTTP Basic Auth
        http.httpBasic();

        // Disable Corss Site Request Forgery (CSRF)
        // In general, not required for stateless REST APIs that use POST, PUT, DELETE and/or PATH
        http.csrf().disable();

        return http.build();
    }
}
