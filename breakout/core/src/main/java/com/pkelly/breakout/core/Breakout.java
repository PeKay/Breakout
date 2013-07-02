package com.pkelly.breakout.core;

import com.badlogic.gdx.Game;
import com.google.inject.Inject;
import com.pkelly.preferences.Options;
import com.pkelly.screens.SplashScreen;

public class Breakout extends Game
{
    @Inject
    Options options;

    @Inject
    SplashScreen splashScreen;

	@Override
	public void create ()
    {
        options.load();
        setScreen(splashScreen);
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
