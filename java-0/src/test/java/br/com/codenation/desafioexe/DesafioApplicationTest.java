package br.com.codenation.desafioexe;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class DesafioApplicationTest {

	@Test
	public void fibonacci() {
		assertNotNull(DesafioApplication.fibonacci());
	}

	@Test
	public void isFibonacci() {
		assertTrue(DesafioApplication.isFibonacci(1));
	}

}
