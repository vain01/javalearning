package cn.onlyfm;

import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

/**
 * @author haoliang on 2018/7/16.
 */
public class Spring {
	void showPath() {
		ClassPathResource classPathResource = new ClassPathResource("pfx.pfx");
		try {
			System.out.println(classPathResource.getFile().getAbsolutePath());
		} catch (IOException e) {
			e.printStackTrace();
		}
		String path = this.getClass().getResource("").getPath();
		System.out.println(path);

	}
}
