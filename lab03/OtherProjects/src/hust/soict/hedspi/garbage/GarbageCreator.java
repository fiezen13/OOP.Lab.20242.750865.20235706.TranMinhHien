package hust.soict.hedspi.garbage;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GarbageCreator {
    public static void main(String[] args) {
        String filename = "test.txt"; 
        byte[] inputBytes = {0};
        long startTime, endTime;

        try {
            inputBytes = Files.readAllBytes(Paths.get(filename));
        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
            return;
        }

        startTime = System.currentTimeMillis();
        String outputString = "";

        for (byte b : inputBytes) {
            outputString += (char) b;
        }

        endTime = System.currentTimeMillis();
        System.out.println("Time taken (GarbageCreator): " + (endTime - startTime) + " ms");
    }
}