package com.algaworks.algafood.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity /*Dizendo que essa classe é gerenciavel pelo Spring*/
@Table(name = "tab_cozinhas")/*No banco ta criando essa tabela chamada tab_cozinhas*/
public class Cozinha {

	@Id /* Nessa tabela esse elemento vai ser o ID */
	@GeneratedValue(strategy = GenerationType.IDENTITY) // *esse código diz que o ID tem que ser Auto Increment*//
	private Long id;

	@Column(name = "nom_cozinha", length = 30) // **coluna no banco com tamanho de 30 varchar**//
	private String nome;

//*Getters and setters and Equals and Hashcodes---------------------------------------------------------------------------------------------------------*//

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cozinha other = (Cozinha) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
