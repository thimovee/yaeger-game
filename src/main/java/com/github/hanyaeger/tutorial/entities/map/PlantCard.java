package com.github.hanyaeger.tutorial.entities.map;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.RectangleEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.api.userinput.MouseEnterListener;
import com.github.hanyaeger.api.userinput.MouseExitListener;
import javafx.scene.Cursor;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;

public class PlantCard extends RectangleEntity implements MouseButtonPressedListener, MouseEnterListener, MouseExitListener {
    private int plantId;

    public PlantCard(Coordinate2D initialLocation, int plantId) {
        super(initialLocation);
        this.plantId = plantId;
        setOpacity(0);
        setFill(Color.BLACK);
        setWidth(62);
        setHeight(90);
    }

    @Override
    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
        ActivePlant.setActivePlantId(plantId);
        System.out.println(ActivePlant.getActivePlantId());
    }

    @Override
    public void onMouseEntered() {
        setCursor(Cursor.HAND);
    }

    @Override
    public void onMouseExited() {
        setCursor(Cursor.DEFAULT);
    }
}
