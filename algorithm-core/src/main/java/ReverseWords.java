/**
 * @author hexadecimal on 2019/5/28.
 */
public class ReverseWords {
	public static String reverseWords(String sentence) {
		if (sentence == null || sentence.equals("")) {
			return sentence;
		}

		String result = "";
		String word = "";
		for (int i = 0; i < sentence.length(); i++) {
			if (Character.isAlphabetic(sentence.charAt(i))) {
				word += sentence.charAt(i);
			}
			else {
				result = word + result;
				result = sentence.charAt(i) + result;
				word = "";
			}
		}
		System.out.println(result);
		result = word + result;

		return result;
	}
}
