package com.algaworks.algafood.domain.repository;

import java.util.List;

import com.algaworks.algafood.domain.model.Cozinha;
	
	public interface CozinhaRepository {

		List<Cozinha> listar();  /*Oque que tem que ter em um repositório de cozinha, uma lista, buscar,salvar,e remover*/
		Cozinha buscar(Long id);
		Cozinha salvar(Cozinha cozinha);
		void remover(Cozinha cozinha);
	
	

}
