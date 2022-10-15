package br.com.pwatecnologia.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.ws.rs.core.Context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pwatecnologia.dto.AlunoDTO;
import br.com.pwatecnologia.entity.Aluno;
import br.com.pwatecnologia.service.IAlunoService;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("api/jornada/Aluno")
@Slf4j
public class AlunoController {

	@Autowired
	private IAlunoService alunoService;

	@GetMapping("listar")
	public ResponseEntity<List<Aluno>> listar() {
		List<Aluno> listaAluno = this.alunoService.listar();
		log.info("Fim da operação listar Aluno");
		return new ResponseEntity<>(listaAluno, HttpStatus.OK);
	}
	
	@PostMapping("salvar")
	public ResponseEntity<Aluno> salvar(@Valid @RequestBody 	AlunoDTO alunoDTO, @Context HttpServletRequest request) {
		Aluno aluno = new Aluno();
		aluno.setIp(request.getRemoteAddr());
		aluno.setDataInclusao(new Date());
		aluno.setPais(request.getLocale().getCountry());
		aluno.setNome(alunoDTO.getNome());
		aluno.setIdade(alunoDTO.getIdade());
		aluno.setEmail(alunoDTO.getEmail());
		aluno.setTelefone(alunoDTO.getTelefone());
		
		aluno = alunoService. salvar(aluno);
		log.info("Fim da operação salvar Aluno");
		return new ResponseEntity<>(aluno, HttpStatus.OK);
	}
	
}
