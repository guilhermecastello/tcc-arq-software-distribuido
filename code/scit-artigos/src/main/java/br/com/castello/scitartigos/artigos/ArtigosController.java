package br.com.castello.scitartigos.artigos;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/artigos")
@Slf4j
@AllArgsConstructor
public class ArtigosController {

    private final ArtigosService artigosService;

    @GetMapping
    public ResponseEntity<ArtigoDTO> getArtigoByArtigo(@RequestParam(value = "artigo") String artigo) {
        return  artigosService.findArtigoByArtigo(artigo).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ArtigoDTO> createArtigo(@RequestBody ArtigoDTO artigoDTO) {
        return artigosService.createArtigo(artigoDTO)
                .map(ResponseEntity::ok)
                .orElseGet(() ->ResponseEntity.unprocessableEntity().build());
    }
}
