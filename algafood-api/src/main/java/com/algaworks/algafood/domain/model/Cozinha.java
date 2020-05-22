package com.algaworks.algafood.domain.model;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Data;
import lombok.EqualsAndHashCode;


@JsonRootName("gastronomia")  /*Essa anotação está dizendo para não retornar Cozinha no request, e sim "gastronomia" só funciona no
XML, o Json não retorna nome root*/
@Data /*Lombok , cria setters, getters automatico*/
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity /*Dizendo que essa classe é gerenciavel pelo Spring*/
@Table(name = "tab_cozinhas")/*No banco ta criando essa tabela chamada tab_cozinhas*/
public class Cozinha {
	
	@EqualsAndHashCode.Include
	@Id /* Nessa tabela esse elemento vai ser o ID */
	@GeneratedValue(strategy = GenerationType.IDENTITY) // *esse código diz que o ID tem que ser Auto Increment*//
	private Long id;
	
//	@JsonIgnore /*A anotação JsonIgnore, diz que é pra ignorar a String Nome, e não retornar seu valor*/
	@JsonProperty("titulo")   /*Aqui estou dizendo que no resquest não vai retornar mais nome, e sim titulo*/
	@Column(name = "nom_cozinha", length = 30) // **coluna no banco com tamanho de 30 varchar**//
	private String nome;

}
