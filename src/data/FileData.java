package data;

import java.util.UUID;
import controllers.DataController;
import controllers.FileController;
import types.DataColumnTypes;
import types.FileTypes;
import types.UserTypes;

public class FileData extends DataController {

    private DataColumnTypes fileUuidColumn = new DataColumnTypes("file_uuid");
    private DataColumnTypes ownerColumn = new DataColumnTypes("owner");
    private DataColumnTypes createAtColumn = new DataColumnTypes("create_at");
    private DataColumnTypes lastModifiedAtColumn = new DataColumnTypes("last_modified_at");

    private String filesBasePath = "files/";

    public FileData() {
        super("FileData.txt");
    }

    public FileTypes getFileByOwner(String owner) {
        String[] useyArray = this.findItemByColumn(owner, ownerColumn);

        // Caso nao encontre o usuario na tabela, retorna nulo
        if (useyArray == null)
            return null;

        return new FileTypes(
                useyArray[this.getIndexFromColumn(fileUuidColumn)],
                useyArray[this.getIndexFromColumn(ownerColumn)],
                useyArray[this.getIndexFromColumn(createAtColumn)],
                useyArray[this.getIndexFromColumn(lastModifiedAtColumn)]);
    }

    public FileTypes getFileByUUID(String fileUUID) {
        String[] useyArray = this.findItemByColumn(fileUUID, fileUuidColumn);

        // Caso nao encontre o usuario na tabela, retorna nulo
        if (useyArray == null)
            return null;

        return new FileTypes(
                useyArray[this.getIndexFromColumn(fileUuidColumn)],
                useyArray[this.getIndexFromColumn(ownerColumn)],
                useyArray[this.getIndexFromColumn(createAtColumn)],
                useyArray[this.getIndexFromColumn(lastModifiedAtColumn)]);
    }

    private String uuidToFilename(String fileUUID) {
        return filesBasePath + fileUUID + ".txt";

    }

    public void createFile(UserTypes userOwner) {

        PermissionFileData permissionFileData = new PermissionFileData();

        String currentDateTime = String.format("%d", new java.util.Date().getTime());

        String fileUUID = UUID.randomUUID().toString();
        String owner = userOwner.getUsername();
        String createAt = currentDateTime;
        String lastModifiedAt = currentDateTime;

        FileTypes file = new FileTypes(fileUUID, owner, createAt, lastModifiedAt);

        FileController userFile = new FileController(uuidToFilename(fileUUID));
        userFile.createFile();

        this.appendRow(new String[] { fileUUID, owner, createAt, lastModifiedAt });

        permissionFileData.giveOwnerPermission(userOwner, file);
    }

    public void deleteFile(String fileUUID) {
        PermissionFileData permissionFileData = new PermissionFileData();
        FileData fileData = new FileData();

        FileController userFile = new FileController(uuidToFilename(fileUUID));
        FileTypes file = fileData.getFileByUUID(fileUUID);
        userFile.deleteFile();

        if (file != null)
            permissionFileData.deletePermissionsFromFile(file);
    }
}
