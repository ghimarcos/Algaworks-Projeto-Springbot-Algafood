package com.algaworks.algafood.jpa;

import org.springframework.context.ApplicationContext;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;

import com.algaworks.algafood.AlgafoodApiApplication;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.CozinhaRepository;
import com.algaworks.algafood.domain.repository.RestauranteRepository;

public class ConsultaRestauranteMain {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args); /* Faz a simulação de um aplicativo Spring Web para iniciar e parar na execução*/
		
		RestauranteRepository restauranteRepository = applicationContext.getBean(RestauranteRepository.class);/*Pega um Bean Spring*/
		
		List<Restaurante> todosRestaurantes = restauranteRepository.listar(); /*Instancia a lista de cozinhas no banco*/
		
		for (Restaurante restaurante : todosRestaurantes) { 
			/*Esse for percorre a lista de cozinhas, e o print trás o nome das cozinhas*/
			System.out.printf("%s --- %f --- %s \n",restaurante.getNome(),
					restaurante.getTaxaFrete(), restaurante.getCozinha().getNome());
		}
		
	}
}
