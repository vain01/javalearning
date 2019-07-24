package cn.onlyfm;

import org.apache.commons.lang3.StringEscapeUtils;
import org.testng.annotations.Test;

/**
 * @author haoliang on 2019/4/4.
 */
public class StringEscapeTest {
	@Test
	public void testName() {
		String content = "{\"card_no\":\"6212261001030909490\",\"bank_code\":\"ICBC\",\"user_name\":\"\\u5360\\u5de7\\u96ef\",\"id_card\":\"360222199304265625\",\"bank_mobile\":\"17701618212\",\"user_mobile\":\"17701618212\",\"verify_code\":\"\",\"order_no\":\"RYT1904031451528397\"}";
		// String content = "{\"card_no\":\"6212261001030909490\",\"bank_code\":\"ICBC\",\"user_name\":\"占巧雯\",\"id_card\":\"360222199304265625\",\"bank_mobile\":\"17701618212\",\"user_mobile\":\"17701618212\",\"verify_code\":\"\",\"order_no\":\"RYT1904031451528397\"}";
		System.out.println(content);
		String unescapedContent = StringEscapeUtils.unescapeJava(content);
		System.out.println(unescapedContent);
		System.out.println(StringEscapeUtils.escapeJava("占巧雯"));
		System.out.println(StringEscapeUtils.escapeJava("占巧雯").toLowerCase());
	}
}
