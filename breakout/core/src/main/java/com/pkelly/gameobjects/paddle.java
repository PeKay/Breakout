package com.pkelly.gameobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;

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

        Color paddleColor = Color.valueOf("E7DAB7");
        setColor(paddleColor.r, paddleColor.g, paddleColor.b, 1);
    }

    @Override
    public void act(float delta)
    {
        super.act(delta);
        update();
    }

    @Override
    protected void update()
    {
        setX(Gdx.input.getX() - getWidth() / 2);
    }

    public void collide(Ball ball)
    {

    }
}
