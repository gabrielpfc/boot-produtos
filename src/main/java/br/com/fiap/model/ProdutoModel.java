package br.com.fiap.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "TB_PRODUTO")
public class ProdutoModel {

	private long id;
	private String nome;
	private String sku;
	private String descricao;
	private float preco;
	private String caracteristicas;
	private Date dataLancamento;
	private CategoriaModel categoriaModel;
	private MarcaModel marcaModel;

	public ProdutoModel() {
	}

	public ProdutoModel(long id, String nome, String sku, String descricao, float preco, String caracteristicas,
			Date dataLancamento, CategoriaModel categoriaModel, MarcaModel marcaModel) {
		super();
		this.id = id;
		this.nome = nome;
		this.sku = sku;
		this.descricao = descricao;
		this.preco = preco;
		this.caracteristicas = caracteristicas;
		this.dataLancamento = dataLancamento;
		this.categoriaModel = categoriaModel;
		this.marcaModel = marcaModel;
	}

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRODUTO_SEQ")
	@SequenceGenerator(name = "PRODUTO_SEQ", initialValue = 1, allocationSize = 1)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "NOME")
	@NotNull(message = "Nome obrigatório")
	@Size(min = 2, max = 50, message = "NOME deve ser entre 2 e 50 caracteres")
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Column(name = "SKU")
	@NotNull(message = "Sku obrigatório")
	@Size(min = 2, max = 40, message = "SKU deve ser entre 2 e 50 caracteres")
	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	@Column(name = "DESCRICAO")
	@NotNull(message = "Descrição obrigatório")
	@Size(min = 10, max = 400, message = "DESCRIÇÃO deve ser entre 10 e 400 caracteres")
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Column(name = "PRECO")
	@DecimalMin(value = "0.01", message = "PRECO deve ser acima de 0.01")
	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	@Column(name = "CARACTERISTICAS")
	@Size(min = 10, max = 400, message = "CARACTERÍSTICAS deve ser entre 10 e 400 caracteres")
	public String getCaracteristicas() {
		return caracteristicas;
	}

	public void setCaracteristicas(String caracteristicas) {
		this.caracteristicas = caracteristicas;
	}

	@Column(name = "DATA_LANCAMENTO")
	@NotNull(message = "Data obrigatória no formato dia/mês/ano, exemplo: 10/06/2019")
	@JsonFormat(pattern="dd/MM/yyyy")
	public Date getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(Date dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	@ManyToOne
	@JoinColumn(name = "ID_CATEGORIA", nullable = false)
	public CategoriaModel getCategoriaModel() {
		return categoriaModel;
	}

	public void setCategoriaModel(CategoriaModel categoriaModel) {
		this.categoriaModel = categoriaModel;
	}

	@ManyToOne
	@JoinColumn(name = "ID_MARCA", nullable = false)
	public MarcaModel getMarcaModel() {
		return marcaModel;
	}

	public void setMarcaModel(MarcaModel marcaModel) {
		this.marcaModel = marcaModel;
	}

	@Override
	public String toString() {
		return "ProdutoModel [id=" + id + ", nome=" + nome + ", sku=" + sku + ", descricao=" + descricao + ", preco="
				+ preco + ", caracteristicas=" + caracteristicas + ", dataLancamento=" + dataLancamento
				+ ", categoriaModel=" + categoriaModel + ", marcaModel=" + marcaModel + "]";
	}

}
