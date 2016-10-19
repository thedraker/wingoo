package br.com.wingoo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.wingoo.model.Questao;

@Repository
public class QuestaoDAO {
	public static Connection conexao;
	/*
	 * Strings SQL
	 */
	private String INSERIR = "INSERT INTO questao (dificuldade, enunciado, valor, status, marcadores) VALUES (?,?,?,?,?)";
	/*
	 * Construtor
	 */
	@Autowired
	public QuestaoDAO(DataSource dataSource) {
		try{
			this.conexao = dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/*
	 * Método para adicionar Questões
	 */
	public void inserir(Questao qstao) {
		try {
			PreparedStatement ps = this.conexao.prepareStatement(INSERIR, PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1, qstao.getDificuldade());
			ps.setString(2, qstao.getEnunciado());
			ps.setDouble(3, qstao.getValor());
			ps.setString(4, qstao.getStatus());
			ps.setString(5, qstao.getMarcadores());
			//ps.setInt(6, qstao.getPessoa().getIdPessoa());
			//ps.setInt(6, qstao.getDisciplina().getIdDisciplina());
			ps.execute();
			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				qstao.setIdQuestao(rs.getInt(1));
				
			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
