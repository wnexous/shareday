package types;

public class FileTypes {

    private String fileUUID, owner, createAt, lastModifiedAt;

    public FileTypes(String fileUUID, String owner, String createAt, String lastModifiedAt) {
        this.fileUUID = fileUUID;
        this.owner = owner;
        this.createAt = createAt;
        this.lastModifiedAt = lastModifiedAt;
    }

    public String getUUID() {
        return this.fileUUID;
    }

    public String getOwner() {
        return this.owner;
    }

    public String getCreateAt() {
        return this.createAt;
    }

    public String getLastModifiedAt() {
        return this.lastModifiedAt;
    }

}
