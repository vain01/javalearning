package cn.onlyfm;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author haoliang on 2018/8/16.
 */
public class MapTest {
	@Test
	public void testMap() {
		Map<String, Object> map = new HashMap<>();
		map.put("key", "value");
		String jstr = JSONObject.toJSONString(map);
		System.out.println(jstr);
		String str = JSON.toJSONString(map);
		System.out.println(str);
	}

	@Test
	public void testSize() {
		Map<String, String> kvs = new HashMap<>();
		System.out.println(kvs.size());
		kvs.put("x", "1");
		kvs.put("y", "2");
		kvs.put("z", "3");
		kvs.put("x", "1");
		System.out.println(kvs.size());
	}
}
