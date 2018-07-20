package cn.onlyfm.annotation;

/**
 * @author haoliang on 2018/7/6.
 */

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value = { ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface UserAnnotation {
	public int id() default 0;
	public String name() default "";
	public int age() default 18;
	public String gender() default "M";
}
