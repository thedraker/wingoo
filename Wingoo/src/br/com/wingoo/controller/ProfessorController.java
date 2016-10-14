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
public class ProfessorController {
		private final PessoaDAO dao;
	
		@Autowired
		public ProfessorController(PessoaDAO daoP){
			this.dao = daoP;
		}
		
		@RequestMapping("addProfessor")
		public String addProfessor(Pessoa professor,
				MultipartFile arquivo) {
			if (!arquivo.isEmpty()) {
				try {
					professor.setFotoPessoa(arquivo.getBytes());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			dao.inserir(professor);
			return "redirect:linkListProf";
		}
		
		@RequestMapping("linkAlterProf")
		public String linkAlterProf(int idProf, Model model){
			model.addAttribute("professor", dao.buscaId(idProf));
			return "alterProf";
		}
		
		@RequestMapping("alteraProfessor")
		public String altera(Pessoa professor) {
			dao.alterarProfessor(professor);	
			return "redirect:linkListProf";
		}
		
		@RequestMapping("desativarProfessor")
		public String desativarProfessor(int idProf){
				dao.desativarProfessor(idProf);
				return "redirect:linkListProf";
		}
		
		@RequestMapping("reativarProfessor")
		public String reativarProfessor(int idProf){
				dao.reativarProfessor(idProf);
				return "redirect:linkOffProf";
		}
		
		@RequestMapping(value="listProfessor", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
		public @ResponseBody ResponseEntity<Object> getAll() throws JSONException {
		    List<Pessoa> professorList = dao.getProfessor();
		    
		    List<JSONObject> entities = new ArrayList<JSONObject>();
		    for (Pessoa e : professorList) {
		        JSONObject Professor = new JSONObject();
		        Professor.put("id", e.getIdPessoa());
		        Professor.put("disciplina", e.getDisciplina());
		        Professor.put("creditos", e.getCreditos());
		        Professor.put("nome", e.getNome());
		        Professor.put("login", e.getLogin());
		        Professor.put("senha", e.getSenha());
		        Professor.put("cpf", e.getCpf());
		        Professor.put("foto", e.getFoto64());
		        entities.add(Professor);
		    }
		    return new ResponseEntity<Object>(entities, HttpStatus.OK);
		}
		
		@RequestMapping(value="listProfessorMorto", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
		public @ResponseBody ResponseEntity<Object> getAllMorto() throws JSONException {
		    List<Pessoa> professorListMorto = dao.getProfessorMorto();
		    
		    List<JSONObject> entities = new ArrayList<JSONObject>();
		    for (Pessoa e : professorListMorto) {
		        JSONObject Professor = new JSONObject();
		        Professor.put("id", e.getIdPessoa());
		        Professor.put("disciplina", e.getDisciplina());
		        Professor.put("creditos", e.getCreditos());
		        Professor.put("nome", e.getNome());
		        Professor.put("login", e.getLogin());
		        Professor.put("senha", e.getSenha());
		        Professor.put("cpf", e.getCpf());
		        Professor.put("foto", e.getFoto64());
		        entities.add(Professor);
		    }
		    return new ResponseEntity<Object>(entities, HttpStatus.OK);
		}
		
		@RequestMapping("profDashboard")
		public String profDashboard(){
			return "prof";
		}
	
		@RequestMapping("linkCadProf")
		public String linkCadProf(){
			return "cadProf";
		}
		
		@RequestMapping("linkListProf")
		public String linkListProf(){
			return "listProf";
		}
		
		@RequestMapping("linkCred")
		public String linkCred(){
			return "listCred";
		}
		
		@RequestMapping("linkOffProf")
		public String linkOffProf(){
			return "offProf";
		}
		
		@RequestMapping("linkCreditos")
		public String linkCreditos(int idProf, Model model){
			model.addAttribute("professor", dao.buscaId(idProf));
			return "atribuirCred";
		}
		
		@RequestMapping("addCreditos")
		public String addCreditos(Pessoa professor){
			dao.inserirCreditos(professor);
			return "listCred";
		}
}
