package br.com.castello.scitinfracoes.artigos;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ArtigoClientService {

    private final WebClient.Builder webClientBuilder;
    public Optional<ArtigoDTO> findArtigoByArtigo(String artigo) {

        return Optional.of(webClientBuilder.build()
                .get()
                .uri("/artigos?artigo="+artigo)
                .retrieve()
                .bodyToMono(ArtigoDTO.class)
                .block());

    }
}
