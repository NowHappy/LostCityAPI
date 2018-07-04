package com.happy.game.lostcity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

import com.happy.game.lostcity.common.CustomAuthenticationEntryPoint;
import com.happy.game.lostcity.common.CustomOAuthExceptionHandler;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter{

	private static final String RESOURCE_ID = "lostcity_manage_resources";
	private static final String USER_ROLE = "#oauth2.hasAuthority('USER')";
	
	@Autowired
    private CustomOAuthExceptionHandler customOAuthExceptionHandler;

    @Autowired
    private CustomAuthenticationEntryPoint customAuthenticationEntryPoint;

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {

        // jdbc token store
        resources.resourceId(RESOURCE_ID).stateless(false);
        resources.authenticationEntryPoint(customAuthenticationEntryPoint);
        resources.accessDeniedHandler(customOAuthExceptionHandler);

        /*
        // jwt token store
        resources.resourceId(RESOURCE_ID).stateless(false)
                    .tokenServices(tokenServices());
        */
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.
                authorizeRequests()
                .antMatchers(HttpMethod.POST, "/api/1.0/users").anonymous()
                .antMatchers(HttpMethod.PATCH, "/api/1.0/users/**/pwd").anonymous()
                .antMatchers(HttpMethod.PUT, "/api/1.0/users/**/pwd").access(USER_ROLE)
                .antMatchers(HttpMethod.PATCH, "/api/1.0/users/**").anonymous()
                .antMatchers(HttpMethod.GET, "/api/1.0/users").access(USER_ROLE)
                .antMatchers("/api/1.0/users/**").access(USER_ROLE)
                .antMatchers("/api/1.0/apps/**").access(USER_ROLE)
                .antMatchers("/api/1.0/coins/**").access(USER_ROLE)
                .antMatchers("/api/1.0/wallets/**").access(USER_ROLE)
                .anyRequest().permitAll();
    }
    
}
