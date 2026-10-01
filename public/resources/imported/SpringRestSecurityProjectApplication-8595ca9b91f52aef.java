package example.spring.rest.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@SpringBootApplication
public class SpringRestSecurityProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRestSecurityProjectApplication.class, args);
	}
	
	//Configuring users
	@Bean
	public UserDetailsService getUserDetailsService() {
		UserDetails user1 = 
				User.
				withUsername("Jack").
				password(encoder().encode("jack@123")).
				roles("ADMIN").build();
		
		UserDetails user2 = 
				User.
				withUsername("James").
				password(encoder().encode("james@123")).
				roles("USER").build();
		
		UserDetailsService userDetailsServiceRef = 
		new InMemoryUserDetailsManager(user1, user2);
		
		return userDetailsServiceRef;
	}
	
	@Bean
	public BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder(7);
	}
	
	@Bean
	public SecurityFilterChain 
	getSecurityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(
				auth -> auth.requestMatchers("/home").permitAll()
				.requestMatchers("/regular").hasAnyRole("USER","ADMIN")
				.requestMatchers("/admin").hasAnyRole("ADMIN")
				.anyRequest().authenticated()
				);
		http.formLogin(Customizer.withDefaults());
		http.httpBasic(Customizer.withDefaults());
		http.csrf(csrf->csrf.disable());
		return http.build();
	}
}









