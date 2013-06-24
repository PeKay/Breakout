package com.pkelly.gameobjects;

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
    }

    public void collide(Ball ball)
    {

    }

}
