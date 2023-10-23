package com.github.hanyaeger.tutorial.ui.buttons;

import com.github.hanyaeger.api.Coordinate2D;
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

public class MenuButton extends TextEntity implements MouseButtonPressedListener, MouseEnterListener, MouseExitListener {
    private MainGame mainGame;


    public MenuButton(Coordinate2D initialLocation, MainGame mainGame){
        super(initialLocation,"MENU");
        setFill(Color.WHITE);
        setFont(Font.font("Roboto", FontWeight.BOLD, 16));
        this.mainGame = mainGame;
    }

    @Override
    public void onMouseEntered(){
        setFill(Color.gray(0.5));
        setCursor(Cursor.HAND);
    }

    @Override
    public void onMouseExited(){
        setFill(Color.WHITE);
        setCursor(Cursor.DEFAULT);
    }


    @Override
    public void onMouseButtonPressed(MouseButton button, Coordinate2D coordinate2D){
        mainGame.setActiveScene(0);
    }



}
