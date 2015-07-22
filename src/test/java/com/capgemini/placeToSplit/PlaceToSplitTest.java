package com.capgemini.placeToSplit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PlaceToSplitTest {
	int[] array;

	@Before
	public void before() {
		array = new int[] { 2, 1, 1, 2, 2 };
	}

	@Test
	public void shouldReturnTrueFor2_1_1_2_2() {
		assertTrue(PlaceToSplit.canBalance(array));
	}

	@Test
	public void shouldReturnFalseFor2_1_5_2_2() {
		array[2] = 5;
		assertFalse(PlaceToSplit.canBalance(array));
	}

	@Test
	public void shouldReturnFalseFor2_1_4_2_2() {
		array[2] = 4;
		assertFalse(PlaceToSplit.canBalance(array));
	}

	@Test
	public void shouldReturnTrueFor1_1() {
		array = new int[] { 1, 1 };
		assertTrue(PlaceToSplit.canBalance(array));
	}

	@Test
	public void shouldReturnFalseFor1() {
		array = new int[] { 1 };
		assertFalse(PlaceToSplit.canBalance(array));
	}

	@Test
	public void shouldReturnFalseFor0() {
		array = new int[] { 0 };
		assertFalse(PlaceToSplit.canBalance(array));
	}
}
