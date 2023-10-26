package com.github.hanyaeger.tutorial.entities.map;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.RectangleEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.api.userinput.MouseEnterListener;
import com.github.hanyaeger.api.userinput.MouseExitListener;
import com.github.hanyaeger.tutorial.entities.sun.SunValue;
import com.github.hanyaeger.tutorial.scenes.FirstLevel;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;

public class GrassTile extends RectangleEntity implements MouseButtonPressedListener, MouseEnterListener, MouseExitListener {

    private boolean isOccupied;
    private Coordinate2D location;
    private FirstLevel level;
    public GrassTile(Coordinate2D initialLocation, boolean isOccupied, FirstLevel level) {
        super(initialLocation);
        setFill(Color.BLACK);
        setWidth(100);
        setHeight(100);
        setOpacity(0);
        this.isOccupied = isOccupied;
        this.location = initialLocation;
        this.level = level;

    }

    @Override
    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
        int activePlantId = ActivePlant.getActivePlantId();
        if(!isOccupied){
            level.addPlant(location, activePlantId);
            isOccupied = true;
        }
    }


    @Override
    public void onMouseEntered() {
        setOpacity(0.1);

    }

    @Override
    public void onMouseExited() {
        setOpacity(0);
    }

    public void setOccupied(boolean isOccupied) {
        this.isOccupied = isOccupied;
    }

}
