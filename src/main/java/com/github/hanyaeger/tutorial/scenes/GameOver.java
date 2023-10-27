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

public class GameOver extends StaticScene {

    private MainGame mainGame;

    public GameOver(MainGame mainGame){
        this.mainGame = mainGame;
    }
    @Override
    public void setupScene(){
        setBackgroundAudio("audio/gameOver.mp3");
    }

    @Override
    public void setupEntities(){
        var mainGameText = new TextEntity(
                new Coordinate2D(getWidth() / 2, getHeight() / 2),
                "Game Over"
        );
        mainGameText.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        mainGameText.setFill(Color.RED);
        mainGameText.setFont(Font.font("Roboto", FontWeight.SEMI_BOLD, 80));
        addEntity(mainGameText);
        addEntity(new QuitButton(new Coordinate2D(getWidth() / 2, getHeight() / 2 + 200), mainGame));
    }

}
