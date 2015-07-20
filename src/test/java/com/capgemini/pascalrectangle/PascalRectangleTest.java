package com.capgemini.pascalrectangle;

import static org.junit.Assert.*;

import org.junit.Test;

public class PascalRectangleTest {

	@Test
	public void shouldReturn1For0_0() {
		assertEquals(1, PascalRectangle.pascal(0, 0));
	}

	@Test
	public void shouldReturn1For0_1() {
		assertEquals(1, PascalRectangle.pascal(0, 1));
	}

	@Test
	public void shouldReturn1For1_1() {
		assertEquals(1, PascalRectangle.pascal(0, 0));
	}

	@Test
	public void shouldReturn2For1_2() {
		assertEquals(2, PascalRectangle.pascal(1, 2));
	}

	@Test
	public void shouldReturn28For6_8() {
		assertEquals(28, PascalRectangle.pascal(6, 8));
	}

	@Test
	public void shouldThrowIllegalArgumentException() {
		try {
			PascalRectangle.pascal(8, 6);
			fail("should throw IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			
		}
		catch (Exception e){
			fail("should throw IllegalArgumentException");
		}
	}
}
