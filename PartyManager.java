package com.RPGProject;

public class PartyManager {
    public static Character createCharacter(String role) {
        String className = Console.readClass("Please choose " + role
                + ": Fighter, Mage, or Rogue.").toLowerCase();
        String characterName = Console.readName("What is the name of " + role + "?");

        return switch (className) {
            case "fighter" -> new Fighter(characterName, StatsTemplates.FIGHTER, "Fighter");
            case "mage" -> new Mage(characterName, StatsTemplates.MAGE, "Mage");
            case "rogue" -> new Rogue(characterName, StatsTemplates.ROGUE, "Rogue");
            default -> throw new IllegalArgumentException("Invalid class: " + className);
        };
    }
}