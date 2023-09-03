package br.com.castello.scitartigos.artigos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArtigosRepository extends JpaRepository<Artigo, Long>, PagingAndSortingRepository<Artigo, Long> {

    public List<Artigo> findAllByArtigo(String artigo);
}
