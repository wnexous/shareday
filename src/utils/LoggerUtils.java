package utils;

public abstract class LoggerUtils {

    static private void printDivisor(String title) {
        System.out.println(title.toUpperCase() + "> " + new String("-").repeat(20) + "\n");

    }

    static public void log(String text) {
        printDivisor("log");
        System.out.println(text);
    }

    static public void error(String text) {
        printDivisor("error");
        System.out.println(text);
    }

    static public void warn(String text) {
        printDivisor("warn");
        System.out.println(text);
    }

}
