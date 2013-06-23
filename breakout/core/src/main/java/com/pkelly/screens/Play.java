package com.pkelly.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.pkelly.gameobjects.Ball;
import com.pkelly.gameobjects.Paddle;

/**
 * Created with IntelliJ IDEA.
 * User: PeKay
 * Date: 22/06/13
 * Time: 20:24
 * To change this template use File | Settings | File Templates.
 */
public class Play implements Screen
{
    private final int NUM_ROWS = 8;
    private final int NUM_COLS = 9;

    private SpriteBatch spriteBatch;
    private Sprite[][] bricks = new Sprite[NUM_COLS][NUM_ROWS];
    private Texture brickTexture;

    private Paddle paddle;
    private Texture paddleTexture;

    private Ball ball;


    @Override
    public void render(float v)
    {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        spriteBatch.begin();

        paddle.draw(spriteBatch);

        if (paddle.getBoundingRectangle().overlaps(ball.getBoundingRectangle()))
        {
            ball.paddleBounce(paddle.velocity);
        }

        for (Sprite[] brickCols : bricks)
        {
            for (Sprite brick : brickCols)
            {
                if (brick.getColor().a > 0)
                {

                    brick.draw(spriteBatch);

                    if (brick.getBoundingRectangle().overlaps(ball.getBoundingRectangle()))
                    {
                        brick.setColor(0, 0, 0, 0);
                        ball.brickBounce();
                    }
                }
            }
        }
        ball.draw(spriteBatch, v);
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

        createBricks();
    }

    private void createBricks()
    {
        int padding = 48;
        int bottomSpacing = 180;
        int width = Gdx.graphics.getWidth() - (padding * 2);
        int height = Gdx.graphics.getHeight() - ((padding * 2) + bottomSpacing);

        brickTexture = new Texture("assets/img/brick.png");

        for (int i = 0; i < NUM_COLS; i++)
        {
            for (int j = 0; j < NUM_ROWS; j++)
            {
                bricks[i][j] = new Sprite(brickTexture);
                bricks[i][j].setScale(3, 2);
                bricks[i][j].setX(padding + ((width / (NUM_COLS - 1)) * i) - (bricks[i][j].getWidth() / 2));
                bricks[i][j].setY(Gdx.graphics.getHeight() - (padding + (height / (NUM_ROWS - 1)) * j - bricks[i][j].getHeight() / 2));
            }
        }
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
        paddle.getTexture().dispose();
        for (Sprite[] brickCols : bricks)
        {
            for (Sprite brick : brickCols)
            {
                brick.getTexture().dispose();
            }
        }

    }
}
