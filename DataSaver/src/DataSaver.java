import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DataSaver {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<String> records = new ArrayList<>();
        int idCounter = 1;
        boolean keepGoing = true;
        while (keepGoing) {
            String firstName = SafeInput.getNonZeroLenString(in, "Enter First Name");
            String lastName = SafeInput.getNonZeroLenString(in, "Enter Last Name");
            String email = SafeInput.getNonZeroLenString(in, "Enter Email");
            int yearOfBirth = SafeInput.getInt(in, "Enter Year of Birth");
            String idNumber = String.format("%06d", idCounter);
            String record = firstName + ", " + lastName + ", " + idNumber + ", " + email + ", " + yearOfBirth;
            records.add(record);
            idCounter++;

            keepGoing = SafeInput.getYNConfirm(in, "Add another record?");
        }
        String fileName = SafeInput.getNonZeroLenString(in, "Enter file name (add .csv extension)");
        Path filePath = Paths.get(System.getProperty("user.dir") + "/src/" + fileName);

        try (BufferedWriter writer = Files.newBufferedWriter(filePath)) {
            for (String record : records) {
                writer.write(record);
                writer.newLine();
            }
            System.out.println("Data saved to " + fileName);
        } catch (IOException e) {
            System.out.println("Error writing the file!");
        }
    }
}