package br.com.castello.scitinfracoes.infracoes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InfracaoRepository extends JpaRepository<Infracao, Long> {
}
