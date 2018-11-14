package cn.onlyfm;

import cn.onlyfm.annotation.TaobaoGoods;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author haoliang on 2018/9/28.
 */
public class ComparatorTest {
	@Test
	public void testMultipleSort() {
		List<TaobaoGoods> goodsList = getGoods();
		print(goodsList);

		Comparator comparator = getComparator('3', '1', '1');
		goodsList = (List<TaobaoGoods>) goodsList.stream().sorted(comparator).collect(Collectors.toList());

		System.out.println("\n");
		print(goodsList);

	}

	void print(List<TaobaoGoods> goods) {
		for (int i = 0; i < goods.size(); i++) {
			System.out.println(goods.get(i));
		}
	}

	@Test
	public void testByVolume() {
		List<TaobaoGoods> goodsList = getGoods();

		// 自定义的comparator
		Comparator volumeComparator = getVolumeComparator(false);

		Collections.sort(goodsList, volumeComparator);
		System.out.println(goodsList);

		// 逆序
		Collections.sort(goodsList, volumeComparator = getVolumeComparator(true));
		System.out.println(goodsList);
	}

	private List<TaobaoGoods> getGoods() {
		List<TaobaoGoods> goodsList = new ArrayList<>();
		goodsList.add(new TaobaoGoods(500L, 130L, 38L, 9d));
		goodsList.add(new TaobaoGoods(600L, 80L, 8L, 8d));
		goodsList.add(new TaobaoGoods(856L, 30L, 18L, 5D));
		goodsList.add(new TaobaoGoods(555L, 133L, 18L, 9d));
		goodsList.add(new TaobaoGoods(555L, 134L, 18L, 9d));
		goodsList.add(new TaobaoGoods(556L, 134L, 18L, 9d));
		goodsList.add(new TaobaoGoods(554L, 134L, 18L, 9d));
		goodsList.add(new TaobaoGoods(555L, 132L, 18L, 9d));
		goodsList.add(new TaobaoGoods(855L, 40L, 2L, 5d));
		goodsList.add(new TaobaoGoods(855L, 40L, 12L, 6d));
		return goodsList;
	}

	@Test
	public void testName() {
		List<TaobaoGoods> goodsList = getGoods();

		Comparator finalPriceComparator = new Comparator() {
			@Override
			public int compare(Object o1, Object o2) {
				TaobaoGoods left = (TaobaoGoods) o1;
				TaobaoGoods right = (TaobaoGoods) o2;
				return left.getFinalPrice().compareTo(right.getFinalPrice());
			}
		};

		Collections.sort(goodsList, finalPriceComparator);
		System.out.println(goodsList);
	}

	private Comparator getVolumeComparator(boolean desc) {
		return new Comparator() {
			@Override
			public int compare(Object o1, Object o2) {
				TaobaoGoods left = (TaobaoGoods) o1;
				TaobaoGoods right = (TaobaoGoods) o2;
				if (desc) {
					return left.getVolume().compareTo(right.getVolume());
				} else {
					return right.getVolume().compareTo(left.getVolume());
				}
			}
		};
	}

	public Comparator<TaobaoGoods> getComparator(char locationFirstValue, char locationSecondValue, char locationThirdValue) {
		Comparator<TaobaoGoods> comparator1st = Comparator.naturalOrder();
		if (locationFirstValue == '1') {
			comparator1st = Comparator.comparingDouble(TaobaoGoods::getCouponValue).reversed();
		} else if (locationFirstValue == '2') {
			comparator1st = Comparator.comparingDouble(TaobaoGoods::getCouponValue);
		} else if (locationFirstValue == '3') {
			comparator1st = Comparator.comparingDouble(TaobaoGoods::getCommissionValue).reversed();
		}

		Comparator comparator2nd = Comparator.naturalOrder();
		if (locationSecondValue == '1') {
			comparator2nd = Comparator.comparingDouble(TaobaoGoods::getFinalPrice).reversed();
		} else if (locationSecondValue == '2') {
			comparator2nd = Comparator.comparingDouble(TaobaoGoods::getFinalPrice);
		}

		Comparator comparator3rd = Comparator.naturalOrder();
		if (locationThirdValue == '1') {
			comparator3rd = Comparator.comparingDouble(TaobaoGoods::getVolume).reversed();
		} else if (locationThirdValue == '2') {
			comparator3rd = Comparator.comparingDouble(TaobaoGoods::getVolume);
		}

		return comparator1st.thenComparing(comparator2nd).thenComparing(comparator3rd);
	}
}

