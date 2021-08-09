package br.com.GerenciarCompras;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private DataSource dataSource;
	
	// configuracoes de autorizacao
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
			.antMatchers("/").permitAll()
			.antMatchers("/login").permitAll()
			.antMatchers("/usuarios/novo-usuario").permitAll()
			.anyRequest().authenticated()
			.and()
			.formLogin(form -> {
				form
					.loginPage("/login")
					.defaultSuccessUrl("/usuarios", true)
					.permitAll();
			})
			.logout(logout -> {
				logout
					.logoutUrl("/logout")
					.logoutSuccessUrl("/");
			})
			.csrf().disable();
	}
	
	// configuracao de usuario registrado
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		// verifica no banco de dados se usuario esta cadastrado
		auth
			.jdbcAuthentication()
			.dataSource(dataSource)
			.passwordEncoder(encoder);
	}
}