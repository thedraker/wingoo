package br.com.wingoo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.wingoo.model.Alternativa;
import br.com.wingoo.model.Disciplina;
import br.com.wingoo.model.Questao;
import br.com.wingoo.model.Questao_Alternativa;
@Repository
public class QuestaoAlternativaDAO {
	public static Connection conexao;
	/*
	 * Strings SQL
	 */
	private String INSERIR = "INSERT INTO Questao_Alternativa (id_questao,id_alternativa) VALUES (?,?)";
	private String BUSCAQUESTOES = "SELECT idQuestaoAlternativa, questao.idQuestao, questao.enunciado, alternativa.conteudo, alternativa.correta FROM questao_alternativa, questao, alternativa WHERE questao_alternativa.id_questao = questao.idQuestao and questao_alternativa.id_alternativa = alternativa.idAlternativa";
	/*
	 * Construtor
	 */
	@Autowired
	public QuestaoAlternativaDAO(DataSource dataSource) {
		try{
			this.conexao = dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * Método para adicionar Disciplinas
	 */
	public void inserir(Questao_Alternativa q_a) {
		try {
			PreparedStatement ps = this.conexao.prepareStatement(INSERIR);
			ps.setInt(1, q_a.getQuestao().getIdQuestao());
			ps.setInt(2, q_a.getAlternativa().getIdAlternativa());
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/*
	 * Método para listar todas as 'Questões Alternativas'
	 */													
	public List<Questao_Alternativa> getQuestaoAlternativa() {
		try {
			List<Questao_Alternativa> qas = new ArrayList<Questao_Alternativa>();
			PreparedStatement ps = this.conexao.prepareStatement(BUSCAQUESTOES);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Questao questao = new Questao();
				questao.setIdQuestao(rs.getInt("idQuestao"));
				questao.setEnunciado(rs.getString("enunciado"));
				
				Alternativa alternativa = new Alternativa();
				alternativa.setConteudo(rs.getString("conteudo"));
				alternativa.setCorreta(rs.getString("correta"));
				
				Questao_Alternativa qa = new Questao_Alternativa();
				qa.setIdQuestaoAlternativa(rs.getInt("idQuestaoAlternativa"));
				qa.setQuestao(questao);
				qa.setAlternativa(alternativa);
				qas.add(qa);
			}
			rs.close();
			ps.close();
			return qas;
		} catch (SQLException e) {
			throw new RuntimeException("Erro listando todas as Questoes\n" + e);
		}
	}
}
