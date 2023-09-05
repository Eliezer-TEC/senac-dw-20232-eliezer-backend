package senacdw20232eliezerbackend.exemplodw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import senacdw20232eliezerbackend.exemplodw.exception.CampoInvalidoException;
import senacdw20232eliezerbackend.exemplodw.exception.IdInexistenteExcpetion;
import senacdw20232eliezerbackend.exemplodw.model.Fabricante;
import senacdw20232eliezerbackend.exemplodw.model.Produto;
import senacdw20232eliezerbackend.exemplodw.model.repository.ProdutoRepository;
import senacdw20232eliezerbackend.exemplodw.model.seletor.ProdutoSeletor;
import senacdw20232eliezerbackend.exemplodw.model.specification.ProdutoSpecifications;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	@Transactional
	public List<Produto> listarTodos() {
		// TODO Auto-generated method stub
		return produtoRepository.findAll();
	}
	
	public List<Produto> listarComSeletor(ProdutoSeletor seletor) {
		//https://www.baeldung.com/spring-data-jpa-query-by-example
		Specification<Produto> specification = ProdutoSpecifications.comFiltros(seletor);
		return produtoRepository.findAll(specification);
	}

	public Produto inserir(Produto novoProduto) throws CampoInvalidoException {
		validarCamposObrigatorios(novoProduto);
		return produtoRepository.save(novoProduto);
	}

	public Produto atualizar(Produto produtoParaAtualizar) throws CampoInvalidoException, IdInexistenteExcpetion {
		validarCamposObrigatorios(produtoParaAtualizar);
		return produtoRepository.save(produtoParaAtualizar);
	}

	private void validarCamposObrigatorios(Produto produto) throws CampoInvalidoException {
		String mensagemValidacao = "";
		mensagemValidacao += validarCampoString(produto.getNome(), "nome");
		//mensagemValidacao += validarCampoString(produto.getFabricante(), "fabricante");
		mensagemValidacao += validarCampoDouble(produto.getValor(), "valor");
		mensagemValidacao += validarCampoDouble(produto.getPeso(), "peso");

		if(!mensagemValidacao.isEmpty()) {
			throw new CampoInvalidoException(mensagemValidacao);
		}
	}

	private String validarCampoString(String string, String nomeCampo) {
		if (string == null || string.trim().isEmpty()) {
			return "Informe o " + nomeCampo + " \n";
		}
		return "";
	}

	private String validarCampoDouble(Double valorCampo, String nomeCampo) {
		if (valorCampo == null) {
			return "Informe o " + nomeCampo + " \n";
		}
		return "";
	}

	public Produto consultarPorId(Long id) throws IdInexistenteExcpetion {
		return produtoRepository.findById(id.longValue()).get();
	}

	public boolean deletarPorId(Long id) throws IdInexistenteExcpetion {
		Boolean resultado = validarId(id);
		if (resultado == true) {
			produtoRepository.deleteById(id.longValue());
		}
		return resultado;
	}

	private boolean validarId(Long id) throws IdInexistenteExcpetion {

		return produtoRepository.existsById(id);

	}

	

}
