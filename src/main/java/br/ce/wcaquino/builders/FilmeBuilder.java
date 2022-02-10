package br.ce.wcaquino.builders;

import java.io.Serializable;

import br.ce.wcaquino.entidades.Filme;

public class FilmeBuilder implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Filme filme = new Filme();
	
	public FilmeBuilder withNome(String nome) {
		filme.setNome(nome);
		return this;
	}
	
	public FilmeBuilder withEstoque(Integer estoque) {
		filme.setEstoque(estoque);
		return this;
	}
	
	public FilmeBuilder withPrecoLocacao(Double precoLocacao) {
		filme.setPrecoLocacao(precoLocacao);
		return this;
	}
	
	public Filme build() {
		return filme;
	}
	
}
