package com.algaworks.algafood.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.domain.model.Estado;

import com.algaworks.algafood.domain.repository.EstadoRepository;

//@Controller /*Estou dizendo que essa classe é um controlador do Spring*/
//@ResponseBody /*A resposta do método Listar, deve ser enviada como resposta para o request*/

@RestController /* ele já tem o @Controller e o ResponseBody tudo junto */
@RequestMapping(value ="/estados", produces = MediaType.APPLICATION_JSON_VALUE) /* estou dizendo que os requests para /estados , serão requisitadas aqui */
public class EstadoController {

	@Autowired
	private EstadoRepository estadoRepository; /* instancio o estadoRepository */

	@GetMapping /* Mapeamento do verbo http 'GET' */
	public List<Estado> listar() {
		return estadoRepository.listar(); /* Passo o modo listar do EstadoRepository para o controlador */
	}

}
