package com.pkelly.juice;

import com.google.inject.AbstractModule;
import com.pkelly.preferences.Options;

/**
 * Created with IntelliJ IDEA.
 * User: paulkelly
 * Date: 26/06/13
 */
public class BreakoutModule extends AbstractModule
{

    @Override
    protected void configure()
    {
        bind(Options.class).asEagerSingleton();
    }
}
