package br.com.arrudadeveloper.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.arrudadeveloper.dtos.CarrosDTOS;
import br.com.arrudadeveloper.responses.Response;
import br.com.arrudadeveloper.services.CarrosService;

@RestController
@RequestMapping(path = "/api/carros")
public class CarrosController {
	
	
	@Autowired
	private CarrosService carrosService;
	
	@GetMapping(value ="/{carro}")
	public String nomeCarro(@PathVariable("carro") String carro) {
	return "Olá, seu carro é: " + carro;	
	}
	
	@GetMapping(value="/listar")
	public ResponseEntity<Response<List<CarrosDTOS>>> listarTodos() {
		return ResponseEntity.ok(new Response<List<CarrosDTOS>>(this.carrosService.listarTodos()));
	}
	
	@GetMapping(path = "/listar/{id}")
	public ResponseEntity<Response<CarrosDTOS>> listarPorId(@PathVariable(name = "id") Long id) {
		return ResponseEntity.ok(new Response<CarrosDTOS>(this.carrosService.listarPorId(id)));
	}
	
	@PostMapping
	public ResponseEntity<Response<CarrosDTOS>> cadastrar(@Valid @RequestBody CarrosDTOS carro, BindingResult result) {
		if (result.hasErrors()) {
			List<String> erros = new ArrayList<String>();
			result.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));
			return ResponseEntity.badRequest().body(new Response<CarrosDTOS>(erros));
		}
		
		return ResponseEntity.ok(new Response<CarrosDTOS>(this.carrosService.cadastrar(carro)));
	}
			
	@PutMapping(path = "/{id}")
	public ResponseEntity<Response<CarrosDTOS>> atualizar(@PathVariable(name = "id") Long id, @Valid @RequestBody CarrosDTOS carro, BindingResult result) {
		if (result.hasErrors()) {
			List<String> erros = new ArrayList<String>();
			result.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));
			return ResponseEntity.badRequest().body(new Response<CarrosDTOS>(erros));
		}
		
		carro.setId(id);
		return ResponseEntity.ok(new Response<CarrosDTOS>(this.carrosService.atualizar(carro)));
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Response<Integer>> remover(@PathVariable(name = "id") Long id) {
		this.carrosService.remover(id);
		return ResponseEntity.ok(new Response<Integer>(1));
	}

}
