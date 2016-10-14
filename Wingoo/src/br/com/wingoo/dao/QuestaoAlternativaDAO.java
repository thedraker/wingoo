package br.com.wingoo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.wingoo.model.Disciplina;
import br.com.wingoo.model.Questao_Alternativa;
@Repository
public class QuestaoAlternativaDAO {
	public static Connection conexao;
	/*
	 * Strings SQL
	 */
	private String INSERIR = "INSERT INTO Questao_Alternativa (id_questao,id_alternativa) VALUES (?,?)";
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
}
