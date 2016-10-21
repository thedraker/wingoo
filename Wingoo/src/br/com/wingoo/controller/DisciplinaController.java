package br.com.wingoo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	public String cadDisciplina(Model model){
		model.addAttribute("disciplina", dao.listar());
		return "cadDisciplina";
	}
	
	@RequestMapping("addNovaDisciplina")
	public String addNovaDisciplina(Disciplina disciplina){
		dao.inserir(disciplina);
		return "redirect:cadQuestao";
	}
	
	@RequestMapping("addDisciplina")
	public String addDisciplina(Disciplina disciplina){
		dao.inserir(disciplina);
		return "cadDisciplina";
	}

}
