package tw.shop.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.config.oauth2.client.CommonOAuth2Provider;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Configuration
public class SecurityConfig extends WebSecurityConfiguration {

	   @Autowired
	   FirebaseAuthenticationTokenFilter firebaseAuthenticationTokenFilter;
		    
	   protected void configure(HttpSecurity http) throws Exception {
		        http
		            .authorizeRequests()
		                .requestMatchers("/", "/home").permitAll()
		                .anyRequest().authenticated()
		                .and()
		            .oauth2Login()
		                .loginPage("/login")
		                .defaultSuccessUrl("/user")
		                .and()
		            .logout()
		                .logoutSuccessUrl("/")
		                .permitAll();
		    }

    @Bean
    public ClientRegistrationRepository clientRegistrationRepository() {
        List<ClientRegistration> registrations = Arrays.asList(
            customOAuth2Provider("google", "/login/google", "google-client-id", "google-client-secret"),
            customOAuth2Provider("github", "/login/github", "github-client-id", "github-client-secret"),
            customOAuth2Provider("facebook", "/login/facebook", "facebook-client-id", "facebook-client-secret")
        );

        return new InMemoryClientRegistrationRepository(registrations);
    }

    private ClientRegistration customOAuth2Provider(String provider, String redirectUri, String clientId, String clientSecret) {
        return CommonOAuth2Provider.GITHUB
            .getBuilder(provider)
            .clientId(clientId)
            .clientSecret(clientSecret)
            .redirectUri(redirectUri)
            .build();
    }
    
    
}
