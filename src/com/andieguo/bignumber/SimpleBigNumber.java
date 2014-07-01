package com.andieguo.bignumber;

import java.io.Serializable;
import java.math.BigInteger;

/**
 * 
 * @author MILK
 * @version 1.1 date 2013-2-2 23:27
 *  function 大整数加减除 不包含大浮点数
 */
/**
 * 实现大整数的四则运算
 * 
 * @author LYJ date 2013-2-2
 */
public class SimpleBigNumber {
	private String bigNumberOne = null;
	private String bigNumberTwo = null;
	private final Caculate cal = new BigNumbers();
	/**
	 * 数字零
	 */
	private static final String ZERO = "0";
	/**
	 * 符号代表负号
	 */
	private static final String NAGTIVE = "-";

	

	public SimpleBigNumber(String bigNumberOne, String bigNumberTwo) {
		filterNumber(bigNumberOne);
		filterNumber(bigNumberTwo);
		this.bigNumberOne = bigNumberOne;
		this.bigNumberTwo = bigNumberTwo;
	}

	public SimpleBigNumber(BigInteger bigNumberOne, BigInteger bigNumberTwo) {
		this.bigNumberOne = bigNumberOne.toString();
		this.bigNumberTwo = bigNumberTwo.toString();
	}

	public void setBigNumberOne(String bigNumberOne) {
		String number = filterNumber(bigNumberOne);
		this.bigNumberOne = number;
	}

	public void setBigNumberTwo(String bigNumberTwo) {
		String number = filterNumber(bigNumberTwo);
		this.bigNumberTwo = number;
	}

	public String add() {
		return cal.add(bigNumberOne, bigNumberTwo);
	}

	public String reduce() {
		return cal.reduce(bigNumberOne, bigNumberTwo);
	}

	public String mulitply() {
		return cal.multiply(bigNumberOne, bigNumberTwo);
	}

	public String mod() {
		return cal.divide(bigNumberOne, bigNumberTwo)[1];
	}

	public String divide() {
		return cal.divide(bigNumberOne, bigNumberTwo)[0];
	}



	/**
	 * @param number
	 *            过滤数字前面为0的数字
	 */
	private String filterNumber(String number) {
		int index = 0;
		char[] numberChar = number.toCharArray();
		int size = numberChar.length;
		while (numberChar[index] == '0')
			++index;
		number = new String(numberChar, index, size - index);
		return number;
	}

	/**
	 * 两个大整数相加
	 * 
	 * @param first
	 * @param second
	 * @return
	 */

	private static void isRegular(byte big, byte small) {
		if (big == 0 || small == 0)
			return;
		if ((big - '0' < 0 || big - '0' > 9))
			throw new IligalNumberException("发现不合法数字" + (char) big + "==="
					+ big);
		if ((small - '0' < 0 || small - '0' > 9))
			throw new IligalNumberException("发现不合法数字" + (char) small + "==="
					+ small);
	}

	private static String toNumberString(char... nchar) {
		int index = 0;
		while (nchar[index] == '0')
			index++;
		return new String(nchar, index, nchar.length - index);
	}

	/**
	 * 当减数和被减数的长度相等时调用此方法
	 * 
	 * @param number1
	 * @param number2
	 * @return 一个正整数或负整数
	 */
	private static String caseWhenEqualThan(final String numberOne,
			final String numberTwo) {
		final char[] btone = numberOne.toCharArray();
		final char[] bttwo = numberTwo.toCharArray();
		int size = numberOne.length();
		int index = -1;
		if (numberOne.equals(numberTwo))
			return ZERO;
		while (index++ < size) {
			int one = btone[index] - '0';
			int two = bttwo[index] - '0';
			if (one > two)
				return caseWhenLagerThan(
						new String(btone, index, size - index), new String(
								bttwo, index, size - index));
			else if (one < two)
				return caseWhenSmallThan(
						new String(btone, index, size - index), new String(
								bttwo, index, size - index));
		}

		return "";
	}

	/**
	 * <li>当减数的长度大于被减数的长度时调用此方法</li>
	 * 
	 * @param number1
	 * @param number2
	 * @return 一个正整数
	 * @see BigInteger#remainder(BigInteger)
	 */
	private static String caseWhenLagerThan(String first, String second) {
		int max = first.length();
		int min = second.length();
		String maxStr = first;
		String minStr = second;
		final int[] number = new int[max];// 定义一个长度为两个数字长度之和的数组用来存储计算结果
		final char[] nchar = new char[max];
		int borrowFlag = 0;// 借位标记
		int cursor = number.length - 1;// 数组移动游标
		byte[] bigChar = maxStr.getBytes();
		byte[] smallChar = minStr.getBytes();
		int index = min - 1;
		for (int j = max - 1; j >= 0; j--) {
			int big = (bigChar[j] - '0' - borrowFlag);
			if (index >= 0) {
				isRegular(bigChar[j], smallChar[index]);
				int small = smallChar[index] - '0';
				int result = (big - small) < 0 ? (big + 10) - small : big
						- small;
				borrowFlag = (big - small) < 0 ? 1 : 0;
				index--;
				number[cursor] = result;
				nchar[cursor] = (char) (result + 0x30);
			} else {
				isRegular(bigChar[j], smallChar[0]);
				number[cursor] = big;
				nchar[cursor] = (char) (big + 0x30);
				borrowFlag = 0;
			}
			cursor--;
		}

		return toNumberString(nchar);

	}

	/**
	 * 当减数的长度与被减数的长度相等时调用此方法
	 * 
	 * @param first
	 * @param second
	 * @return
	 * @see #reduce(String, String)
	 */
	private static String caseWhenSmallThan(String first, String second) {

		return NAGTIVE + caseWhenLagerThan(second, first);
	}

	/**
	 * 判断被检测的数字是不是负数
	 * 
	 * @param number
	 * @return 是返回true 不是返回false
	 */
	private static boolean isNagtiveDigit(String number) {
		return number.startsWith("-");
	}

	private static class BigNumbers implements Caculate, Serializable {
		private static final long serialVersionUID = 3879390166436108519L;

		public String add(String first, String second) {
			boolean b1 = first.startsWith("-");
			boolean b2 = second.startsWith("-");
			int len1 = first.length();
			int len2 = second.length();
			if (b1 && !b2)
				return reduce(second, first.substring(1, len1));
			else if (b2 && !b1)
				return reduce(first, second.substring(1, len2));
			int max = Math.max(len1, len2);
			int min = Math.min(len1, len2);
			String maxStr = len1 > len2 ? first : second;
			String minStr = maxStr == second ? first : second;
			boolean isNagtive = false;
			if (b1 && b2) {
				maxStr = maxStr.substring(1, maxStr.length());
				minStr = minStr.substring(1, minStr.length());
				max -= 1;
				min -= 1;
				isNagtive = true;
			}
			final int[] number = new int[max + 1];
			final char[] nchar = new char[max + 1];
			int carryFlag = 0;// 进位标记
			int cursor = number.length - 1;// 数组移动游标
			byte[] bigChar = maxStr.getBytes();
			byte[] smallChar = minStr.getBytes();
			int index = min - 1;
			for (int j = max - 1; j >= 0; j--) {
				int big = bigChar[j] - '0';
				assert (big >= 0 && big <= 9);
				if (index >= 0) {
					isRegular(bigChar[j], smallChar[index]);
					int small = smallChar[index] - '0';
					assert (small > 0 && small <= 9);
					int result = (big + small + number[cursor] + carryFlag);
					carryFlag = result / 10;
					number[cursor] = result % 10;
					nchar[cursor] = (char) ((result % 10) + 0x30);
					index--;

				} else {
					isRegular(bigChar[j], smallChar[0]);
					int result = (big + carryFlag);
					carryFlag = result / 10;
					number[cursor] = result % 10;
					nchar[cursor] = (char) ((result % 10) + 0x30);
				}
				cursor--;
			}
			number[cursor] = carryFlag;
			nchar[cursor] = (char) (carryFlag + 0x30);
			String isNag = isNagtive ? NAGTIVE : "";
			return isNag + toNumberString(nchar);

		}

		public String[] divide(String numberOne, String numberTwo) {
			int sizeone = numberOne.length();
			int sizetwo = numberTwo.length();
			if (sizeone <= 18 && sizetwo <= 18)
				return obtainFactorAndModItem(numberOne, numberTwo);
			if (sizeone < sizetwo)
				return new String[] { ZERO, numberOne };
			if (sizeone == sizetwo)
				return obtainFactorAndModItem(numberOne, numberTwo);
			if (numberTwo.equals("1"))
				return new String[] { numberOne, ZERO };
			final StringBuilder std = new StringBuilder();
			String midDivideNumble = numberOne.substring(0, sizetwo);
			int numberOneIndex = sizetwo - 1;
			int i = numberOneIndex;
			String[] factor = null;
			char[] numberChar = numberOne.toCharArray();
			for (; i < sizeone;) {
				factor = obtainFactorAndModItem(midDivideNumble, numberTwo);
				midDivideNumble = factor[1];
				if (!midDivideNumble.equals(ZERO) && i + 1 < sizeone)
					midDivideNumble += numberChar[i + 1] + "";
				else if (midDivideNumble.equals(ZERO) && i < sizeone - 1) {
					midDivideNumble = new String(numberChar[i + 1] + "");
				}
				if (factor[0].equals(ZERO) && i == numberOneIndex) {
					i++;
					continue;
				}
				std.append(factor[0]);
				i++;
			}
			return new String[] { std.toString(), factor[1] };

		}

		public String multiply(String first, String second) {
			if (first.equals(ZERO) || second.equals(ZERO))
				return ZERO;
			if (first.equals("1"))
				return second;
			if (second.equals("1"))
				return first;
			boolean b1 = first.startsWith("-");
			boolean b2 = second.startsWith("-");
			int len1 = first.length();
			int len2 = second.length();
			boolean isNagtive = false;
			if (b1 && !b2) {
				isNagtive = true;
				first = first.substring(1, len1);
				len1 -= 1;
			} else if (b2 && !b1) {
				second = second.substring(1, len2);
				isNagtive = true;
				len2 -= 1;
			} else if (b2 && b1) {
				first = first.substring(1, len1);
				second = second.substring(1, len2);
				len1 -= 1;
				len2 -= 1;
				isNagtive = false;
			}
			final int[] number = new int[len1 + len2];// 定义一个长度为两个数字长度之和的数组用来存储计算结果
			final char[] nchar = new char[len1 + len2];
			int max = Math.max(len1, len2);
			int min = Math.min(len1, len2);
			String maxStr = len1 > len2 ? first : second;
			String minStr = maxStr == second ? first : second;
			int carryFlag = 0;// 进位标记
			int cusor = number.length - 1;// 数组移动游标
			int index = 0;
			byte[] bigChar = maxStr.getBytes();
			byte[] smallChar = minStr.getBytes();
			for (int i = min - 1; i >= 0; i--) {
				int big = smallChar[i] - '0';
				index = cusor;
				carryFlag = 0;
				for (int j = max - 1; j >= 0; j--) {
					isRegular(smallChar[i], bigChar[j]);
					int small = bigChar[j] - '0';
					isRegular(smallChar[i], bigChar[j]);
					int result = (big * small + number[index] + carryFlag);
					carryFlag = (int) result / 10;
					int item = (result % 10);
					number[index] = item;
					nchar[index] = (char) (item + 0x30);
					index--;
				}
				cusor--;
				number[index] = carryFlag;
				nchar[index] = (char) (carryFlag + 0x30);
			}
			String isNag = isNagtive ? NAGTIVE : "";
			return isNag + toNumberString(nchar);

		}

		public String reduce(String first, String second) {
			int sizeOne = first.length();
			int sizeTwo = second.length();
			boolean b1 = first.startsWith("-");
			boolean b2 = second.startsWith("-");
			if (b1 && !b2)
				return add(second, first.substring(1, sizeOne));
			if (b2 && !b1)
				return add(first, second.substring(1, sizeTwo));
			if (sizeOne > sizeTwo)
				return caseWhenLagerThan(first, second);
			if (sizeOne == sizeTwo)
				return caseWhenEqualThan(first, second);
			if (sizeOne < sizeTwo)
				return caseWhenSmallThan(first, second);
			return null;

		}

		/**
		 * 获得两个数的商与余数
		 * 
		 * @param first
		 * @param second
		 * @return String类型的数组 其中的第一个数为除数第二个数是模
		 */
		private final String[] obtainFactorAndModItem(String first,
				String second) {
			String[] str = new String[2];
			int firstsize = first.length(), secondsize = second.length();
			if (firstsize < secondsize)
				return new String[] { ZERO, first };
			if (firstsize <= 0x12 && secondsize <= 0x12) {
				str[0] = new String(Long.valueOf(first) / Long.valueOf(second)
						+ "");
				str[1] = new String(Long.valueOf(first) % Long.valueOf(second)
						+ "");
				return str;
			}
			if (first.equals(ZERO))
				return new String[] { new String(ZERO), new String(ZERO) };
			else {
				int divideNumber = 0;
				String mod = "";
				while (divideNumber <= 9) {
					String result = multiply(second, divideNumber + "");
					mod = reduce(first, result);
					boolean b = isNagtiveDigit(mod);
					if (!b) {
						str[0] = divideNumber + "";
						str[1] = mod;
					} else if (b||mod.equals(ZERO))
						break;
					divideNumber++;

				}

			}
			return str;

		}

	}

	


}