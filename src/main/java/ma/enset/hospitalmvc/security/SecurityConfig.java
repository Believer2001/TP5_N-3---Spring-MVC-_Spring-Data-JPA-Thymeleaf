package ma.enset.hospitalmvc.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    // Bean PasswordEncoder pour l'encodage des mots de passe
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // Bean InMemoryUserDetailsManager pour gérer les utilisateurs en mémoire
   // @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager(PasswordEncoder passwordEncoder) {
        String encodedPassword = passwordEncoder.encode("1234");
        System.out.println("password: " + encodedPassword);
        return new InMemoryUserDetailsManager(
                User.withUsername("user1").password(encodedPassword).roles("USER").build(),
                User.withUsername("user2").password(encodedPassword).roles("USER").build(),
                User.withUsername("admin").password(encodedPassword).roles("USER", "ADMIN").build()
        );
    }
@Bean
public JdbcUserDetailsManager jdbcUserDetailsManager(DataSource dataSource){

 return  new JdbcUserDetailsManager(dataSource);
}


    // Configuration des règles de sécurité HTTP
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .formLogin()
                .loginPage("/login") // Page de connexion personnalisée
                .defaultSuccessUrl("/")
                .permitAll() // Permet l'accès à la page de login à tout le monde
                .and()
                .authorizeHttpRequests()
                .requestMatchers("/webjars/**").permitAll() // Autoriser l'accès aux ressources statiques
                .requestMatchers("/deletePatient/**").hasRole("ADMIN") // Accès réservé aux administrateurs
                .requestMatchers("/admin/**").hasRole("ADMIN") // Accès réservé aux administrateurs
                .requestMatchers("/user/**").hasRole("USER") // Accès réservé aux utilisateurs
                .anyRequest().authenticated() // Toutes les autres requêtes nécessitent une authentification
                .and()
                .exceptionHandling()
                .accessDeniedPage("/notAuthorized"); // Page d'accès refusé

        return httpSecurity.build();
    }
}
