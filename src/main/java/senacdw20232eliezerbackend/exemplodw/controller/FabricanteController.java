package senacdw20232eliezerbackend.exemplodw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import senacdw20232eliezerbackend.exemplodw.exception.CampoInvalidoException;
import senacdw20232eliezerbackend.exemplodw.model.Fabricante;
import senacdw20232eliezerbackend.exemplodw.service.FabricanteService;


@RestController
@RequestMapping(path = "/api/fabricante")
@CrossOrigin(origins = { "http://localhost:4200", "http://localhost:5500" }, maxAge = 3600)
public class FabricanteController {

	
	@Autowired
	private FabricanteService fabricanteService;
	
	
	@PostMapping("/cadastrar")
	public Fabricante salvar(@RequestBody Fabricante novoFornecedor) throws CampoInvalidoException{
		return fabricanteService.inserir(novoFornecedor);
	}
	
	@Transactional
	
	@GetMapping(path = "/todos")
	public List<Fabricante> listarTodos(){
		List<Fabricante> fabricantes = fabricanteService.listarTodos();
		return fabricantes;
	}
	}
