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

import br.com.fiap.business.CategoriaBusiness;
import br.com.fiap.model.CategoriaModel;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {
	
	@Autowired
	public CategoriaBusiness categoriaBusiness;
	
	// Busca
	@GetMapping
	public ResponseEntity<List<CategoriaModel>> findAll() {	
		
		List<CategoriaModel> categorias = categoriaBusiness.findAll();	
		return ResponseEntity.ok(categorias);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CategoriaModel> findById(@PathVariable("id") long id) {

		CategoriaModel categoria = categoriaBusiness.findById(id);	
		return ResponseEntity.ok(categoria);
	}
	
	// Cadastro
	@PostMapping
	public ResponseEntity save(@RequestBody @Valid CategoriaModel categoriaModel) {
		
		categoriaBusiness.save(categoriaModel);
		
		URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(categoriaModel.getIdCategoria()).toUri();
		
		return ResponseEntity.created(location).build();
		
	}
	
	// Edicao
	@PutMapping("/{id}")
	public ResponseEntity update(@PathVariable("id") long id, @RequestBody @Valid CategoriaModel categoriaModel) {

		categoriaBusiness.findById(id);
					
		categoriaModel.setIdCategoria(id);
		categoriaBusiness.save(categoriaModel);
	
		return ResponseEntity.ok().build();		
	}
		
	// Deleção	
	@DeleteMapping("/{id}")
	public ResponseEntity deleteById(@PathVariable("id") long id) {
		
		categoriaBusiness.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
}
