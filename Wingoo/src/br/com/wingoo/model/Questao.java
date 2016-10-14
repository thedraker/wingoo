package br.com.wingoo.model;

public class Questao {
	private int idQuestao;
	private String dificuldade;
	private String enunciado;
	private Double valor;
	private String marcadores;
	private String status;
	private Pessoa pessoa;
	private Disciplina disciplina;
	
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getIdQuestao() {
		return idQuestao;
	}
	public void setIdQuestao(int idQuestao) {
		this.idQuestao = idQuestao;
	}
	public String getDificuldade() {
		return dificuldade;
	}
	public void setDificuldade(String dificuldade) {
		this.dificuldade = dificuldade;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public String getMarcadores() {
		return marcadores;
	}
	public void setMarcadores(String marcadores) {
		this.marcadores = marcadores;
	}
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	public Disciplina getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
	public String getEnunciado() {
		return enunciado;
	}
	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}
}
