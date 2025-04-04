package com.RPGProject;

public class PartyManager {
    private static String[] classOptions = { "Fighter", "Mage", "Rogue" };

    public static Character createCharacter(String role, boolean isAIControlled) {
        String className = Console.readChoice("Please choose your " + role, classOptions).toLowerCase();
        String characterName = Console.readText("What is the name of your " + role + "?");

        return switch (className) {
            case "fighter" -> new Fighter(characterName, StatsTemplates.FIGHTER, "Fighter", isAIControlled);
            case "mage" -> new Mage(characterName, StatsTemplates.MAGE, "Mage", isAIControlled, 10);
            case "rogue" -> new Rogue(characterName, StatsTemplates.ROGUE, "Rogue", isAIControlled);
            default -> throw new IllegalArgumentException("Invalid class: " + className);
        };
    }
}