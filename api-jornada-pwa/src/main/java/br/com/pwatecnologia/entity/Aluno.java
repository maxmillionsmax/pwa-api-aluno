package br.com.pwatecnologia.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="aluno")
@Data
public class Aluno {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String nome;
	private Integer idade;
	private String email;
	private String telefone;
	private Date dataInclusao;
	private String pais;
	private String ip;

}
