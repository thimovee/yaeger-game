package com.github.hanyaeger.tutorial.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.tutorial.MainGame;
import com.github.hanyaeger.tutorial.ui.buttons.MenuButton;

public class FirstLevel extends DynamicScene {
    private MainGame plantworld;
    public FirstLevel(MainGame plantworld){
        this.plantworld = plantworld;
    }
    @Override
    public void setupScene(){
        setBackgroundAudio("audio/levelMusic.mp3");
        setBackgroundImage("backgrounds/gameLevel.png");
        setBackgroundAudioVolume(0.5);
    }

    @Override
    public void setupEntities(){
        addEntity(new MenuButton(new Coordinate2D(getWidth() - 115, 5), plantworld));
    }



}