package br.com.wingoo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.wingoo.model.Disciplina;

@Repository
public class DisciplinaDAO {
	public static Connection conexao;
	/*
	 * Strings SQL
	 */
	private String INSERIR = "INSERT INTO disciplina (disciplina) VALUES (?)";
	/*
	 * Construtor
	 */
	@Autowired
	public DisciplinaDAO(DataSource dataSource) {
		try{
			this.conexao = dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * Método para adicionar Disciplinas
	 */
	public void inserir(Disciplina disciplina) {
		try {
			PreparedStatement ps = this.conexao.prepareStatement(INSERIR);
			ps.setString(1, disciplina.getDisciplina());
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
