package fr.kabiro.lol.ism.core.pojo;

public class ZipFile {
    private String path;
    private byte[] fileContent;

    public ZipFile(String path, byte[] fileContent) {
        this.path = path;
        this.fileContent = fileContent;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public byte[] getFileContent() {
        return fileContent;
    }

    public void setFileContent(byte[] fileContent) {
        this.fileContent = fileContent;
    }
}
