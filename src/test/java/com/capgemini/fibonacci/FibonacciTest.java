package com.capgemini.fibonacci;

import static org.junit.Assert.*;

import org.junit.Test;
public class FibonacciTest {

	@Test
	public void shouldReturn1For1() {
		assertEquals(1, Fibonacci.fib(1));
	}
	@Test
	public void shouldReturn1For2() {
		assertEquals(1, Fibonacci.fib(2));
	}
	@Test
	public void shouldReturn2For3() {
		assertEquals(2, Fibonacci.fib(3));
	}
	@Test
	public void shouldReturn1597For17() {
		assertEquals(1597, Fibonacci.fib(17));
	}
	@Test
	public void shouldThrowIllegalArgumentException() {
		try {
			Fibonacci.fib(-1);
			fail("should throw IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			
		}
		catch (Exception e){
			fail("should throw IllegalArgumentException");
		}
	}
}
