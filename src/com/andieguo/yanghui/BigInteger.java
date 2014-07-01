package com.andieguo.yanghui;

public class BigInteger {
	byte[] digits;

	public BigInteger(String numberStr) {
		int a = 0;
		char[] aChar = numberStr.toCharArray();
		if (aChar[0] == '-')
			a = 1;
		int i = aChar.length;
		this.digits = new byte[i - a];
		do {
			this.digits[i - 1] = (byte) aChar[i - 1];
			i--;
		} while (i > a);
	}

	public BigInteger(byte[] digits1) {
		// TODO Auto-generated constructor stub
	}

	// ”加“的方法：
	public BigInteger add(BigInteger another) {
		int a = this.digits.length;
		int b = another.digits.length;
		byte[] digits1;
		if (a >= b)
			digits1 = new byte[this.digits.length + 1];
		else
			digits1 = new byte[another.digits.length + 1];
		BigInteger add = new BigInteger(digits1);

		int i = digits1.length - 1;

		byte[] instance = new byte[Math.max(a, b)];
		byte[] instance1 = new byte[Math.max(a, b)];
		int j = another.digits.length;
		int L = this.digits.length;

		for (int k = (Math.max(a, b) - L); k >= 1; k--) {
			instance[k - 1] = 0;
		}
		for (int k = Math.max(a, b); k >= (Math.max(a, b) - L + 1); k--) {
			instance[k - 1] = this.digits[L - 1];
			L--;
		}
		for (int k = (Math.max(a, b) - j); k >= 1; k--) {
			instance[k - 1] = 0;
		}
		for (int k = Math.max(a, b); k >= (Math.max(a, b) - j + 1); k--) {
			instance[k - 1] = this.digits[j - 1];
			j--;
		}

		do {
			add.digits[i - 1] = (byte) (instance[i - 1] + instance1[i - 1]);
			if (add.digits[i] > 9) {
				add.digits[i] = (byte) (add.digits[i] % 10);
				add.digits[i - 1] = (byte) (add.digits[i] / 10);
			}
			i--;
		} while (i > 0);
		return add;
	}
}
