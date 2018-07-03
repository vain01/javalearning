package cn.onlyfm.others;

/**
 * @author haoliang on 2018/7/2.
 */
public enum AcceptStatus {
	PROCESSING(0, "处理中"),
	SUCCESS(1, "成功"),
	FAILURE(2, "失败"),;

	private int code;
	private String name;

	private AcceptStatus(int code, String name) {
		this.code = code;
		this.name = name;
	}

	@Override
	public String toString() {
		return code + ":" + name;
	}
}
