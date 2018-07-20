package cn.onlyfm.annotation;

/**
 * @author haoliang on 2018/7/6.
 */
public class TestMain {
	@UserAnnotation(age = 20, gender = "F", id = 2014, name = "zhangsan")//注解的使用
	private Object obj;

	public static void main(String[] args) throws Exception {
		UserAnnotation ua = TestMain.class.getField("obj").getAnnotation(UserAnnotation.class);//得到注解,起到了标记的作用

		System.out.println(ua.age() + "," + ua.gender() + "," + ua.id() + "," + ua.name());
		//***进一步操作的话，假设Object要指向一个User类，那么可以讲注解的值给他
		// TestMain tm = new TestMain();
		// objFiled.set(tm, new User(ua.age(), ua.gender(), ua.id(), ua.name())); //不错吧，将自己的信息送给obj，起到了附加信息的作用

		//-----------请自由遐想吧~~，下面来说说注解怎么能获得注解自己的注解-------------
		// Target t = ua.annotationType().getAnnotation(Target.class);
		// ElementType[] values = t.value();
	}
}
