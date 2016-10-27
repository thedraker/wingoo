package br.com.wingoo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.wingoo.dao.TurmaDAO;
import br.com.wingoo.model.Pessoa;
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
	
	@RequestMapping("linkListTurma")
	public String listaAdministrador(Model model) {
		model.addAttribute("turma", dao.getLista());
		return "listTurma";
	}
	
	@RequestMapping("linkAlterTurma")
	public String linkAlterAluno(int idTurma, Model model){
		model.addAttribute("turma", dao.buscaId(idTurma));
		return "alterTurma";
	}
	
	@RequestMapping("alteraTurma")
	public String altera(Turma turma) {
		dao.alterarTurma(turma);	
		return "redirect:linkListTurma";
	}
	
	@RequestMapping("desativarTurma")
	public String desativarTurma(int idTurma){
			dao.desativarTurma(idTurma);
			return "redirect:linkListTurma";
	}
}
