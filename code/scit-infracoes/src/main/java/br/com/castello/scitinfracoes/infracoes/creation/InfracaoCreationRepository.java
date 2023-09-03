package br.com.castello.scitinfracoes.infracoes.creation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InfracaoCreationRepository extends JpaRepository<InfracaoCreation, Long> {

}
