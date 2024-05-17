import data.FileData;
import data.PermissionFileData;
import types.FileTypes;
import types.UserTypes;

public class Main {

    public static void main(String[] args) {

        // funcao cria usuario na tabela ja com senha com hash
        // u.createUser();

        // UsersData usuario = getgetUserByUsername("teste");

        FileData fd = new FileData();
        // FileTypes f = fd.getFileByUUID("41d4e67c-161b-4119-9f0f-ee9343de7aa3");
        // PermissionFileData pfd = new PermissionFileData();

        // pfd.giveGuestPermission(new UserTypes("teste2", "123456"), f);

        fd.deleteFile("41d4e67c-161b-4119-9f0f-ee9343de7aa3");

    }
}