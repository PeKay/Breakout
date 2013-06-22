package com.pkelly.screens;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created with IntelliJ IDEA.
 * User: PeKay
 * Date: 22/06/13
 * Time: 14:53
 * To change this template use File | Settings | File Templates.
 */
public class SplashScreen implements Screen
{
    private SpriteBatch batch;
    private Sprite splash;

    @Override
    public void render(float v)
    {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        splash.draw(batch);
        batch.end();
    }

    @Override
    public void resize(int i, int i2)
    {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void show()
    {
        batch = new SpriteBatch();

        Texture splashImage = new Texture("C:\\Users\\PeKay\\Documents\\GitHub\\Breakout\\breakout\\core\\src\\main\\resources\\assets\\img\\splashTitle.png");
        splash = new Sprite(splashImage);
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
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
