/*
 * Copyright (c) 2019 KrishnakanthYachareni. All rights reserved.
 */

package com.mastercard.demo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        // Credentials from db
        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery(
                        "select username,password, 'true' as enabled from member where username=?")
                .authoritiesByUsernameQuery(
                        "select member.username, member_role.role as authorities FROM member, member_role where member.username=? AND member.id = member_role.member_id");

        // Credential in Local memory
        /*auth.inMemoryAuthentication().
                withUser("user")
                .password("password")
                .authorities("ADMIN_ROLE")
                .and()
                .withUser("krishna")
                .password("password")
                .authorities("USER_ROLE");*/
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("bankapp/list*").hasRole("ADMIN_ROLE")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/user/login")
                .failureUrl("/user/login?error=true")
                .usernameParameter("username")
                .passwordParameter("password")
                .defaultSuccessUrl("/bankapp/list", true)
                .permitAll()
                .and()
                .logout()
                .permitAll();
    }
}