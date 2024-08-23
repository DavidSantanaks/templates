package br.com.david.nosso_template.pessoas.repository;

import br.com.david.nosso_template.pessoas.PessoasEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<PessoasEntity,Integer> {
}
