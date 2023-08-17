package senacdw20232eliezerbackend.exemplodw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import senacdw20232eliezerbackend.exemplodw.model.Produto;
import senacdw20232eliezerbackend.exemplodw.model.repository.ProdutoRepository;


@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Transactional
	public List<Produto> listarTodos() {
		// TODO Auto-generated method stub
		return produtoRepository.findAll();
	}

}
