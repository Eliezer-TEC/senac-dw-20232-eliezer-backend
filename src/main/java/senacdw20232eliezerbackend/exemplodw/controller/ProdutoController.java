package senacdw20232eliezerbackend.exemplodw.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import senacdw20232eliezerbackend.exemplodw.model.Produto;
import senacdw20232eliezerbackend.exemplodw.service.ProdutoService;

@RestController
@RequestMapping(path = "/api/produtos")
public class ProdutoController {

	
	@Autowired
	private ProdutoService produtoService;
	@GetMapping
	public List<Produto> listarTodosProdutos() {
		return produtoService.listarTodos();

	}
	
}
