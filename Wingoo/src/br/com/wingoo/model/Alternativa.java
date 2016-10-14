package br.com.wingoo.model;

public class Alternativa {
	private int idAlternativa;
	private String conteudo;
	private String correta;
	
	
	public int getIdAlternativa() {
		return idAlternativa;
	}
	public void setIdAlternativa(int idAlternativa) {
		this.idAlternativa = idAlternativa;
	}
	public String getCorreta() {
		return correta;
	}
	public void setCorreta(String correta) {
		this.correta = correta;
	}
	public String getConteudo() {
		return conteudo;
	}
	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}
}
