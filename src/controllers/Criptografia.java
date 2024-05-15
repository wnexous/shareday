// Sendo implementado ainda
package controllers;
import java.io.*;
import javax.crypto.*;
import javax.crypto.spec.*;
import java.security.spec.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.KeySpec;


public class Criptografia {

    public static SecretKey sKey;
    private static String algoritimo = "AES/CBC/PKCS5Padding";

    public static void encrypt(char[] passwd, File arquivo){
        try {
            SecretKeyFactory skf = SecretKeyFactory.getInstance(algoritimo);
            KeySpec ks = new PBEKeySpec(passwd, new byte[] {1,2,3,4,5,6,7,8,9,10}, 1000);
            SecretKey skey = skf.generateSecret (ks);
            Cipher cipher = Cipher.getInstance(algoritimo);
            cipher.init(Cipher.ENCRYPT_MODE, skey);


        } catch(InvalidKeySpecException | NoSuchAlgorithmException nsae){
            System.out.printf("Erro: %s", nsae.getMessage());
        } catch (NoSuchPaddingException | InvalidKeyException a) {
            System.out.println(a.getMessage());
        }
    }
}
