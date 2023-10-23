package com.github.hanyaeger.tutorial;

import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.YaegerGame;
import com.github.hanyaeger.tutorial.scenes.FirstLevel;
import com.github.hanyaeger.tutorial.scenes.GameCompleted;
import com.github.hanyaeger.tutorial.scenes.GameLevels;
import com.github.hanyaeger.tutorial.scenes.GameOver;

public class MainGame extends YaegerGame {

    @Override
    public void setupGame() {
        setGameTitle("Bio Defenders");
        setSize(new Size(1408, 704));
    }

    @Override
    public void setupScenes(){
        addScene(0, new GameLevels(this));
        addScene(1, new FirstLevel(this));
        addScene(2, new GameOver(this));
        addScene(3, new GameCompleted(this));
    }


    public static void main(String[] args){
        launch(args);
    }

}
