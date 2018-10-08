package cn.onlyfm;

import org.testng.annotations.Test;

/**
 * @author haoliang on 2018/9/21.
 */
public class ExceptionTest {
	@Test
	public void testName() {
		try {
			methodA();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			methodRuntimeException();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void methodA() throws Exception {
		throw new Exception("methodA");
	}

	public void methodRuntimeException() {
		throw new RuntimeException("methodRuntimeException");
	}
}
