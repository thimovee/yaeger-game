package com.github.hanyaeger.tutorial.entities.plants;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.tutorial.entities.zombies.Zombie;

public class Pea extends DynamicSpriteEntity implements Collided, Collider, SceneBorderTouchingWatcher {
    private static final double SPEED = 2.0;
    private static final int DAMAGE = 5;

    public Pea(Coordinate2D initialLocation) {
        super("sprites/Peabullet.png", initialLocation, new Size(20, 20));
        setMotion(SPEED, 90d);
    }

    @Override
    public void onCollision(Collider collider) {
        if(collider instanceof Zombie){
            ((Zombie) collider).setHealth(((Zombie) collider).getHealth() - DAMAGE);
            remove();
        }
    }


    @Override
    public void notifyBoundaryTouching(SceneBorder sceneBorder) {
        if (sceneBorder == SceneBorder.RIGHT) {
            remove();
        }
    }
}
