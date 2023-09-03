package br.com.castello.scitartigos.artigos;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class ArtigosService {

    private final ArtigoMapper mapper;
    private final ArtigosRepository artigosRepository;

    public Optional<ArtigoDTO> findArtigoByArtigo(String artigo) {
        return artigosRepository.findAllByArtigo(artigo).stream().findFirst().map(mapper::map);
    }

    public Optional<ArtigoDTO> createArtigo(ArtigoDTO artigoDTO) {
        return Optional.of(mapper.map(artigosRepository.save(mapper.map(artigoDTO))));
    }
}
