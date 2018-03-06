import org.testng.annotations.Test;

import java.util.ArrayList;

/**
 * @author haoliang on 2018/3/6.
 */
public class QuickSortTest {
	@Test
	public void sort() {
		ArrayList<Integer> nums = new ArrayList<>();
		nums.add(0);
		nums.add(9);
		nums.add(-3);
		nums.add(10);
		nums.add(7);
		nums.add(-2);
		nums.add(20);
		System.out.println(nums);
		System.out.println(QuickSort.quickSort(nums));

	}
}