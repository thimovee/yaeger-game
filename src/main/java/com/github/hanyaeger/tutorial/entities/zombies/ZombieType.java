package com.github.hanyaeger.tutorial.entities.zombies;

import com.github.hanyaeger.api.Coordinate2D;

public enum ZombieType {
    ALLSTAR(AllStar.class),
    BUCKETHEAD(Buckethead.class),
    CONEHEAD(Conehead.class),
    BALLOON(BalloonZombie.class),
    FLAG(FlagZombie.class);


    private final Class<? extends Zombie> zombieClass;

    ZombieType(Class<? extends Zombie> zombieClass) {
        this.zombieClass = zombieClass;
    }

    public Zombie createZombie(Coordinate2D location) {
        try {
            return zombieClass.getConstructor(Coordinate2D.class).newInstance(location);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    }
