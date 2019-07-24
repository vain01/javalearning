package cn.onlyfm;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author haoliang on 2019/1/29.
 */
public class LinkedListTest {
	@Test
	public void testInsert() {
		LinkedList<String> linkedList = new LinkedList<>();
		linkedList.addAll(Arrays.asList("a,b,c".split(",")));
		System.out.println(linkedList);
		linkedList.addFirst("d");
		System.out.println(linkedList);
		linkedList.addFirst(linkedList.pollLast());
		System.out.println(linkedList);
		linkedList.add(0, linkedList.pollLast());
		System.out.println(linkedList);
	}
}
