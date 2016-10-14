package br.com.wingoo.model;

public class Questao_Alternativa {
	
	private int idQuestaoAlternativa;
	private Questao questao;
	private Alternativa alternativa;
	
	public int getIdQuestaoAlternativa() {
		return idQuestaoAlternativa;
	}
	public void setIdQuestaoAlternativa(int idQuestaoAlternativa) {
		this.idQuestaoAlternativa = idQuestaoAlternativa;
	}
	public Questao getQuestao() {
		return questao;
	}
	public void setQuestao(Questao questao) {
		this.questao = questao;
	}
	public Alternativa getAlternativa() {
		return alternativa;
	}
	public void setAlternativa(Alternativa alternativa) {
		this.alternativa = alternativa;
	}
}