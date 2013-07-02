package com.pkelly.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.google.inject.Inject;
import com.pkelly.preferences.Options;

/**
 * Created with IntelliJ IDEA.
 * User: paulkelly
 * Date: 27/06/13
 */
public class OptionsMenu implements Screen
{
    @Inject
    private Options options;

    @Inject
    private MainMenu mainMenu;

    private Stage stage;
    private TextureAtlas buttonTextureAtlas;
    private Skin buttonSkin;
   // private TextureAtlas uiTextureAtlas;
   // private Skin uiSkin;
    private Table table;
    private TextButton backButton;
    private BitmapFont white, black;
    private Label heading;

    @Override
    public void render(float delta)
    {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.act(delta);
        stage.draw();
    }

    @Override
    public void resize(int width, int height)
    {
        stage.setViewport(width, height, true);
        table.invalidateHierarchy();
        table.setSize(width, height);
    }

    @Override
    public void show()
    {
        stage = new Stage();

        Gdx.input.setInputProcessor(stage);

        buttonTextureAtlas = new TextureAtlas("ui/button.pack");
        buttonSkin = new Skin(buttonTextureAtlas);

       // uiTextureAtlas = new TextureAtlas("ui/uiskin32.json");

       // uiSkin = new Skin(uiTextureAtlas);

        table = new Table();
        table.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        white = new BitmapFont(Gdx.files.internal("font/white.fnt"), false);
        black = new BitmapFont(Gdx.files.internal("font/black.fnt"), false);

        Label.LabelStyle labelHeading = new Label.LabelStyle(white, Color.WHITE);
        heading = new Label("Breakout", labelHeading);

        backButton = getTextButton("BACK");
        backButton.addListener(new ClickListener()
        {
            @Override
            public void clicked(InputEvent event, float x, float y)
            {
                ((Game) Gdx.app.getApplicationListener()).setScreen(mainMenu);
            }
        });

        //Slider volume = new Slider(0, 100, 5, false, uiSkin);

       // String[] availResolutions = {"800x600", "1280x720"};
        //SelectBox Resolution = new SelectBox(availResolutions, uiSkin);

        table.add(heading);
        table.getCell(heading).spaceBottom(100);
        table.row();
//        table.add(volume);
//        table.row();
//        table.add(Resolution);
//        table.row();
        table.add(backButton);
        stage.addActor(table);
    }

    @Override
    public void hide()
    {
    }

    @Override
    public void pause()
    {
    }

    @Override
    public void resume()
    {
    }

    @Override
    public void dispose()
    {
        stage.dispose();
        buttonTextureAtlas.dispose();
        buttonSkin.dispose();
        white.dispose();
        black.dispose();
    }

    private TextButton getTextButton(String text)
    {
        TextButton button = new TextButton(text, getTextButtonStyle());
        button.pad(16);
        return button;
    }

    private TextButton.TextButtonStyle getTextButtonStyle()
    {
        TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.up = buttonSkin.getDrawable("button.up");
        textButtonStyle.down = buttonSkin.getDrawable("button.focus.down");
        textButtonStyle.over = buttonSkin.getDrawable("button.focus.up");
        textButtonStyle.pressedOffsetX = 1;
        textButtonStyle.pressedOffsetY = -1;
        textButtonStyle.font = black;
        return textButtonStyle;
    }
}
