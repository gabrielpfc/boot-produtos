package br.com.fiap.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.fiap.model.MarcaModel;
import br.com.fiap.repository.MarcaRepository;

@Component
public class MarcaBusiness {
	
	@Autowired
	public MarcaRepository marcaRepository;

	public List<MarcaModel> findAll() {
		return marcaRepository.findAll();
	}

	public MarcaModel findById(long id) {
		return marcaRepository.findById(id).get();
	}

	public void save(MarcaModel marcaModel) {
		marcaRepository.save(marcaModel);		
	}

	public void deleteById(long id) {
		marcaRepository.deleteById(id);
	}

}
