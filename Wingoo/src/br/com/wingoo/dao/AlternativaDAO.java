package br.com.wingoo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.wingoo.model.Alternativa;
@Repository
public class AlternativaDAO {
	public static Connection conexao;
	/*
	 * Strings SQL
	 */
	private String INSERIR = "INSERT INTO alternativa (conteudo,correta) VALUES (?,?)";
	/*
	 * Construtor
	 */
	@Autowired
	public AlternativaDAO(DataSource dataSource) {
		try{
			this.conexao = dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * Método para adicionar Alternativas
	 */
	public void inserir(Alternativa alternativa) {
		try {
			PreparedStatement ps = conexao.prepareStatement(INSERIR, PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1, alternativa.getConteudo());
			ps.setString(2, alternativa.getCorreta());
			ps.execute();
			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				alternativa.setIdAlternativa(rs.getInt(1));
				
			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
