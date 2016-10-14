package br.com.wingoo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.wingoo.dao.DisciplinaDAO;
import br.com.wingoo.model.Disciplina;

@Controller
public class DisciplinaController {
private final DisciplinaDAO dao;
	
	@Autowired
	public DisciplinaController(DisciplinaDAO daoD){
		this.dao = daoD;
	}
	
	@RequestMapping("cadDisciplina")
	public String cadDisciplina(){
		return "cadDisciplina";
	}
	
	@RequestMapping("addDisciplina")
	public String addDisciplina(Disciplina disciplina){
		dao.inserir(disciplina);
		return "cadDisciplina";
	}

}
