import java.util.ArrayList;

/**
 * @author haoliang on 2018/3/6.
 */
public class GetMaxN {
	public static int getMaxN(ArrayList<Integer> nums, int n) {
		if (null == nums || n <= 0 || nums.size() < n) {
			System.out.println("error, out of range");
			return 99999;
		}
		if (nums.size() == 1 && n == 1) {
			return nums.get(0);
		}
		ArrayList<Integer> leftHand = new ArrayList<>();
		ArrayList<Integer> rightHand = new ArrayList<>();

		for (int i = 1; i < nums.size(); i++) {
			if (nums.get(0) < nums.get(i)) {
				rightHand.add(nums.get(i));
			} else {
				leftHand.add(nums.get(i));
			}
		}
		rightHand.add(nums.get(0));
		if (rightHand.size() == 1 && n == 1 || rightHand.size() >= n) {
			return getMaxN(rightHand, n);
		} else {
			return getMaxN(leftHand, n - rightHand.size());
		}
	}
}
