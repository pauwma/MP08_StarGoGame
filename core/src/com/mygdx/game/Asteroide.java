package com.mygdx.game;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;

import java.util.Random;

public class Asteroide extends Actor {
    Rectangle bounds;
    AssetManager manager;
    boolean scoreAdded;

    Asteroide(){
        setSize(64, 64);
        bounds = new Rectangle();
        setVisible(false);
        scoreAdded=false;
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
        // Crear un objeto Random
        Random random = new Random();

        // Generar un número aleatorio entre 1 y 6 (ambos incluidos)
        int asteroidNumber = random.nextInt(6) + 1;

        // Seleccionar el nombre de archivo correspondiente al número generado
        String asteroidFilename = "asteroide_" + asteroidNumber + ".png";

        // Cargar la imagen correspondiente usando el TextureManager
        Texture asteroidTexture = manager.get(asteroidFilename, Texture.class);
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public void setManager(AssetManager manager) {
        this.manager = manager;
    }
}
