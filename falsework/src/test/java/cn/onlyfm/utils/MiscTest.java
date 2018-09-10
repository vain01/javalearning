package cn.onlyfm.utils;

import lombok.Data;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

/**
 * @author haoliang on 2018/6/5.
 */
public class MiscTest {
	public static final String DATE_TIMESTAMP_SHORT_FORMAT = "yyyyMMddHHmmss";
	public static final String DATE_TIMESTAMP_LONG_FORMAT = "yyyyMMddHHmmssS";

	@Test
	public void testMis(){
		System.out.println("sfd" + null + "asfd");
		int[] ints = new int[0];
		System.out.println(ints.length);
	}

	@DataProvider(name = "testMobileRegexData")
	public static Object[][] testMobileRegexData() {
		return new Object[][]{
			{"13488889999", true},
			{"16600009999", true},
			{"18588889999909", false},
			{"19799990000", false},
			// {null, false}, //不对null做判断
			{"", false}
		};
	}

	@Test
	public void testBase64() {
		String content = "sss";
		String encodedStr = Base64.getEncoder().encodeToString(content.getBytes());
		String decodedStr = new String(Base64.getDecoder().decode(encodedStr));
		System.out.println(decodedStr);
		System.out.println("=" + (content.length() > 2048 ? content.substring(0, 2048) : content));
	}

	@Test
	public void test() {
		Map<String, String> map = null;
		sxx(map);
	}

	public void sxx(Map<String, String> map) {
		System.out.println(map.isEmpty());  //NPE
	}

	@Test
	public void testDateFormat() throws ParseException {
		Date date = new Date();
		System.out.println(date); // 		Fri Jun 29 17:01:49 CST 2018
		System.out.println(new SimpleDateFormat(DATE_TIMESTAMP_SHORT_FORMAT).format(date));// 		20180629170149
		System.out.println(new SimpleDateFormat(DATE_TIMESTAMP_LONG_FORMAT).format(date));//		20180629170149212
	}

	@Test(dataProvider = "testMobileRegexData")
	public void testMoblieRegex(String mobile, boolean matchResult) {
		String regex = "^((13[0-9])|(14[0-9])|(15[0-9])|166|(17[0-9])|(18[0-9])|(19[8,9]))\\d{8}$";
		boolean isMatch = Pattern.matches(regex, mobile);
		Assert.assertEquals(isMatch, matchResult);
	}

	@Test
	public void testMethodCall() {
		List<String> myList =
			Arrays.asList("a1", "a2", "b1", "c2", "c1");

		myList.forEach(System.out::print);
		System.out.println();

		myList
			.stream()
			.filter(s -> s.startsWith("c"))
			.map(String::toUpperCase)
			.sorted()
			.forEach(System.out::println);
	}

	// TODO
	@Test
	public void testNotBlank() {
		Ano ano = new Ano();
		System.out.println(ano);
		System.out.println(getAno(ano));
	}

	public Ano getAno(@Valid Ano ano) {
		System.out.println(ano.getId());
		System.out.println(ano.getBillNo());
		return ano;
	}

	@Test
	public void testCallNull() {
		testNull(null);
	}

	public void testNull(Map<String, String> param) {
		System.out.println(param);  // 输出null
	}

	@Test
	public void testObjectToLong() {
		Object num = 888;
		Long result = ((Integer) num).longValue();
		System.out.println(result);
	}

	@Test
	public void testMapUtils() {
		Map<String, String> mapNull = null;
		Map<String, String> mapEmpty = new HashMap<>();
		System.out.println(MapUtils.isEmpty(mapNull)); // true
		System.out.println(MapUtils.isEmpty(mapEmpty)); // true
	}

	@Test
	public void testListUtils() {
		List<String> listNull = null;
		List<String> listEmpty = new ArrayList<>();
		// System.out.println(listNull.isEmpty());    // NullPointerException
		System.out.println(listEmpty.isEmpty());    // true
	}

	@Test
	public void testCollectionUtils() {
		List<String> listNull = null;
		List<String> listEmpty = new ArrayList<>();
		System.out.println(CollectionUtils.isEmpty(listNull)); // true
		System.out.println(CollectionUtils.isEmpty(listEmpty)); // true
	}

	@Test
	public void testOptional() {
		List<String> listNull = null;
		System.out.println(listNull);  // null
		List<String> listEmpty = new ArrayList<>();
		System.out.println(listEmpty);  // []
		List<String> listNormal = new ArrayList<>();
		listNormal.add("C");
		listNormal.add("D");
		System.out.println(listNormal);  // [C, D]

		System.out.println("+++++++");
		// Optional.of(listNull); // NPE
		listNull = Optional.ofNullable(listNull).orElse(new ArrayList<>());
		System.out.println(listNull);  // []
		Optional.ofNullable(listNormal).ifPresent(list -> list.forEach(item -> listEmpty.add("B" + item)));
		System.out.println(listEmpty);  // [BC, BD]

		Integer pageSize = null;
		System.out.println(pageSize);   // null
		Optional.ofNullable(pageSize).orElse(0);
		System.out.println(pageSize);   // null
		pageSize = Optional.ofNullable(pageSize).orElse(0);
		System.out.println(pageSize);   // 0
	}

	@Test
	public void testAssert() {
		Integer numNull = null;
		Integer numWithValue = 7;
		assert numNull != null;
		// assert numWithValue != null;    // 断言开启状态下程序终止，报错java.lang.AssertionError
	}

	@Test
	public void testInheritance() {
		/*  无论下面Child类构造函数阿东加与不加super()，下行都输出：
			Parent
			Child
		*/
		Child child = new Child();
		child.sayHello();
		child.sayHi();
	}

	@Test
	public void testInterface() {
		FootballImpl footballImpl = new FootballImpl();
		Sports sports = footballImpl;
		Activity activity = footballImpl;
		Football football = footballImpl;
		sports.setHomeTeam("Ping Team");
		activity.setName();
		football.homeTeamScored(8);
		footballImpl.homeTeamScored(9);
	}

	@Test
	public void testFreedom() {
		Long userId = 102934209l;
		System.out.println(userId.toString());
	}

	public interface Sports {
		public void setHomeTeam(String name);

		public void setVisitingTeam(String name);
	}

	public interface Activity {
		public void setName();
	}

	public interface Football extends Sports, Activity {
		public void homeTeamScored(int points);

		public void visitingTeamScored(int points);

	}

	@Data
	public class Ano {
		private Integer id;
		@NotBlank(message = "订单号不能为空")
		private String billNo;
	}

	public class FootballImpl implements Football {

		public void setHomeTeam(String name) {
			System.out.println(name);
		}

		public void setVisitingTeam(String name) {
			System.out.println(name);
		}

		public void setName() {
			System.out.println("setName");
		}

		public void homeTeamScored(int points) {
			System.out.println("homeTeamScored:" + points);
		}

		public void visitingTeamScored(int points) {
			System.out.println("visitingTeamScored:" + points);
		}
	}

	public abstract class Parent {
		public Parent() {
			System.out.println("Parent");
		}

		public void sayHello() {
			System.out.println("Hello in parent");
		}

		public abstract void sayHi();
	}

	public class Child extends Parent {
		public Child() {
			// super();
			System.out.println("Child");
		}

		public void sayHi() {
			System.out.println("Hi in child");
		}
	}
}
