package com.algaworks.algafood.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.repository.CozinhaRepository;

//@Controller /*Estou dizendo que essa classe é um controlador do Spring*/
//@ResponseBody /*A resposta do método Listar, deve ser enviada como resposta para o request*/

@RestController /* ele já tem o @Controller e o ResponseBody tudo junto*/
@RequestMapping("/cozinhas") /*estou dizendo que os requests para /cozinhas , serão requisitadas aqui*/
public class CozinhaController {
	
	@Autowired
	private CozinhaRepository cozinhaRepository; /*instancio a cozinhaRepository*/
	
	@GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}) /*Mapeamento do verbo http 'GET' + afirmando para apenas retornar em JsonS ou XML*/
	public List<Cozinha> listar(){
		return cozinhaRepository.listar();  /*Passo o modo listar do CozinhaRepository para o controlador*/
	}
	
	@GetMapping("/{cozinhaId}") /*aqui estou dizendo o caminho do get tem que ser em /cozinhas/{cozinhaId}*/
	
	public Cozinha buscar(@PathVariable Long cozinhaId) {   /*Aqui com o @PathVariable estou dizendo que o ID que ele vai 
	receber para fazer a busca vai ser o ID que eu passar no GET*/
		
		return cozinhaRepository.buscar(cozinhaId);  /*Metodo buscar por ID*/
	}
	
}
