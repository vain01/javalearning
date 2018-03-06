import java.util.ArrayList;

/**
 * @author haoliang on 2018/3/6.
 */
public class QuickSort {
	public static ArrayList<Integer> quickSort(ArrayList<Integer> nums) {
		if (null == nums || nums.size() <= 1) {
			return nums;
		}
		ArrayList<Integer> leftHand = new ArrayList<>();
		ArrayList<Integer> rightHand = new ArrayList<>();
		ArrayList<Integer> base = new ArrayList<>();

		base.add(nums.get(0));
		for (int i = 1; i < nums.size(); i++) {
			if (base.get(0) <= nums.get(i)) {
				rightHand.add(nums.get(i));
			} else {
				leftHand.add(nums.get(i));
			}
		}
		leftHand = quickSort(leftHand);
		rightHand = quickSort(rightHand);

		leftHand.addAll(base);
		leftHand.addAll(rightHand);

		System.out.println(leftHand);
		return leftHand;
	}
}
