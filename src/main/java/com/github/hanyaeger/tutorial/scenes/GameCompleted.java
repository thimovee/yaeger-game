package com.github.hanyaeger.tutorial.scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.StaticScene;
import com.github.hanyaeger.tutorial.MainGame;
import com.github.hanyaeger.tutorial.ui.buttons.QuitButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class GameCompleted extends StaticScene {

    private MainGame plantworld;

    public GameCompleted(MainGame plantworld){
        this.plantworld = plantworld;
    }
    @Override
    public void setupScene(){
        setBackgroundAudio("audio/levelCompleted.mp3");
    }

    @Override
    public void setupEntities(){
        var plantworldText = new TextEntity(
                new Coordinate2D(getWidth() / 2, getHeight() / 2),
                "You successfully beat this level!"
        );
        plantworldText.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        plantworldText.setFill(Color.RED);
        plantworldText.setFont(Font.font("Roboto", FontWeight.SEMI_BOLD, 80));
        addEntity(plantworldText);
        addEntity(new QuitButton(new Coordinate2D(getWidth() / 2, getHeight() / 2 + 200),plantworld));
    }

}
