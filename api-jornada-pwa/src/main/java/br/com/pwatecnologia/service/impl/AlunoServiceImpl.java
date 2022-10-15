package br.com.pwatecnologia.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pwatecnologia.dao.IAlunoDao;
import br.com.pwatecnologia.entity.Aluno;
import br.com.pwatecnologia.service.IAlunoService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AlunoServiceImpl implements IAlunoService {

	@Autowired
	IAlunoDao alunoDao;

	@Override
	public Aluno salvar(Aluno aluno) {
		aluno = alunoDao.save(aluno);
		log.info("Persistindo LogAcesso id: " + aluno.getId());
		return aluno;
	}

	@Override
	public List<Aluno> listar() {
		log.info("Listando todos os Alunos ");
		return alunoDao.listar();
	}

}
