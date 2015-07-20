package com.capgemini.nodes;

import static org.junit.Assert.*;

import org.junit.Test;

public class CycleExceptionTest {

	@Test
	public void shouldReturnCycleExceptionMessage() {
		assertEquals("CycleException", new CycleException().getMessage());
	}
}
