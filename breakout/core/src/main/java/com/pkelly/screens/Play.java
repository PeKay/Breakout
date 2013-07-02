package com.pkelly.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.google.inject.Inject;
import com.pkelly.collections.BrickCollection;
import com.pkelly.gameobjects.Ball;
import com.pkelly.gameobjects.Brick;
import com.pkelly.gameobjects.Paddle;
import com.pkelly.preferences.Options;

/**
 * Created with IntelliJ IDEA.
 * User: paulkelly
 * Date: 22/06/13
 */
public class Play implements Screen
{
    @Inject
    private Options options;

    final int TARGET_WIDTH = 640;
    final int TARGET_HEIGHT = 480;

    float SCALE_X = 1;
    float SCALE_Y = 1;
    float ZOOM_FACTOR;

    private final int NUM_ROWS = 8;
    private final int NUM_COLS = 9;

    private Stage stage;

    private BrickCollection bricks;

    private Paddle paddle;
    private Texture paddleTexture;

    private Ball ball;

    private SpriteBatch spriteBatch;

    ShapeRenderer shapeRenderer;

    OrthographicCamera camera;

    @Override
    public void show()
    {
        stage = new Stage();

        camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        System.out.println(Gdx.graphics.getWidth() + " : " + Gdx.graphics.getHeight());

        shapeRenderer = new ShapeRenderer();

        ball = new Ball();

        paddle = new Paddle();

        bricks = new BrickCollection(NUM_ROWS, NUM_COLS);

        stage.addActor(ball);
        stage.addActor(paddle);
        stage.addActor(bricks);
    }

    @Override
    public void render(float delta)
    {
        GL20 gl = Gdx.graphics.getGL20();

        shapeRenderer.setProjectionMatrix(camera.combined);

        Color backgroundColour = Color.valueOf("24282C");
        gl.glClearColor(backgroundColour.r, backgroundColour.g, backgroundColour.b, 1);
        gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


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

        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        Color borderColor = Color.valueOf("68725C");
        shapeRenderer.setColor(borderColor.r, borderColor.g, borderColor.b, 1);
        shapeRenderer.rect(0, 0, Gdx.graphics.getWidth(), 5);
        shapeRenderer.rect(0, 0, 5, Gdx.graphics.getHeight());
        shapeRenderer.rect(0, Gdx.graphics.getHeight() - 5, Gdx.graphics.getWidth(), 5);
        shapeRenderer.rect(Gdx.graphics.getWidth() - 5, 0, 5, Gdx.graphics.getWidth());
        shapeRenderer.end();
    }

    @Override
    public void resize(int width, int height)
    {
        camera.setToOrtho(false);
        SCALE_X = width/TARGET_WIDTH;
        SCALE_Y = height/TARGET_HEIGHT;
        ZOOM_FACTOR = Math.max((int)SCALE_X, (int)SCALE_Y);
        camera.zoom = 1/ZOOM_FACTOR;
        camera.update();
        stage.setViewport(width, height, true);
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
