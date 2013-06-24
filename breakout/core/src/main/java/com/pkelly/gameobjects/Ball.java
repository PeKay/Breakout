package com.pkelly.gameobjects;

import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenManager;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.pkelly.tween.BallAccessor;

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

    TweenManager tweenManager;

    public Ball()
    {
        super(ballTexture);

        setPosition(Gdx.graphics.getWidth() / 2, 120);
        velocity = new Vector2(1.2f, -2.6f);

        Color ballColor = Color.valueOf("CAC462");
        setColor(ballColor.r, ballColor.g, ballColor.b, 1);

        tweenManager = new TweenManager();
    }

    @Override
    public void act(float delta)
    {
        super.act(delta);

        addGravity();

        update();

        addResistance();

        tweenManager.update(delta);
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

        int borderWidth = 5;

        if (getX() < borderWidth)
        {
            setX(borderWidth);
            bounceX();
        } else if (getX() > Gdx.graphics.getWidth() - borderWidth)
        {
            setX(Gdx.graphics.getWidth() - borderWidth);
            bounceX();
        }

        if (getY() < borderWidth)
        {
            setY(borderWidth);
            bounceY();
        } else if (getY() > Gdx.graphics.getHeight() - borderWidth)
        {
            setY(Gdx.graphics.getHeight() - borderWidth);
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

        Tween.registerAccessor(Ball.class, new BallAccessor());
        Tween.set(this, BallAccessor.SQUASH).target(1.4f, 0.6f).start(tweenManager);
        Tween.to(this, BallAccessor.SQUASH, 0.3f).target(1, 1).start(tweenManager);
    }

    private void bounceY()
    {
        velocity.y = -velocity.y;

        Tween.registerAccessor(Ball.class, new BallAccessor());
        Tween.set(this, BallAccessor.SQUASH).target(1.6f, 0.4f).start(tweenManager);
        Tween.to(this, BallAccessor.SQUASH, 0.3f).target(1, 1).start(tweenManager);
    }
}
