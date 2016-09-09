package com.cc.config;

import com.cc.constants.UserRoleEnum;
import com.cc.service.MyAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

/**
 * Created by Administrator on 2016/8/25.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    public static final String PASSWORD = "123321";
    public static final String USERNAME = "cc";
    @Autowired
    private MyAuthenticationProvider myAuthenticationProvider;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/", "/index", "/css/*", "/images/*", "icons/*", "themes/*", "/js/*", "/upload/*", "/file/files/*", "/vote/*").permitAll()
                .antMatchers("/manage/**").hasAuthority(UserRoleEnum.admin.name())
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/manage/candidate/index")
                .failureUrl("/login?error")
                .usernameParameter("username")
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/logout")
                .deleteCookies("remember-me")
                .logoutSuccessUrl("/")
                .permitAll()
                .and()
                .rememberMe();
        //解决跨域、同域名显示信息
        http.csrf().disable();
        http.headers().frameOptions().disable();
    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(myUserDetailService);
//    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(myAuthenticationProvider);
        auth.inMemoryAuthentication()
                .withUser(USERNAME).password(PASSWORD).roles(UserRoleEnum.admin.name())
                .authorities(new SimpleGrantedAuthority(UserRoleEnum.admin.name()));
    }
}
