//package com.example.UserApp.security;
//
//
//import com.example.UserApp.Filter.UserAuthenticationFilter;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
////@NoArgsConstructor
//@Configuration @EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    private UserDetailsService userDetailsService;
//
//  @Bean
//    public PasswordEncoder passwordEncoder() {
//        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//
//        return bCryptPasswordEncoder;
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//
//        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
//    }
//
////    @Override
////    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
////        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
////    }
//
////    @Override
////    public void configure(WebSecurity web) throws Exception {
////        web
//////                .ignoring()
//////                .antMatchers("/resources/**"); // #3
////        web.ignoring().antMatchers("/authFailure");
////    }
////    @Autowired
////public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
////    auth
////            .inMemoryAuthentication()
////            .withUser("user")  // #1
////            .password("password")
////            .roles("USER")
////            .and()
////            .withUser("admin") // #2
////            .password("password")
////            .roles("ADMIN","USER");
////}
//
////cors().disable()
//    //antMatchers("/login", "/signup", "/")
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
////              http.csrf().disable();
////        http.authorizeRequests()
////                .antMatchers("/authFailure")
////                .permitAll()
////                .anyRequest()
////                .authenticated()
////                .and()
////                .formLogin().and()
////                .httpBasic()
////                .and()
////                .sessionManagement()
////                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//
////        defaultSuccessUrl("/start/profile", true).failureUrl("/start/error")
//
//        http.csrf().disable();
//        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//        http.authorizeRequests().anyRequest().permitAll();
//        http.addFilter(new UserAuthenticationFilter(authenticationManagerBean()));
//
////                .anyRequest().authenticated().and().formLogin().loginPage("/login").loginProcessingUrl("/perform_login")
////                .defaultSuccessUrl("/profile", true).failureUrl("/error").and().logout().logoutUrl("/perform_logout")
////                .deleteCookies("JSESSIONID");
//
////        http
////                .authorizeRequests()
////                .antMatchers("/signup","/about").permitAll() // #4
////                .antMatchers("/admin/**").hasRole("ADMIN") // #6
////                .anyRequest().authenticated() // 7
////                .and()
////                .formLogin()  // #8
////                .permitAll(); // #5
//    }
//
//    @Bean
//    @Override
//    public AuthenticationManager authenticationManagerBean() throws Exception{
//        return super.authenticationManagerBean();
//    }
//
//
////  @Autowired
////  public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
////    auth
////      .inMemoryAuthentication()
////        .withUser("user").password("password").roles("USER");
////  }
//
////@Autowired
////public void configureGlobal(AuthenticationManagerBuilder auth) {
////    auth
////            .inMemoryAuthentication()
////            .withUser("user")  // #1
////            .password("password")
////            .roles("USER")
////            .and()
////            .withUser("admin") // #2
////            .password("password")
////            .roles("ADMIN","USER");
////}
//
//
//}
