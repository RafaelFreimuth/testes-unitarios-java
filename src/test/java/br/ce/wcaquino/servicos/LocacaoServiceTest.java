package br.ce.wcaquino.servicos;

import static br.ce.wcaquino.utils.DataUtils.isMesmaData;
import static br.ce.wcaquino.utils.DataUtils.obterDataComDiferencaDias;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Test;

import br.ce.wcaquino.builders.FilmeBuilder;
import br.ce.wcaquino.builders.UsuarioBuilder;
import br.ce.wcaquino.entidades.Filme;
import br.ce.wcaquino.entidades.Locacao;
import br.ce.wcaquino.entidades.Usuario;

public class LocacaoServiceTest {

	@Test
	public void deveAlugarFilme() {
		LocacaoService service = new LocacaoService();
		
		Usuario usuario = new UsuarioBuilder()
								.withNome("Rafael")
								.build();
		
		Filme filme = new FilmeBuilder()
							.withNome("Invocação do mal")
							.withEstoque(15)
							.withPrecoLocacao(26.1)
							.build();
		
		Locacao locacao = service.alugarFilme(usuario, filme);
		
		assertTrue(locacao.getValor().equals(26.1));
		assertTrue(isMesmaData(locacao.getDataLocacao(), new Date()));
		assertTrue(isMesmaData(locacao.getDataRetorno(), obterDataComDiferencaDias(1)));
	}
}
