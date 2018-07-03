/**
 * @author haoliang on 2018/2/11.
 * 二分法查找
 */
public class BinarySearch {
	/**
	 * 循环方式实现
	 *
	 * @param nums 有序的数组
	 * @param key  待查关键字
	 * @return
	 */
	public static int binarySearchWhile(int[] nums, int key) {
		if (nums == null || nums.length < 1)
			return -1;
		int lo = 0;
		int hi = nums.length - 1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			if (key > nums[mid]) {
				lo = mid + 1;
			} else if (key < nums[mid]) {
				hi = mid - 1;
			} else {
				return mid;
			}
		}
		return -1;
	}

	/**
	 * 递归方式实现
	 *
	 * @param nums 有序的数组
	 * @param key  待查关键字
	 * @return
	 */
	public static int binarySearchRecursion(int[] nums, int key) {
		return binarySearchRecursion(nums, 0, nums.length - 1, key);
	}

	private static int binarySearchRecursion(int[] nums, int lo, int hi, int key) {
		if (nums == null || lo > hi)
			return -1;
		int mid = lo + (hi - lo) / 2;
		if (key > nums[mid]) {
			return binarySearchRecursion(nums, mid + 1, hi, key);
		} else if (key < nums[mid]) {
			return binarySearchRecursion(nums, lo, mid - 1, key);
		} else {
			return mid;
		}
	}
}
