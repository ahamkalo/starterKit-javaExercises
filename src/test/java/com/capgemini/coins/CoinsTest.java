package com.capgemini.coins;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class CoinsTest {
	List<Integer> coins = new ArrayList<Integer>();

	@Test
	public void shouldReverseSecondCoin() {
		coins.addAll(Arrays.asList(1,1,0,1,0,0));
		Coins.reverseCoin(coins, 2);
		assertEquals(1, (int) coins.get(2));

		Coins.reverseCoin(coins, 2);
		assertEquals(0, (int) coins.get(2));
	}
	@Test
	public void shouldCount2For1_1_0_1_0_0() {
		coins.addAll(Arrays.asList(1,1,0,1,0,0));
		assertEquals(2, Coins.countAdjacentPairs(coins));
	}

	@Test
	public void shouldReturn4For1_1_0_1_0_0() {
		coins.addAll(Arrays.asList(1,1,0,1,0,0));
		assertEquals(4, Coins.solution(coins));
	}

	@Test
	public void shouldReturn4For0_0_0_0_0_0() {
		coins.addAll(Arrays.asList(0,0,0,0,0,0));
		assertEquals(4, Coins.solution(coins));
	}

	@Test
	public void shouldReturn4For1_1_1_1_1_1() {
		coins.addAll(Arrays.asList(1,1,1,1,1,1));
		assertEquals(4, Coins.solution(coins));
	}

	@Test
	public void shouldReturn5For0_0_0_0_0_1() {
		coins.addAll(Arrays.asList(0,0,0,0,0,1));
		assertEquals(5, Coins.solution(coins));
	}

	@Test
	public void shouldReturn5For1_0_0_0_0_0() {
		coins.addAll(Arrays.asList(1,0,0,0,0,0));
		assertEquals(5, Coins.solution(coins));
	}

	@Test
	public void shouldReturn1For1_0() {
		coins.addAll(Arrays.asList(1,0));
		assertEquals(1, Coins.solution(coins));
	}

	@Test
	public void shouldReturn1For0_1() {
		coins.addAll(Arrays.asList(0,1));
		assertEquals(1, Coins.solution(coins));
	}

	@Test
	public void shouldReturn0For0_0() {
		coins.addAll(Arrays.asList(0,0));
		assertEquals(0, Coins.solution(coins));
	}

	@Test
	public void shouldReturn0For1_1() {
		coins.addAll(Arrays.asList(1,1));
		assertEquals(0, Coins.solution(coins));
	}
}
