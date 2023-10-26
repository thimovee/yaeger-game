package com.github.hanyaeger.tutorial.entities.zombies;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.tutorial.scenes.FirstLevel;


public abstract class Zombie extends DynamicSpriteEntity implements Collided, Collider, SceneBorderTouchingWatcher {

    protected int id;
    protected int health;
    protected double attack;
    protected Coordinate2D location;
    protected String image;

    public Zombie(int health, double attack, Coordinate2D location, String image, int id) {
        super(image, location, new Size(125,125));
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

    public double getAttack() {
        return attack;
    }

    public void setHealth(int health) {
        this.health = health;
    }


    @Override
    public void notifyBoundaryTouching(SceneBorder sceneBorder) {
        if (sceneBorder == SceneBorder.LEFT) {
            remove();
        }
    }

}
