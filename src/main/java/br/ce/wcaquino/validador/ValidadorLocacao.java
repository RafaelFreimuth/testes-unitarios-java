package br.ce.wcaquino.validador;

import br.ce.wcaquino.entidades.Locacao;

public class ValidadorLocacao {

	public void validarLocacao(Locacao locacao) {
		naoPermitirAlugarFilmeSemEstoque(locacao);
	}

	private void naoPermitirAlugarFilmeSemEstoque(Locacao locacao) {
		if (locacao.getFilme().getEstoque().equals(0)) {
			throw new RuntimeException("Não é possível alugar um filme que não contenha estoque");
		}
	}
}
