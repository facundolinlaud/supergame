package com.facundolinlaud.supergame.utils.events;

import com.badlogic.ashley.core.Entity;

public class EntityAttackedEvent extends Event {
    private Entity victim;
    private Entity attacker;
    private int damage;

    public EntityAttackedEvent(Entity victim, Entity attacker, int damage) {
        this.victim = victim;
        this.attacker = attacker;
        this.damage = damage;
    }

    public Entity getVictim() {
        return victim;
    }

    public Entity getAttacker() {
        return attacker;
    }

    public int getDamage() {
        return damage;
    }
}
