package senacdw20232eliezerbackend.exemplodw.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import senacdw20232eliezerbackend.exemplodw.model.Fabricante;

@Repository
public interface FabricanteRepository extends JpaRepository<Fabricante, Long>, JpaSpecificationExecutor<Fabricante> {
	List<Fabricante> findAllByNomeLike(String nomeInformado);
}
