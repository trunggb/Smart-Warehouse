package services;

import java.util.Base64;

import javax.ejb.Stateless;

import org.jasypt.util.text.BasicTextEncryptor;

@Stateless
public class EncryptionService{
	/**
	 * Encrypt a plain text and then encode using BASE64
	 * @param encryptKey
	 * @param plainText
	 * @return
	 */
	public static String encrypt(String encryptKey, String plainText) {
		BasicTextEncryptor encryptor = new BasicTextEncryptor();
		encryptor.setPassword(encryptKey);
		String encryptedString = encryptor.encrypt(plainText);
		return Base64.getEncoder().encodeToString(encryptedString.getBytes());
	}
	
	/**
	 * Decrypt a cipherText text and then decode using BASE64
	 * @param encryptKey
	 * @param cipherText
	 * @return
	 */
	public static String decrypt(String encryptKey, String cipherText) {
		BasicTextEncryptor encryptor = new BasicTextEncryptor();
		encryptor.setPassword(encryptKey);
		byte[] decoded = Base64.getDecoder().decode(cipherText);
		return encryptor.decrypt(new String(decoded));
	}
}
