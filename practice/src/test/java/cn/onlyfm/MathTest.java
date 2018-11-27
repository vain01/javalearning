package cn.onlyfm;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.Test;

import static java.lang.Math.min;

/**
 * @author haoliang on 2018/11/23.
 */
public class MathTest {
	@Data
	class DeviceAppItem {
		private Long batchId;
		private Long userId;
		private String appName;
	}

	@Test
	public void testMin() {
		DeviceAppItem item = new DeviceAppItem();
		// item.setAppName(null);
		// item.setAppName("1");
		item.setAppName("saldfjas");

		String adjustedAppName = StringUtils.EMPTY;
		int appNameMaxLength = 3;
		if (item.getAppName() !=null ) {
			int strMaxLen = min(item.getAppName().length(), appNameMaxLength);
			adjustedAppName = item.getAppName().substring(0, strMaxLen);
		}

		System.out.println(adjustedAppName);
	}
}
