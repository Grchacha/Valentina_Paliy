package org.example;


    public class Runner {
        public static void main(String[] args) {
            if (args.length == 0) {
                CLI1.run();
            } else {
                String command = args[0];
                String filePath = args[1];
                int key = Integer.parseInt(args[2]);
                CLI1.processCommand(command, filePath, 3);
                System.out.println(command);
                System.out.println(filePath);
                System.out.println(key);
            }
        }
    }

