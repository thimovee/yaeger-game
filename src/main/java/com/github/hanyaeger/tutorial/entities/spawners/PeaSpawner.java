package com.github.hanyaeger.tutorial.entities.spawners;

import com.github.hanyaeger.api.entities.EntitySpawner;
import com.github.hanyaeger.tutorial.entities.plants.Pea;
import com.github.hanyaeger.tutorial.entities.plants.Plant;

public class PeaSpawner extends EntitySpawner {
    private final Plant peashooter;

    public PeaSpawner(Plant peashooter, int interval) {
        super(interval);
        this.peashooter = peashooter;
    }

    @Override
    protected void spawnEntities() {
        Pea pea = new Pea(peashooter.getLocation());
        spawn(pea);
    }
}
