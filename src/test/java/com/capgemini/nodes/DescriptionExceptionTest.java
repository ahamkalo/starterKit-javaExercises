package com.capgemini.nodes;

import static org.junit.Assert.*;

import org.junit.Test;

public class DescriptionExceptionTest {

	@Test
	public void shouldReturnDescriptionExceptionMessage() {
		assertEquals("DescriptionException", new DescriptionException().getMessage());
	}
}
