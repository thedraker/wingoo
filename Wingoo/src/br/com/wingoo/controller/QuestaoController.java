package br.com.wingoo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.wingoo.dao.AlternativaDAO;
import br.com.wingoo.dao.DisciplinaDAO;
import br.com.wingoo.dao.QuestaoAlternativaDAO;
import br.com.wingoo.dao.QuestaoDAO;
import br.com.wingoo.model.Alternativa;
import br.com.wingoo.model.Disciplina;
import br.com.wingoo.model.Questao;
import br.com.wingoo.model.Questao_Alternativa;

@Controller
public class QuestaoController {
private final QuestaoDAO dao;
private final DisciplinaDAO daoD;

	
	@Autowired
	public QuestaoController(QuestaoDAO daoQ, DisciplinaDAO daoD){
		this.dao = daoQ;
		this.daoD = daoD;
	}
	
	@RequestMapping("cadQuestao")
	public String cadQuestao(Model model){
		model.addAttribute("disciplina", daoD.listar());
		return "cadQuestao";
	}
	
	@RequestMapping("addQuestao")
	public String addQuestao(Questao questao, Disciplina disciplina, Model model, HttpSession sessao){
		questao.setDisciplina(disciplina);
		dao.inserir(questao);
		sessao.setAttribute("questao", questao);
		return "cadAlternativa";
	}

}
