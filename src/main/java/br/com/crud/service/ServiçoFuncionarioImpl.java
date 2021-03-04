package br.com.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.crud.model.Funcionario;
import br.com.crud.repository.RepositorioFuncionario;


@Service
public class ServiçoFuncionarioImpl implements ServiçoFuncionario {
	@Autowired
	private RepositorioFuncionario repositorioFuncionario;
	
	@Override
	public List<Funcionario> getAllFuncionarios(){
		return repositorioFuncionario.findAll();
		
	}
	// criando botão
	@Override
	public void salvarFuncionario(Funcionario funcionario) {
		this.repositorioFuncionario.save(funcionario);
	}
	
	@Override
	public Funcionario getFuncionarioById(long id) {
		Optional<Funcionario> optional = repositorioFuncionario.findById(id);
		Funcionario funcionario = null;
		if (optional.isPresent()) {
			funcionario = optional.get();
		}else {
			throw new RuntimeException("Funcionario Não Encontrado pelo id ::" + id);
		}
		return funcionario;
	}
	
	@Override
	public void deletarFuncionarioById(long id) {
		this.repositorioFuncionario.deleteById(id);
		
	}

}
