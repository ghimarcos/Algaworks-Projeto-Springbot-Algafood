package com.algaworks.algafood.domain.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;


@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Data
@Entity
@Table(name = "tab_restaurantes")
public class Restaurante {
	
	@EqualsAndHashCode.Include
	@Id /* Nessa tabela esse elemento vai ser o ID */
	@GeneratedValue(strategy = GenerationType.IDENTITY) // *esse código diz que o ID tem que ser Auto Increment*//
	private Long id;

	@Column(name = "nom_restaurante", length = 30, nullable = false) /* Coluna na tabela com tamanho de 30 varchar */
	private String nome;

	@Column(name = "taxa_frete", nullable = false) /* Coluna na tabela com nome, e passando que não pode ser adicionado valor nulo */
	private BigDecimal taxaFrete; /* Coluna na tabela do tipo BigDecimal */
	
	
	@ManyToOne  /*Estou dizendo que um restaurante tem uma ou várias cozinhas*/
	private Cozinha cozinha; /*Fazendo a relação entre a tabela cozinha e restaurante*/
	
	
}
