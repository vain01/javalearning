package cn.onlyfm.annotation;

import org.testng.annotations.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author haoliang on 2018/7/16.
 */
public class UserTest {
	@Test
	public void testReflection() {
		User u = new User();
		u.showBirthday();
		try {
			System.out.println("======");
			Class clazz = Class.forName("cn.onlyfm.annotation.User");
			User user = (User) clazz.newInstance();
			user.showBirthday();
			System.out.println(clazz);

			System.out.println("======");
			Constructor[] constructors = clazz.getConstructors();
			for (Constructor c : constructors) {
				System.out.println(c);
			}
			System.out.println("======");
			Method[] methods = clazz.getMethods();
			for (Method m : methods) {
				System.out.println(m);
			}
			System.out.println("======");
			Field[] fields = clazz.getFields();
			for (Field field : fields) {
				System.out.println(field);
			}
			System.out.println("======");

			Field[] allFields = clazz.getDeclaredFields();
			for (Field field : allFields) {
				System.out.println(field);
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		}
	}

}