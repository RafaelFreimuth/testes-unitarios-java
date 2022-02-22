package br.ce.wcaquino.servicos;

import static br.ce.wcaquino.utils.DataUtils.isMesmaData;
import static br.ce.wcaquino.utils.DataUtils.obterDataComDiferencaDias;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import br.ce.wcaquino.builders.FilmeBuilder;
import br.ce.wcaquino.builders.UsuarioBuilder;
import br.ce.wcaquino.entidades.Filme;
import br.ce.wcaquino.entidades.Locacao;
import br.ce.wcaquino.entidades.Usuario;

public class LocacaoServiceTest {

	@Rule
	public ExpectedException expectedException = ExpectedException.none();
	
	@Test
	public void deveAlugarFilmeComEstoqueDisponivel() {
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
		
		assertEquals(Double.valueOf(26.1), locacao.getValor());
		
		assertTrue(isMesmaData(locacao.getDataLocacao(), new Date()));
		assertTrue(isMesmaData(locacao.getDataRetorno(), obterDataComDiferencaDias(1)));
	}
	
	@Test(expected = RuntimeException.class)
	public void naoDeveAlugarUmFilmeQueNaoTenhaEstoque() {
		LocacaoService service = new LocacaoService();
		
		Usuario usuario = new UsuarioBuilder()
								.withNome("Rafael")
								.build();
		
		Filme filme = new FilmeBuilder()
							.withNome("Invocação do mal")
							.withEstoque(0)
							.withPrecoLocacao(26.1)
							.build();
		
		service.alugarFilme(usuario, filme);
	}
	
	@Test
	public void naoDeveAlugarUmFilmeQueNaoTenhaEstoqueComVerificacaoComRule() {
		LocacaoService service = new LocacaoService();
		
		Usuario usuario = new UsuarioBuilder()
								.withNome("Rafael")
								.build();
		
		Filme filme = new FilmeBuilder()
							.withNome("Invocação do mal")
							.withEstoque(0)
							.withPrecoLocacao(26.1)
							.build();
				
		expectedException.expect(RuntimeException.class);
		expectedException.expectMessage("Não é possível alugar um filme que não contenha estoque");
		
		service.alugarFilme(usuario, filme);
	}
}
