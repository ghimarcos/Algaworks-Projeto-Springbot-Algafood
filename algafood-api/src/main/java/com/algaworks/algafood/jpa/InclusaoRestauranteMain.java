package com.algaworks.algafood.jpa;

import org.springframework.context.ApplicationContext;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;

import com.algaworks.algafood.AlgafoodApiApplication;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.CozinhaRepository;
import com.algaworks.algafood.domain.repository.RestauranteRepository;

public class InclusaoRestauranteMain {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args); /* Faz a simulação de um aplicativo Spring Web para iniciar e parar na execução*/
		
		RestauranteRepository restauranteRepository = applicationContext.getBean(RestauranteRepository.class);/*Pega um Bean Spring*/
		
		
		Restaurante restaurante1 = new Restaurante();
		restaurante1.setNome("Japo");
		restaurante1.setTaxaFrete(BigDecimal.valueOf(20.00));
		
		Restaurante restaurante2 = new Restaurante();
		restaurante2.setNome("Cantinho do Paladar");			/*Instancia um novo Restaurante, e seta o nome dela*/
		restaurante2.setTaxaFrete(BigDecimal.valueOf(18.00));  /*Passando a taxa do frete como BigDecimal*/
		
		restaurante1 = restauranteRepository.salvar(restaurante1);
		restaurante2 = restauranteRepository.salvar(restaurante2); /*Adiciona os Restaurantes ao banco*/
		
		System.out.printf("%d - %s \n", restaurante1.getId(), restaurante1.getNome());
		System.out.printf("%d - %s \n", restaurante2.getId(), restaurante2.getNome()); /*Aqui é só para ver os Restaurantes que foram adicionadas*/
	}
}
