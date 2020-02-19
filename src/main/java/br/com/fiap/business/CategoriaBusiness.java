package br.com.fiap.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.fiap.model.CategoriaModel;
import br.com.fiap.repository.CategoriaRepository;

@Component
public class CategoriaBusiness {

	@Autowired
	public CategoriaRepository categoriaRepository;

	public List<CategoriaModel> findAll() {
		return categoriaRepository.findAll();
	}

	public CategoriaModel findById(long id) {
		return categoriaRepository.findById(id).get();
	}

	public void save(CategoriaModel categoriaModel) {
		categoriaRepository.save(categoriaModel);
	}

	public void deleteById(long id) {
		categoriaRepository.deleteById(id);
	}

}
