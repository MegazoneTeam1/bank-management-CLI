package view;

import java.util.Scanner;

public class PrintUtil {
    private static final Scanner scanner = new Scanner(System.in);

    public static void print(String message) {
        System.out.print(message);
    }

    public static void println(String message) {
        System.out.println(message);
    }

    public static String readLine(String prompt) {
        print(prompt);
        return scanner.nextLine();
    }

    public static int readInt(String prompt) {
        while (true) {
            try {
                print(prompt);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                println("정수형을 입력해주세요.");
            }
        }
    }

    public static void displayMenu(String[] options) {
        for (int i = 0; i < options.length; i++) {
            println((i + 1) + ". " + options[i]);
        }
    }

}
