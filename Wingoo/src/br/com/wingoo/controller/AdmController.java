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

@Controller
public class AdmController {
		/*private final ProfessorDAO dao;
		
		@Autowired
		public ProfessorController(ProfessorDAO daoE){
			this.dao = daoE;
		}
		*/
		@RequestMapping("admDashboard")
		public String admDashboard(){
			return "adm";
		}
}
