package com.github.hanyaeger.tutorial.entities.spawners;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.EntitySpawner;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.core.entities.motion.MotionApplier;
import com.github.hanyaeger.tutorial.entities.zombies.Zombie;
import com.github.hanyaeger.tutorial.entities.zombies.ZombieType;
import javafx.scene.Node;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public class ZombieSpawner extends EntitySpawner implements SceneBorderTouchingWatcher {

    private final double sceneWidth;
    private final double sceneHeight;

    private List<Zombie> zombies;


    private final ZombieType[] zombieTypes = {
            ZombieType.ALLSTAR,
            ZombieType.BUCKETHEAD,
            ZombieType.CONEHEAD,
            ZombieType.BALLOON,
            ZombieType.FLAG
    };

    public ZombieSpawner(Coordinate2D coordinate2D, List<Zombie> zombies) {
        super(90);
        this.sceneWidth = coordinate2D.getX();
        this.sceneHeight = coordinate2D.getY();
        this.zombies = zombies;
    }

    @Override
    protected void spawnEntities() {
        ZombieType randomZombieType = getRandomZombieType();
        Zombie zombie = randomZombieType.createZombie(randomLocation());
        spawn(zombie);
        zombies.add(zombie);
    }

    private Coordinate2D randomLocation() {
        int randomRow = new Random().nextInt(5);
        int randomCol = 8;
        double x = 410 + 105 * randomCol;
        double y = (randomRow == 4) ? (100 + 120 * randomRow - 50) : (100 + 120 * randomRow + 60);
        return new Coordinate2D(x, y);
    }





    private ZombieType getRandomZombieType() {
        return zombieTypes[new Random().nextInt(zombieTypes.length)];
    }

    @Override
    public void notifyBoundaryTouching(SceneBorder sceneBorder) {
        if (sceneBorder == SceneBorder.RIGHT) {
            remove();
        }
    }

    @Override
    public void setMotionApplier(MotionApplier motionApplier) {

    }

    @Override
    public MotionApplier getMotionApplier() {
        return null;
    }

    @Override
    public void setAnchorLocationX(double v) {

    }

    @Override
    public void setAnchorLocationY(double v) {

    }

    @Override
    public void setAnchorLocation(Coordinate2D coordinate2D) {

    }

    @Override
    public Coordinate2D getAnchorLocation() {
        return null;
    }

    @Override
    public void transferCoordinatesToNode() {

    }

    @Override
    public void setAnchorPoint(AnchorPoint anchorPoint) {}

    @Override
    public AnchorPoint getAnchorPoint() {
        return null;
    }

    @Override
    public Optional<? extends Node> getNode() {
        return Optional.empty();
    }

    public void setZombies(List<Zombie> zombies) {
        this.zombies = zombies;
    }

    public void getZombies(List<Zombie> zombies) {
        this.zombies = zombies;
    }
}
