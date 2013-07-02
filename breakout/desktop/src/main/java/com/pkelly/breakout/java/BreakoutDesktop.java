package com.pkelly.breakout.java;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.pkelly.breakout.core.Breakout;
import com.pkelly.juice.BreakoutSetup;

public class BreakoutDesktop {
	public static void main (String[] args) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.useGL20 = true;
        config.resizable = true;
		new LwjglApplication(BreakoutSetup.getInjector().getInstance(Breakout.class), config);
	}
}
