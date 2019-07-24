package cn.onlyfm;

import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * @author hexadecimal on 2019/4/26.
 */
public class HexTest {
	@Test
	public void testRgbToHexColor() {
		int red = 0;
		int green = 10;
		int blue = 255;
		System.out.println(rgbToHexColor(red, green, blue));
		System.out.println(hexColor(red, green, blue));
	}

	public String rgbToHexColor(int red, int green, int blue) {
		Long now = System.currentTimeMillis();
		String[] hexTable = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};
		int hexBase = 16;
		String ret = "#"
			//red高位
			+ hexTable[red / hexBase]
			//red低位
			+ hexTable[red % hexBase]
			//green高位
			+ hexTable[green / hexBase]
			//green低位
			+ hexTable[green % hexBase]
			//blue高位
			+ hexTable[blue / hexBase]
			//blue低位
			+ hexTable[blue % hexBase];

		return ret + (now - System.currentTimeMillis());
	}

	public String hexColor(int red, int green, int blue) {
		Long now = System.currentTimeMillis();
		String ret = "#";
		for (Integer item : Arrays.asList(red, green, blue)) {
			ret += item < 16 ? "0" + Integer.toHexString(item) : Integer.toHexString(item);
		}
		return ret.toUpperCase() + (now - System.currentTimeMillis());
	}
}
