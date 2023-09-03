package br.com.castello.scitinfracoes.artigos;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class ArtigoWebClientConfig {

    @Bean
    public WebClient.Builder artigoWebClientBuilder() {
        return WebClient.builder()
                .baseUrl("http://localhost:8000/");
    }
}
