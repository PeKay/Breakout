package com.pkelly.tween;

import aurelienribon.tweenengine.TweenAccessor;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * Created with IntelliJ IDEA.
 * User: paulkelly
 * Date: 22/06/13
 */
public class ActorAccessor implements TweenAccessor<Actor>
{

    public static final int ALPHA = 0;

    @Override
    public int getValues(Actor actor, int tweenType, float[] returnValues)
    {
        switch(tweenType)
        {
            case ALPHA:
                returnValues[0] = actor.getColor().a;
                return 1;
            default:
                assert false;
                return -1;
        }
    }

    @Override
    public void setValues(Actor actor, int tweenType, float[] returnValues)
    {
        switch(tweenType)
        {
            case ALPHA:
                actor.setColor(actor.getColor().r, actor.getColor().g, actor.getColor().b, returnValues[0]);
                break;
            default:
                assert false;
        }
    }
}
