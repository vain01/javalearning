/**
 * @author haoliang on 2018/2/12.
 * 正整数转成二进制表示的字符串
 */
public class Conversion {
	/**
	 * 取余+除法方式
	 *
	 * @param number
	 * @return
	 */
	public static String IntToBinaryStringFor(int number) {
		String result = "";
		for (int n = number; n > 0; n /= 2) {
			result = n % 2 + result;
		}
		return result;
	}

	/**
	 * 位与+移位方式
	 *
	 * @param number
	 * @return
	 */
	public static String IntToBinaryStringShift(int number) {
		String result = "";
		int mask = 1;
		while (number > 0) {
			result = (number & mask) + result;
			number = number >> 1;
		}
		return result;
	}
}
