package com.algaworks.algafood.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.RestauranteRepository;

@Component
public class RestauranteRepositoryImpl implements RestauranteRepository {
	
	@PersistenceContext /* vai injetar o EntityManager na classe */
	private EntityManager manager; /* O EntityManager faz o auxilio com a linguagem sql do banco */

	@Override
	public List<Restaurante> listar() { /* Cria uma Lista para buscar elementos da tabela Cozinha no banco */
		return manager.createQuery("from Restaurante", Restaurante.class) /*
																	 * Esta criando uma consulta com todo os elementos
																	 * que tem dentro de Cozinha
																	 */
				.getResultList(); /* Está me retornando os Resultados da Lista Cozinha */
	}

	@Override
	public Restaurante buscar(Long id) {
		return manager.find(Restaurante.class, id); /* Esse metodo manager.find, faz um select */
	}

	@Transactional /* Esse metodo é executado dentro de uma transação */
	@Override
	public Restaurante salvar(Restaurante restaurante) { /* Adicionar Cozinha */
		return manager.merge(restaurante); /*
										 * Passa a instancia persistida ao construtor, ou seja, passa ID e todos os
										 * elementos da classe cozinha para o construtor adicionar(Cozinha cozinha)
										 */
	}

	@Transactional
	@Override
	public void remover(Restaurante restaurante) {
		restaurante = buscar(restaurante.getId()); /*
											 * Primeiro o método remover tem que buscar oque irá remover do banco, no
											 * caso essa busca será pelo ID
											 */
		manager.remove(restaurante); /* Instancia o metodo de remoção no banco com o maneger */
	}

	
}
