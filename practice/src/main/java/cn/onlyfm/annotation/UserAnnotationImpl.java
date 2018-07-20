package cn.onlyfm.annotation;

import java.lang.annotation.Annotation;

/**
 * @author haoliang on 2018/7/6.
 */
public class UserAnnotationImpl implements UserAnnotation {
	public int id() {
		return 0;
	}

	public String name() {
		return null;
	}

	public int age() {
		return 0;
	}

	public String gender() {
		return null;
	}

	/**
	 * Returns the annotation type of this annotation.
	 *
	 * @return the annotation type of this annotation
	 */
	public Class<? extends Annotation> annotationType() {
		return null;
	}
}
