import org.testng.annotations.Test;

/**
 * @author hexadecimal on 2019/5/28.
 */
public class ReverseWordsTest {
	@Test
	public void testName() {
		String sentence = "I am aabo";
		System.out.println(sentence);
		String reversed = ReverseWords.reverseWords(sentence);
		System.out.println(reversed);
	}
}
