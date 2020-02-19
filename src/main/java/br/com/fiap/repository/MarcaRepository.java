package br.com.fiap.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.model.MarcaModel;

public interface MarcaRepository extends JpaRepository<MarcaModel, Long>{

}
