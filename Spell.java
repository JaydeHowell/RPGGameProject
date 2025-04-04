package com.RPGProject;

public record Spell (int id, String name, int cost, int damageDice, int timesRolled) {

    public int rollDamage() {
        return new Dice(damageDice, name).rollDice(timesRolled);
    }

    public boolean isOffensive() {
        return damageDice > 0;
    }
}
