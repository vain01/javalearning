package cn.onlyfm.utils.constants;

/**
 * @author haoliang on 2018/5/22.
 */
public enum CharType {
	NUMBER("数字"),
	CHAR("英文字符"),
	CHAR_CHINESE("中文字符"),;

	private String type;

	private CharType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return type;
	}
}
