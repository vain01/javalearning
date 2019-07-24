package cn.onlyfm;

import org.testng.annotations.Test;

import java.io.*;

/**
 * @author haoliang on 2019/4/3.
 */
public class FileTest {
	@Test
	public void testName() throws FileNotFoundException {
		InputStream inputStream = new FileInputStream("C:\\Users\\haoliang\\Desktop\\keys.txt");
		String sql = readFile(inputStream);

		try {
			File file = new File("C:\\Users\\haoliang\\Desktop\\result.txt");
			FileOutputStream fileOutputStream = new FileOutputStream(file);
			writeToFile(fileOutputStream, sql);
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testosaf() {
		String a = "asdf=99";
		System.out.println(a.substring(a.indexOf("=")));

	}

	public String readFile(InputStream inputStream) {
		StringBuilder stringBuilder = new StringBuilder();
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"), 512);
			// 读取一行，得到key, 根据key获取value, 组合sql语句
			for (String line = reader.readLine(); line != null; line = reader.readLine()) {
				line = line.trim();
				String value = findValue(line);

				stringBuilder.append("update yhb_third_service_cfg set `value` = " + value + " where `key`='" + line + "';\n");
			}

		}
		catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		}
		catch (IOException ioe) {
			ioe.printStackTrace();
		}
		return stringBuilder.toString();
	}

	private String findValue(String key) {
		String ret = "";
		try {
			InputStream is = new FileInputStream("C:\\Users\\haoliang\\Desktop\\source.txt");
			BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"), 512);
			// 读取一行，存储于字符串列表中
			for (String line = reader.readLine(); line != null; line = reader.readLine()) {
				boolean isKey = line.contains(key);
				if (isKey) {
					String nextLine = reader.readLine();
					int index = nextLine.indexOf("=");
					if (index == -1) {
						continue;
					}
					nextLine = nextLine.substring(nextLine.indexOf("=") + 1);
					if (nextLine.equals("'7,15,21'")) {
						continue;
					}
					ret = nextLine;
				}
			}
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}

		return ret;
	}

	public void writeToFile(FileOutputStream fileOutputStream, String content) throws FileNotFoundException {
		try {
			fileOutputStream.write(new String(content).getBytes());
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
