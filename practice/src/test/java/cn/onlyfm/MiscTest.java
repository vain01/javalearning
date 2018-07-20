package cn.onlyfm;

import cn.onlyfm.annotation.LombokLearning;
import cn.onlyfm.annotation.User;
import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author haoliang on 2018/7/6.
 */
public class MiscTest {
	@Test
	public void testMap(){
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

