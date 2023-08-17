package senacdw20232eliezerbackend.exemplodw.model.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import senacdw20232eliezerbackend.exemplodw.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	
}
