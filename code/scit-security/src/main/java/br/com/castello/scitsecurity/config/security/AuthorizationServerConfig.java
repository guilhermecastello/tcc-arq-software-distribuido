package br.com.castello.scitsecurity.config.security;

//@Configuration
//@Import(OAuth2AuthorizationServerConfiguration.class)
public class AuthorizationServerConfig {

//    @Bean
//    public RegisteredClientRepository registeredClientRepository() {
//        RegisteredClient registeredClient = RegisteredClient.withId(UUID.randomUUID().toString())
//                .clientId("articles-client")
//                .clientSecret("{noop}secret")
//                .clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_BASIC)
//                .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
//                .authorizationGrantType(AuthorizationGrantType.REFRESH_TOKEN)
//                .redirectUri("http://127.0.0.1:8080/login/oauth2/code/articles-client-oidc")
//                .redirectUri("http://127.0.0.1:8080/authorized")
//                .scope(OidcScopes.OPENID)
//                .scope("articles.read")
//                .build();
//        return new InMemoryRegisteredClientRepository(registeredClient);
//    }
//
//    @Bean
//    @Order(Ordered.HIGHEST_PRECEDENCE)
//    public SecurityFilterChain authServerSecurityFilterChain(HttpSecurity http) throws Exception {
//        OAuth2AuthorizationServerConfiguration.applyDefaultSecurity(http);
//        return http.formLogin(Customizer.withDefaults()).build();
//    }
//
//    @Bean
//    public JWKSource<SecurityContext> jwkSource() {
//        RSAKey rsaKey = generateRsa();
//        JWKSet jwkSet = new JWKSet(rsaKey);
//        return (jwkSelector, securityContext) -> jwkSelector.select(jwkSet);
//    }
//
//    private static RSAKey generateRsa() {
//        KeyPair keyPair = generateRsaKey();
//        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
//        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
//        return new RSAKey.Builder(publicKey)
//                .privateKey(privateKey)
//                .keyID(UUID.randomUUID().toString())
//                .build();
//    }
//
//    private static KeyPair generateRsaKey() {
//        KeyPairGenerator keyPairGenerator = null;
//        try {
//            keyPairGenerator = KeyPairGenerator.getInstance("RSA");
//        } catch (NoSuchAlgorithmException e) {
//            throw new RuntimeException(e);
//        }
//        keyPairGenerator.initialize(2048);
//        return keyPairGenerator.generateKeyPair();
//    }

//    @Bean
//    public ProviderSettings providerSettings() {
//        return ProviderSettings.builder()
//                .issuer("http://auth-server:9000")
//                .build();
//    }
}
