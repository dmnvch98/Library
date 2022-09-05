package utils;

import usersPackage.UserType;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * Класс для хранения вспомогательных методов не относящихся к какому-либо классу.
 * **/
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

    public static UserType askUserType() {
        int enteredNumber = askEnterNumberInRange("Select user type: \n1 - Admin\n2 - User\nEnter number: ", 1, 2);
        return enteredNumber == 1 ? UserType.ADMIN : UserType.USER;
    }

    public static List<String> askCredentials() {
        String userName = askEnterString("%s%5s", "Enter username (minimum 4 characters) : ", "");
        String password = askEnterString("%s%5s", "Enter password (minimum 4 characters) : ", "");
        return List.of(userName, password);
    }
}
