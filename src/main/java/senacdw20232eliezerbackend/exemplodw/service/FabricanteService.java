package senacdw20232eliezerbackend.exemplodw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import senacdw20232eliezerbackend.exemplodw.exception.CampoInvalidoException;
import senacdw20232eliezerbackend.exemplodw.model.Fabricante;
import senacdw20232eliezerbackend.exemplodw.model.repository.FabricanteRepository;

@Service
public class FabricanteService {

	@Autowired
	private FabricanteRepository fabricanteRepository;
	
	public Fabricante inserir(Fabricante novoFornecedor) throws CampoInvalidoException {
		validarCamposObrigatorios(novoFornecedor);
		return fabricanteRepository.save(novoFornecedor);
	}

	private void validarCamposObrigatorios(Fabricante fornecedor) throws CampoInvalidoException {
		String mensagemValidacao = "";
		
		mensagemValidacao += validarCampoString(fornecedor.getNome(), "nome");
		mensagemValidacao += validarCampoString(fornecedor.getCnpj(), "cnpj");
		mensagemValidacao += validarCampoString(fornecedor.getCidade(), "cidade");
		mensagemValidacao += validarCampoString(fornecedor.getCep(), "cep");
		mensagemValidacao += validarCampoString(fornecedor.getUf(), "uf");
		
		if(!mensagemValidacao.isEmpty()) {
			throw new CampoInvalidoException(mensagemValidacao);
		}
	}

	private String validarCampoString(String valorCampo, String nomeCampo) {
		if(valorCampo == null || valorCampo.trim().isEmpty()) {
			return "Informe o " + nomeCampo + " \n";
		}
		return "";
	}

	@Transactional
	public List<Fabricante> listarTodos() {
		return fabricanteRepository.findAll();
	}

	
}
