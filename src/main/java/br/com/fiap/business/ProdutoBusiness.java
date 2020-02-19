package br.com.fiap.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.fiap.exception.ResponseBusinessException;
import br.com.fiap.model.CategoriaModel;
import br.com.fiap.model.ProdutoModel;
import br.com.fiap.repository.CategoriaRepository;
import br.com.fiap.repository.ProdutoRepository;

@Component
public class ProdutoBusiness {

	@Autowired
	public ProdutoRepository produtoRepository;

	@Autowired
	private CategoriaRepository categoriaRepository;

	public ProdutoModel applyBusiness(ProdutoModel produtoModel) throws ResponseBusinessException {

		String sku = changeSkuToUpperCase(produtoModel.getSku());
		produtoModel.setSku(sku);

		float preco = addValueToPreco(produtoModel.getCategoriaModel(), produtoModel.getPreco());
		produtoModel.setPreco(preco);

		verifiyNomeProduto(produtoModel.getNome());

		return produtoModel;
	}

	protected String changeSkuToUpperCase(String sku) {
		return sku.toUpperCase();
	}

	protected float addValueToPreco(CategoriaModel categoriaModel, float preco) {

		CategoriaModel categoria = categoriaRepository.findById(categoriaModel.getIdCategoria()).get();

		if ("Smartphone".equals(categoria.getNomeCategoria())) {
			preco = preco + 10;
		} else if ("Notebook".equals(categoria.getNomeCategoria())) {
			preco = preco + 20;
		}

		return preco;
	}

	protected void verifiyNomeProduto(String nomeProduto) throws ResponseBusinessException {

		String nome = nomeProduto.toUpperCase();

		if (nome.contains("TESTE")) {
			throw new ResponseBusinessException("Não é possível cadastrar produtos que contenha a palavra 'teste'");
		}
	}

	public List<ProdutoModel> findAll() {
		return produtoRepository.findAll();
	}

	public ProdutoModel findById(long id) {
		return produtoRepository.findById(id).get();
	}

	public void save(ProdutoModel produtoModel) {
		produtoRepository.save(produtoModel);

	}

	public void deleteById(long id) {
		produtoRepository.deleteById(id);
	}

}
