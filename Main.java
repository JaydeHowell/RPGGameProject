package com.RPGProject;

public class Main {
    public static void main(String[] args) {

        Character champion = PartyManager.createCharacter("combatant", false);
        Character opponent = PartyManager.createCharacter("opponent", true);

        System.out.println("Let the battle begin!");
        Console.pause(500);
        Battle battle = new Battle();
        battle.startBattle(champion, opponent);
    }

}
