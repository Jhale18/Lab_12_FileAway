import javax.swing.*;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Files;

public class FileInspector {
    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File(System.getProperty("user.dir") + "/src"));
        int result = chooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            Path filePath = file.toPath();
            int lines = 0;
            int words = 0;
            int characters = 0;
            try (BufferedReader reader = Files.newBufferedReader(filePath)) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                    lines++;
                    words += line.split("\\s+").length;
                    characters += line.length();
                }
            } catch (IOException e) {
                System.out.println("Error reading the file!");
                e.printStackTrace();
            }

            System.out.println("\nSummary:");
            System.out.println("File: " + file.getName());
            System.out.println("Lines: " + lines);
            System.out.println("Words: " + words);
            System.out.println("Characters: " + characters);
        } else {
            System.out.println("No file selected!");
        }
    }
}
