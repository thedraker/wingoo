package br.com.wingoo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.wingoo.dao.TurmaDAO;
import br.com.wingoo.model.Turma;

@Controller
public class TurmaController {
	private final TurmaDAO dao;
	
	@Autowired
	public TurmaController(TurmaDAO daoT){
		this.dao = daoT;
	}
	
	@RequestMapping("cadTurma")
	public String cadTurma(){
		return "cadTurma";
	}
	@RequestMapping("addTurma")
	public String addExaminador(Turma turma) {
		dao.inserir(turma);
		return "cadTurma";
	}
	
	@RequestMapping("linkListaTurma")
	public String listaAdministrador(Model model) {
		model.addAttribute("turma", dao.getLista());
		return "listTurma";
	}
}
