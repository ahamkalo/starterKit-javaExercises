package com.capgemini.pythagorean;

/**
 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for
 * which, a2 + b2 = c2 For example, 32 + 42 = 9 + 16 = 25 = 52. There exists
 * exactly one Pythagorean triplet for which a + b + c = 1000. Find the product
 * abc.
 */

/**
 * Euclid's Algorythm
 * 
 * If m > n then a = m^2 - n^2, b = 2mn, c = m^2 + n^2 form a Pythagorean triple
 * a + b + c = 2m(m + n) If 2m(m + n) = 1000 --> m(m + n) = 500 then m < sqrt(500)
 * 
 */
public class Pythagorean {

	public static int result() {
		int a, b, c, n;

		for (int m = 1; m <= Math.sqrt(500); m++) {
			n = 500 / m - m;
			if (n > m) {
				continue;
			}
			a = m * m - n * n;
			b = 2 * m * n;
			c = m * m + n * n;
			if (a + b + c == 1000) {
				return a * b * c;
			}
		}

		return 0;
	}
}
