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
public class ExaminadorController {
		private final PessoaDAO dao;
		
		@Autowired
		public ExaminadorController(PessoaDAO daoE){
			this.dao = daoE;
		}
		
		
		@RequestMapping("linkCadExm")
		public String linkCadExm(){
			return "cadExm";
		}
		@RequestMapping("addExaminador")
		public String addExaminador(Pessoa examinador,
				MultipartFile arquivo) {
			if (!arquivo.isEmpty()) {
				try {
					examinador.setFotoPessoa(arquivo.getBytes());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			dao.inserir(examinador);
			return "redirect:linkListExm";
		}
		
		@RequestMapping("linkListExm")
		public String linkListExm(){
			return "listExm";
		}
		
		
		@RequestMapping(value="listExaminador", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
		public @ResponseBody ResponseEntity<Object> getAll() throws JSONException {
		    List<Pessoa> examinadorList = dao.getExaminador();
		    
		    System.out.println(examinadorList);
		    
		    List<JSONObject> entities = new ArrayList<JSONObject>();
		    for (Pessoa e : examinadorList) {
		        JSONObject Examinador = new JSONObject();
		        Examinador.put("id", e.getIdPessoa());
		        Examinador.put("disciplina", e.getDisciplina());
		        Examinador.put("nome", e.getNome());
		        Examinador.put("login", e.getLogin());
		        Examinador.put("senha", e.getSenha());
		        Examinador.put("cep", e.getCep());
		        Examinador.put("foto", e.getFoto64());
		        entities.add(Examinador);
		    }
		    return new ResponseEntity<Object>(entities, HttpStatus.OK);
		}
		
		@RequestMapping("linkOffExm")
		public String linkOffExm(){
			return "offExm";
		}
		

		@RequestMapping("linkAlterExm")
		public String linkAlterExam(int idExm, Model model){
			model.addAttribute("examinador", dao.buscaId(idExm));
			return "alterExam";
		}
		
		@RequestMapping("alteraExaminador")
		public String altera(Pessoa examinador) {
			dao.alterarExaminador(examinador);	
			return "redirect:linkListExm";
		}
		
		@RequestMapping("removerExaminador")
		public String removerExaminador(int idExm){
			System.out.println("Entrou no remover");
			System.out.println("examinador = " + idExm);
				dao.remover(idExm);
				return "redirect:linkListExm";
		}
}
