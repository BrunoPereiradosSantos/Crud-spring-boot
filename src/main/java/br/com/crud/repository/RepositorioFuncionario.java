package br.com.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.crud.model.Funcionario;

@Repository
public interface RepositorioFuncionario extends JpaRepository<Funcionario, Long> {

}
