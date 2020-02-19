package br.com.fiap.business;

import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.fiap.exception.ResponseBusinessException;
import br.com.fiap.model.CategoriaModel;
import br.com.fiap.model.ProdutoModel;
import br.com.fiap.repository.CategoriaRepository;

@SpringBootTest
public class ProdutoBusinessTest {

	@InjectMocks
	public ProdutoBusiness produtoBusiness;

	@Mock
	private CategoriaRepository categoriaRepository;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testChangeSkuToUpperCase() {

		// GIVEN
		String sku = "1223abcf";
		String expected = "1223ABCF";

		// WHEN
		String actual = produtoBusiness.changeSkuToUpperCase(sku);

		// THEN
		assertEquals("Erro ao transformar o SKU em maiúsculo.", expected, actual);

	}

	@Test
	public void testAddValueToPrecoWithCategoriaSmarthphone() {

		// GIVEN
		CategoriaModel categoriaModel = new CategoriaModel(1, null, null);
		float preco = 10;
		float expected = 20;

		// WHEN
		Mockito.when(categoriaRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(new CategoriaModel(1, "Smartphone", null)));
		float actual = produtoBusiness.addValueToPreco(categoriaModel, preco);

		// THEN
		assertEquals("Erro ao adicionar 10 reais caso a categoria seja 'Smartphone'. ", expected, actual, 0);
	}

	@Test
	public void testAddValueToPrecoWithCategoriaNotebook() {

		// GIVEN
		CategoriaModel categoriaModel = new CategoriaModel(1, null, null);
		float preco = 10;
		float expected = 30;

		// WHEN
		Mockito.when(categoriaRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(new CategoriaModel(2, "Notebook", null)));
		float actual = produtoBusiness.addValueToPreco(categoriaModel, preco);

		// THEN
		assertEquals("Erro ao adicionar 10 reais caso a categoria seja 'Notebook'. ", expected, actual, 0);
	}

	@Test
	public void testAddValueToPrecoWithoutCategoria() {

		// GIVEN
		CategoriaModel categoriaModel = new CategoriaModel(1, null, null);
		float preco = 10;
		float expected = 10;

		// WHEN
		Mockito.when(categoriaRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(new CategoriaModel(3, "Games", null)));
		float actual = produtoBusiness.addValueToPreco(categoriaModel, preco);

		// THEN
		assertEquals("Erro ao retornar o preco caso categoria não seja Smartphone ou Notebook", expected, actual, 0);
	}

	@Test(expected = ResponseBusinessException.class)
	public void testVerifiyNomeProdutoWithTeste() throws ResponseBusinessException {

		// GIVEN
		String nomeProduto = "Produto de Teste";

		// WHEN
		produtoBusiness.verifiyNomeProduto(nomeProduto);
	}

	@Test
	public void testVerifiyNomeProdutoWithoutTeste() throws ResponseBusinessException {

		// GIVEN
		String nomeProduto = "Produto Normal";

		// WHEN
		produtoBusiness.verifiyNomeProduto(nomeProduto);
	}

	@Test
	public void testApplyBusiness() throws ResponseBusinessException {
		
		// GIVEN
		CategoriaModel categoriaModel = new CategoriaModel(1, "Notebook", null);
		ProdutoModel produtoModel = new ProdutoModel(1, "Produto OK", "1223abcf", "Descrição teste", 10, "Caractetisticas Teste", null, categoriaModel, null);
		ProdutoModel expected = new ProdutoModel(1, "Produto OK", "1223ABCF", "Descrição teste", 30, "Caractetisticas Teste", null, categoriaModel, null);
		
		// WHEN
		Mockito.when(categoriaRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(categoriaModel));
		ProdutoModel actual = produtoBusiness.applyBusiness(produtoModel);
		
		// THEN
		Mockito.verify(categoriaRepository, Mockito.times(1)).findById(Mockito.anyLong());
		assertEquals(expected.toString(), actual.toString());
	}

}
