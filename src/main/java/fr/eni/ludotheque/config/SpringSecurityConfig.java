package fr.eni.ludotheque.config;

import fr.eni.ludotheque.config.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.web.SecurityFilterChain;




    @Configuration
    @EnableWebSecurity
    public class SpringSecurityConfig {

        @Bean
        public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
            return http.authorizeHttpRequests(auth -> {
//                        return http.csrf().disable().authorizeHttpRequests(auth ->{
                // Routes spécifiques d'administration
                auth.requestMatchers("/jeux/creer").hasRole("ADMIN");
                auth.requestMatchers("/jeux/{id}/edition").hasRole("ADMIN");
                auth.requestMatchers("/jeux/{id}/suppression").hasRole("ADMIN");
                auth.requestMatchers("/exemplaires/{id}/creer").hasRole("ADMIN");

                // Routes des employés et des administrateurs
                auth.requestMatchers("/clients/ajout").hasAnyRole("EMPLOYE", "ADMIN");
                auth.requestMatchers("/clients").hasAnyRole("EMPLOYE", "ADMIN");
                auth.requestMatchers("/clients/delete/**").hasAnyRole("EMPLOYE", "ADMIN");
                auth.requestMatchers("/clients/modif/**").hasAnyRole("EMPLOYE", "ADMIN");

                // Routes accessibles à tous les rôles
                auth.requestMatchers("/loations").hasAnyRole("EMPLOYE", "ADMIN", "UTILISATEUR");
                auth.requestMatchers("/locations/{id}/ajoutloc").hasAnyRole("EMPLOYE", "ADMIN", "UTILISATEUR");
                auth.requestMatchers("/jeux/{id}/detail").hasAnyRole("EMPLOYE", "ADMIN", "UTILISATEUR");
                auth.requestMatchers("/jeux/{id}/detail").hasAnyRole("EMPLOYE", "ADMIN", "UTILISATEUR");
                auth.requestMatchers("/jeux").hasAnyRole("EMPLOYE", "ADMIN", "UTILISATEUR");
                auth.requestMatchers("/chiffrer").hasAnyRole("EMPLOYE", "ADMIN", "UTILISATEUR");
                auth.requestMatchers("/").hasAnyRole("EMPLOYE", "ADMIN", "UTILISATEUR");

                // Toute autre requête doit être authentifiée
                auth.anyRequest().authenticated();
            }).formLogin(Customizer.withDefaults()).build();
        }
//        @Bean
//        public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//            http
//                    .authorizeRequests()
//                    .anyRequest().permitAll() // Autorise toutes les requêtes sans restriction
//                    .and()
//                    .csrf().disable(); // Désactive la protection CSRF si nécessaire
//            return http.build();
//        }

        //        @Bean
//        public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//            return http.authorizeHttpRequests((requests)-> requests
//                    .requestMatchers(HttpMethod.GET,"/jeu/creer").hasRole("ROLE_ADMIN")
//                    .requestMatchers("/jeu/{id}/edition").hasRole("ROLE_ADMIN")
//                    .requestMatchers("/jeu/{id}/suppression").hasRole("ROLE_ADMIN")
//                    .requestMatchers("/exemplaires/{id}/creer").hasRole("ROLE_ADMIN")
//                    .requestMatchers("/clients").hasAnyRole("ROLE_EMPLOYE", "ROLE_ADMIN")
//                    .requestMatchers("/jeu/{id}/detail").hasAnyRole("ROLE_EMPLOYE", "ROLE_ADMIN", "ROLE_UTILISATEUR")
//                    .requestMatchers("/jeux").hasAnyRole("ROLE_EMPLOYE", "ROLE_ADMIN", "ROLE_UTILISATEUR")
//                    .requestMatchers("/").hasAnyRole("ROLE_EMPLOYE", "ROLE_ADMIN", "ROLE_UTILISATEUR")
//                    .requestMatchers(HttpMethod.POST).hasAnyRole("ROLE_EMPLOYE", "ROLE_ADMIN")
//                    .anyRequest().authenticated()
//            )
//                    .formLogin(Customizer.withDefaults()).build();
//        }

        @Autowired
        private CustomUserDetailsService customUserDetailsService;

        @Bean
        public BCryptPasswordEncoder passwordEncoder() {
            return new BCryptPasswordEncoder();
        }

        @Bean
        public AuthenticationManager authenticationManager(HttpSecurity http, BCryptPasswordEncoder bCryptPasswordEncoder) throws Exception {
            AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
            authenticationManagerBuilder.userDetailsService(customUserDetailsService).passwordEncoder(bCryptPasswordEncoder);
            return authenticationManagerBuilder.build();
        }
    }
