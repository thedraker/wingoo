package br.com.wingoo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.wingoo.dao.AlternativaDAO;
import br.com.wingoo.dao.QuestaoAlternativaDAO;
import br.com.wingoo.dao.QuestaoDAO;
import br.com.wingoo.model.Alternativa;
import br.com.wingoo.model.Questao;
import br.com.wingoo.model.Questao_Alternativa;

@Controller
public class QuestaoController {
private final QuestaoDAO dao;
private final AlternativaDAO daoA;
private final QuestaoAlternativaDAO daoQA;

	
	@Autowired
	public QuestaoController(QuestaoDAO daoQ, AlternativaDAO daoA, QuestaoAlternativaDAO daoQA){
		this.dao = daoQ;
		this.daoA = daoA;
		this.daoQA = daoQA;
	}
	
	@RequestMapping("cadQuestao")
	public String cadQuestao(){
		return "cadQuestao";
	}
	
	@RequestMapping("addQuestao")
	public String addQuestao(Questao questao, Model model, HttpSession sessao,Alternativa alternativa, Questao_Alternativa q){
		dao.inserir(questao);
		sessao.setAttribute("questao", questao);
		daoA.inserir(alternativa);
		q.setAlternativa(alternativa);
		q.setQuestao(questao);
		daoQA.inserir(q);
		return "cadAlternativa";
	}

}
