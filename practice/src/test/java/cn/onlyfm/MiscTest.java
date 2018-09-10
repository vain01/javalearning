package cn.onlyfm;

import cn.onlyfm.annotation.LombokLearning;
import cn.onlyfm.annotation.User;
import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author haoliang on 2018/7/6.
 */
public class MiscTest {
	@Test
	public void testRandom() {
		double rndNo = ThreadLocalRandom.current().nextDouble();
		System.out.println(rndNo);
		System.out.println(rndNo < 0.2);
		System.out.println();
	}

	@Test
	public void testLong() {
		Long x = 1534313411000L;
		Long y = 1534313411000L;
		System.out.println(Long.compare(x, y) == 0);
		System.out.println(Long.compare(x, y) < 0);
		System.out.println(Long.compare(x, y) > 0);
		System.out.println(x == y);
		System.out.println(x < y);
		System.out.println(x > y);
	}

	@Test
	public void testMap1() {
		Map result = new HashMap();

		Map a = null;
		result.putAll(a);
	}

	@Test
	public void testArrayForeach() {
		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("c");
		for (String s : list) {
			if (s.equals("b")) {
				list.remove(s);
			}
		}
		System.out.println(list);
	}

	@Test
	public void testArray() {
		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("c");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(i + ":" + list.get(i));
			if (list.get(i).equals("b")) {
				list.remove(i);
				i--;
			}
		}
		System.out.println(list);
	}

	@Test
	public void testMap() {
		Map<String, String> map = new HashMap<String, String>();
		System.out.println(map.get("rt"));
	}

	@Test
	public void testTime() {
		System.out.println(System.currentTimeMillis() / 1000);
	}
	// @Pointcut("execution(* *(..))")
	// @Test
	// public void testJoinPoint(ProceedingJoinPoint joinPoint) {
	// 	// 获取方法签名
	// 	MethodSignature signature = (MethodSignature) joinPoint.getSignature();
	// 	System.out.println(signature);
	// 	//java reflect相关类，通过反射得到注解
	// 	Method method = signature.getMethod();
	// 	System.out.println(method);
	// 	Class<?> targetClass = method.getDeclaringClass();
	// 	System.out.println(targetClass);
	// }

	@Test
	public void testLombok() {
		LombokLearning lombokLearning = new LombokLearning();
		// lombokLearning.setName("Hello");

		User user = new User();
		user.setMoblie(lombokLearning.getPhone());
		user.setUserName(lombokLearning.getName());

		System.out.println(user.getMoblie());
		System.out.println(user.getUserName());
		System.out.println(user);
	}

	@Test
	public void testBillDTO() {
		BillDTO request = new BillDTO();
		request.setProductName("china%xxx _33% ");
		System.out.println(request.getProductName().length());
		setProductName(request);
		System.out.println(request);
	}

	private void setProductName(BillDTO request) {
		if (!StringUtils.isBlank(request.getProductName())) {
			request.setProductName(request.getProductName().replace("%", "").replace("_", "").trim());
			System.out.println(request.getProductName().length());
			request.setProductName(request.getProductName().trim());
			System.out.println(request.getProductName().length());
		}
	}
}

