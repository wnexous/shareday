package controllers;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

/**
 * 
 * HOW USE?
 * 
 * FileController fc = new FileController("path/from/file.txt")
 */

public class FileController {
    private Path filePath;
    private File file;

    public FileController(String pathname) {
        this.file = new File(pathname);
        this.filePath = this.file.toPath();
    }

    public List<String> getLines() {
        try {
            return Files.readAllLines(this.filePath);
        } catch (Exception e) {
            return null;
        }
    }

    private String toNewLine(String line) {
        if (!line.endsWith("\n"))
            line += "\n";

        return line;
    }

    public void appendLine(String line) {
        try {
            Files.write(this.filePath, toNewLine(line).getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void appendLines(List<String> lines) {
        try {
            for (String line : lines) {
                Files.write(this.filePath, toNewLine(line).getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void writeLine(String line) {
        try {
            Files.write(this.filePath, toNewLine(line).getBytes(StandardCharsets.UTF_8), StandardOpenOption.WRITE);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void writeLines(List<String> lines) {
        try {
            this.clearFile();
            this.appendLines(lines);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void clearFile() {
        try {
            Files.write(this.filePath, ("").getBytes(StandardCharsets.UTF_8));
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void removeLineByIndex(int index) {
        List<String> lines = this.getLines();

        try {
            lines.remove(index);
            this.writeLines(lines);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void deleteFile() {
        this.file.delete();
    }

    public void createFile() {
        try {
            this.file.createNewFile();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
