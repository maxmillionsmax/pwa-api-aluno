package br.com.pwatecnologia.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.pwatecnologia.entity.Aluno;

public interface IAlunoDao extends JpaRepository<Aluno, Long> {

	@Query("select a from Aluno a")
	public List<Aluno> listar();

}
