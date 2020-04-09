package com.algaworks.algafood.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import com.algaworks.algafood.domain.model.Cozinha;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Component
public class CadastroCozinha {

	@PersistenceContext /* vai injetar o EntityManager na classe */
	private EntityManager manager;/* O EntityManager faz o auxilio com a linguagem sql do banco */

	/* Cria uma Lista para buscar elementos da tabela Cozinha no banco */
	public List<Cozinha> listar(){

		TypedQuery<Cozinha> query = manager.createQuery("from Cozinha",
				Cozinha.class); /* Esta criando uma consulta com todo os elementos que tem dentro de Cozinha */
			
		return query.getResultList(); /*Está me retornando os Resultados da Lista Cozinha*/
		
	}
	
	public Cozinha buscar(Long id) {
		return manager.find(Cozinha.class, id); /*Esse metodo manager.find, faz um select */
	}
	
	@Transactional /*Esse metodo é executado dentro de uma transação*/
	public Cozinha salvar(Cozinha cozinha) {
		/*Adicionar Cozinha*/
		return manager.merge(cozinha);/*Passa a instancia persistida ao construtor, ou seja, passa ID e todos os elementos da classe cozinha
		para o construtor adicionar(Cozinha cozinha)*/
	}
	
	@Transactional /*tem que ser marcado como transactional, para dizer que ele é instanciado dentro de uma transição*/
	public void remover(Cozinha cozinha) {
		cozinha = buscar(cozinha.getId()); /*Primeiro o método remover tem que buscar oque irá remover do banco, no caso essa busca será pelo ID*/
		
		manager.remove(cozinha);/*Instancia o metodo de remoção no banco com o maneger*/
		
		
	}
}
