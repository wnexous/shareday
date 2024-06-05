package controllers;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashController {
    
    public static String encode(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            StringBuilder hexString = new StringBuilder();
            
            for (byte b : hash) {
                hexString.append(String.format("%02x", b));
            }
            
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean verify(String password, String hash) {
        return encode(password).equals(hash);
    }
}
