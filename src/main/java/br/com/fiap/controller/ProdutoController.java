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

import br.com.fiap.business.ProdutoBusiness;
import br.com.fiap.exception.ResponseBusinessException;
import br.com.fiap.model.ProdutoModel;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
				
	@Autowired
	public ProdutoBusiness produtoBusiness;
	
	// Busca
	@GetMapping
	public ResponseEntity<List<ProdutoModel>> findAll() {
		
		List<ProdutoModel> produtos = produtoBusiness.findAll();
		return ResponseEntity.ok(produtos);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ProdutoModel> findById(@PathVariable("id") long id) {	
		
		ProdutoModel produtoModel = produtoBusiness.findById(id);
		return ResponseEntity.ok(produtoModel);
	}
	
	// Cadastro
	@PostMapping
	public ResponseEntity save(@Valid @RequestBody ProdutoModel produtoModel) throws ResponseBusinessException {		
		
		ProdutoModel produto = produtoBusiness.applyBusiness(produtoModel);
		
		produtoBusiness.save(produto);		
		
		URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(produtoModel.getId()).toUri();		
		
		return ResponseEntity.created(location).build();	
	}
	
	// Edicao
	@PutMapping("/{id}")
	public ResponseEntity update(@PathVariable("id") long id, @Valid @RequestBody ProdutoModel produtoModel) throws ResponseBusinessException {				
		
		produtoBusiness.findById(id);	
		
		ProdutoModel produto = produtoBusiness.applyBusiness(produtoModel);
		
		produto.setId(id);
		produtoBusiness.save(produto);		
		return ResponseEntity.ok().build();		
	}
	
	
	// Deleção	
	@DeleteMapping("/{id}")
	public ResponseEntity deleteById(@PathVariable("id") long id) {
		
		produtoBusiness.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
}
