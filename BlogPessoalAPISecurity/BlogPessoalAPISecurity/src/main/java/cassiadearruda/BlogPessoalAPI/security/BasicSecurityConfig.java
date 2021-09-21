package cassiadearruda.BlogPessoalAPI.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

//-------------------------------------------------------------------------------------------------------------------------------------//
//------------------------------------------------------------SECURITY-----------------------------------------------------------------//
//-------------------------------------------------------------------------------------------------------------------------------------//
@EnableWebSecurity
public class BasicSecurityConfig extends WebSecurityConfigurerAdapter {

//------------------------------------------------------------SECURITY-----------------------------------------------------------------//
	@Autowired
	private UserDetailsService userDetailsService;

//------------------------------------------------------------SECURITY-----------------------------------------------------------------//
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}

//------------------------------------------------------------SECURITY-----------------------------------------------------------------//
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
//------------------------------------------------------------SECURITY-----------------------------------------------------------------//
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/usuario/logar")
			.permitAll().antMatchers("/usuario/cadastrar").permitAll()
			.anyRequest().authenticated()
			.and().httpBasic()
			.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and().cors().and().csrf().disable();
	}
}
