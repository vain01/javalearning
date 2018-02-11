/**
 * @author haoliang on 2018/2/11.
 * greatest common divisor 最大公约数
 */
public class GCD {
	public static int gcd(int p, int q) {
		if (0 == q) {
			return p;
		}
		int r = p % q;
		return gcd(q, r);
	}
}
