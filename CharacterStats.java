package com.RPGProject;

public record CharacterStats(
            int maxHealth,
            int level,
            String weapon,
            int armor,
            int attackDice,
            int damageDice,
            boolean isSpell
    ) {}