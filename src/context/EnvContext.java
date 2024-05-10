package context;

import java.util.ArrayList;
import java.util.List;
import controllers.FileController;

/**
 * How use?
 * 
 * String item = EnvContext.getItem("item");
 * 
 */

public abstract class EnvContext {

    static private FileController fileController = new FileController(".env");

    public static String getItem(String token) {
        List<String[]> lines = parseLinesWithDivisor("=");

        for (String[] line : lines) {
            if (line[0].equals(token))
                return line[1];
        }

        return null;
    }

    private static List<String[]> parseLinesWithDivisor(String divisor) {
        List<String[]> lines = new ArrayList<String[]>();

        for (String line : fileController.getLines()) {
            lines.add(line.split(divisor));
        }

        return lines;
    }

}
