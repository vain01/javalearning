package cn.onlyfm.annotation;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author haoliang on 2018/9/28.
 */
@Data
@AllArgsConstructor
public class TaobaoGoods {
	private Long volume;
	private Long finalPrice;
	private Long couponValue;
}
