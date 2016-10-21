package br.com.wingoo.model;

public class Prova_Aluno {
	private int idProvaAluno;
	private String devolutiva;
	private Pessoa pessoa;
	private Prova prova;
	private Turma turma;
	
	public int getIdProvaAluno() {
		return idProvaAluno;
	}
	public void setIdProvaAluno(int idProvaAluno) {
		this.idProvaAluno = idProvaAluno;
	}
	public String getDevolutiva() {
		return devolutiva;
	}
	public void setDevolutiva(String devolutiva) {
		this.devolutiva = devolutiva;
	}
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	public Prova getProva() {
		return prova;
	}
	public void setProva(Prova prova) {
		this.prova = prova;
	}
	public Turma getTurma() {
		return turma;
	}
	public void setTurma(Turma turma) {
		this.turma = turma;
	}
	
	
}
