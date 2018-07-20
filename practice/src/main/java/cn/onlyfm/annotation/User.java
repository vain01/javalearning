package cn.onlyfm.annotation;

import lombok.Data;

/**
 * @author haoliang on 2018/7/6.
 */
@Data
public class User {
	private String userName;
	private long moblie;
	public int habbit;

	public void showBirthday(){
		System.out.println("birthday");
	}
}
