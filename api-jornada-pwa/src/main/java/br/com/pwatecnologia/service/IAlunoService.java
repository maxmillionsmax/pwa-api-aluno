package br.com.pwatecnologia.service;

import java.util.List;

import br.com.pwatecnologia.entity.Aluno;


public interface IAlunoService {

	public Aluno salvar(Aluno aluno);
	public List<Aluno> listar();

}
