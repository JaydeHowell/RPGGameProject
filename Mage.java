package com.RPGProject;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Mage extends Character{
    private int mana;
    private int currentMana;
    private ArrayList<String> knownSpells = new ArrayList<>();

    public Mage(String name, CharacterStats stats, String className, boolean isAIControlled, int mana) {
        super(name, stats, className, isAIControlled);
        this.mana = mana;
        this.currentMana = mana;
        knownSpells.add("Lightning");
        knownSpells.add("Shield");
        knownSpells.add("Overheat");
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

    public String chooseSpellAI() {
        List<String> weighted = new ArrayList<>();
        int mana = getCurrentMana();
        weighted = knownSpells;

        if (mana >= 5) {
            weighted.add("Overheat");
            weighted.add("Overheat");
            weighted.add("Overheat");
        }
        if (mana >= 2) {
            weighted.add("Lightning");
            weighted.add("Lightning");
        }
        if (currentHealth <= getMaxHealth()/2) {
            weighted.add("Shield");
        }
        weighted.add("Shield");

        return weighted.get(new Random().nextInt(weighted.size()));
    }

    public Spell spellDecision(Mage mage, Character target) {
        Console.printSmallPause("You have " + getCurrentMana() + " remaining.");
        String[] spellOptions = knownSpells.toArray(new String[0]);
        while (true) {
            String choice = Console.readChoice("Which attack would you like to use?", spellOptions);
            Spell decision = SpellRegistry.getByName(choice);
            if (currentMana >= decision.cost()) {
                return decision;
            } else {
                System.out.println("You don't have enough mana to cast " + decision.name());
            }
        }
    }

    public void castSpell(Spell spell, Mage caster, Character target) {
        if (currentMana >= spell.cost()) {
            currentMana -= spell.cost();
            int damage = spell.rollDamage();
            target.takeDamage(damage, caster);
            Console.printLargePause(getName() + " casts " + spell.name() + " at "
                    + target.getName() + " for " + damage + " damage!");
        } else {
            Console.printSmallPause("Not enough mana to cast ");
        }
    }

    public void addSpell(String spell) {
        knownSpells.add(spell);
    }

    public void removeSpell(String spell) {
        knownSpells.remove(spell);
    }

    public ArrayList<String> getKnownSpells() {
        return knownSpells;
    }

    public void resetKnownSpells(ArrayList<String> spellOptions) {
        this.knownSpells = spellOptions;
    }

    public int getMana() {
        return mana;
    }

    public int getCurrentMana() {
        return currentMana;
    }

    public void setCurrentMana(int mana) {
        this.currentMana = mana;
    }
}
