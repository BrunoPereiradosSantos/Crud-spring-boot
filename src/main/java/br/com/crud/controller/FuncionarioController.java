package br.com.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.crud.model.Funcionario;
import br.com.crud.service.ServiçoFuncionario;

@Controller
public class FuncionarioController {
	
	//manipulador de metodos para exibir lista dos funcionarios
	
	@Autowired
	private ServiçoFuncionario serviçoFuncionario;
	
	@GetMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("listaFuncionarios", serviçoFuncionario.getAllFuncionarios());
		return "index";
		
	}
	
	@GetMapping("/mostrarNovoFuncionarioForm")
	public String mostrarNovoFuncionarioForm(Model model) {
		//inserção de funcionarios pelo botão
		Funcionario funcionario = new Funcionario();
		model.addAttribute("funcionario", funcionario);
		return "novo_funcionario";		
	}
	
	@PostMapping("/salvarFuncionario")
	public String salvarFuncionario(@ModelAttribute("funcionario") Funcionario funcionario){
		//Salvar funcionarios no banco de dados
		serviçoFuncionario.salvarFuncionario(funcionario);
		return "redirect:/";	
	}
	@GetMapping("/mostrarFormUpdate/{id}")
	public String mostrarFormUpdate(@PathVariable(value = "id") long id, Model model) {
		
		//pegar funcionario do service
		
		Funcionario funcionario = serviçoFuncionario.getFuncionarioById(id);
		
		//setar atributo de funcionario como modelo pre populado do formulario
		model.addAttribute("funcionario", funcionario);
		
		return "update_funcionario";
	}
	
	@GetMapping("/deletarFuncionario/{id}")
	public String deletarFuncionario(@PathVariable(value="id")long id) {
		
		//chamada para deletar funcionario
		
		this.serviçoFuncionario.deletarFuncionarioById(id);
		return "redirect:/";
		
	}
	
}
