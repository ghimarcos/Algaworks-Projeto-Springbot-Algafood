package com.algaworks.algafood.domain.model;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;



@Data /*Lombok , cria setters, getters automatico*/
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity /*Dizendo que essa classe é gerenciavel pelo Spring*/
@Table(name = "tab_cozinhas")/*No banco ta criando essa tabela chamada tab_cozinhas*/
public class Cozinha {
	
	@EqualsAndHashCode.Include
	@Id /* Nessa tabela esse elemento vai ser o ID */
	@GeneratedValue(strategy = GenerationType.IDENTITY) // *esse código diz que o ID tem que ser Auto Increment*//
	private Long id;

	@Column(name = "nom_cozinha", length = 30) // **coluna no banco com tamanho de 30 varchar**//
	private String nome;

}
