package br.com.wingoo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.wingoo.dao.AlternativaDAO;
import br.com.wingoo.dao.QuestaoAlternativaDAO;
import br.com.wingoo.model.Alternativa;
import br.com.wingoo.model.Questao;
import br.com.wingoo.model.Questao_Alternativa;

@Controller
public class AlternativaController {
	private final AlternativaDAO dao;
	private final QuestaoAlternativaDAO daoQ;
	
	@Autowired
	public AlternativaController(AlternativaDAO daoA, QuestaoAlternativaDAO daoQ){
		this.dao = daoA;
		this.daoQ = daoQ;
	}
	
	@RequestMapping("cadAlternativa")
	public String cadAlternativa(){
		return "cadAlternativa";
	}
	
	@RequestMapping("addAlternativa")
	public String addAlternativa(Alternativa alternativa, Questao questao, Questao_Alternativa q){
		dao.inserir(alternativa);
		q.setAlternativa(alternativa);
		q.setQuestao(questao);
		daoQ.inserir(q);
		return "cadAlternativa";
	}
}
