package util;

import java.util.Scanner;

public class MyScanner {
    private static final Scanner scanner = new Scanner(System.in);

    public String scanString() {
        return scanner.nextLine();
    }
    public String scanString(String message) {
        System.out.println(message);
        return scanString();
    }

    public Integer scanInteger() {
        Integer result = scanner.nextInt();
        scanner.nextLine();
        return result;
    }
    public Integer scanInteger(String message) {
        System.out.println(message);
        return scanInteger();
    }
}
