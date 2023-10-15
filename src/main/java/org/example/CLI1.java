package org.example;

import java.io.IOException;
import java.util.Scanner;

public class CLI1 {
    public static void run() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter command (ENCRYPT, DECRYPT, BRUTE_FORCE): ");
        String command = scanner.nextLine();

        System.out.print("Enter file path: ");
        String filePath = scanner.nextLine();

        if (!command.equals("BRUTE_FORCE")) {
            System.out.print("Enter key: ");
            int key = scanner.nextInt();
            scanner.nextLine();
            processCommand(command, filePath, key);
        } else {
            bruteForce(filePath);
        }
    }

    static void processCommand(String command, String filePath, int key) {
        try {
            String text = FileService.readFile("\\C:\\навчання\\Develop\\Lady Gaga - Americano.txt\\");
            String result = "";
            if (command.equals("ENCRYPT")) {
                result = CaesarCipher.encrypt(text, 3, filePath);
            } else if (command.equals("DECRYPT")) result = CaesarCipher.decrypt(text, 3, filePath);

            FileService.writeFile("[ENCRYPTED/DECRYPTED]_" + "C:\\навчання\\Develop\\output.txt", result);
            System.out.println("Operation completed successfully.");
        } catch (IOException e) {
            System.err.println("Error reading/writing file: " + e.getMessage());
        }
    }

    private static void bruteForce(String filePath) {
        try {
            String text = FileService.readFile("\\C:\\навчання\\Develop\\Lady Gaga - Americano.txt\\");
            System.out.println("Brute Force Results:");
            CaesarCipher.bruteForce(text);
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}