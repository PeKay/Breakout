package com.pkelly.gameobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created with IntelliJ IDEA.
 * User: paulkelly
 * Date: 23/06/13
 */
public class Paddle extends GameObject
{
    private static Texture paddleTexture = new Texture("img/paddle.png");
    private final int FIXED_Y = 30;

    public Paddle()
    {
        super(paddleTexture);

        setY(FIXED_Y);
    }

    @Override
    public void draw(SpriteBatch spriteBatch)
    {
        update();

        super.draw(spriteBatch);
    }

    @Override
    protected void update()
    {
        setX(Gdx.input.getX() - getWidth() / 2);
    }

    public void collide(Ball ball)
    {

    }

    public void dispose()
    {
        getTexture().dispose();
    }
}
