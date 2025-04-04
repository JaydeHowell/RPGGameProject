package com.RPGProject;

public class Rogue extends Character{
    private int guile;

    public Rogue(String name, CharacterStats stats, String className, boolean isAIControlled) {
        super(name, stats, className, isAIControlled);
    }

    @Override
    public int dealDamage(Character target) {
        if (target.isLastAttackMissed()) {
            System.out.println(target.getName() + " is vulnerable for a sneak attack!");
            return rollDamageDice().rollDice(2);
        } else {
            return rollDamageDice().rollDice(1);
        }
    }

    @Override
    public String getAttackFlavor(Character target) {
        return getName() + " the " + getClassName()
                + " strikes deftly at " + target.getName() + ".";
    }
}
