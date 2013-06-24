package com.pkelly.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.pkelly.collections.BrickCollection;
import com.pkelly.gameobjects.Ball;
import com.pkelly.gameobjects.Brick;
import com.pkelly.gameobjects.Paddle;

/**
 * Created with IntelliJ IDEA.
 * User: paulkelly
 * Date: 22/06/13
 */
public class Play implements Screen
{
    private final int NUM_ROWS = 8;
    private final int NUM_COLS = 9;

    private SpriteBatch spriteBatch;

    private BrickCollection bricks;

    private Paddle paddle;
    private Texture paddleTexture;

    private Ball ball;

    @Override
    public void render(float delta)
    {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        //Collision Detection
        Rectangle collisionRectangle = new Rectangle(ball.getX() + ball.getVelocity().x, ball.getY() +
                ball.getVelocity().y, ball.getHeight(), ball.getWidth());

        if (collisionRectangle.overlaps(paddle.getBoundingRectangle()))
        {
            ball.collide(paddle);
            paddle.collide(ball);
        } else
        {
            ball.stopColliding();
        }

        for (Brick brick : bricks.getBricks())
        {
            if (brick.getBoundingRectangle().overlaps(collisionRectangle))
            {
                bricks.collide(brick, ball);
                ball.collide(brick);
                break;
            }
        }

        //End Collision Detection

        spriteBatch.begin();

        paddle.draw(spriteBatch);

        bricks.draw(spriteBatch);
        ball.draw(spriteBatch);
        spriteBatch.end();
    }

    @Override
    public void resize(int i, int i2)
    {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void show()
    {
        spriteBatch = new SpriteBatch();

        ball = new Ball();

        paddle = new Paddle();

        bricks = new BrickCollection(NUM_ROWS, NUM_COLS);
    }

    @Override
    public void hide()
    {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void pause()
    {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void resume()
    {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void dispose()
    {
        spriteBatch.dispose();
        paddle.dispose();
        ball.dispose();
        bricks.dispose();

    }
}
