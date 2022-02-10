package br.ce.wcaquino.builders;

import java.io.Serializable;
import java.util.Date;

import br.ce.wcaquino.entidades.Filme;
import br.ce.wcaquino.entidades.Locacao;
import br.ce.wcaquino.entidades.Usuario;

public class LocacaoBuilder implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Locacao locacao = new Locacao();
	
	public LocacaoBuilder withUsuario(Usuario usuario) {
		locacao.setUsuario(usuario);
		return this;
	}
	
	public LocacaoBuilder withFilme(Filme filme) {
		locacao.setFilme(filme);
		return this;
	}
	
	public LocacaoBuilder withDataLocacao(Date dataLocacao) {
		locacao.setDataLocacao(dataLocacao);
		return this;
	}
	
	public LocacaoBuilder withDataRetorno(Date dataRetorno) {
		locacao.setDataRetorno(dataRetorno);
		return this;
	}
	
	public LocacaoBuilder withValor(Double valor) {
		locacao.setValor(valor);
		return this;
	}
	
	public Locacao build() {
		return locacao;
	}

}
