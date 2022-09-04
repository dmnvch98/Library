package utils;

import usersPackage.UserType;

import java.util.InputMismatchException;
import java.util.Scanner;

import static utils.Utils.askEnterNumberInRange;

public final class UsersUtils {
    static Scanner scanner = new Scanner(System.in);
    private UsersUtils() {
    }

    public static UserType askUserType() {
        int enteredNumber = askEnterNumberInRange("Select user type: \n1 - Admin\n2 - User\nEnter number: ", 1, 2);
        return enteredNumber == 1 ? UserType.ADMIN : UserType.USER;
    }


//    public static boolean isStringHasFourOrMoreCharacters(String text) {
//        return text.length() >= 4;
//    }
//
//    public static String askEnterString(String format, String message, String startCursor) {
//        while (true) {
//            System.out.format(format, message, startCursor);
//            String enteredString = scanner.nextLine();
//            if (isStringHasFourOrMoreCharacters(enteredString)) {
//                return enteredString;
//            }
//        }
//    }
}
