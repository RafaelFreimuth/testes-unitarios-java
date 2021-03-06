package br.ce.wcaquino.validador;

import br.ce.wcaquino.entidades.Filme;
import br.ce.wcaquino.entidades.Locacao;
import br.ce.wcaquino.utils.ObjectUtil;

public class ValidadorLocacao {

	public void validarCamposObrigatorios(Locacao locacao) {
		if (ObjectUtil.isNull(locacao.getFilme())) {
			throw new RuntimeException("O Filme ? obrigat?rio para a loca??o de um filme.");
		}
		
		if (ObjectUtil.isNull(locacao.getUsuario())) {
			throw new RuntimeException("O Usu?rio ? obrigat?rio para a loca??o de um filme.");
		}
	}

	public void naoPermitirAlugarFilmeSemEstoque(Filme filme) {
		if (filme.getEstoque().equals(0)) {
			throw new RuntimeException("N?o ? poss?vel alugar um filme que n?o contenha estoque.");
		}
	}
}
