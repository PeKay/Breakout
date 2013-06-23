package com.pkelly.tween;

import aurelienribon.tweenengine.TweenAccessor;
import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 * Created with IntelliJ IDEA.
 * User: PeKay
 * Date: 22/06/13
 * Time: 16:03
 * To change this template use File | Settings | File Templates.
 */
public class SpriteAccessor implements TweenAccessor<Sprite>
{

    public static final int ALPHA = 0;

    @Override
    public int getValues(Sprite sprite, int tweenType, float[] returnValues)
    {

        switch(tweenType)
        {
            case ALPHA:
                returnValues[0] = sprite.getColor().a;
                return 1;
            default:
                assert false;
                return -1;
        }

    }

    @Override
    public void setValues(Sprite sprite, int tweenType, float[] returnValues)
    {
       switch(tweenType)
       {
           case ALPHA:
            sprite.setColor(sprite.getColor().r, sprite.getColor().g, sprite.getColor().b, returnValues[0]);
            break;
           default:
               assert false;
       }
    }
}
