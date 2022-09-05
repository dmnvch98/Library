package utils;

import java.util.InputMismatchException;
import java.util.Scanner;

public final class Utils {

    private Utils() {
    }
    public static String askEnterString(String format, String message, String startCursor) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.format(format, message, startCursor);
            String enteredString = scanner.nextLine();
            if (isStringHasFourOrMoreCharacters(enteredString)) {
                return enteredString;
            }
        }
    }
    public static boolean isStringHasFourOrMoreCharacters(String text) {
        return text.length() >= 4;
    }

    public static int askEnterNumberInRange(String text, int start, int end) {
        while (true){
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.print(text);
                int enteredNum = scanner.nextInt();
                if (enteredNum >= start || enteredNum <= end) {
                    return enteredNum;
                }
            } catch (InputMismatchException e) {
                System.out.println("WARNING: Not number entered");
            }
        }
    }

    public static void print(Object object) {
        System.out.println(object);
    }
}
