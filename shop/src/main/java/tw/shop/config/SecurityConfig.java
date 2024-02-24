package tw.shop.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.SecurityBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.config.oauth2.client.CommonOAuth2Provider;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.oauth2.client.*;


@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Configuration
public class SecurityConfig implements WebSecurityConfigurer {

	   @Autowired
	   FirebaseAuthenticationTokenFilter firebaseAuthenticationTokenFilter;
	   
	   @Value("${spring.security.oauth2.client.registration.google.client-id}")
	    private String googleClientId;

	    @Value("${spring.security.oauth2.client.registration.google.client-secret}")
	    private String googleClientSecret;

	    @Value("${spring.security.oauth2.client.registration.github.client-id}")
	    private String githubClientId;

	    @Value("${spring.security.oauth2.client.registration.github.client-secret}")
	    private String githubClientSecret;

	    @Value("${spring.security.oauth2.client.registration.facebook.client-id}")
	    private String facebookClientId;

	    @Value("${spring.security.oauth2.client.registration.facebook.client-secret}")
	    private String facebookClientSecret;
		    
	   public void configure(HttpSecurity http) throws Exception {
	        http
	            .authorizeRequests(authorizeRequests ->
	                authorizeRequests
	                    .requestMatchers("/", "/home").permitAll()
	                    .anyRequest().authenticated()
	            )
	            .oauth2Login(oauth2Login ->
	                oauth2Login
	                    .loginPage("/login")
	                    .defaultSuccessUrl("/user")
	            )
	            .logout(logout ->
	                logout
	                    .logoutSuccessUrl("/")
	                    .permitAll()
	            );
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
        switch(provider.toLowerCase()) {
            case "google":
                return CommonOAuth2Provider.GOOGLE
                        .getBuilder(provider)
                        .clientId(clientId)
                        .clientSecret(clientSecret)
                        .redirectUri(redirectUri)
                        .build();
            case "github":
                return CommonOAuth2Provider.GITHUB
                        .getBuilder(provider)
                        .clientId(clientId)
                        .clientSecret(clientSecret)
                        .redirectUri(redirectUri)
                        .build();
            case "facebook":
                return CommonOAuth2Provider.FACEBOOK
                        .getBuilder(provider)
                        .clientId(clientId)
                        .clientSecret(clientSecret)
                        .redirectUri(redirectUri)
                        .build();
            default:
                throw new IllegalArgumentException("Unsupported provider: " + provider);
        }
    }
    
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


	@Override
	public void init(SecurityBuilder builder) throws Exception {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void configure(SecurityBuilder builder) throws Exception {
		// TODO Auto-generated method stub
		
	}
    
}
