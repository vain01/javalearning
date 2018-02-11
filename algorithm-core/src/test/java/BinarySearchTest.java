import org.testng.annotations.Test;

/**
 * @author haoliang on 2018/2/11.
 */
public class BinarySearchTest {
	@Test
	public void binarySearchWhile() {
		int[] testArray = {3, 4, 5, 6, 8, 9};
		int key = 8;
		System.out.println(BinarySearch.binarySearchWhile(testArray, key));
	}

	@Test
	public void binarySearchRecursion() {
		int[] testArray = {3, 4, 5, 6, 8, 9};
		int key = 8;
		System.out.println(BinarySearch.binarySearchRecursion(testArray, key));
	}
}