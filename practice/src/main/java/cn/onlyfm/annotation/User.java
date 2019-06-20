package cn.onlyfm.annotation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author haoliang on 2018/7/6.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	private String userName;
	private Long mobile;
	public int habbit;

	public void showBirthday(){
		System.out.println("birthday");
	}

	@Override
	public String toString() {
		return this.getUserName() + "\n" +
			this.getMobile();
	}
}
