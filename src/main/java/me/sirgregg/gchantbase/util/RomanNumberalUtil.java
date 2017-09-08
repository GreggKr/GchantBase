package me.sirgregg.gchantbase.util;

import java.util.TreeMap;

public class RomanNumberalUtil {
	private final TreeMap<Integer, String> encodeKey = new TreeMap<>();

	public RomanNumberalUtil() {
		encodeKey.put(1000, "M");
		encodeKey.put(900, "CM");
		encodeKey.put(500, "D");
		encodeKey.put(400, "CD");
		encodeKey.put(100, "C");
		encodeKey.put(90, "XC");
		encodeKey.put(50, "L");
		encodeKey.put(40, "XL");
		encodeKey.put(10, "X");
		encodeKey.put(9, "IX");
		encodeKey.put(5, "V");
		encodeKey.put(4, "IV");
		encodeKey.put(1, "I");
	}

	// TODO: redo
	public String encode(int number) {
		int l = encodeKey.floorKey(number);

		if (number == l) return encodeKey.get(number);
		return encodeKey.get(l) + encode(number - 1);
	}

	// TODO: redo
	public int decode(String roman) {
		int res = 0;

		for (int i = 0; i < roman.length(); i++) {
			int s1 = value(roman.charAt(i));

			if (i + 1 < roman.length()) {
				int s2 = value(roman.charAt(i + 1));

				if (s1 >= s2) {
					res = res + s1;
				} else {
					res = res + s2 - s1;
					i++;
				}
			} else {
				res = res + s1;
				i++;
			}
		}
		return res;
	}

	private int value(char r) {
		if (r == 'I')
			return 1;
		if (r == 'V')
			return 5;
		if (r == 'X')
			return 10;
		if (r == 'L')
			return 50;
		if (r == 'C')
			return 100;
		if (r == 'D')
			return 500;
		if (r == 'M')
			return 1000;
		return -1;
	}
}
