package com.pkelly.gameobjects;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;

/**
 * Created with IntelliJ IDEA.
 * User: paulkelly
 * Date: 23/06/13
 */
public class Brick extends GameObject
{

    public Brick()
    {
        super();
    }

    public Brick(Texture texture)
    {
        super(texture);

        Color brickColor = Color.valueOf("6B9284");
        setColor(brickColor.r, brickColor.g, brickColor.b, 1);
    }

    public void collide(Ball ball)
    {

    }

}
