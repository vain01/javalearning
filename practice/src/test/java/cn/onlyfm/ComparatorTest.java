package cn.onlyfm;

import cn.onlyfm.annotation.TaobaoGoods;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author haoliang on 2018/9/28.
 */
public class ComparatorTest {
	@Test
	public void testByVolume() {
		List<TaobaoGoods> taobaoGoodsList = new ArrayList<>();
		taobaoGoodsList.add(new TaobaoGoods(500L, 130L, 38L));
		taobaoGoodsList.add(new TaobaoGoods(600L, 80L, 8L));
		taobaoGoodsList.add(new TaobaoGoods(555L, 30L, 18L));
		taobaoGoodsList.add(new TaobaoGoods(855L, 40L, 2L));

		Comparator volumeComparator = getVolumeComparator();

		Collections.sort(taobaoGoodsList, volumeComparator);
		System.out.println(taobaoGoodsList);

		Comparator finalPriceComparator = new Comparator() {
			@Override
			public int compare(Object o1, Object o2) {
				TaobaoGoods left = (TaobaoGoods) o1;
				TaobaoGoods right = (TaobaoGoods) o2;
				return left.getFinalPrice().compareTo(right.getFinalPrice());
			}
		};

		Collections.sort(taobaoGoodsList, finalPriceComparator);
		System.out.println(taobaoGoodsList);

	}

	private Comparator getVolumeComparator() {
		return new Comparator() {
			@Override
			public int compare(Object o1, Object o2) {
				TaobaoGoods left = (TaobaoGoods) o1;
				TaobaoGoods right = (TaobaoGoods) o2;
				return left.getVolume().compareTo(right.getVolume());
			}
		};
	}
}
