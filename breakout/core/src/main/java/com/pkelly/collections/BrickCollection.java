package com.pkelly.collections;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.pkelly.gameobjects.Ball;
import com.pkelly.gameobjects.Brick;
import com.pkelly.gameobjects.GameObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: paulkelly
 * Date: 23/06/13
 */
public class BrickCollection extends GameObject
{
    List<Brick> bricks;
    Texture brickTexture;

    private final int PADDING = 48;
    private final int BOTTOM_SPACING = 180;

    public BrickCollection(int numRows, int numColumns)
    {
        bricks = new ArrayList<Brick>();

        int width = Gdx.graphics.getWidth() - (PADDING * 2);
        int height = Gdx.graphics.getHeight() - ((PADDING * 2) + BOTTOM_SPACING);

        brickTexture = new Texture("img/brick.png");

        Brick brick;

        for (int i = 0; i < numColumns; i++)
        {
            for (int j = 0; j < numRows; j++)
            {
                brick = new Brick(brickTexture);
                brick.setX(PADDING + ((width / (numColumns - 1)) * i) - (brick.getWidth() / 2));
                brick.setY(Gdx.graphics.getHeight() - (PADDING + (height / (numRows - 1)) * j - brick.getHeight() / 2));

                addBrick(brick);
            }
        }
    }

    @Override
    public void draw(SpriteBatch spriteBatch)
    {
        for (Brick brick : bricks)
        {
            brick.draw(spriteBatch);
        }

    }

    public List<Brick> getBricks()
    {
        return bricks;
    }

    public void collide(Brick brick, Ball ball)
    {
        removeBrick(brick);
    }

    public void addBrick(Brick brick)
    {
        bricks.add(brick);
    }

    public void removeBrick(Brick brick)
    {
        bricks.remove(brick);
    }

    public void dispose()
    {
        for (Brick brick : bricks)
        {
            brick.getTexture().dispose();
        }
    }

}
