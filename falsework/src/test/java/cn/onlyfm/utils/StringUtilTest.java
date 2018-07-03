package cn.onlyfm.utils;

import cn.onlyfm.utils.constants.CharType;
import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @author haoliang on 2018/5/15.
 */
@Slf4j
public class StringUtilTest {

	@Test(dataProvider = "testSetMaskData")
	public void testSetMask(String str, int prefixRetain, int suffixRetain, String expectedStr) throws Exception {
		Assert.assertEquals(expectedStr, StringUtil.setMask(str, prefixRetain, suffixRetain));
	}

	@DataProvider(name = "testSetMaskData")
	public Object[][] testSetMaskData() {
		return new Object[][]{
			{"", 0, 9, ""},
			{"370783198210010001", 4, 4, "3707**********0001"},
			{"370783198210010001", 18, 4, "370783198210010001"},
			{"370783198210010001", 4, 19, "370783198210010001"},
			{null, 18, 4, ""}
		};
	}

	@Test
	public void testByte2HexString() throws Exception {
		System.out.println(StringUtil.bytes2HexString("abcd".getBytes()));
		System.out.println(StringUtil.bytes2HexString("".getBytes()));
		System.out.println(StringUtil.bytesToHexString("0".getBytes()));
		System.out.println(StringUtil.bytesToHexString("A".getBytes()));
		System.out.println(StringUtil.bytesToHexString("a".getBytes()));
	}

	@Test
	public void testHexString2Bytes() throws Exception {
		System.out.println(new String(StringUtil.hexString2Bytes("6162634")));
		System.out.println(StringUtil.bytes2HexString(StringUtil.hexString2Bytes("616263")));
		Assert.assertEquals(StringUtil.bytes2HexString(StringUtil.hexString2Bytes("616263")), "616263");
	}

	@Test
	public void testGetSpecifiedLengthStr() throws Exception {
		System.out.println(StringUtil.getSpecifiedLengthStr(1, CharType.NUMBER));
		System.out.println(StringUtil.getSpecifiedLengthStr(0, CharType.NUMBER));
		System.out.println(StringUtil.getSpecifiedLengthStr(10, CharType.CHAR));
		System.out.println(StringUtil.getSpecifiedLengthStr(3, CharType.CHAR_CHINESE));
		System.out.println(StringUtil.getSpecifiedLengthStr(40000, CharType.CHAR_CHINESE));
		Assert.assertEquals(StringUtil.getSpecifiedLengthStr(40000, CharType.CHAR_CHINESE).length(), 40000);
	}

	@Test(dataProvider = "testJoinStringData")
	public void testJoinString(String[] strArray, String splitter, String expected) throws Exception {
		Assert.assertEquals(StringUtil.joinString(strArray, splitter), expected);
	}

	@DataProvider(name = "testJoinStringData")
	public Object[][] testJoinStringData() {
		return new Object[][]{
			{new String[]{"ab", "b"}, "-", "ab-b"},
			{new String[]{"ab", null, "b"}, "-", "ab-null-b"},
			{new String[]{"a"}, ",", "a"},
			{new String[]{"ba", "", "c"}, "8", "ba88c"},
			{new String[]{"ba", "", "c"}, "", "bac"},
			{new String[]{}, "-", ""},
			{null, "x", ""}
		};
	}
}