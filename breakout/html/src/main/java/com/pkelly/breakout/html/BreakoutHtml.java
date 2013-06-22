package com.pkelly.breakout.html;

import com.pkelly.breakout.core.Breakout;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.gwt.GwtApplication;
import com.badlogic.gdx.backends.gwt.GwtApplicationConfiguration;

public class BreakoutHtml extends GwtApplication {
	@Override
	public ApplicationListener getApplicationListener () {
		return new Breakout();
	}
	
	@Override
	public GwtApplicationConfiguration getConfig () {
		return new GwtApplicationConfiguration(480, 320);
	}
}
