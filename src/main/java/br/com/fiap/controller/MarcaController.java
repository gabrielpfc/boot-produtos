package br.com.fiap.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.fiap.business.MarcaBusiness;
import br.com.fiap.model.MarcaModel;

@RestController
@RequestMapping("/marca")
public class MarcaController {
	
	@Autowired
	public MarcaBusiness marcaBusiness;

	// Busca
	@GetMapping
	public ResponseEntity<List<MarcaModel>> findAll() {	
		
		List<MarcaModel> marcas = marcaBusiness.findAll();	
		return ResponseEntity.ok(marcas);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<MarcaModel> findById(@PathVariable("id") long id) {

		MarcaModel marca = marcaBusiness.findById(id);
		return ResponseEntity.ok(marca);
	}
	
	// Cadastro
	@PostMapping
	public ResponseEntity save(@RequestBody @Valid MarcaModel marcaModel) {
		
		marcaBusiness.save(marcaModel);
		
		URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(marcaModel.getIdMarca()).toUri();
		
		return ResponseEntity.created(location).build();
		
	}
	
	// Edicao
	@PutMapping("/{id}")
	public ResponseEntity update(@PathVariable("id") long id, @RequestBody @Valid MarcaModel marcaModel) {
		
		marcaBusiness.findById(id);
		
		marcaModel.setIdMarca(id);
		marcaBusiness.save(marcaModel);
		return ResponseEntity.ok().build();
	}	
	
	// Deleção	
	@DeleteMapping("/{id}")
	public ResponseEntity deleteById(@PathVariable("id") long id) {
		
		marcaBusiness.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
}
