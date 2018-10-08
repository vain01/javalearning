package cn.onlyfm.utils;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author haoliang on 2018/9/25.
 */
public class GenericTest {
	public static void getDataWildcard(List<?> data) {
		System.out.println("data :" + data.get(0));
	}

	public static <E> void getData(List<E> data) {
		System.out.println("data :" + data.get(0));
	}

	public static void getExtendsNumber(List<? extends Number> data) {
		System.out.println("data :" + data.get(0));
	}

	public static void getSuperNumber(List<? super Number> data) {
		System.out.println("data :" + data.get(0));
	}

	@Test
	public void testName() {
		List<Integer> list = new ArrayList<>();
		list.add(9);
		System.out.println(list);
	}

	@Test
	public void testMethod() {
		List<String> name = new ArrayList<>();
		List<Integer> age = new ArrayList<>();
		List<Number> number = new ArrayList<>();

		name.add("icon");
		age.add(18);
		number.add(314);

		getData(name);
		getData(age);
		getData(number);

		getDataWildcard(name);
		getDataWildcard(age);
		getDataWildcard(number);

		getExtendsNumber(age);
		getExtendsNumber(number);

		getSuperNumber(number);
	}

}
