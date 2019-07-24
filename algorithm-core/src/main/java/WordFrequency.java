import java.util.HashMap;
import java.util.Map;

/**
 * @author hexadecimal on 2019/5/27.
 */
public class WordFrequency {
	public static Map<String, Integer> count(String sentence) {
		Map<String, Integer> ret = new HashMap<>();
		if (sentence != null && sentence != "") {
			String[] words = sentence.split(" ");
			for (String item : words) {
				ret.put(item, ret.get(item) == null ? 1 : ret.get(item) + 1);
			}
		}

		return ret;
	}
}
