package com.github.hanyaeger.tutorial.ui.buttons;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.RectangleEntity;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.api.userinput.MouseEnterListener;
import com.github.hanyaeger.api.userinput.MouseExitListener;
import com.github.hanyaeger.tutorial.MainGame;
import javafx.scene.Cursor;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class LevelButton extends RectangleEntity implements MouseButtonPressedListener, MouseEnterListener, MouseExitListener {
    private MainGame mainGame;


    public LevelButton(Coordinate2D initialLocation, MainGame mainGame){
        super(initialLocation);
        setFill(Color.BLACK);
        setWidth(300);
        setHeight(295);
        setOpacity(0);
        this.mainGame = mainGame;
    }

    @Override
    public void onMouseEntered(){
        setCursor(Cursor.HAND);
    }

    @Override
    public void onMouseExited(){
        setCursor(Cursor.DEFAULT);
    }


    @Override
    public void onMouseButtonPressed(MouseButton button, Coordinate2D coordinate2D){
        // hard coded omdat er maar een level is
        mainGame.setActiveScene(1);
    }



}
