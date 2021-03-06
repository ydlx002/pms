package com.ydlx.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {
	/** The hexadecimal letters of character array */
	private static final char[] hexChar = { '0', '1', '2', '3', '4', '5', '6',
			'7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
	/**
	 * This method is used to encrypt the specified string with the MD5 algorithm
	 * @param encryptString	the string to be encrypted
	 * @return	the encrypted string with the MD5 algorithm
	 */
	public static String passwordEncoder(String encryptString) {
		byte[] input = encryptString.getBytes();
		String encryptedString = null;
		try {
			// Obtain an MD5 digest algorithm object
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(input);
			byte[] temp = md.digest();
			char[] str = new char[32];
			byte b = 0;
			for (int i = 0; i < 16; i++) {
				b = temp[i];
				// replace the low nibble of each byte to 16 hex characters
				str[2 * i] = hexChar[b >>> 4 & 0xf];
				// replace the high nibble of each byte to 16 hex characters
				str[2 * i + 1] = hexChar[b & 0xf];
			}
			encryptedString = new String(str);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return encryptedString;
	}

}
