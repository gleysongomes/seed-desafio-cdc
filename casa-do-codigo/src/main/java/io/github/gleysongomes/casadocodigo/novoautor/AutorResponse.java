package io.github.gleysongomes.casadocodigo.novoautor;

import java.time.LocalDateTime;

// 1 ponto

public class AutorResponse {

	private String nome;

	private String email;

	private String descricao;

	private LocalDateTime dataCriacao;

	private String codigo;

	// 1 ponto
	public AutorResponse(Autor autor) {
		this.nome = autor.getNome();
		this.email = autor.getEmail();
		this.descricao = autor.getDescricao();
		this.codigo = autor.getCodigo();
		this.dataCriacao = autor.getDataCriacao();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
}
