//package com.bb2.Products_ApiRest.Configs;
//
//
//import com.bb2.Products_ApiRest.Enums.RoleEnum;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//
//@Configuration
//@EnableWebSecurity
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//    //Configuración de seguridad de la api
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/hello/").permitAll() //Para probar con endpoint hello/
//                .antMatchers("/users/**").permitAll() //Para poder registrar un usuario
//                .antMatchers("/h2-console/**").permitAll() //Para poder registrar un producto
//                .antMatchers("/hello/authUserPrueba").hasRole(String.valueOf(RoleEnum.USER))
//                .antMatchers("/hello/authAdminPrueba").hasRole(String.valueOf(RoleEnum.ADMIN))
//                .anyRequest().permitAll() //.authenticated()
//                .and().formLogin().and().httpBasic();
//        http.csrf().and().cors().disable();
//    }
//
//    //Configuración de la autenticación usuarios, contraseñas y roles
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .passwordEncoder(passwordEncoder())//En esta línea indicamos que codifique el password
//                .withUser("user").password(passwordEncoder().encode("password")).roles(String.valueOf(RoleEnum.USER))
//                .and()
//                .withUser("admin").password(passwordEncoder().encode("password")).roles(String.valueOf(RoleEnum.USER),String.valueOf(RoleEnum.ADMIN));
////                .and()
////                .withUser(buscarUsuarioEnBdd()).password(passwordEncoder().encode("password")).roles(String)
//    }
//
//    //Para codificar las contraseñas
//    @Bean
//    public BCryptPasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder();
//    }
//}
