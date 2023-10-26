package com.github.hanyaeger.tutorial.entities.sun;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class SunValueDisplay extends TextEntity {

    public SunValueDisplay(Coordinate2D initialLocation) {
        super(initialLocation, "100");
        setFont(Font.font("Roboto", 20));
        setFill(Color.BLACK);
    }

    public void setSunText(int sun){
        setText(Integer.toString(sun));
    }

    public String getSunText(){
        return getText();
    }
}
