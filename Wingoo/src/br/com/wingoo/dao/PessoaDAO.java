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

/**
 * 
 * @author Marcos Vinícius e Luiz Carlos
 *
 */

@Repository
public class PessoaDAO {
	public static Connection conexao;
	/*
	 * Strings SQL: Comandos para o Banco de Dados
	 */
	private String INSERIR = "INSERT INTO pessoa (idPessoa, nome, email, cpf, cep, endereco, numero, complemento, bairro, cidade, estado, telefone, creditos, disciplina, tipo, login, senha, status, fotoPessoa) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private String INSERIRCREDITOS = "UPDATE pessoa SET creditos=? WHERE idPessoa=?";
	private String BUSCATODOS = "SELECT * FROM pessoa";
	private String BUSCAIDPESSOA = "SELECT * from pessoa WHERE idPessoa = ?";
	private String BUSCAEXAMINADOR = "SELECT * FROM pessoa WHERE tipo = 'Examinador' and status = 'Vivo'";
	private String BUSCAPROFESSOR = "SELECT * FROM pessoa WHERE tipo = 'Professor' and status = 'Vivo'";
	private String BUSCAPROFESSORMORTO = "SELECT * FROM pessoa WHERE tipo = 'Professor' and status = 'Morto'";
	private String BUSCAEXAMINADORMORTO = "SELECT * FROM pessoa WHERE tipo = 'Examinador' and status = 'Morto'";
	private String REATIVAREXAMINADOR = "UPDATE pessoa SET status='Vivo' WHERE idPessoa=?";
	private String DESATIVAREXAMINADOR = "UPDATE pessoa SET status='Morto' WHERE idPessoa=?";
	private String REATIVARPROFESSOR = "UPDATE pessoa SET status='Vivo' WHERE idPessoa=?";
	private String DESATIVARPROFESSOR = "UPDATE pessoa SET status='Morto' WHERE idPessoa=?";
	private String BUSCAALUNO = "SELECT * FROM pessoa WHERE tipo = 'Aluno'";
	private String ALTERAREXAMINADOR = "UPDATE pessoa SET nome =?, email=?, cpf=?,cep=?, endereco=?, numero=?, complemento=?, bairro=?, cidade=?, estado=?, telefone=?, disciplina=?, login=?, senha=? WHERE idPessoa=?";
	private String ALTERARALUNO = "UPDATE pessoa SET nome =?, email=?, cpf=?,cep=?, endereco=?, numero=?, complemento=?, bairro=?, cidade=?, estado=?, telefone=?, login=?, senha=? WHERE idPessoa=?";
	private String ALTERARPROFESSOR = "UPDATE pessoa SET nome =?, email=?, cpf=?,cep=?, endereco=?, numero=?, complemento=?, bairro=?, cidade=?, estado=?, telefone=?, disciplina=?, login=?, senha=? WHERE idPessoa=?";
	private String REMOVER = "DELETE FROM pessoa WHERE idPessoa=?";
	private String REMOVERCREDITOS = "UPDATE pessoa SET creditos=? WHERE idPessoa=?";
	private String ALTERARFOTO = "UPDATE examinador SET fotoExam=? WHERE idExaminador=?";
	/*
	 * Iniciando a conexão no Construtor
	 */
	@Autowired
	public PessoaDAO(DataSource dataSource) {
		try{
			this.conexao = dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/*
	 * Método para adicionar Pessoas
	 */
	public void inserir(Pessoa pe) {
		try {
			PreparedStatement ps = this.conexao.prepareStatement(INSERIR);
			ps.setInt(1, pe.getIdPessoa());
			ps.setString(2, pe.getNome());
			ps.setString(3, pe.getEmail());
			ps.setString(4, pe.getCpf());
			ps.setString(5, pe.getCep());
			ps.setString(6, pe.getEndereco());
			ps.setString(7, pe.getNumero());
			ps.setString(8, pe.getComplemento());
			ps.setString(9, pe.getBairro());
			ps.setString(10, pe.getCidade());
			ps.setString(11, pe.getEstado());
			ps.setString(12, pe.getTelefone());
			ps.setInt(13, pe.getCreditos());
			ps.setString(14, pe.getDisciplina());
			ps.setString(15, pe.getTipo());
			ps.setString(16, pe.getLogin());
			ps.setString(17, pe.getSenha());
			ps.setString(18, pe.getStatus());
			ps.setBlob(19, (pe.getFotoPessoa() == null) ? null
					: new ByteArrayInputStream(pe.getFotoPessoa()));
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/*
	 * Método para alterar Examinador
	 */
	public void alterarExaminador(Pessoa pe) {
		try {
			PreparedStatement ps = this.conexao.prepareStatement(ALTERAREXAMINADOR);
			ps.setString(1, pe.getNome());
			ps.setString(2, pe.getEmail());
			ps.setString(3, pe.getCpf());
			ps.setString(4, pe.getCep());
			ps.setString(5, pe.getEndereco());
			ps.setString(6, pe.getNumero());
			ps.setString(7, pe.getComplemento());
			ps.setString(8, pe.getBairro());
			ps.setString(9, pe.getCidade());
			ps.setString(10, pe.getEstado());
			ps.setString(11, pe.getTelefone());
			ps.setString(12, pe.getDisciplina());
			ps.setString(13, pe.getLogin());
			ps.setString(14, pe.getSenha());
			ps.setInt(15, pe.getIdPessoa());
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/*
	 * Método para alterar Professor
	 */
	public void alterarProfessor(Pessoa pe) {
		try {
			PreparedStatement ps = this.conexao.prepareStatement(ALTERARPROFESSOR);
			ps.setString(1, pe.getNome());
			ps.setString(2, pe.getEmail());
			ps.setString(3, pe.getCpf());
			ps.setString(4, pe.getCep());
			ps.setString(5, pe.getEndereco());
			ps.setString(6, pe.getNumero());
			ps.setString(7, pe.getComplemento());
			ps.setString(8, pe.getBairro());
			ps.setString(9, pe.getCidade());
			ps.setString(10, pe.getEstado());
			ps.setString(11, pe.getTelefone());
			ps.setString(12, pe.getDisciplina());
			ps.setString(13, pe.getLogin());
			ps.setString(14, pe.getSenha());
			ps.setInt(15, pe.getIdPessoa());
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/*
	 * Método para alterar Aluno
	 */
	public void alterarAluno(Pessoa pe) {
		try {
			PreparedStatement ps = this.conexao.prepareStatement(ALTERARALUNO);
			ps.setInt(1, pe.getIdPessoa());
			ps.setString(2, pe.getNome());
			ps.setString(3, pe.getEmail());
			ps.setString(4, pe.getCpf());
			ps.setString(5, pe.getCep());
			ps.setString(6, pe.getEndereco());
			ps.setString(7, pe.getNumero());
			ps.setString(8, pe.getComplemento());
			ps.setString(9, pe.getBairro());
			ps.setString(10, pe.getCidade());
			ps.setString(11, pe.getEstado());
			ps.setString(12, pe.getTelefone());
			ps.setInt(13, pe.getCreditos());
			ps.setString(14, pe.getDisciplina());
			ps.setString(15, pe.getTipo());
			ps.setString(16, pe.getLogin());
			ps.setString(17, pe.getSenha());
			ps.setString(18, pe.getStatus());
			ps.setBlob(19, (pe.getFotoPessoa() == null) ? null
					: new ByteArrayInputStream(pe.getFotoPessoa()));
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * Método para listar todos os 'Examinadores'
	 */													
	public List<Pessoa> getExaminador() {
		try {
			List<Pessoa> pes = new ArrayList<Pessoa>();
			PreparedStatement ps = this.conexao.prepareStatement(BUSCAEXAMINADOR);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Pessoa pe = new Pessoa();
				pe.setIdPessoa(rs.getInt("idPessoa"));
				pe.setNome(rs.getString("nome"));
				pe.setEmail(rs.getString("email"));
				pe.setCpf(rs.getString("cpf"));
				pe.setCep(rs.getString("cep"));
				pe.setEndereco(rs.getString("endereco"));
				pe.setNumero(rs.getString("numero"));
				pe.setComplemento(rs.getString("complemento"));
				pe.setBairro(rs.getString("bairro"));
				pe.setCidade(rs.getString("cidade"));
				pe.setEstado(rs.getString("estado"));
				pe.setTelefone(rs.getString("telefone"));
				pe.setCreditos(rs.getInt("creditos"));
				pe.setDisciplina(rs.getString("disciplina"));
				pe.setTipo(rs.getString("tipo"));
				pe.setLogin(rs.getString("login"));
				pe.setSenha(rs.getString("senha"));
				pe.setStatus(rs.getString("status"));
				pe.setFotoPessoa(rs.getBytes("fotoPessoa"));
				pes.add(pe);
			}
			rs.close();
			ps.close();
			return pes;

		} catch (SQLException e) {
			throw new RuntimeException("Erro listando todos os Examinadores\n" + e);
		}
	}
	/*
	 * Método para listar todos os 'Examinadores' desativados
	 */													
	public List<Pessoa> getExaminadorMorto() {
		try {
			List<Pessoa> pes = new ArrayList<Pessoa>();
			PreparedStatement ps = this.conexao.prepareStatement(BUSCAEXAMINADORMORTO);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Pessoa pe = new Pessoa();
				pe.setIdPessoa(rs.getInt("idPessoa"));
				pe.setNome(rs.getString("nome"));
				pe.setEmail(rs.getString("email"));
				pe.setCpf(rs.getString("cpf"));
				pe.setCep(rs.getString("cep"));
				pe.setEndereco(rs.getString("endereco"));
				pe.setNumero(rs.getString("numero"));
				pe.setComplemento(rs.getString("complemento"));
				pe.setBairro(rs.getString("bairro"));
				pe.setCidade(rs.getString("cidade"));
				pe.setEstado(rs.getString("estado"));
				pe.setTelefone(rs.getString("telefone"));
				pe.setCreditos(rs.getInt("creditos"));
				pe.setDisciplina(rs.getString("disciplina"));
				pe.setTipo(rs.getString("tipo"));
				pe.setLogin(rs.getString("login"));
				pe.setSenha(rs.getString("senha"));
				pe.setStatus(rs.getString("status"));
				pe.setFotoPessoa(rs.getBytes("fotoPessoa"));
				pes.add(pe);
			}
			rs.close();
			ps.close();
			return pes;

		} catch (SQLException e) {
			throw new RuntimeException("Erro listando todos os Examinadores\n" + e);
		}
	}
	
	/*
	 * Método para listar todos os 'Professor'
	 */													
	public List<Pessoa> getProfessor() {
		try {
			List<Pessoa> pes = new ArrayList<Pessoa>();
			PreparedStatement ps = this.conexao.prepareStatement(BUSCAPROFESSOR);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Pessoa pe = new Pessoa();
				pe.setIdPessoa(rs.getInt("idPessoa"));
				pe.setNome(rs.getString("nome"));
				pe.setEmail(rs.getString("email"));
				pe.setCpf(rs.getString("cpf"));
				pe.setCep(rs.getString("cep"));
				pe.setEndereco(rs.getString("endereco"));
				pe.setNumero(rs.getString("numero"));
				pe.setComplemento(rs.getString("complemento"));
				pe.setBairro(rs.getString("bairro"));
				pe.setCidade(rs.getString("cidade"));
				pe.setEstado(rs.getString("estado"));
				pe.setTelefone(rs.getString("telefone"));
				pe.setCreditos(rs.getInt("creditos"));
				pe.setDisciplina(rs.getString("disciplina"));
				pe.setTipo(rs.getString("tipo"));
				pe.setLogin(rs.getString("login"));
				pe.setSenha(rs.getString("senha"));
				pe.setStatus(rs.getString("status"));
				pe.setFotoPessoa(rs.getBytes("fotoPessoa"));
				pes.add(pe);
			}
			rs.close();
			ps.close();
			return pes;

		} catch (SQLException e) {
			throw new RuntimeException("Erro listando todos os Professor\n" + e);
		}
	}
	
	/*
	 * Método para listar todos os 'Professor' desativados
	 */													
	public List<Pessoa> getProfessorMorto() {
		try {
			List<Pessoa> pes = new ArrayList<Pessoa>();
			PreparedStatement ps = this.conexao.prepareStatement(BUSCAPROFESSORMORTO);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Pessoa pe = new Pessoa();
				pe.setIdPessoa(rs.getInt("idPessoa"));
				pe.setNome(rs.getString("nome"));
				pe.setEmail(rs.getString("email"));
				pe.setCpf(rs.getString("cpf"));
				pe.setCep(rs.getString("cep"));
				pe.setEndereco(rs.getString("endereco"));
				pe.setNumero(rs.getString("numero"));
				pe.setComplemento(rs.getString("complemento"));
				pe.setBairro(rs.getString("bairro"));
				pe.setCidade(rs.getString("cidade"));
				pe.setEstado(rs.getString("estado"));
				pe.setTelefone(rs.getString("telefone"));
				pe.setCreditos(rs.getInt("creditos"));
				pe.setDisciplina(rs.getString("disciplina"));
				pe.setTipo(rs.getString("tipo"));
				pe.setLogin(rs.getString("login"));
				pe.setSenha(rs.getString("senha"));
				pe.setStatus(rs.getString("status"));
				pe.setFotoPessoa(rs.getBytes("fotoPessoa"));
				pes.add(pe);
			}
			rs.close();
			ps.close();
			return pes;

		} catch (SQLException e) {
			throw new RuntimeException("Erro listando todos os Professor\n" + e);
		}
	}
	
	
	/*
	 * Método para listar todos os 'Aluno'
	 */													
	public List<Pessoa> getAluno() {
		try {
			List<Pessoa> pes = new ArrayList<Pessoa>();
			PreparedStatement ps = this.conexao.prepareStatement(BUSCAALUNO);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Pessoa pe = new Pessoa();
				pe.setIdPessoa(rs.getInt("idPessoa"));
				pe.setNome(rs.getString("nome"));
				pe.setEmail(rs.getString("email"));
				pe.setCpf(rs.getString("cpf"));
				pe.setCep(rs.getString("cep"));
				pe.setEndereco(rs.getString("endereco"));
				pe.setNumero(rs.getString("numero"));
				pe.setComplemento(rs.getString("complemento"));
				pe.setBairro(rs.getString("bairro"));
				pe.setCidade(rs.getString("cidade"));
				pe.setEstado(rs.getString("estado"));
				pe.setTelefone(rs.getString("telefone"));
				pe.setCreditos(rs.getInt("creditos"));
				pe.setDisciplina(rs.getString("disciplina"));
				pe.setTipo(rs.getString("tipo"));
				pe.setLogin(rs.getString("login"));
				pe.setSenha(rs.getString("senha"));
				pe.setStatus(rs.getString("status"));
				pe.setFotoPessoa(rs.getBytes("fotoPessoa"));
				pes.add(pe);
			}
			rs.close();
			ps.close();
			return pes;

		} catch (SQLException e) {
			throw new RuntimeException("Erro listando todos os Aluno\n" + e);
		}
	}
	/*
	 * Método para buscar todas as pessoas
	 */
	/*
	 * Método para listar todos os 'Aluno'
	 */													
	public List<Pessoa> getPessoas() {
		try {
			List<Pessoa> pes = new ArrayList<Pessoa>();
			PreparedStatement ps = this.conexao.prepareStatement(BUSCATODOS);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Pessoa pe = new Pessoa();
				pe.setIdPessoa(rs.getInt("idPessoa"));
				pe.setNome(rs.getString("nome"));
				pe.setEmail(rs.getString("email"));
				pe.setCpf(rs.getString("cpf"));
				pe.setCep(rs.getString("cep"));
				pe.setEndereco(rs.getString("endereco"));
				pe.setNumero(rs.getString("numero"));
				pe.setComplemento(rs.getString("complemento"));
				pe.setBairro(rs.getString("bairro"));
				pe.setCidade(rs.getString("cidade"));
				pe.setEstado(rs.getString("estado"));
				pe.setTelefone(rs.getString("telefone"));
				pe.setCreditos(rs.getInt("creditos"));
				pe.setDisciplina(rs.getString("disciplina"));
				pe.setTipo(rs.getString("tipo"));
				pe.setLogin(rs.getString("login"));
				pe.setSenha(rs.getString("senha"));
				pe.setStatus(rs.getString("status"));
				pe.setFotoPessoa(rs.getBytes("fotoPessoa"));
				pes.add(pe);
			}
			rs.close();
			ps.close();
			return pes;

		} catch (SQLException e) {
			throw new RuntimeException("Erro listando todos os Aluno\n" + e);
		}
	}
	/*
	 * Método para remover pessoa
	 */
/*	public void remover(Pessoa pessoa){
		try {
			PreparedStatement stmt = this.conexao.prepareStatement(REMOVER);
			stmt.setInt(1, pessoa.getIdPessoa());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}*/
	
	public void remover(int id){
		try {
			PreparedStatement stmt = this.conexao.prepareStatement(REMOVER);
			stmt.setInt(1, id);
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	/*
	 * Método para busca de Pessoas por Id
	 */
	public Pessoa buscaId(int id) {
		Pessoa pe = new Pessoa();
		try {
			PreparedStatement ps = conexao.prepareStatement(BUSCAIDPESSOA);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				pe.setIdPessoa(rs.getInt("idPessoa"));
				pe.setNome(rs.getString("nome"));
				pe.setEmail(rs.getString("email"));
				pe.setCpf(rs.getString("cpf"));
				pe.setCep(rs.getString("cep"));
				pe.setEndereco(rs.getString("endereco"));
				pe.setNumero(rs.getString("numero"));
				pe.setComplemento(rs.getString("complemento"));
				pe.setBairro(rs.getString("bairro"));
				pe.setCidade(rs.getString("cidade"));
				pe.setEstado(rs.getString("estado"));
				pe.setTelefone(rs.getString("telefone"));
				pe.setCreditos(rs.getInt("creditos"));
				pe.setDisciplina(rs.getString("disciplina"));
				pe.setTipo(rs.getString("tipo"));
				pe.setLogin(rs.getString("login"));
				pe.setSenha(rs.getString("senha"));
				pe.setStatus(rs.getString("status"));
				pe.setFotoPessoa(rs.getBytes("fotoPessoa"));
			}
			ps.close();
		} catch (SQLException e) {
			throw new RuntimeException("Erro listando Pessoas por Id\n" + e);
		}
		return pe;
	}
	/*
	 * Método para inserir Créditos para o Professor
	 */
	public void inserirCreditos(Pessoa pe) {
		try {
			PreparedStatement ps = conexao.prepareStatement(INSERIRCREDITOS);
			ps.setInt(1, pe.getCreditos());
			ps.setInt(2, pe.getIdPessoa());
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/*
	 * Método para remover Créditos para o Professor
	 */
	public void removerCreditos(Pessoa pe) {
		try {
			PreparedStatement ps = conexao.prepareStatement(REMOVERCREDITOS);
			ps.setInt(1, pe.getCreditos());
			ps.setInt(2, pe.getIdPessoa());
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/*
	 * Método para remover Reativar Examinador
	 */
	public void reativarExaminador(int id){
		try {
			PreparedStatement stmt = conexao.prepareStatement(REATIVAREXAMINADOR);
			stmt.setInt(1, id);
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	/*
	 * Método para desativar Examinador
	 */
	public void desativarExaminador(int id){
		try {
			PreparedStatement stmt = conexao.prepareStatement(DESATIVAREXAMINADOR);
			stmt.setInt(1, id);
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	/*
	 * Método para remover Reativar Examinador
	 */
	public void reativarProfessor(int id){
		try {
			PreparedStatement stmt = conexao.prepareStatement(REATIVARPROFESSOR);
			stmt.setInt(1, id);
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	/*
	 * Método para remover Créditos para o Professor
	 */
	public void desativarProfessor(int id){
		try {
			PreparedStatement stmt = conexao.prepareStatement(DESATIVARPROFESSOR);
			stmt.setInt(1, id);
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
