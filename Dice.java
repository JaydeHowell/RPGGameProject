package com.RPGProject;

import com.sun.tools.jconsole.JConsoleContext;

import java.util.Scanner;

public class Dice {
    private int sides;
    private String rollType;

    public Dice(int sides, String rollType) {
        this.rollType = rollType;
        setSides(sides);
    }


    public static int readNumber(String prompt) {
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[] {
                4, 6, 8, 10, 12, 20
        };
        boolean restart = true;
        int value = 0;
        while (restart) {
            System.out.print(prompt);
            value = scanner.nextInt();
            for (int j : array) {
                if (j == value) {
                    restart = false;
                    break;
                }
            }
            if (restart) {
                System.out.println("Sides must be equal to 2, 4, 6, 8, 10, 12, or 20.");
            }
        }
        return value;
    }

    public int rollDice(int timesRolled) {
        setTimesRolled(timesRolled);
        int total = 0;
        System.out.println();
        for (int i = timesRolled; i > 0; i--) {
            int roll = (int) (Math.random() * sides + 1);
            total = total + roll;
            System.out.println("Rolling to " + rollType + "...");
            Console.pause(1000);
            System.out.println(Console.cleanInput(rollType) + " Roll #" + i + ": " + roll);
        }
        System.out.println();
        System.out.println("Total: " + total);
        Console.pause(1000);
        return total;
    }

    public int rollWithDisadvantage() {
        int firstRoll = rollDice(1);
        int secondRoll = rollDice(1);
        Console.printSmallPause("Taking the lower of " + firstRoll
                + " and " + secondRoll);
        return Math.min(firstRoll, secondRoll);
    }

    public void setSides(int sides) {
        if (sides < 2) {
            throw new IllegalArgumentException("There cannot be fewer than 2 sides on a die.");
        }
        this.sides = sides;
    }

    public void setTimesRolled(int timesRolled) {
        if (timesRolled < 1) {
            throw new IllegalArgumentException("Times rolled cannot be fewer than 1.");
        }
    }
}

