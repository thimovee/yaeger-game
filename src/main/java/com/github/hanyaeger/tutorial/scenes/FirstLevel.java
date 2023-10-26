package com.github.hanyaeger.tutorial.scenes;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.tutorial.MainGame;
import com.github.hanyaeger.tutorial.entities.map.GrassTile;
import com.github.hanyaeger.tutorial.entities.map.PlantCard;
import com.github.hanyaeger.tutorial.entities.plants.*;
import com.github.hanyaeger.tutorial.entities.spawners.PeaSpawner;
import com.github.hanyaeger.tutorial.entities.spawners.SunSpawner;
import com.github.hanyaeger.tutorial.entities.sun.SunValue;
import com.github.hanyaeger.tutorial.entities.sun.SunValueDisplay;
import com.github.hanyaeger.tutorial.entities.zombies.Zombie;
import com.github.hanyaeger.tutorial.entities.spawners.ZombieSpawner;
import com.github.hanyaeger.tutorial.ui.buttons.MenuButton;

import java.util.*;

public class FirstLevel extends DynamicScene implements EntitySpawnerContainer {
    private MainGame plantworld;
    private SunValueDisplay sunValueDisplay = new SunValueDisplay(new Coordinate2D(43, 78));;
    private SunValue sunValue = new SunValue();
    private List<Plant> plants = new ArrayList<>();
    private List<Zombie> zombies = new ArrayList<>();
    private ZombieSpawner zombieSpawner;

    private Timer timer;

    public FirstLevel(MainGame plantworld){
        this.plantworld = plantworld;
    }
    @Override
    public void setupScene(){
        setBackgroundAudio("audio/levelMusic.mp3");
        setBackgroundImage("backgrounds/gameLevel.png");
        setBackgroundAudioVolume(0.5);
    }


public void setScene(int sceneId){
        plantworld.setActiveScene(sceneId);
}

    public void addPlant(Coordinate2D location, int selectedPlantId) {
        switch (selectedPlantId) {
            case 0:
                Peashooter peashooter = new Peashooter(location);
                if(sunValue.getValue() < peashooter.getCost()){
                    break;
                } else {
                    addEntity(peashooter);
                    plants.add(peashooter);
                    addEntitySpawner(new PeaSpawner(peashooter, 1000));
                    sunValue.decrease(peashooter.getCost());
                    sunValueDisplay.setSunText(sunValue.getValue());
                    break;
                }
            case 1:
                Sunflower sunflower = new Sunflower(location, sunValueDisplay);
                if(sunValue.getValue() < sunflower.getCost()){
                    break;
                } else {
                    addEntity(sunflower);
                    plants.add(sunflower);
                    addEntitySpawner(new SunSpawner(location, sunValue, sunValueDisplay));
                    sunValue.decrease(sunflower.getCost());
                    sunValueDisplay.setSunText(sunValue.getValue());
                    break;
                }
            case 2:
                Mine mine = new Mine(location);
                if(sunValue.getValue() < mine.getCost()){
                    break;
                } else {
                    addEntity(mine);
                    plants.add(mine);
                    sunValue.decrease(mine.getCost());
                    sunValueDisplay.setSunText(sunValue.getValue());
                    break;
                }
            case 3:
                Walnut walnut = new Walnut(location);
                if(sunValue.getValue() < walnut.getCost()){
                    break;
                } else {
                    addEntity(walnut);
                    plants.add(walnut);
                    sunValue.decrease(walnut.getCost());
                    sunValueDisplay.setSunText(sunValue.getValue());
                    break;
                }
            case 4:
                Repeater repeater = new Repeater(location, new Size(100, 100));
                if(sunValue.getValue() < repeater.getCost()){
                    break;
                } else {
                    addEntity(repeater);
                    plants.add(repeater);
                    addEntitySpawner(new PeaSpawner(repeater, 500));
                    sunValue.decrease(repeater.getCost());
                    sunValueDisplay.setSunText(sunValue.getValue());
                    break;
                }
            default:
                break;
        }
    }
    @Override
    public void setupEntities(){
        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 9; col++) {
                double x = 410 + 105 * col;
                double y = 100 + 120 * row;
                addEntity(new GrassTile(new Coordinate2D(x, y), false, this));
            }
        }

        for (int cards = 0; cards < 5; cards++) {
            double x = 113 + 75 * cards;
            double y = 10;
            addEntity(new PlantCard(new Coordinate2D(x, y), cards));
        }


        addEntity(new MenuButton(new Coordinate2D(getWidth() - 115, 5), plantworld));
        addEntity(sunValueDisplay);


        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                performZombieActions();
            }
        }, 0, 1000);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                performPlantActions();
            }
        }, 0, 1000);



    }


    public void performPlantActions() {
        Iterator<Plant> iterator = plants.iterator();
        while (iterator.hasNext()) {
            Plant plant = iterator.next();
            plant.action();

            if (plant.getHealth() <= 0) {
                iterator.remove();
            }
        }
    }
    public void performZombieActions() {
        Iterator<Zombie> iterator = zombies.iterator();
        while (iterator.hasNext()) {
            Zombie zombie = iterator.next();
            zombie.action();

            if (zombie.getHealth() <= 0) {
                iterator.remove();
            }
        }
    }



    @Override
    public void setupEntitySpawners() {
        zombieSpawner = new ZombieSpawner(new Coordinate2D(getWidth(), getHeight()), zombies);
        addEntitySpawner(new SunSpawner(new Coordinate2D(getWidth(), getHeight()), sunValue, sunValueDisplay));
        addEntitySpawner(zombieSpawner);

    }
}