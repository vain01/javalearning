package cn.onlyfm.utils;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.jayway.jsonpath.JsonPath;
import org.apache.commons.lang3.StringUtils;
import com.alibaba.fastjson.JSON;

import java.util.List;
import java.util.Map;

public class JsonUtil {

	private static ObjectMapper objectMapper = new ObjectMapper();

	public static <T> String bean2JsonStr(T bean) {
		return getJsonStr(bean);
	}

	public static String map2JsonStr(Map map) {
		return getJsonStr(map);
	}

	public static String list2JsonStr(List list) {
		return getJsonStr(list);
	}

	private static String getJsonStr(Object source) {
		String result = StringUtils.EMPTY;
		try {
			result = objectMapper.writeValueAsString(source);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public static <T> T jsonStr2Bean(String json, Class<T> beanClass) {
		try {
			return objectMapper.readValue(json, beanClass);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Map jsonStr2Map(String json) {
		try {
			return objectMapper.readValue(json, Map.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static <T> List<T> jsonStr2List(String json, Class<T> beanClass) {
		try {
			return (List<T>) objectMapper.readValue(json, getCollectionType(List.class, beanClass));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static JavaType getCollectionType(Class<?> collectionClass, Class<?>... elementClasses) {
		return objectMapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);
	}

	public static String beanToJosnStr(String bean){
		return JSON.toJSONString(bean);
	}

	/**
	 * 将对象转换为json字符串
	 *
	 * @param obj 要转换的对象
	 * @return json字符串
	 */
	public static String jsonFormat(Object obj) {
		Gson gson = new GsonBuilder().disableHtmlEscaping().create();
		return gson.toJson(obj);
	}

	/**
	 * 获取Json字符串元素值
	 *
	 * @param jsonStr  json字符串
	 * @param jsonPath 节点，如data.userid
	 * @return 值
	 */
	public static String jsonNodeValue(String jsonStr, String jsonPath) {
		try {
			return JsonPath.read(jsonStr, jsonPath).toString();
		} catch (com.jayway.jsonpath.PathNotFoundException e) {
			return null;
		}
	}

	/**
	 * 获取Json字符串元素
	 *
	 * @param jsonStr  json字符串
	 * @param jsonPath 节点，如data.userid
	 * @return 值, 注意类型
	 */
	public static <T> T getNodeValue(String jsonStr, String jsonPath) {
		try {
			return JsonPath.read(jsonStr, jsonPath);
		} catch (com.jayway.jsonpath.PathNotFoundException e) {
			return null;
		}
	}

	/**
	 * 将字符串转换为Json对象
	 *
	 * @param jsonStr son格式的字符串
	 * @return json对象
	 */
	public static JsonObject stringToJsonObject(String jsonStr) {
		JsonParser parser = new JsonParser();
		return parser.parse(jsonStr).getAsJsonObject();
	}

	public String mapToJsonStr(Map<String, String> param) {
		String result = StringUtils.EMPTY;
		if (param == null || param.isEmpty()) {
			return result;
		}
		result = JSON.toJSONString(param);
		return result;
	}
}
 
