package com.bancopichincha.infraestructure.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig  extends WebSecurityConfigurerAdapter {

    @Autowired
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        String moduleName = "/cuentas/**";
        String moduleClientes = "/clientes/**";
        String moduleMovimientos = "/movimientos/**";
        String swaggerPage = "/swagger-ui.html#/**";
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.PUT,
                        moduleName,moduleClientes,moduleMovimientos,swaggerPage)
                .permitAll()
                .antMatchers(HttpMethod.GET,
                        moduleName,moduleClientes,moduleMovimientos,swaggerPage)
                .permitAll()
                .antMatchers(HttpMethod.OPTIONS,
                        moduleName,moduleClientes,moduleMovimientos)
                .permitAll()
                .antMatchers(HttpMethod.POST,
                        moduleName,moduleClientes,moduleMovimientos,swaggerPage)
                .permitAll()
                .antMatchers("/v2/api-docs",
                        "/configuration/ui",
                        "/swagger-resources/**",
                        "/configuration/security",
                        "/swagger-ui.html",
                        "/webjars/**").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .headers().contentSecurityPolicy("script-src 'self'");
    }
}
