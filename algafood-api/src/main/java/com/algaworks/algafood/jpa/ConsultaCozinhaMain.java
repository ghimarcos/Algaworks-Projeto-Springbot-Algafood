package com.algaworks.algafood.jpa;

import org.springframework.context.ApplicationContext;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;

import com.algaworks.algafood.AlgafoodApiApplication;
import com.algaworks.algafood.domain.model.Cozinha;

public class ConsultaCozinhaMain {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args); /* Faz a simulação de um aplicativo Spring Web para iniciar e parar na execução*/
		
		CadastroCozinha cadastroCozinha = applicationContext.getBean(CadastroCozinha.class);/*Pega um Bean Spring*/
		
		List<Cozinha> cozinhas = cadastroCozinha.listar(); /*Instancia a lista de cozinhas no banco*/
		
		for (Cozinha cozinha : cozinhas) { 
			/*Esse for percorre a lista de cozinhas, e o print trás o nome das cozinhas*/
			System.out.println(cozinha.getNome());
		}
		
	}
}
