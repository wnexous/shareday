package data;

import java.util.ArrayList;
import java.util.List;

import controllers.DataController;
import types.DataColumnTypes;
import types.FileTypes;
import types.UserTypes;

public class PermissionFileData extends DataController {

    private DataColumnTypes usernameColumn = new DataColumnTypes("username");
    private DataColumnTypes fileUuidColumn = new DataColumnTypes("file_uuid");
    private DataColumnTypes canEditColumn = new DataColumnTypes("can_edit");

    public PermissionFileData() {
        super("PermissionFileData.txt");
    }

    public void giveOwnerPermission(UserTypes user, FileTypes file) {
        this.appendRow(new String[] { user.getUsername(), file.getUUID(), Boolean.toString(true) });
    }

    public void giveGuestPermission(UserTypes guest, FileTypes file) {
        this.appendRow(new String[] { guest.getUsername(), file.getUUID(), Boolean.toString(false) });
    }

    public ArrayList<UserTypes> getPermissionsFromUser(UserTypes user) {
        UsersData usersData = new UsersData();

        List<String[]> dataTable = this.findItemsByColumn(user.getUsername(), usernameColumn);
        ArrayList<UserTypes> dataArray = new ArrayList<UserTypes>();

        // Caso nao encontre o usuario na tabela, retorna nulo
        if (dataTable == null || dataTable.size() == 0)
            return null;

        for (String[] dataRowTable : dataTable) {
            String username = dataRowTable[this.getIndexFromColumn(usernameColumn)];

            if (username.equals(user.getUsername())) {
                UserTypes finddedUser = usersData.getUserByUsername(username);
                if (finddedUser != null)
                    dataArray.add(finddedUser);
            }
        }
        return dataArray;
    }

    public ArrayList<FileTypes> getPermissionsFromFile(FileTypes file) {
        FileData fileData = new FileData();

        List<String[]> dataTable = this.findItemsByColumn(file.getUUID(), fileUuidColumn);
        ArrayList<FileTypes> dataArray = new ArrayList<FileTypes>();

        // Caso nao encontre o usuario na tabela, retorna nulo
        if (dataTable == null || dataTable.size() == 0)
            return null;

        for (String[] dataRowTable : dataTable) {
            String fileUUID = dataRowTable[this.getIndexFromColumn(fileUuidColumn)];

            if (fileUUID.equals(file.getUUID())) {
                FileTypes finddedData = fileData.getFileByUUID(fileUUID);
                if (finddedData != null)
                    dataArray.add(finddedData);
            }
        }
        return dataArray;
    }

    public void deletePermissionsFromFile(FileTypes file) {
        // ArrayList<FileTypes> fileType
        List<Integer> rowIndexes = this.findIndexFromItemsByColumn(file.getUUID(), fileUuidColumn);
        for (Integer rowIndex : rowIndexes) {
            this.removeRowByIndex(rowIndex);
        }

    }
}
