package tdi.bootcamp.training.springweb.perpusspringweb.config;


import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .passwordEncoder(passwordEncoder())
                .withUser("admin").password(passwordEncoder().encode("admin")).roles("ADMIN", "USER")
                .and()
                .withUser("bambang").password(passwordEncoder().encode("bimbang")).roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        super.configure(http);
        http.authorizeRequests()
                .antMatchers("/api/penerbit/**").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
//                .formLogin()
//                .loginPage("/signin")
//                .usernameParameter("username")
//                .passwordParameter("passwd")
//                .loginProcessingUrl("/process-sign-in")
//                .successForwardUrl("/")
//                .permitAll()
//                .and().logout().permitAll();
                .httpBasic();

    }
}
