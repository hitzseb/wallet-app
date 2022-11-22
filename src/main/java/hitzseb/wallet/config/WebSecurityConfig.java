package hitzseb.wallet.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) 
    		throws Exception {
        http.httpBasic().and().cors()
        .and().csrf().disable()
        .authorizeRequests().antMatchers(
        		"/api/v1/registration","/swagger-ui/**", 
                "/swagger-ui.html", "/v3/api-docs/**")
        .permitAll().anyRequest().authenticated()
        .and().formLogin().permitAll()
        .and().logout().permitAll();
        return http.build();
    }
}
