package com.pkelly.gameobjects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

/**
 * Created with IntelliJ IDEA.
 * User: paulkelly
 * Date: 23/06/13
 */
public class GameObject extends Image
{
    protected Vector2 velocity;

    public GameObject()
    {
        super();
        velocity = new Vector2();
    }

    public GameObject(Texture texture)
    {
        super(texture);
        velocity = new Vector2();
    }

    protected void update()
    {
        setX(getX() + velocity.x);
        setY(getY() + velocity.y);
    }

    public Vector2 getVelocity()
    {
        return velocity;
    }

    public void setVelocity(Vector2 velocity)
    {
        this.velocity = velocity;
    }

    public Rectangle getBoundingRectangle()
    {
        return new Rectangle(getX(), getY(), getWidth(), getHeight());
    }

}
