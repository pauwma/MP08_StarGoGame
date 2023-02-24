

package com.mygdx.game;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;

import java.util.Random;

public class Pipe extends Actor {
    Rectangle bounds;
    boolean upsideDown;
    AssetManager manager;
    boolean scoreAdded;
    String asteroidImage;
    private float rotation;

    Pipe(String image){
        setSize(64, 64);
        bounds = new Rectangle();
        setVisible(false);
        scoreAdded=false;
        asteroidImage = image;
    }

    @Override
    public void act(float delta) {
        moveBy(-200 * delta, 0);
        bounds.set(getX(), getY(), getWidth(), getHeight());
        if(!isVisible())
            setVisible(true);
        if (getX() < -64)
            remove();
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);

        // Seleccionar el nombre de archivo correspondiente al número generado
        batch.draw( manager.get(asteroidImage, Texture.class), getX(), getY() );
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public boolean isUpsideDown() {
        return upsideDown;
    }

    public void setUpsideDown(boolean upsideDown) {
        this.upsideDown = upsideDown;
    }

    public void setManager(AssetManager manager) {
        this.manager = manager;
    }
}