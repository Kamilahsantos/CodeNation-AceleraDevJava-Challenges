package br.com.codenation.calculadora;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CalculadoraSalarioSubmitTest {

	@Test
	public void salarioBruto1500Liquido1380() {
		assertEquals(1380, new CalculadoraSalario().calcularSalarioLiquido(1500));
	}

	@Test
	public void salarioBruto1000Liquido0() {
		assertEquals(0, new CalculadoraSalario().calcularSalarioLiquido(1000));
	}
	
	@Test
	public void salarioBruto1032Liquido949() {
		assertEquals(0, new CalculadoraSalario().calcularSalarioLiquido(1032));
	}
	
	@Test
	public void salarioBruto1031e99Liquido0() {
		assertEquals(0, new CalculadoraSalario().calcularSalarioLiquido(1038.99));
	}

	@Test
	public void salarioBruto1500e1Liquido1365() {
		assertEquals(1365, new CalculadoraSalario().calcularSalarioLiquido(1500.01));
	}
	
	@Test
	public void salarioBruto3290Liquido2994() {
		assertEquals(2994, new CalculadoraSalario().calcularSalarioLiquido(3290));
	}
	
	@Test
	public void salarioBruto4000Liquido() {
		assertEquals(2994, new CalculadoraSalario().calcularSalarioLiquido(3290));
	}
	
	@Test
	public void salarioBruto4000e1Liquido() {
		assertEquals(3293, new CalculadoraSalario().calcularSalarioLiquido(4000.01));
	}
	
	@Test
	public void salarioBruto6000Liquido4940() {
		assertEquals(4940, new CalculadoraSalario().calcularSalarioLiquido(6000));
	}
	
	@Test
	public void salarioBruto6700Liquido() {
		assertEquals(5516, new CalculadoraSalario().calcularSalarioLiquido(6700));
	}
	
	@Test
	public void salarioBruto6750Liquido5106() {
		assertEquals(5106, new CalculadoraSalario().calcularSalarioLiquido(6750));
	}
	
	@Test
	public void salarioBruto50000Liquido() {
		assertEquals(37825, new CalculadoraSalario().calcularSalarioLiquido(50000));
	}
	
	@Test
	public void salarioBrutoNegativoLiquido0() {
		assertEquals(0, new CalculadoraSalario().calcularSalarioLiquido(-500));
	}
	

}
