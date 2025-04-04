package com.RPGProject;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class SpellRegistry {
    private static final Map<Integer, Spell> idToSpell = new HashMap<>();
    private static final Map<String, Spell> nameToSpell = new HashMap<>();

    static {
        register(new Spell(1, "Lightning", 2, 6, 2));
        register(new Spell(2, "Overheat", 5, 10, 2));
        register(new Spell(3, "Shield", 0, 0, 0));
    }

    private static void register(Spell spell) {
        idToSpell.put(spell.id(), spell);
        nameToSpell.put(spell.name().toLowerCase().trim(), spell);
    }

    public static Spell getByID(int id) {
        return idToSpell.get(id);
    }

    public static Spell getByName(String name) {
        return nameToSpell.get(name.toLowerCase().trim());
    }

    public static Collection<Spell> getAllSpells() {
        return idToSpell.values();
    }
}
