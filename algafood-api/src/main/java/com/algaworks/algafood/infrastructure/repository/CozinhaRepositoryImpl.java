package com.algaworks.algafood.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.repository.CozinhaRepository;

@Component /* Está dizendo que essa classe é um componente do spring */
public class CozinhaRepositoryImpl implements CozinhaRepository {

	@PersistenceContext /* vai injetar o EntityManager na classe */
	private EntityManager manager; /* O EntityManager faz o auxilio com a linguagem sql do banco */

	@Override
	public List<Cozinha> listar() { /* Cria uma Lista para buscar elementos da tabela Cozinha no banco */
		return manager.createQuery("from Cozinha", Cozinha.class) /*
																	 * Esta criando uma consulta com todo os elementos
																	 * que tem dentro de Cozinha
																	 */
				.getResultList(); /* Está me retornando os Resultados da Lista Cozinha */
	}

	@Override
	public Cozinha buscar(Long id) {
		return manager.find(Cozinha.class, id); /* Esse metodo manager.find, faz um select */
	}

	@Transactional /* Esse metodo é executado dentro de uma transação */
	@Override
	public Cozinha salvar(Cozinha cozinha) { /* Adicionar Cozinha */
		return manager.merge(cozinha); /*
										 * Passa a instancia persistida ao construtor, ou seja, passa ID e todos os
										 * elementos da classe cozinha para o construtor adicionar(Cozinha cozinha)
										 */
	}

	@Transactional
	@Override
	public void remover(Cozinha cozinha) {
		cozinha = buscar(cozinha.getId()); /*
											 * Primeiro o método remover tem que buscar oque irá remover do banco, no
											 * caso essa busca será pelo ID
											 */
		manager.remove(cozinha); /* Instancia o metodo de remoção no banco com o maneger */
	}

}
