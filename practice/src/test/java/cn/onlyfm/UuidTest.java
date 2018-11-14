package cn.onlyfm;


import org.testng.annotations.Test;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.UUID;

/**
 * @author haoliang on 2018/10/19.
 */
public class UuidTest {
	@Test
	public void testRandomUUID() {
		String id = UUID.randomUUID().toString();
		System.out.println(id);
	}

	@Test
	public void testFromString() {
		String uuidOrigin = "17a14d0d-e24f-4b51-a911-e2f4b54ba946";
		String id = UUID.fromString(uuidOrigin).toString();
		System.out.println(id);
		System.out.println(uuidOrigin.equals(id));
	}

	@Test
	public void testNameUUIDFromBytes() {
		String uuidOrigin = "17a14d0d-e24f-4b51-a911-e2f4b54ba946";
		byte[] bytes = uuidOrigin.getBytes();
		String id = UUID.nameUUIDFromBytes(bytes).toString();
		System.out.println(id);
		System.out.println(uuidOrigin.equals(id));
	}

	@Test
	public void testSpecifiedLength() {
		String id = UUID.randomUUID().toString();
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException nsae) {
			throw new InternalError("MD5 not supported", nsae);
		}
		String output = Base64.getEncoder().encodeToString(md.digest(id.getBytes()));
		System.out.println(output);
	}
}
