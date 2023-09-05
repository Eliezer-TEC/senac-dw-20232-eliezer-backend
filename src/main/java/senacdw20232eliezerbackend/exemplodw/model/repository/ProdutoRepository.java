package senacdw20232eliezerbackend.exemplodw.model.repository;



import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import senacdw20232eliezerbackend.exemplodw.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>, JpaSpecificationExecutor<Produto> {
	//É possível declarar métodos do JpaRepository aqui, combinando atributos e operadores SQL
	
	//https://reflectoring.io/spring-data-specifications/
	//Exemplo WHERE nome like '%123%'
	List<Produto> findAllByNomeLike(String nomeInformado);
	
}
