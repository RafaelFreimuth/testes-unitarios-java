package br.ce.wcaquino.servicos;

import static br.ce.wcaquino.utils.DataUtils.adicionarDias;

import java.util.Date;

import br.ce.wcaquino.entidades.Filme;
import br.ce.wcaquino.entidades.Locacao;
import br.ce.wcaquino.entidades.Usuario;
import br.ce.wcaquino.validador.ValidadorLocacao;

public class LocacaoService {
	
	public Locacao alugarFilme(Usuario usuario, Filme filme) {
		ValidadorLocacao validadorLocacao = new ValidadorLocacao();
		
		Locacao locacao = new Locacao();
		locacao.setFilme(filme);
		locacao.setUsuario(usuario);
		locacao.setDataLocacao(new Date());
		
		validadorLocacao.validarCamposObrigatorios(locacao);

		locacao.setValor(filme.getPrecoLocacao());

		Date dataEntrega = new Date();
		dataEntrega = adicionarDias(dataEntrega, 1);
		
		locacao.setDataRetorno(dataEntrega);
		
		validadorLocacao.naoPermitirAlugarFilmeSemEstoque(filme);
		
		return locacao;
	}
}