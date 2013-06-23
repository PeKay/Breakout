package com.pkelly.gameobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

/**
 * Created with IntelliJ IDEA.
 * User: PeKay
 * Date: 23/06/13
 * Time: 00:43
 * To change this template use File | Settings | File Templates.
 */
public class Paddle extends Sprite
{
    int targetX;

   public Vector2 velocity = new Vector2(0, 0);

    private static Texture paddleTexture = new Texture("assets/img/brick.png");

    public Paddle()
    {
        super(paddleTexture);

        setScale(4, 1);
        setY(30);

        velocity.limit(10);

    }

    @Override
    public void draw(SpriteBatch spriteBatch)
    {
        calculateVelocity();

        updatePosition();

        super.draw(spriteBatch);
    }

    private void calculateVelocity()
    {
        targetX = Gdx.input.getX();

        velocity.x = targetX - getX();
    }


    public void updatePosition()
    {
        setX(getX() + velocity.x);

        if (getX() < 0)
        {
            setX(0);
            velocity.scl(0);
        } else if (getX() > Gdx.graphics.getWidth())
        {
            setX(Gdx.graphics.getWidth());
            velocity.scl(0);
        }
    }

}
