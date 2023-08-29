package senacdw20232eliezerbackend.exemplodw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import senacdw20232eliezerbackend.exemplodw.exception.CampoInvalidoException;
import senacdw20232eliezerbackend.exemplodw.exception.IdInexistenteExcpetion;
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
	
	@GetMapping({"/{id}"})
	public Produto pesquisarId(@PathVariable Integer id) throws IdInexistenteExcpetion{
		return produtoService.consultarPorId(id.longValue());
		
	}
	@PutMapping()
	public boolean atualizar(@RequestBody Produto produtoParaAtualizar) throws CampoInvalidoException, IdInexistenteExcpetion{
		pesquisarId(produtoParaAtualizar.getId());
		return produtoService.atualizar(produtoParaAtualizar) != null;
		
	}
	
	@PostMapping
	public Produto salvar(@RequestBody Produto novoProduto) 
			throws CampoInvalidoException {
		return produtoService.inserir(novoProduto);
	}
	
	@DeleteMapping("/{id}")
	public boolean delete (@PathVariable Integer id) throws IdInexistenteExcpetion {
		return produtoService.deletarPorId(id.longValue());
	}
}
