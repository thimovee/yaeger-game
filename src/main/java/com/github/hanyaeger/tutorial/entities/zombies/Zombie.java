package com.github.hanyaeger.tutorial.entities.zombies;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;



public abstract class Zombie extends DynamicSpriteEntity implements Collided, Collider {

    protected int id;
    protected int health;
    protected int attack;
    protected Coordinate2D location;
    protected String image;

    public Zombie(int health, int attack, Coordinate2D location, String image, int id) {
        super(image, location, new Size(70,70));
        this.health = health;
        this.attack = attack;
        this.location = location;
        this.image = image;
        this.id = id;
    }

    public Coordinate2D getLocation() {
        return location;
    }

    public abstract void action();

    public int getHealth() {
        return health;
    }

    public int getAttack() {
        return attack;
    }

    public void setHealth(int health) {
        this.health = health;
    }

}
