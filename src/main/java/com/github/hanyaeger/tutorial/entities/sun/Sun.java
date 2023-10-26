package com.github.hanyaeger.tutorial.entities.sun;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;
import com.github.hanyaeger.api.userinput.MouseEnterListener;


public class Sun extends SpriteEntity implements MouseEnterListener {
    private SunValue sunValue;
    private SunValueDisplay sunValueDisplay;
    public Sun(Coordinate2D initialLocation, SunValue sunValue,  SunValueDisplay sunValueDisplay) {
        super("sprites/Sun_PvZ2.png", initialLocation, new Size(70,70));
        this.sunValueDisplay = sunValueDisplay;
        this.sunValue = sunValue;
    }

    @Override
    public void onMouseEntered() {
        sunValue.increase();
        sunValueDisplay.setSunText(sunValue.getValue());
        remove();
    }
}
