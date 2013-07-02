package com.pkelly.juice;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * Created with IntelliJ IDEA.
 * User: paulkelly
 * Date: 26/06/13
 */
public class BreakoutSetup
{

    public static Injector getInjector()
    {
        Injector injector = Guice.createInjector(new BreakoutModule());
        return injector;
    }
}
