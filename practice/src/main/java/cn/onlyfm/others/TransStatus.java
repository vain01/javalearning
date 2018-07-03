package cn.onlyfm.others;

/**
 * @author haoliang on 2018/7/2.
 */
public enum TransStatus {
	SUCCESS("成功"),
	FAILUR("失败"),;

	private String name;

	private TransStatus(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}
}
