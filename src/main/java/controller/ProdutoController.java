package controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import model.Produto;

@RestController
@RequestMapping(path = "/api/produtos")
public class ProdutoController {

	
	@GetMapping
	public List<Produto> listarTodosProdutos() {
		//TODO consultar no banco (através de um Repository/DAO)
		Produto p1 = new Produto("Produto 1", "Fabricante 1", 10, 1, LocalDate.now());
		Produto p2 = new Produto("Produto 2", "Fabricante 2", 20, 2, LocalDate.now());
		Produto p3 = new Produto("Produto 3", "Fabricante 3", 30, 3, LocalDate.now());
		
		ArrayList<Produto> lista = new ArrayList<Produto>();
		lista.add(p1);
		lista.add(p2);
		lista.add(p3);
		
		return lista;
	}
	
}