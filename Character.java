package com.RPGProject;

public abstract class Character {
    private String name;
    private String className;
    private CharacterStats stats;
    public int currentHealth;
    private boolean lastAttackMissed = false;

    public Character(String name, CharacterStats stats, String className) {
        this.name = Console.cleanInput(name);
        this.className = className;
        this.stats = stats;
        this.currentHealth = stats.maxHealth();
    }

    public int takeDamage (int damage) {
        currentHealth -= damage;
        return damage;
    }

    public boolean isSpell() {
        return stats.isSpell();
    }

    public boolean isAlive () {
        return currentHealth > 0;
    }

    public abstract int dealDamage(Character target);

    public abstract String getAttackFlavor(Character target);

    public String getName() {
        return name;
    }

    public int getLevel() {
        return stats.level();
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    public int getMaxHealth() {
        return stats.maxHealth();
    }

    public int getAttackDice() {
        return stats.attackDice();
    }

    public Dice rollDamageDice() {
        return new Dice(stats.damageDice(), "damage");
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public boolean isLastAttackMissed() {
        return lastAttackMissed;
    }

    public void setLastAttackMissed(boolean lastAttackMissed) {
        this.lastAttackMissed = lastAttackMissed;
    }
}
