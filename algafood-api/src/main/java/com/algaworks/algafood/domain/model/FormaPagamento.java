package com.algaworks.algafood.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Data
@Table(name = "tab_formaPagamento")
public class FormaPagamento {
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // *esse código diz que o ID tem que ser Auto Increment*//
	private Long id;
	
	
	@Column(name = "descricao", length = 30, nullable = false) /* Coluna na tabela com tamanho de 30 varchar */
	private String descricao;
	
	
}
