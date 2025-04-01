package com.RPGProject;

public class Main {
    public static void main(String[] args) {

        Character champion = PartyManager.createCharacter("your combatant");
        Character opponent = PartyManager.createCharacter("your opponent");

        System.out.println("Let the battle begin!");
        Console.pause(500);
        Battle battle = new Battle();
        battle.startBattle(champion, opponent);
    }

}
