package cn.onlyfm;

import cn.onlyfm.model.CardType;
import cn.onlyfm.model.Signal;
import org.testng.annotations.Test;

/**
 * @author haoliang on 2018/11/14.
 */
public class EnumTest {
	@Test
	public void testDefault() {
		System.out.println(CardType.CLASSIC);       //CLASSIC
	}

	@Test
	public void testName() {
		System.out.println(CardType.CLASSIC.name());    //CLASSIC
	}

	@Test
	public void testValue() {
		System.out.println(CardType.CLASSIC.getValue());        //经典黑卡
	}

	@Test
	public void testValueOf() {
		CardType testing = CardType.valueOf("CLASSIC");
		System.out.println(testing);
	}

	@Test
	public void testSwitch() {
		Signal testing = Signal.GREEN;
		switch (testing) {
			case GREEN:
				System.out.println(1);
		}
	}

	@Test
	public void testSwitchCardType() {
		CardType testing = CardType.valueOf("CLASSIC");
		switch (testing) {
			case CLASSIC:
				System.out.println(testing);
				System.out.println(testing.name());
				System.out.println(testing.getValue());
		}
	}

	@Test
	public void testEquals() {
		CardType type = CardType.SUPREME;
		System.out.println(!type.equals(CardType.CLASSIC));
		System.out.println(type != CardType.CLASSIC);
	}
}
