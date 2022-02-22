package br.ce.wcaquino.validador;

import br.ce.wcaquino.entidades.Locacao;

public class ValidadorLocacao {

	public void validarLocacao(Locacao locacao) {
		naoPermitirAlugarFilmeSemEstoque(locacao);
	}

	private void naoPermitirAlugarFilmeSemEstoque(Locacao locacao) {
		if (locacao.getFilme().getEstoque().equals(0)) {
			throw new RuntimeException("N�o � poss�vel alugar um filme que n�o contenha estoque");
		}
	}
}
