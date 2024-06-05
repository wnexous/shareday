import data.FileData;
import data.PermissionFileData;
import data.UsersData;
import types.FileTypes;
import types.UserTypes;
import controllers.Criptografia;

import pages.*;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        UsersData usersData = new UsersData();

        UserTypes u = new UserTypes("teste", "teste");

        usersData.createUser(u);
        // funcao cria usuario na tabela ja com senha com hash


        // UsersData usuario = getgetUserByUsername("teste");

//        FileData fd = new FileData();
        // FileTypes f = fd.getFileByUUID("41d4e67c-161b-4119-9f0f-ee9343de7aa3");
        // PermissionFileData pfd = new PermissionFileData();

        // pfd.giveGuestPermission(new UserTypes("teste2", "123456"), f);

//        fd.deleteFile("41d4e67c-161b-4119-9f0f-ee9343de7aa3");

        // Testando a criptografia
//        String inputfile = ""; // data/teste.txt
//        String encrypted = ""; // data/testeEncrypted
//        String decrypted = ""; // data/testeDecrypted
//
//        cript(inputfile, encrypted, decrypted);
//
//    }
//
//    public static void cript(String input, String encrypted, String decrypted){
//        try{
//            // Criptografando
//            Criptografia.encrypt(input, encrypted);
//            //descriptografando Criptografia.decrypt(encrypted, decrypted);
//            System.out.println("Feito com sucesso");
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
    }
}

