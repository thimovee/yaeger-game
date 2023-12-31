package com.github.hanyaeger.tutorial.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.StaticScene;
import com.github.hanyaeger.tutorial.ui.buttons.LevelButton;
import com.github.hanyaeger.tutorial.MainGame;
import com.github.hanyaeger.tutorial.ui.buttons.QuitButton;

public class GameLevels extends StaticScene {

    private MainGame mainGame;

    public GameLevels(MainGame mainGame){
        this.mainGame = mainGame;
    }
    @Override
    public void setupScene(){
        setBackgroundAudio("audio/themeSong.mp3");
        setBackgroundImage("backgrounds/levelSelect.png");
        setBackgroundAudioVolume(0.5);
    }

    @Override
    public void setupEntities(){
        addEntity(new QuitButton(new Coordinate2D(getWidth() - 130, 5), mainGame));
        addEntity(new LevelButton(new Coordinate2D(25, 70), mainGame));
    }

}