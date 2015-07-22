package com.capgemini.nodes;

import static org.junit.Assert.*;

import org.junit.Test;

public class PenultimateExceptionTest {

	@Test
	public void shouldReturnPenultimateExceptionMessage() {
		assertEquals("PenultimateException", new PenultimateException().getMessage());
	}
}
