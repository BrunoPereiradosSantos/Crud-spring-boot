package br.com.crud.service;

import java.util.List;



import br.com.crud.model.Funcionario;

public interface ServiçoFuncionario {
	List<Funcionario> getAllFuncionarios();
	//criar botão
	void salvarFuncionario(Funcionario funcionario);
	Funcionario getFuncionarioById(long id);
	void deletarFuncionarioById(long id);

		
	}


