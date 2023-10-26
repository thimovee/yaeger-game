package com.github.hanyaeger.tutorial.entities.plants;

import com.github.hanyaeger.api.entities.EntitySpawner;

public class PeaSpawner extends EntitySpawner {
    private final Plant peashooter;

    public PeaSpawner(Plant peashooter, int interval) {
        super(interval);
        this.peashooter = peashooter;
    }

    @Override
    protected void spawnEntities() {
        Pea pea = new Pea(peashooter.location);
        spawn(pea);
    }
}
