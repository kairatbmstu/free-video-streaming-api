/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.free.freevideostreamingapi.oauth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;


/**
 * @author grant
 */
@Configuration
@EnableAuthorizationServer
public class OAuth2AuthServerConfig extends AuthorizationServerConfigurerAdapter {

    String CLIENT_ID = "clientIdPassword";
    String CLIENT_SECRET = new BCryptPasswordEncoder().encode("secret");

    @Value("${application.security.oauth2.access-token-lifetime-seconds:3600}")
    private int accessTokenLifeTimeSeconds;

    @Value("${application.security.oauth2.refresh-token-lifetime-seconds:36000}")
    private int refreshTokenLifeTimeSeconds;

    private String privateKey = "-----BEGIN RSA PRIVATE KEY-----\n" +
            "MIIEowIBAAKCAQEAtKbbiNGwSYPitluzwyDy2g2Aeabjcl6Z9BJT7o6DJBhUtjzT\n" +
            "rC0+5eoOAL9EcHwUMAQXgDjv9CvAFA/qGPNxfW8bD8BZcXlHTczdBIunGizJfFcc\n" +
            "FOyGsKuX4JrOfGy8lorTI7VWofSSDS9XkGH7uiu9+eA367HNYaA8IaZplugARAh3\n" +
            "4jukcvVuCpqMy3QekhaZFbYADf5B3f7Gmo0wzKyNPhSLhDmzSfNATEev22KwN0vW\n" +
            "ePzwWvSLpZIF9zrUrsgrOlQwAJMCn0wejTNL3rHIM0RwB8lAu4eqj61gXSIlx5wN\n" +
            "6epSNifDd9KFbzOhE6blukACdiKFFeAZAl8DwQIDAQABAoIBAEane/VnDauzCViJ\n" +
            "RSVsHY9q+HSb8RkqJsxu3qTO2DulyHv+Dkuo5pDFmfRw2jOkU8Dz2L0th6vX8Kfo\n" +
            "EYbwr9J/QfZHJLRc2qZzGX5NoG18VtFqwHDukT9H3X7bDSdc3+WBJlMw+VEedoDx\n" +
            "oy21JN8LfKHeMADe6ZTlNp9ylpmOOyOmoaKD5ioRgZzp7ko2lowxfec2LIpkbxXT\n" +
            "4sdilRewverhIlnPWkrb2tfcD6HjjBfyFBjaEA+RsHepFkMMh3v6GLbot8yny/2v\n" +
            "FdHdrfXckCVmpI/d5CI0JrtD92nZcaHOKnBt6t2SM3h6D0FZrWsQKjTaBZUQpVBC\n" +
            "m2oEtgECgYEA4YkAXeLQJ6HGePa/rMKYKU1zo9PEIiexUY4MLoXcWFinexbjc+0w\n" +
            "hjBZwAyd8jIVb7TFxJuq0SElKv20RnD77LPjFiDra99FiHhGyny8VuPCUfnSg1H3\n" +
            "Nd6aVSNHVQtLGPjAOJkFjuQJ//M4QK9NeUXM/h/1lDyzQkhgYg5oqxUCgYEAzQ3K\n" +
            "XalkXqKa3ZpKn5f91AB7OgtphQuGNlyztORgqTWjslERo6AgoDbIGw7a4m+VBb+V\n" +
            "7fXJ4hX/UTi1qLYobc7GMbGGV5Jx/CzSov8C8ZbLm0dHo0wCGjPve01KXzyT+qNl\n" +
            "I6HUMNQ5FEUvw61F41y8m86puiN60p0o/H/yMP0CgYEAsYA8nKeUwYxOAwfYBOTG\n" +
            "EsOVPpu9IlBw+sm8BqVtrM5hSbvS2XsUlJfbGw4TBPmr61WvzLPjNWJLuVEhH8tu\n" +
            "SnWtRM412plHRUe8F0Mii5QHbLMcniPVVz1R4623R1RzDz0/M4wjVrlcsWc/n5EY\n" +
            "fViVJHAMvFUllAYYbTP/5p0CgYBBwvx1kU/JMejszQDFsh8LkKP0d5h9vLZsVMql\n" +
            "ZuDBI5y+IVXA3ifYefkvBFKacCKg11KkIEGAqoFZcRCBbPoGTVwur7pf921q7I0Z\n" +
            "DSPKiwv9XpzQ+B1sfd998cm6RVlH9oMHLG06w7USlSW+YaGaSzGJ3nt8YMiRJynv\n" +
            "4LCxmQKBgFVeHImH5kcA82G0UWQ26N5xEAdLHLlqwbFTFKJnI4BZ8Qvmmv8JuUNz\n" +
            "wa6f4RH+3U7w300UPJ713RZGNDaYhuftR/9Yjurklnmr728uSXBg0Su9mJePlAqc\n" +
            "kT32jzENp//Sv9Rg4XtEETGdq4DrCSLtwkfw7+cRemIA/fSWJTnk\n" +
            "-----END RSA PRIVATE KEY-----";
    private String publicKey = "-----BEGIN PUBLIC KEY-----\n" +
            "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAtKbbiNGwSYPitluzwyDy\n" +
            "2g2Aeabjcl6Z9BJT7o6DJBhUtjzTrC0+5eoOAL9EcHwUMAQXgDjv9CvAFA/qGPNx\n" +
            "fW8bD8BZcXlHTczdBIunGizJfFccFOyGsKuX4JrOfGy8lorTI7VWofSSDS9XkGH7\n" +
            "uiu9+eA367HNYaA8IaZplugARAh34jukcvVuCpqMy3QekhaZFbYADf5B3f7Gmo0w\n" +
            "zKyNPhSLhDmzSfNATEev22KwN0vWePzwWvSLpZIF9zrUrsgrOlQwAJMCn0wejTNL\n" +
            "3rHIM0RwB8lAu4eqj61gXSIlx5wN6epSNifDd9KFbzOhE6blukACdiKFFeAZAl8D\n" +
            "wQIDAQAB\n" +
            "-----END PUBLIC KEY-----";

    @Autowired
    private AuthenticationManager authenticationManager;

    @Bean
    public JwtAccessTokenConverter tokenEnhancer() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setSigningKey(privateKey);
        converter.setVerifierKey(publicKey);
        return converter;
    }

    @Bean
    public JwtTokenStore tokenStore() {
        return new JwtTokenStore(tokenEnhancer());
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients
                .inMemory()
                .withClient(CLIENT_ID)
                .secret(CLIENT_SECRET)
                .authorizedGrantTypes("password", "refresh_token")
                .scopes("read", "write", "trust")
                .accessTokenValiditySeconds(accessTokenLifeTimeSeconds)
                .refreshTokenValiditySeconds(refreshTokenLifeTimeSeconds);
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints)  {
        endpoints
                .tokenStore(tokenStore())
                .tokenEnhancer(tokenEnhancer())
                .authenticationManager(authenticationManager);
    }


    @Override
    public void configure(AuthorizationServerSecurityConfigurer security)  {
        security.tokenKeyAccess("permitAll()")
                .checkTokenAccess("isAuthenticated()");
    }
}
