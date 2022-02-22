package br.ce.wcaquino.validador;

import br.ce.wcaquino.entidades.Locacao;
import br.ce.wcaquino.utils.ObjectUtil;

public class ValidadorLocacao {

	public void validarLocacao(Locacao locacao) {
		validarCamposObrigatorios(locacao);
		naoPermitirAlugarFilmeSemEstoque(locacao);
	}

	private void validarCamposObrigatorios(Locacao locacao) {
		if (ObjectUtil.isNull(locacao.getFilme())) {
			throw new RuntimeException("O Filme é obrigatório para a locação de um filme.");
		}
		
		if (ObjectUtil.isNull(locacao.getUsuario())) {
			throw new RuntimeException("O Usuário é obrigatório para a locação de um filme.");
		}
	}

	private void naoPermitirAlugarFilmeSemEstoque(Locacao locacao) {
		if (locacao.getFilme().getEstoque().equals(0)) {
			throw new RuntimeException("Não é possível alugar um filme que não contenha estoque");
		}
	}
}
