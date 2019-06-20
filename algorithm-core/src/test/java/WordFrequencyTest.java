import org.testng.annotations.Test;

import java.util.Map;

/**
 * @author hexadecimal on 2019/5/27.
 */
public class WordFrequencyTest {
	@Test
	public void testName() {
		String sentence = "i am aabo i am ";
		Map<String, Integer> ret = WordFrequency.count(sentence);
		System.out.println(ret);
		for (String key : ret.keySet()) {
			System.out.println(key + ":" + ret.get(key));
		}
	}
}
