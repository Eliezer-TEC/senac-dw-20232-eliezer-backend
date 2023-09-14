package senacdw20232eliezerbackend.exemplodw.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import senacdw20232eliezerbackend.exemplodw.model.Produto;


@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>, JpaSpecificationExecutor<Produto> {
	List<Produto> findAllByNomeLike(String nomeInformado);
}
