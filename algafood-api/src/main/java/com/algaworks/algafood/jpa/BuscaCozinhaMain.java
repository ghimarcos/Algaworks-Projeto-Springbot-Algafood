package com.algaworks.algafood.jpa;

import org.springframework.context.ApplicationContext;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;

import com.algaworks.algafood.AlgafoodApiApplication;
import com.algaworks.algafood.domain.model.Cozinha;

public class BuscaCozinhaMain {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args); /* Faz a simulação de um aplicativo Spring Web para iniciar e parar na execução*/
		
		CadastroCozinha cadastroCozinha = applicationContext.getBean(CadastroCozinha.class);/*Pega um Bean Spring*/
		
		Cozinha cozinha = cadastroCozinha.buscar(2L); /*Instancia o metodo de busca do manager, passando ID 1L  (L = long*/
		
			/*Print que trás o nome das cozinhas*/
			System.out.println(cozinha.getNome());
		}
		
	}

