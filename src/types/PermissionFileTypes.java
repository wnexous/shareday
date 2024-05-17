package types;

public class PermissionFileTypes {

    private String username, fileUUID;
    private boolean canEdit;

    public PermissionFileTypes(String username, String fileUUID, boolean canEdit) {
        this.fileUUID = fileUUID;
        this.username = username;
        this.canEdit = canEdit;
    }

    public String getFileUUID() {
        return this.fileUUID;
    }
}
