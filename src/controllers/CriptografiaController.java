package controllers;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.Key;
import java.util.Properties;
import java.security.MessageDigest;
import java.util.Arrays;

public class CriptografiaController {

    private static final String ALGORITHM = "AES";
    private static final String TRANSFORMATION = "AES";

    private static final String HASH_ALGORITHM = "SHA-256";

    private static byte[] getKey() throws Exception {
        try {
            String envFilePath = ""; // Caminho para .env
            FileInputStream fis = new FileInputStream(envFilePath);
            Properties props = new Properties();
            props.load(fis);
            String keyValue = props.getProperty("key");

            // Aplica o hash SHA-256 na chave original
            MessageDigest digest = MessageDigest.getInstance(HASH_ALGORITHM);
            byte[] hashedKeyBytes = digest.digest(keyValue.getBytes());

            // Pega apenas os primeiros 16 bytes do resultado do hash
            byte[] truncatedKeyBytes = Arrays.copyOf(hashedKeyBytes, 16);

            return truncatedKeyBytes;
        } catch (Exception e) {
            System.out.println("Erro ao obter a chave: " + e.getMessage());
            throw e;
        }
    }

    public static void encrypt(String inputFile, String outputFile) throws Exception {
        doCrypto(Cipher.ENCRYPT_MODE, inputFile, outputFile);
    }

    public static void decrypt(String inputFile, String outputFile) throws Exception {
        doCrypto(Cipher.DECRYPT_MODE, inputFile, outputFile);
    }

    private static void doCrypto(int cipherMode, String inputFile, String outputFile) throws Exception {
        Key secretKey = new SecretKeySpec(getKey(), ALGORITHM);
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        cipher.init(cipherMode, secretKey);

        try (FileInputStream inputStream = new FileInputStream(inputFile);
             FileOutputStream outputStream = new FileOutputStream(outputFile)) {
            byte[] inputBytes = new byte[(int) inputStream.available()];
            inputStream.read(inputBytes);
            byte[] outputBytes = cipher.doFinal(inputBytes);
            outputStream.write(outputBytes);
        }
    }
}
