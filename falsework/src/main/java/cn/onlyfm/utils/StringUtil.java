package cn.onlyfm.utils;

import cn.onlyfm.utils.constants.CharType;
import org.apache.commons.lang3.StringUtils;

/**
 * @author haoliang on 2018/5/14.
 */

public class StringUtil {
	public static final String EMPTY = "";
	private static final int RADIX_HEX = 16;
	private static final String NUMBER_BASE = "0123456789";
	private static final String CHAR_BASE = "abcdefghijklmnopqrstuvwxyz";
	private static final String CHAR_CHINESE_BASE = "赵钱孙李周吴郑王冯陈褚卫蒋沈韩杨朱秦尤许何吕施张孔曹严华金魏陶姜戚谢邹喻柏水窦章云苏潘葛奚范彭郎鲁韦昌马苗凤花方俞任袁柳酆鲍史唐费廉岑薛雷贺倪汤滕殷罗毕郝邬安常乐于时傅皮卞齐康伍余元卜顾孟平黄和穆萧尹姚邵湛汪祁毛禹狄米贝明臧计伏成戴谈宋茅庞熊纪舒屈项祝董梁杜阮蓝闵席季麻强贾路娄危江童颜郭梅盛林刁钟徐邱骆高夏蔡田樊胡凌霍虞万支柯昝管卢莫经房裘缪干解应宗丁宣贲邓郁单杭洪包诸左石崔吉钮龚程嵇邢滑裴陆荣翁荀羊于惠甄曲家封芮羿储靳汲邴糜松井段富巫乌焦巴弓牧隗山谷车侯宓蓬全郗班仰秋仲伊宫宁仇栾暴甘钭厉戎祖武符刘景詹束龙叶幸司韶郜黎蓟溥印宿白怀蒲邰从鄂索咸籍赖卓蔺屠蒙池乔阴郁胥能苍双闻莘党翟谭贡劳逄姬申扶堵冉宰郦雍却璩桑桂濮牛寿通边扈燕冀浦尚农温别庄晏柴瞿阎充慕连茹习宦艾鱼容向古易慎戈廖庾终暨居衡步都耿满弘匡国文寇广禄阙东欧殳沃利蔚越夔隆师巩厍聂晁勾敖融冷訾辛阚那简饶空曾毋沙乜养鞠须丰巢关蒯相查后荆红游郏竺权逯盖益桓公仉督岳帅缑亢况郈有琴归海晋楚闫法汝鄢涂钦商牟佘佴伯赏墨哈谯篁年爱阳佟言福南火铁迟漆官冼真展繁檀祭密敬揭舜楼疏冒浑挚胶随高皋原种练弥仓眭蹇覃阿门恽来綦召仪风介巨木京狐郇虎枚抗达杞苌折麦庆过竹端鲜皇亓老是秘畅邝还宾闾辜纵侴";

	/**
	 * 将字符串设置掩码（把部分字符设成*号，信息脱敏）
	 *
	 * @param str
	 * @param prefixRetain 前置保留位
	 * @param suffixRetain 后置保留位
	 * @return
	 */
	public static String setMask(String str, int prefixRetain, int suffixRetain) {
		// 验空
		if (StringUtils.isBlank(str)) return "";

		// 保留位长度检查
		prefixRetain = prefixRetain < 0 ? 0 : prefixRetain;
		suffixRetain = suffixRetain < 0 ? 0 : suffixRetain;
		if (prefixRetain >= str.length() || suffixRetain >= str.length() || prefixRetain + suffixRetain >= str.length()) return str;

		// 截取保留位
		String prefixStr = str.substring(0, prefixRetain);
		String suffixStr = str.substring(str.length() - suffixRetain, str.length());

		StringBuilder returnStr = new StringBuilder();
		// 前保留位填充
		returnStr.append(prefixStr);
		// 掩码填充
		for (int i = 0; i < str.length() - prefixRetain - suffixRetain; i++) returnStr.append("*");
		// 后保留位填充
		returnStr.append(suffixStr);

		return returnStr.toString();
	}

	/**
	 * 将byte数组转换成16进制字符串
	 *
	 * @param srcBytes 待转换的byte数组
	 * @return
	 */
	public static String byte2Hex(byte[] srcBytes) {
		StringBuilder hexRetSB = new StringBuilder();
		for (byte b : srcBytes) {
			String hexString = Integer.toHexString(0xff & b);
			// 补全1位的16进制字符串
			hexRetSB.append(hexString.length() == 1 ? "0" : "").append(hexString);
		}
		return hexRetSB.toString();
	}

	/**
	 * 将16进制字符串转为转换成byte数组
	 *
	 * @param source
	 * @return
	 */
	public static byte[] hex2Bytes(String source) {
		// 每两个16进制字符组成一个字节
		byte[] sourceBytes = new byte[source.length() / 2];
		for (int i = 0; i < sourceBytes.length; i++) {
			// 每两个取值，并按16进制转成int型，然后转成字节
			sourceBytes[i] = (byte) Integer.parseInt(source.substring(i * 2, i * 2 + 2), RADIX_HEX);
		}
		return sourceBytes;
	}

	/**
	 * 获取指定长度的字符字符串
	 *
	 * @param length
	 * @param charType
	 * @return
	 */
	public static String getSpecifiedLengthStr(int length, CharType charType) {
		StringBuilder stringBuilder = new StringBuilder();
		switch (charType) {
			case NUMBER:
				fillResultStr(NUMBER_BASE, length, stringBuilder);
				break;
			case CHAR:
				fillResultStr(CHAR_BASE, length, stringBuilder);
				break;
			case CHAR_CHINESE:
				fillResultStr(CHAR_CHINESE_BASE, length, stringBuilder);
				break;
			default:
		}
		return stringBuilder.toString();
	}

	private static void fillResultStr(String base, int length, StringBuilder stringBuilder) {
		for (int i = 0; i < length; i++) {
			stringBuilder.append(randomOne(base));
		}
	}

	private static char randomOne(String string) {
		return string.charAt(RandomUtil.nextInt(string.length()));
	}
}
