package test;

import br.com.codenation.DesafioMeuTimeApplication;
import br.com.codenation.desafio.exceptions.CapitaoNaoInformadoException;
import br.com.codenation.desafio.exceptions.IdentificadorUtilizadoException;
import br.com.codenation.desafio.exceptions.JogadorNaoEncontradoException;
import br.com.codenation.desafio.exceptions.TimeNaoEncontradoException;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class DesafioMeuTimeApplicationTest {
  private DesafioMeuTimeApplication app;

  @Before
  public void before(){
    app = new DesafioMeuTimeApplication();
  }

  @Test(expected = IdentificadorUtilizadoException.class)
  public void deveRetornarErroQuandoRepeteIdTime(){
    app.incluirTime(1L,"time", LocalDate.now(),"preto", "branco");
    app.incluirTime(1L,"time", LocalDate.now(),"roxo", "vermelho");
  }

  @Test(expected = TimeNaoEncontradoException.class)
  public void deveRetornarErroQuandoTimeNaoExiste(){
    app.incluirJogador(1L,1L, "kamila", LocalDate.now(), 30, new BigDecimal(1.25));
  }

  @Test(expected = IdentificadorUtilizadoException.class)
  public void deveRetornarErroQuandoRepeteIdJogador(){
    app.incluirTime(1L,"time", LocalDate.now(),"preto", "branco");
    app.incluirJogador(1L,1L, "teste", LocalDate.now(), 56, new BigDecimal(1.25));
    app.incluirJogador(1L,1L, "maria", LocalDate.now(), 56, new BigDecimal(1.25));
  }

  @Test(expected = IllegalArgumentException.class)
  public void deveRetornarErroQuandoHabilidadeMaior100(){
    app.incluirTime(1L,"time", LocalDate.now(),"roxo", "vermelho");
    app.incluirJogador(1L,1L, "jao", LocalDate.now(), 56, new BigDecimal(1.25));
    app.incluirJogador(2L,1L, "jao", LocalDate.now(), 101, new BigDecimal(1.25));
  }

  @Test(expected = IllegalArgumentException.class)
  public void deveRetornarErroQuandoHabilidadeMenor0(){
    app.incluirTime(1L,"time", LocalDate.now(),"branco", "azul");
    app.incluirJogador(1L,1L, "jao", LocalDate.now(), 56, new BigDecimal(1.25));
    app.incluirJogador(2L,1L, "jao", LocalDate.now(), -1, new BigDecimal(1.25));
  }

  @Test(expected = JogadorNaoEncontradoException.class)
  public void deveRetornarErroQuandoNaoExisteJogador(){
    app.incluirTime(1L,"time", LocalDate.now(),"branco", "azul");
    app.incluirJogador(1L,1L, "jao", LocalDate.now(), 56, new BigDecimal(1.25));
    app.definirCapitao(2L);
  }

  @Test(expected = TimeNaoEncontradoException.class)
  public void deveRetornarErroQuandoBuscaCapitaoENaoExisteTime(){
    app.incluirTime(1L,"time", LocalDate.now(),"branco", "azul");
    app.incluirJogador(1L,1L, "jao", LocalDate.now(), 56, new BigDecimal(1.25));
    app.definirCapitao(1L);
    app.buscarCapitaoDoTime(2L);
  }

  @Test(expected = CapitaoNaoInformadoException.class)
  public void deveRetornarErroQuandoBuscaCapitaoENaoHaCapitao(){
    app.incluirTime(1L,"time", LocalDate.now(),"branco", "azul");
    app.incluirJogador(1L,1L, "jao", LocalDate.now(), 56, new BigDecimal(1.25));
    app.buscarCapitaoDoTime(1L);
  }

  @Test
  public void deveRetornarIdCapitao(){
    app.incluirTime(1L,"time", LocalDate.now(),"branco", "azul");
    app.incluirJogador(3L,1L, "jao", LocalDate.now(), 56, new BigDecimal(1.25));
    app.definirCapitao(3L);
    assertEquals(new Long(3L), app.buscarCapitaoDoTime(1L));
  }

  @Test(expected = JogadorNaoEncontradoException.class)
  public void deveRetornarErroQuandoBuscaNomeDeJogadorInexistente(){
    app.buscarNomeJogador(1L);
  }

  @Test
  public void deveRetornarNomeJogador(){
    app.incluirTime(1L,"time", LocalDate.now(),"branco", "azul");
    app.incluirJogador(3L,1L, "jao", LocalDate.now(), 56, new BigDecimal(1.25));
    assertEquals("jao", app.buscarNomeJogador(3L));
  }

  @Test(expected = TimeNaoEncontradoException.class)
  public void deveRetornarErroQuandoBuscaNomeDeTimeInexistente(){
    app.buscarNomeTime(1L);
  }

  @Test
  public void deveRetornarNomeTime(){
    app.incluirTime(1L,"time", LocalDate.now(),"branco", "azul");
    assertEquals("time", app.buscarNomeTime(1L));
  }

  @Test(expected = TimeNaoEncontradoException.class)
  public void deveRetornarErroQuandoBuscaJogadoresDeTimeInexistente(){
    app.buscarJogadoresDoTime(1L);
  }

  @Test
  public void deveRetornarListaOrdenadaJogadores(){
    app.incluirTime(1L,"time", LocalDate.now(),"branco", "azul");
    app.incluirTime(2L,"time", LocalDate.now(),"branco", "azul");
    app.incluirJogador(15L,1L, "jao", LocalDate.now(), 56, new BigDecimal(1.25));
    app.incluirJogador(12L,2L, "jao", LocalDate.now(), 56, new BigDecimal(1.25));
    app.incluirJogador(3L,1L, "jao", LocalDate.now(), 56, new BigDecimal(1.25));
    assertEquals(new ArrayList<Long>(Arrays.asList(3L, 15L)), app.buscarJogadoresDoTime(1L));
  }

  @Test
  public void deveRetornarMelhorJogador(){
    app.incluirTime(1L,"time", LocalDate.now(),"branco", "azul");
    app.incluirTime(2L,"time", LocalDate.now(),"branco", "azul");
    app.incluirJogador(15L,1L, "jao", LocalDate.now(), 56, new BigDecimal(1.25));
    app.incluirJogador(12L,2L, "jao", LocalDate.now(), 56, new BigDecimal(1.25));
    app.incluirJogador(3L,1L, "jao", LocalDate.now(), 89, new BigDecimal(1.25));
    app.incluirJogador(8L,1L, "jao", LocalDate.now(), 91, new BigDecimal(1.25));
    assertEquals(new Long(8L), app.buscarMelhorJogadorDoTime(1L));
  }

  @Test
  public void deveRetornarJogadorMaisVelho(){
    app.incluirTime(1L,"time", LocalDate.now(),"branco", "azul");
    app.incluirTime(2L,"time", LocalDate.now(),"branco", "azul");
    app.incluirJogador(15L,1L, "jao", LocalDate.of(1990,3,5), 56, new BigDecimal(1.25));
    app.incluirJogador(12L,2L, "jao", LocalDate.of(1900,1,1), 56, new BigDecimal(1.25));
    app.incluirJogador(3L,1L, "jao", LocalDate.of(1987,1,1), 89, new BigDecimal(1.25));
    app.incluirJogador(8L,1L, "jao", LocalDate.of(1987,1,1), 91, new BigDecimal(1.25));
    assertEquals(new Long(3L), app.buscarJogadorMaisVelho(1L));
  }

  @Test
  public void deveRetornarListaVaziaTimes(){
    assertEquals(new ArrayList<Long>(), app.buscarTimes());
  }

  @Test
  public void deveRetornarListaOrdenadaTimes(){
    app.incluirTime(35L,"time", LocalDate.now(),"branco", "azul");
    app.incluirTime(2L,"time", LocalDate.now(),"branco", "azul");
    app.incluirTime(7L,"time", LocalDate.now(),"branco", "azul");
    app.incluirTime(5L,"time", LocalDate.now(),"branco", "azul");
    assertEquals(new ArrayList<Long>(Arrays.asList(2L,5L,7L,35L)), app.buscarTimes());
  }

  @Test
  public void deveRetornarJogadorMaiorSalario(){
    app.incluirTime(1L,"time", LocalDate.now(),"branco", "azul");
    app.incluirTime(2L,"time", LocalDate.now(),"branco", "azul");
    app.incluirJogador(15L,1L, "jao", LocalDate.of(1990,3,5), 56, BigDecimal.valueOf(1357.25));
    app.incluirJogador(12L,2L, "jao", LocalDate.of(1900,1,1), 56, BigDecimal.valueOf(10000000.25));
    app.incluirJogador(3L,1L, "jao", LocalDate.of(1987,1,1), 89, BigDecimal.valueOf(13357.25));
    app.incluirJogador(8L,1L, "jao", LocalDate.of(1987,1,1), 91, BigDecimal.valueOf(10557.25));
    assertEquals(new Long(3L), app.buscarJogadorMaiorSalario(1L));
  }

  @Test
  public void deveRetornarSalarioJogador(){
    app.incluirTime(1L,"time", LocalDate.now(),"branco", "azul");
    app.incluirTime(2L,"time", LocalDate.now(),"branco", "azul");
    app.incluirJogador(15L,1L, "jao", LocalDate.of(1990,3,5), 56, BigDecimal.valueOf(1357.25));
    app.incluirJogador(12L,2L, "jao", LocalDate.of(1900,1,1), 56, BigDecimal.valueOf(10000000.25));
    app.incluirJogador(3L,1L, "jao", LocalDate.of(1987,1,1), 89, BigDecimal.valueOf(13357.25));
    app.incluirJogador(8L,1L, "jao", LocalDate.of(1987,1,1), 91, BigDecimal.valueOf(10557.25));
    assertEquals(BigDecimal.valueOf(13357.25), app.buscarSalarioDoJogador(3L));
  }

  @Test
  public void deveRetornarLista3TopJogadores(){
    app.incluirTime(1L,"time", LocalDate.now(),"branco", "azul");
    app.incluirTime(2L,"time", LocalDate.now(),"branco", "azul");
    app.incluirJogador(15L,1L, "jao", LocalDate.of(1990,3,5), 56, BigDecimal.valueOf(1357.25));
    app.incluirJogador(12L,2L, "jao", LocalDate.of(1900,1,1), 100, BigDecimal.valueOf(10000000.25));
    app.incluirJogador(11L,2L, "jao", LocalDate.of(1900,1,1), 100, BigDecimal.valueOf(10000000.25));
    app.incluirJogador(3L,1L, "jao", LocalDate.of(1987,1,1), 89, BigDecimal.valueOf(13357.25));
    app.incluirJogador(8L,1L, "jao", LocalDate.of(1987,1,1), 91, BigDecimal.valueOf(10557.25));
    assertEquals(new ArrayList<>(Arrays.asList(11L,12L,8L)), app.buscarTopJogadores(3));
  }

  @Test(expected = IllegalArgumentException.class)
  public void deveRetornarIndexOutOfBounds(){
    app.incluirTime(1L,"time", LocalDate.now(),"branco", "azul");
    app.incluirTime(2L,"time", LocalDate.now(),"branco", "azul");
    app.incluirJogador(15L,1L, "jao", LocalDate.of(1990,3,5), 56, BigDecimal.valueOf(1357.25));
    app.incluirJogador(12L,2L, "jao", LocalDate.of(1900,1,1), 53, BigDecimal.valueOf(10000000.25));
    app.incluirJogador(3L,1L, "jao", LocalDate.of(1987,1,1), 89, BigDecimal.valueOf(13357.25));
    app.incluirJogador(8L,1L, "jao", LocalDate.of(1987,1,1), 91, BigDecimal.valueOf(10557.25));
    app.buscarTopJogadores(5);
  }

  @Test
  public void deveRetornarArrayVazio(){
    assertEquals(new ArrayList<Long>(), app.buscarTopJogadores(3));
  }

  @Test
  public void deveRetornarCamisaSecundariaTimeFora(){
    app.incluirTime(1L,"time", LocalDate.now(),"branco", "azul");
    app.incluirTime(2L,"time", LocalDate.now(),"branco", "verde");
    assertEquals("verde", app.buscarCorCamisaTimeDeFora(1L,2L));
  }

  @Test
  public void deveRetornarCamisaPrincipalTimeFora(){
    app.incluirTime(1L,"time", LocalDate.now(),"branco", "azul");
    app.incluirTime(2L,"time", LocalDate.now(),"azul", "verde");
    assertEquals("azul", app.buscarCorCamisaTimeDeFora(1L,2L));
  }

  @Test(expected = TimeNaoEncontradoException.class)
  public void deveRetornarExcecaoSeUmDosTimesNaoExistir(){
    app.buscarCorCamisaTimeDeFora(1L,2L);
  }

}
