package br.com.wingoo.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import br.com.wingoo.dao.PessoaDAO;
import br.com.wingoo.model.Pessoa;

@Controller
public class AlunoController {
	private final PessoaDAO dao;
	
	@Autowired
	public AlunoController(PessoaDAO daoE){
		this.dao = daoE;
	}
	
	
	@RequestMapping("linkCadAluno")
	public String linkCadAluno(){
		return "cadAluno";
	}
	@RequestMapping("addAluno")
	public String addExaminador(Pessoa aluno,
			MultipartFile arquivo) {
		if (!arquivo.isEmpty()) {
			try {
				aluno.setFotoPessoa(arquivo.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		dao.inserir(aluno);
		return "redirect:linkListExm";
	}
	
	@RequestMapping("linkListAluno")
	public String linkListAluno(){
		return "listAluno";
	}
	
	
	@RequestMapping(value="listAluno", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Object> getAll() throws JSONException {
	    List<Pessoa> alunoList = dao.getExaminador();
 
	    List<JSONObject> entities = new ArrayList<JSONObject>();
	    for (Pessoa e : alunoList) {
	        JSONObject Aluno = new JSONObject();
	        Aluno.put("id", e.getIdPessoa());
	        Aluno.put("disciplina", e.getDisciplina());
	        Aluno.put("nome", e.getNome());
	        Aluno.put("login", e.getLogin());
	        Aluno.put("senha", e.getSenha());
	        Aluno.put("cep", e.getCep());
	        Aluno.put("foto", e.getFoto64());
	        entities.add(Aluno);
	    }
	    return new ResponseEntity<Object>(entities, HttpStatus.OK);
	}
	
	@RequestMapping("linkOffAluno")
	public String linkOffAluno(){
		return "offAluno";
	}
	

	@RequestMapping("linkAlterAluno")
	public String linkAlterAluno(int idAluno, Model model){
		model.addAttribute("aluno", dao.buscaId(idAluno));
		return "alterAluno";
	}
	
	@RequestMapping("alteraAluno")
	public String altera(Pessoa aluno) {
		dao.alterarExaminador(aluno);	
		return "redirect:linkListAluno";
	}
	
	@RequestMapping("removerAluno")
	public String removerAluno(int idAluno){
			dao.remover(idAluno);
			return "redirect:linkListAluno";
	}
}
