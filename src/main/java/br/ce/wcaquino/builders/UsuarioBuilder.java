package br.ce.wcaquino.builders;

import java.io.Serializable;

import br.ce.wcaquino.entidades.Usuario;

public class UsuarioBuilder implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private static Usuario usuario = new Usuario();
	
	public UsuarioBuilder withNome(String nome) {
		usuario.setNome(nome);
		
		return this;
	}
	
	public Usuario build() {
		return usuario;
	}
}
