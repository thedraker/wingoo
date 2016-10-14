package br.com.wingoo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.wingoo.dao.QuestaoDAO;
import br.com.wingoo.model.Questao;

@Controller
public class QuestaoController {
private final QuestaoDAO dao;
	
	@Autowired
	public QuestaoController(QuestaoDAO daoQ){
		this.dao = daoQ;
	}
	
	@RequestMapping("cadQuestao")
	public String cadQuestao(){
		return "cadQuestao";
	}
	
	@RequestMapping("addQuestao")
	public String addQuestao(Questao questao, Model model, HttpSession sessao){
		dao.inserir(questao);
		sessao.setAttribute("questao", questao);
		System.out.println(questao.toString());
		return "cadAlternativa";
	}

}
