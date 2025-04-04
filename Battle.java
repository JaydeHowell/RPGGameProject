package com.RPGProject;

public class Battle {
    private Dice hitDice = new Dice(20, "hit");
    private static final int HIT_THRESHOLD = 10;
    private boolean lastAttackMissed = false;

    public void startBattle(Character champion, Character opponent) {
        Console.printLargePause("The battle between "
                + champion.getName() + " and " + opponent.getName()
                + " has begun!");
        int countRound = 1;

        while (champion.isAlive() && opponent.isAlive()) {
            System.out.println("Round #" + countRound);
            takeTurn(champion, opponent);
            if (!opponent.isAlive()) {
                break;
            }

            takeTurn(opponent,champion);
            if (!champion.isAlive()) {
                break;
            }

            countRound++;
        }
        Character winner = champion.isAlive() ? champion : opponent;
        System.out.println(winner.getName() + " the " + winner.getClassName() + " is victorious!");
        System.out.println("This battle took " + countRound + " rounds to complete.");
    }


    public void takeTurn(Character attacker, Character defender) {
        Console.printLargePause(attacker.getName() + " is taking their turn.");

        attack(attacker, defender);

        if (defender.isAlive()) {
            Console.printSmallPause(defender.getName() + " has "
                    + defender.getCurrentHealth() + " health remaining");
        } else {
            Console.printLargePause("It's over!");
        }
    }

    private void attack(Character attacker, Character defender) {
        Console.printLargePause(attacker.getAttackFlavor(defender));
        int toHit;
        switch (defender) {
            case Rogue rogue when attacker.isSpell() -> {
                Console.printLargePause(defender.getName() + " is showing lightning quick reflexes!");
                toHit = hitDice.rollWithDisadvantage();
            }
            case null, default -> toHit = hitDice.rollDice(1);
        }
        switch (attacker) {
            case Mage mage -> {
                if (mage.isAIControlled()) {
                    String choice = mage.chooseSpellAI();
                    Spell spell = SpellRegistry.getByName(choice);
                    mage.castSpell(spell, mage, defender);
                } else {
                    Spell spell = mage.spellDecision(mage, defender);
                    mage.castSpell(spell, mage, defender);
                }
            }
            default -> {
                if (toHit >= HIT_THRESHOLD) {
                    Console.printSmallPause("It's a hit!");
                    attacker.setLastAttackMissed(false);
                    int damage = attacker.dealDamage(defender);
                    int damageTaken = defender.takeDamage(damage, attacker);
                    Console.printSmallPause(defender.getName() + " takes " + damageTaken + " damage.");
                    if (defender instanceof Fighter fighter && fighter.shouldUseSecondWind()) {
                        fighter.useSecondWind();
                    }
                } else {
                    Console.printLargePause("The attack missed.");
                    attacker.setLastAttackMissed(true);
                }
            }
        }
    }

    public boolean isLastAttackMissed() {
        return lastAttackMissed;
    }
}
