package br.com.wingoo.dao;

import java.io.ByteArrayInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.wingoo.model.Pessoa;
import br.com.wingoo.model.Turma;

@Repository
public class TurmaDAO {
	public static Connection conexao;
	/*
	 * Strings para comandos no Banco de Dados
	 */
	private String INSERIR = "INSERT INTO turma (nome,token,status) VALUES (?,?,?)";
	private String LISTAR = "SELECT * FROM turma WHERE status='Vivo'";
	private String LISTARMORTO = "SELECT * FROM turma WHERE status='Morto'";
	private String DESATIVARTURMA = "UPDATE turma SET status='Morto' WHERE idTurma=?";
	private String ALTERATURMA = "UPDATE turma SET nome=?, token=? where idTurma=?"; 
	private String BUSCAIDTURMA = "SELECT * FROM turma WHERE idTurma=?";
	@Autowired
	public TurmaDAO(DataSource ds){
		try{
			this.conexao = ds.getConnection();
		} catch (SQLException e){
			e.printStackTrace();
		}
	}
	/*
	 * Método para adicionar Turma
	 */
	public void inserir(Turma turma) {
		try {
			PreparedStatement ps = conexao.prepareStatement(INSERIR);
			ps.setString(1, turma.getNome());
			ps.setString(2, turma.getToken());
			ps.setString(3, turma.getStatus());
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/*
	 * Método para listar Turma
	 */
	public List<Turma> getLista() {
		try {
			List<Turma> turmas = new ArrayList<Turma>();
			PreparedStatement ps = conexao.prepareStatement(LISTAR);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Turma turma = new Turma();
				turma.setIdTurma(rs.getInt("idTurma"));
				turma.setNome(rs.getString("nome"));
				turma.setToken(rs.getString("token"));
				turma.setStatus(rs.getString("status"));
				turmas.add(turma);
			}
			rs.close();
			ps.close();
			return turmas;
		} catch (SQLException e) {
			throw new RuntimeException("Erro listando todas as turmas\n"
					+ e);
		}
	}
	/*
	 * Método para listar Turma
	 */
	public List<Turma> getListaMortos() {
		try {
			List<Turma> turmas = new ArrayList<Turma>();
			PreparedStatement ps = conexao.prepareStatement(LISTARMORTO);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Turma turma = new Turma();
				turma.setIdTurma(rs.getInt("idTurma"));
				turma.setNome(rs.getString("nome"));
				turma.setToken(rs.getString("token"));
				turma.setStatus(rs.getString("status"));
				turmas.add(turma);
			}
			rs.close();
			ps.close();
			return turmas;
		} catch (SQLException e) {
			throw new RuntimeException("Erro listando todas as turmas\n"
					+ e);
		}
	}
	
	/*
	 * Método para alterar Turma
	 */
	public void alterarTurma(Turma turma) {
		try {
			PreparedStatement ps = this.conexao.prepareStatement(ALTERATURMA);
			ps.setString(1, turma.getNome());
			ps.setString(2, turma.getToken());
			ps.setInt(3, turma.getIdTurma());
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * Método para busca de Pessoas por Id
	 */
	public Turma buscaId(int id) {
		Turma turma = new Turma();
		try {
			PreparedStatement ps = conexao.prepareStatement(BUSCAIDTURMA);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				turma.setIdTurma(rs.getInt("idTurma"));
				turma.setNome(rs.getString("nome"));
				turma.setToken(rs.getString("token"));
			}
			ps.close();
		} catch (SQLException e) {
			throw new RuntimeException("Erro listando Turmas por Id\n" + e);
		}
		return turma;
	}
	/*
	 * Método para desativar Turma
	 */
	public void desativarTurma(int id){
		try {
			PreparedStatement stmt = conexao.prepareStatement(DESATIVARTURMA);
			stmt.setInt(1, id);
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
}
