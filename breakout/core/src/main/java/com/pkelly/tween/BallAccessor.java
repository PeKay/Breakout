package com.pkelly.tween;

import aurelienribon.tweenengine.TweenAccessor;
import com.pkelly.gameobjects.Ball;

/**
 * Created with IntelliJ IDEA.
 * User: paulkelly
 * Date: 24/06/13
 */
public class BallAccessor implements TweenAccessor<Ball>
{

    public static final int SQUASH = 0;

    @Override
    public int getValues(Ball ball, int tweenType, float[] returnValues)
    {
        switch(tweenType)
        {
            case SQUASH:
                returnValues[0] = ball.getScaleX();
                returnValues[1] = ball.getScaleY();
                return 1;
            default:
                assert false;
                return -1;
        }
    }

    @Override
    public void setValues(Ball ball, int tweenType, float[] returnValues)
    {
        switch(tweenType)
        {
            case SQUASH:
                ball.setScale(returnValues[0], returnValues[1]);
                break;
            default:
                assert false;
        }
    }
}
