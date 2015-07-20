package com.capgemini.nodes;

import static org.junit.Assert.*;

import org.junit.Test;

public class IdExceptionTest {

	@Test
	public void shouldReturnIdExceptionMessage() {
		assertEquals("IdException", new IdException().getMessage());
	}
}
