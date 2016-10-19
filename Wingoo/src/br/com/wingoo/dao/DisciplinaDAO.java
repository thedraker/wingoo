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

@Repository
public class DisciplinaDAO {
	public static Connection conexao;
	/*
	 * Strings SQL
	 */
	private String INSERIR = "INSERT INTO disciplina, outro (disciplina, outro) VALUES (?,?)";
	private String LISTAR = "SELECT * from disciplina";
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
			ps.setString(1, disciplina.getNomeDisciplina());
			ps.setString(2, disciplina.getOutro());
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * Método para adicionar Disciplinas
	 */
	public List<Disciplina> listar() {
		try {
			List<Disciplina> dps = new ArrayList<Disciplina>();
			PreparedStatement ps = this.conexao.prepareStatement(LISTAR);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Disciplina dp = new Disciplina();
				dp.setIdDisciplina(rs.getInt("idDisciplina"));
				dp.setNomeDisciplina(rs.getString("nomeDisciplina"));
				dp.setOutro(rs.getString("outro"));
				dps.add(dp);
			}
			rs.close();
			ps.close();
			return dps;
		} catch (SQLException e) {
			throw new RuntimeException("Erro listando todas as disciplinas\n" + e);
		}
	}

}
