package br.com.treinamento.spring_security.mudy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//	@Autowired
//	private DataSource dataSource;
//
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
//		.antMatchers("/home/**")
//			.permitAll()
		.anyRequest()
			.authenticated()
		.and()
			.formLogin(form -> form
				.loginPage("/login")
				//.defaultSuccessUrl("/usuario/pedido", true)
				.permitAll()
        );
//		.logout(logout -> {
//			logout.logoutUrl("/logout")
//				.logoutSuccessUrl("/home");
//		}).csrf().disable();
	}

	@Bean
	@Override
	protected UserDetailsService userDetailsService() {
		UserDetails user =
				User.withDefaultPasswordEncoder()
						.username("jean")
						.password("jean")
						.roles("ADM")
						.build();
		return new InMemoryUserDetailsManager(user);
	}
//
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//		auth
//			.jdbcAuthentication()
//			.dataSource(dataSource)
//			.passwordEncoder(encoder);
//
//		UserDetails user =
//				 User.builder()
//					.username("jean")
//					.password("jean")
//					.password(encoder.encode("maria"))
//					.roles("ADM")
//					.build();
//	}
	
}
