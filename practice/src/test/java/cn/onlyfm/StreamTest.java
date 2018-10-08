package cn.onlyfm;

import cn.onlyfm.annotation.User;
import org.testng.annotations.Test;
import org.testng.collections.Lists;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author haoliang on 2018/9/10.
 */
public class StreamTest {
	private static List<String> words = Arrays.asList("hello world",
		"hello java",
		"hello hello");
	private static List<String> wordList = Arrays.asList("aa", "bb", "cc");

	public static Stream<String> getCharacter(String str) {
		char[] array = str.toCharArray();
		List<String> list = new ArrayList<>();

		for (char item : array) {
			list.add(String.valueOf(item));
		}
		Stream<String> stream = list.stream();
		return stream;
	}

	@Test
	public void testName() {
		List<Integer> nums = Lists.newArrayList(1, 1, null, 2, 3, 4, null, 5, 6, 7, 8, 9, 10);
		System.out.println(nums);
		List<Integer> numsWithoutNull = nums.stream().filter(num -> num != null).
			collect(() -> new ArrayList<Integer>(),
				(list, item) -> list.add(item),
				(list1, list2) -> list1.addAll(list2));
		System.out.println(numsWithoutNull);
	}

	@Test
	public void testCollector() {
		List<User> users = Lists.newArrayList(
			new User("zhangsan", 17717550328L, 1),
			new User("lisi", 17192193865L, 2),
			new User("zhangs", 13482892312L, 3));
		Map<String, List<User>> mapGroupByUserName = users.stream().collect(Collectors.groupingBy(User::getUserName));
		System.out.println(mapGroupByUserName);

		List<String> userNameList = users.stream().map(User::getUserName).collect(Collectors.toList());
		System.out.println(userNameList);
	}

	@Test
	public void testToMap() {
		List<User> users = Lists.newArrayList(
			new User("zhangsan", 17717550328L, 1),
			new User("lisi", 17192193865L, 2),
			new User("zhangs", 13482892312L, 3));

		Map<String, Long> userNameMobile = users.stream().collect(Collectors.toMap(User::getUserName,User::getMoblie));
		System.out.println(userNameMobile);
		System.out.println(userNameMobile.get("asdf")==null);

		Map<String, User> usersMap = users.stream().collect(Collectors.toMap(User::getUserName, Function.identity()));
		System.out.println(usersMap);
	}

	@Test
	public void test1() {
		words.stream()
			//对words的每一项都做切割操作，把每一个字符串都转换为数组
			//执行完后数据结构如下{["hello","world"],["hello","java"],["hello","hello"]}
			.map(item -> item.split(" "))
			//对每个数组做单独的遍历操作
			.forEach(arr -> {
				for (String item : arr) {
					System.out.println(item);
				}
			});
	}

	@Test
	public void test2() {
		words.stream()
			//把每一项转化为数组包含列表的Stream流
			//然后这个函数把所有的List里面的字符串都取出来放在了一个集合中，这个集合做下一次执行的数据源
			//{"hello","world","hello","java","hello","hello"}
			.flatMap(item -> {
				String[] arr = item.split(" ");
				return Arrays.asList(arr).stream();
			})
			//根据每一项的HashCode和equals方法做去重操作
			.distinct()
			//打印每一项
			.forEach(item -> System.out.println(item));
	}

	@Test
	public void test3() {
		wordList.stream()
			//把T1的getCharacter方法应用于wordList的每一项,wordList每一项都是String
			//getCharacter方法的参数也是String，符合函数式接口
			//通过map方法就把wordList的每一项都转换为了存放单个字符(以字符串的形式存放)列表的Stream流即Stream<List<String>>
			.map(StreamTest::getCharacter)
			//对转换后的每一项(List)分别做遍历操作
			.forEach(sm -> sm.forEach(System.out::println));
	}

	@Test
	public void test4() {
		wordList.stream()
			.flatMap(StreamTest::getCharacter)
			.distinct()
			.forEach(System.out::println);
	}
}
