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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import br.com.wingoo.dao.PessoaDAO;

@Controller
public class ProfessorController {
		private final PessoaDAO dao;
	
		@Autowired
		public ProfessorController(PessoaDAO daoP){
			this.dao = daoP;
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
		
		@RequestMapping("linkAtribuirCreditos")
		public String linkAtribuirCreditos(){
			return "atribuirCred";
		}
}
