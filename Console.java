package com.RPGProject;

import java.util.Scanner;
import java.util.Set;

public class Console {
    private static Scanner scanner = new Scanner(System.in);
    private static final Set<String> VALID_CLASSES = Set.of("Fighter", "Mage", "Rogue");

    public static String readClass(String prompt) {
        String value;
        while (true) {
            System.out.println(prompt);
            value = scanner.nextLine().trim();
            if (value.equalsIgnoreCase("Fighter") ||
                value.equalsIgnoreCase("Mage") ||
                value.equalsIgnoreCase("Rogue")) {
            break;
            }
            System.out.println("Please type the name of one of the listed combatants.");
        }
        return value;
    }
    public static String readName(String prompt) {
        String value;
        while (true) {
            System.out.println(prompt);
            value = scanner.nextLine().trim();
            if (value.isEmpty()) {
                System.out.println("Please type a name for your character.");
            } else {
                break;
            }
        }
        return value;
    }

    public static void pause(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static void printSmallPause(String input) {
        System.out.println(input);
        Console.pause(500);
    }

    public static void printLargePause(String input) {
        System.out.println(input);
        Console.pause(1000);
    }

    public static String cleanInput(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }
        return input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase();
    }
}
