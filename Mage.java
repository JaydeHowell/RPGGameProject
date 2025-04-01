package com.RPGProject;

public class Mage extends Character{
    private int mana;

    public Mage(String name, CharacterStats stats, String className) {
        super(name, stats, className);
    }

    @Override
    public int dealDamage(Character target) {
        return rollDamageDice().rollDice(1);
    }

    @Override
    public String getAttackFlavor(Character target) {
        return getName() + " the " + getClassName()
                + " casts a spell at " + target.getName() + ".";
    }
}
