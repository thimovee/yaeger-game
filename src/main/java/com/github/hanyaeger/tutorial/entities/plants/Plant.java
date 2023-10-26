package com.github.hanyaeger.tutorial.entities.plants;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

public abstract class Plant extends DynamicSpriteEntity implements Collided, Collider {
    protected int cost;
    protected int id;
    protected int health;
    protected int attack;
    protected Coordinate2D location;
    protected String image;

    public Plant(int cost, int health, int attack, Coordinate2D location, String image, int id) {
        super(image, location, new Size(70,70));
        this.cost = cost;
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

    public void getDamage(int damage){
        this.health -= damage;
    }

    public int getHealth(){
        return this.health;
    }

    public int getAttack(){
        return this.attack;
    }

    public int getCost(){
        return this.cost;
    }


}