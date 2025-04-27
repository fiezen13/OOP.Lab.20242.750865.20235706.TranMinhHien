package hust.soict.hedspi.garbage;

import java.nio.file.Files;
import java.nio.file.Paths;

public class NoGarbage {
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
        StringBuilder outputString = new StringBuilder();

        for (byte b : inputBytes) {
            outputString.append((char) b);
        }

        endTime = System.currentTimeMillis();
        System.out.println("Time taken (NoGarbage): " + (endTime - startTime) + " ms");
    }
}