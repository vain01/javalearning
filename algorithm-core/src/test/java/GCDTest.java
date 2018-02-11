import org.testng.annotations.Test;

/**
 * @author haoliang on 2018/2/11.
 */
public class GCDTest {

	@Test
	public void testGcd() throws Exception {
		int p = 2, q = 3;
		System.out.println(GCD.gcd(p, q));
	}
}