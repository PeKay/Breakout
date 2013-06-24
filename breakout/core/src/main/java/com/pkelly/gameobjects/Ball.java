package com.pkelly.gameobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

/**
 * Created with IntelliJ IDEA.
 * User: paulkelly
 * Date: 23/06/13
 */
public class Ball extends GameObject
{
    private final Vector2 GRAVITY_VECTOR = new Vector2(0, 0);
    private final float TERMINAL_VELOCITY_LENGTH = 16;
    private final float RESISTANCE = 1;

    private static Texture ballTexture = new Texture("img/ball.png");

    boolean isColliding = false;

    public Ball()
    {
        super(ballTexture);

        setPosition(Gdx.graphics.getWidth() / 2, 120);
        velocity = new Vector2(1.2f, -2.6f);
    }

    @Override
    public void draw(SpriteBatch spriteBatch)
    {
        addGravity();

        update();

        addResistance();

        super.draw(spriteBatch);
    }

    private void addGravity()
    {
        velocity.add(GRAVITY_VECTOR);
    }

    private void addResistance()
    {
        velocity.scl(RESISTANCE);

        velocity.limit(TERMINAL_VELOCITY_LENGTH);
    }

    @Override
    protected void update()
    {
        super.update();

        if (getX() < 0)
        {
            setX(0);
            bounceX();
        } else if (getX() > Gdx.graphics.getWidth())
        {
            setX(Gdx.graphics.getWidth());
            bounceX();
        }

        if (getY() < 0)
        {
            setY(0);
            bounceY();
        } else if (getY() > Gdx.graphics.getHeight())
        {
            setY(Gdx.graphics.getHeight());
            bounceY();
        }
    }

    public void collide(Brick brick)
    {
        if (getCentreX() < brick.getX()) bounceX();
        if (getCentreX() > brick.getX() + brick.getWidth()) bounceX();
        if (getCentreY() < brick.getY()) bounceY();
        if (getCentreY() > brick.getY() + brick.getHeight()) bounceY();

    }

    public void collide(Paddle paddle)
    {
        if (!isColliding)
        {
            isColliding = true;
            if (getCentreX() < paddle.getX()) bounceX();
            if (getCentreX() > paddle.getX() + paddle.getWidth()) bounceX();
            bounceY();
        }
    }

    private float getCentreX()
    {
        return getX() + (getWidth() / 2);
    }

    private float getCentreY()
    {
        return getY() + (getHeight() / 2);
    }

    public void stopColliding()
    {
        isColliding = false;
    }

    private void bounceX()
    {
        velocity.x = -velocity.x;
    }

    private void bounceY()
    {
        velocity.y = -velocity.y;
    }

    public void dispose()
    {
        getTexture().dispose();
    }
}
