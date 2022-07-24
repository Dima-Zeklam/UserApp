package com.example.UserApp.security;


import com.example.UserApp.Filter.UserAuthenticationFilter;
import com.example.UserApp.Filter.UserAuthorizationFilter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@Configuration
@EnableWebSecurity
@NoArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private PasswordEncoder passwordEncoder;

//  @Bean
//    public PasswordEncoder passwordEncoder() {
//        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//
//        return bCryptPasswordEncoder;
//    }
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
//    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder.bCryptPasswordEncoder());
    }

//    @Autowired
//public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//    auth
//            .inMemoryAuthentication()
//            .withUser("user")  // #1
//            .password("password")
//            .roles("USER")
//            .and()
//            .withUser("admin") // #2
//            .password("password")
//            .roles("ADMIN","USER");
//}


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        UserAuthenticationFilter userAuthenticationFilter = new UserAuthenticationFilter(authenticationManagerBean());
        userAuthenticationFilter.setFilterProcessesUrl("/api/login");
        http.csrf().disable();
        //cors().disable()
        // http.formLogin().and()
        http.sessionManagement().sessionCreationPolicy(STATELESS);
        //http.authorizeRequests().antMatchers("**").permitAll();
        http.authorizeRequests().antMatchers("/api/login/**", "/api/token/refresh/**").permitAll();
        http.authorizeRequests().antMatchers(GET, "/api/users/**").hasAnyAuthority("ROLE_USER");
        http.authorizeRequests().antMatchers(POST, "/api/user/save/**").hasAnyAuthority("ROLE_ADMIN");
        http.addFilter(userAuthenticationFilter);
        http.addFilterBefore(new UserAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);

    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }


//                .anyRequest().authenticated().and().formLogin().loginPage("/login").loginProcessingUrl("/perform_login")
//                .defaultSuccessUrl("/profile", true).failureUrl("/error").and().logout().logoutUrl("/perform_logout")
//                .deleteCookies("JSESSIONID");

}


//  @Autowired
//  public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//    auth
//      .inMemoryAuthentication()
//        .withUser("user").password("password").roles("USER");
//  }

//@Autowired
//public void configureGlobal(AuthenticationManagerBuilder auth) {
//    auth
//            .inMemoryAuthentication()
//            .withUser("user")  // #1
//            .password("password")
//            .roles("USER")
//            .and()
//            .withUser("admin") // #2
//            .password("password")
//            .roles("ADMIN","USER");
//}

//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web
////                .ignoring()
////                .antMatchers("/resources/**"); // #3
//        web.ignoring().antMatchers("/authFailure");
//    }
