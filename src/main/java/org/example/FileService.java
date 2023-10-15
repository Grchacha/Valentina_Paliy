package org.example;
import java.io.*;

public class FileService {
    public static String readFile(String filePath) throws IOException {
        StringBuilder text = new StringBuilder();
        BufferedReader reader = new BufferedReader(new FileReader("\\C:\\навчання\\Develop\\Lady Gaga - Americano.txt\\"));
        String line;
        while ((line = reader.readLine()) != null) {
            text.append(line).append("\n");
        }
        reader.close();
        return text.toString();
    }

    public static void printFileContent(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("\\C:\\навчання\\Develop\\Lady Gaga - Americano.txt\\"));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        reader.close();
    }

    public static void writeFile(String filePath, String content) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\навчання\\Develop\\output.txt"));
        writer.write(content);
        writer.close();
    }

//    public static void writeToFile(String filePath, String content, int key) throws IOException {
//        BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\навчання\\Develop\\output.txt"));
//        String encryptedContent = CaesarCipher.encrypt(content, key, filePath);
//        writer.write(encryptedContent);
//        writer.close();
//    }

    public static void writeDecryptedToFile(String filePath, String content, int key) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\навчання\\Develop\\output.txt"));
        String decryptedContent = CaesarCipher.decrypt(content, key, filePath);
        writer.write(decryptedContent);
        writer.close();
    }
}
