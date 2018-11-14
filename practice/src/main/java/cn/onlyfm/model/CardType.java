package cn.onlyfm.model;

import lombok.Getter;

public enum CardType {
	/**
	 * 1 经典黑卡
	 */
	CLASSIC("经典黑卡"),
	/**
	 * 2 至尊金卡
	 */
	SUPREME("至尊金卡");

	@Getter
	private String value;

	CardType(String value) {
		this.value = value;
	}
}