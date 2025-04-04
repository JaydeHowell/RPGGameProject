package com.RPGProject;

public class Fighter extends Character{
    private int stamina;
    private boolean hasUsedSecondWind;

    public Fighter(String name, CharacterStats stats, String className, boolean isAIControlled) {
        super(name, stats, className, isAIControlled);
    }

    public boolean shouldUseSecondWind() {
        return !hasUsedSecondWind && getCurrentHealth() <= (getMaxHealth()) / 2;
    }

    public void useSecondWind() {
        if (!hasUsedSecondWind && isAlive()) {
            var secondWindDice = new Dice(10, "heal");
            int heal = secondWindDice.rollDice(1);
            setCurrentHealth(Math.min(getCurrentHealth() + heal, getMaxHealth()));
            hasUsedSecondWind = true;
            System.out.println(getName() + " used Second Wind to recover " + heal + " HP!");
        }
    }

    @Override
    public int takeDamage(int damage, Character attacker) {
        if (!attacker.isSpell()) {
            int reduced = damage - 2;
            super.takeDamage(reduced, attacker);
            System.out.println(getName() + "'s heavy armor reduced the damage by 2");
            return reduced;
        } else {
            return super.takeDamage(damage, attacker);
        }
    }

    @Override
    public int dealDamage(Character target) {
        return rollDamageDice().rollDice(1);
    }

    @Override
    public String getAttackFlavor(Character target) {
        return getName() + " the " + getClassName()
                + " swings aggressively at " + target.getName() + ".";
    }
}
