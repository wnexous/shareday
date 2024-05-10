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

    public FileController(String pathname) {
        File file = new File(pathname);
        this.filePath = file.toPath();
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

    public void appendLines(String[] lines) {
        try {
            for (String line : lines) {
                Files.write(this.filePath, toNewLine(line).getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

}
