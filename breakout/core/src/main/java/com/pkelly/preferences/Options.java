package com.pkelly.preferences;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.google.inject.Singleton;

/**
 * Created with IntelliJ IDEA.
 * User: paulkelly
 * Date: 26/06/13
 */

@Singleton
public class Options
{
    Preferences prefs;

    private final String TAG = Options.class.getName();

    private final int DEFAULT_RESOLUTION_WIDTH = 800;
    private final int getDEFAULT_RESOLUTION_HEIGHT = 600;
    private final int DEFAULT_SOUND_EFFECT_VOLUME = 100;
    private final int DEFAULT_MUSIC_VOLUME = 100;

    private int resolutionWidth = DEFAULT_RESOLUTION_WIDTH;
    private int resolutionHeight = getDEFAULT_RESOLUTION_HEIGHT;
    private int soundEffectVolume = DEFAULT_SOUND_EFFECT_VOLUME;
    private int musicVolume = DEFAULT_MUSIC_VOLUME;

    public int getMusicVolume()
    {
        return musicVolume;
    }

    public void setMusicVolume(int musicVolume)
    {
        this.musicVolume = musicVolume;
    }

    public int getResolutionWidth()
    {
        return resolutionWidth;
    }

    public void setResolutionWidth(int resolutionWidth)
    {
        this.resolutionWidth = resolutionWidth;
    }

    public int getResolutionHeight()
    {
        return resolutionHeight;
    }

    public void setResolutionHeight(int resolutionHeight)
    {
        this.resolutionHeight = resolutionHeight;
    }

    public int getSoundEffectVolume()
    {
        return soundEffectVolume;
    }

    public void setSoundEffectVolume(int soundEffectVolume)
    {
        this.soundEffectVolume = soundEffectVolume;
    }

    public void load()
    {
        prefs = Gdx.app.getPreferences("Options");
        Gdx.app.debug(TAG, "Loading options.");
        if (prefs.contains("resolutionWidth"))
        {
            resolutionWidth = prefs.getInteger("resolutionWidth");
            Gdx.app.debug(TAG, "resolutionWidth set to : " + resolutionWidth);
        }
        if (prefs.contains("resolutionHeight"))
        {
            resolutionHeight = prefs.getInteger("resolutionHeight");
            Gdx.app.debug(TAG, "resolutionHeight set to : " + resolutionHeight);
        }
        if (prefs.contains("soundEffectVolume"))
        {
            soundEffectVolume = prefs.getInteger("soundEffectVolume");
            Gdx.app.debug(TAG, "soundEffectVolume set to : " + soundEffectVolume);
        }
        if (prefs.contains("musicVolume"))
        {
            musicVolume = prefs.getInteger("musicVolume");
            Gdx.app.debug(TAG, "musicVolume set to : " + musicVolume);
        }
    }

    public void save()
    {
        prefs.putInteger("resolutionWidth", resolutionWidth);
        prefs.putInteger("resolutionHeight", resolutionHeight);
        prefs.putInteger("soundEffectVolume", soundEffectVolume);
        prefs.putInteger("musicVolume", musicVolume);
        prefs.flush();
        Gdx.app.log(TAG, "Options saved.");
    }

    public void loadDefaults()
    {
        Gdx.app.debug(TAG, "Loading default options.");
        resolutionWidth = DEFAULT_RESOLUTION_WIDTH;
        resolutionHeight = getDEFAULT_RESOLUTION_HEIGHT;
        soundEffectVolume = DEFAULT_SOUND_EFFECT_VOLUME;
        musicVolume = DEFAULT_MUSIC_VOLUME;
    }
}
