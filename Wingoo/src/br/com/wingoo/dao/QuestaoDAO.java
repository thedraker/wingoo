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

import br.com.wingoo.model.Disciplina;
import br.com.wingoo.model.Pessoa;
import br.com.wingoo.model.Questao;
import br.com.wingoo.model.Turma;

@Repository
public class QuestaoDAO {
	public static Connection conexao;
	/*
	 * Strings SQL
	 */
	private String INSERIR = "INSERT INTO questao (dificuldade, enunciado, valor, status, marcadores, id_disciplina) VALUES (?,?,?,?,?,?)";
	private String BUSCAQUESTOES = "SELECT idQuestao, dificuldade, enunciado, valor, status, marcadores, disciplina.nomeDisciplina FROM questao, disciplina WHERE questao.id_disciplina = disciplina.idDisciplina";
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
			ps.setInt(6, qstao.getDisciplina().getIdDisciplina());
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
	/*
	 * Método para listar todas as 'Questões'
	 */													
	public List<Questao> getQuestoes() {
		try {
			List<Questao> questoes = new ArrayList<Questao>();
			PreparedStatement ps = this.conexao.prepareStatement(BUSCAQUESTOES);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Disciplina disciplina = new Disciplina();
				disciplina.setNomeDisciplina(rs.getString("nomeDisciplina"));
				
				Questao questao = new Questao();
				questao.setIdQuestao(rs.getInt("idQuestao"));
				questao.setDificuldade(rs.getString("dificuldade"));
				questao.setEnunciado(rs.getString("enunciado"));
				questao.setValor(rs.getDouble("valor"));
				questao.setStatus(rs.getString("status"));
				questao.setMarcadores(rs.getString("marcadores"));
				questao.setDisciplina(disciplina);
				questoes.add(questao);
			}
			rs.close();
			ps.close();
			return questoes;
		} catch (SQLException e) {
			throw new RuntimeException("Erro listando todas as Questoes\n" + e);
		}
	}
}
