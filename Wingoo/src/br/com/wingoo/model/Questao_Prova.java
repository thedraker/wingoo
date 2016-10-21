package br.com.wingoo.model;

public class Questao_Prova {
	private int idQuestaoProva;
	private Pessoa pessoa;
	private Questao questao;
	
	public int getIdQuestaoProva() {
		return idQuestaoProva;
	}
	public void setIdQuestaoProva(int idQuestaoProva) {
		this.idQuestaoProva = idQuestaoProva;
	}
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	public Questao getQuestao() {
		return questao;
	}
	public void setQuestao(Questao questao) {
		this.questao = questao;
	}
}
