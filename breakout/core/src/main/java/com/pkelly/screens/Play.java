package com.pkelly.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Stage;
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

    private Stage stage;

    private BrickCollection bricks;

    private Paddle paddle;
    private Texture paddleTexture;

    private Ball ball;

    private SpriteBatch spriteBatch;

    ShapeRenderer shapeRenderer;

    @Override
    public void render(float delta)
    {
        Color backgroundColour = Color.valueOf("24282C");
        Gdx.gl.glClearColor(backgroundColour.r, backgroundColour.g, backgroundColour.b, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        Color borderColor = Color.valueOf("68725C");
        shapeRenderer.setColor(borderColor.r, borderColor.g, borderColor.b, 1);
        shapeRenderer.rect(0, 0, Gdx.graphics.getWidth(), 5);
        shapeRenderer.rect(0, 0, 5, Gdx.graphics.getHeight());
        shapeRenderer.rect(0, Gdx.graphics.getHeight() - 5, Gdx.graphics.getWidth(), 5);
        shapeRenderer.rect(Gdx.graphics.getWidth() - 5, 0, 5, Gdx.graphics.getWidth());
        shapeRenderer.end();

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

        stage.act(delta);
        stage.draw();
    }

    @Override
    public void resize(int i, int i2)
    {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void show()
    {
        stage = new Stage();

        shapeRenderer = new ShapeRenderer();

        ball = new Ball();

        paddle = new Paddle();

        bricks = new BrickCollection(NUM_ROWS, NUM_COLS);

        stage.addActor(ball);
        stage.addActor(paddle);
        stage.addActor(bricks);
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
        stage.dispose();
    }
}
