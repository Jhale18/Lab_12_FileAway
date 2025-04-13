import java.util.Scanner;

public class SafeInput {

    public static String getNonZeroLenString(Scanner pipe, String prompt) {
        String retString;
        do {
            System.out.print(prompt + ": ");
            retString = pipe.nextLine().trim();
        } while (retString.isEmpty());

        return retString;
    }

    public static int getInt(Scanner pipe, String prompt) {
        int result;
        while (true) {
            System.out.print(prompt + ": ");
            if (pipe.hasNextInt()) {
                result = pipe.nextInt();
                pipe.nextLine();
                return result;
            } else {
                String trash = pipe.nextLine();
                System.out.println("Invalid input: \"" + trash + "\". Please enter a valid integer.");
            }
        }
    }

    public static double getDouble(Scanner pipe, String prompt) {
        double result;
        while (true) {
            System.out.print(prompt + ": ");
            if (pipe.hasNextDouble()) {
                result = pipe.nextDouble();
                pipe.nextLine();
                return result;
            } else {
                String trash = pipe.nextLine();
                System.out.println("Invalid input: \"" + trash + "\". Please enter a valid double.");
            }
        }
    }

    public static int getRangedInt(Scanner pipe, String prompt, int low, int high) {
        int result;
        while (true) {
            System.out.print(prompt + " [" + low + " - " + high + "]: ");
            if (pipe.hasNextInt()) {
                result = pipe.nextInt();
                pipe.nextLine();
                if (result >= low && result <= high) {
                    return result;
                } else {
                    System.out.println("Invalid input. Please enter an integer between " + low + " and " + high + ".");
                }
            } else {
                String trash = pipe.nextLine();
                System.out.println("Invalid input: \"" + trash + "\". Please enter a valid integer.");
            }
        }
    }

    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high) {
        double result;
        while (true) {
            System.out.print(prompt + " [" + low + " - " + high + "]: ");
            if (pipe.hasNextDouble()) {
                result = pipe.nextDouble();
                pipe.nextLine(); // Clear the buffer
                if (result >= low && result <= high) {
                    return result;
                } else {
                    System.out.println("Invalid input. Please enter a number between " + low + " and " + high + ".");
                }
            } else {
                String trash = pipe.nextLine();
                System.out.println("Invalid input: \"" + trash + "\". Please enter a valid double.");
            }
        }
    }

    public static boolean getYNConfirm(Scanner pipe, String prompt) {
        String input;
        while (true) {
            System.out.print(prompt + " [Y/N]: ");
            input = pipe.nextLine().trim();
            if (input.equalsIgnoreCase("Y")) {
                return true;
            } else if (input.equalsIgnoreCase("N")) {
                return false;
            } else {
                System.out.println("Invalid input. Please enter 'Y' for Yes or 'N' for No.");
            }
        }
    }

    public static String getRegExString(Scanner pipe, String prompt, String pattern) {
        String input;
        while (true) {
            System.out.print(prompt + ": ");
            input = pipe.nextLine().trim();
            if (input.matches(pattern)) {
                return input;
            } else {
                System.out.println("Invalid input. Please try again.");
            }
        }
    }

    public static void prettyHeader(String msg) {
        int width = 60;
        int padding = (width - 6 - msg.length()) / 2;

        for (int i = 0; i < width; i++) System.out.print("*");
        System.out.println();

        System.out.print("***");
        for (int i = 0; i < padding; i++) System.out.print(" ");
        System.out.print(msg);
        for (int i = 0; i < padding; i++) System.out.print(" ");
        if ((msg.length() + 6) % 2 != 0) System.out.print(" ");
        System.out.println("***");

        for (int i = 0; i < width; i++) System.out.print("*");
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        prettyHeader("Message Centered Here");
        String nonZeroString = getNonZeroLenString(in, "Enter a non-empty string");
        System.out.println("You entered: " + nonZeroString);
        in.close();
    }
}