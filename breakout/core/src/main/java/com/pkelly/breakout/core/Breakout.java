package com.pkelly.breakout.core;

import com.badlogic.gdx.Game;
import com.pkelly.screens.SplashScreen;

public class Breakout extends Game
{

	@Override
	public void create ()
    {
        setScreen(new SplashScreen());
    }

	@Override
	public void resize (int width, int height)
    {
        super.resize(width, height);
	}

	@Override
	public void render ()
    {
        super.render();
	}

	@Override
	public void pause ()
    {
        super.pause();
	}

	@Override
	public void resume ()
    {
        super.resume();
	}

	@Override
	public void dispose ()
    {
        super.dispose();
	}
}
