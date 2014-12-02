package com.mabezdev.space;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.mabezdev.space.Managers.GameStateManager;
import com.mabezdev.space.Managers.MyKeys;

public class Main extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
    FreeTypeFontGenerator font;
    BitmapFont font1;
    OrthographicCamera camera;
    public final static int WIDTH = 900;
    public final static int HEIGHT = 480;
    private float dt;
    private GameStateManager gsm;

	
	@Override
	public void create () {
        camera = new OrthographicCamera();
        camera.viewportWidth = WIDTH;
        camera.viewportHeight = HEIGHT;

        Gdx.app.getGraphics().setTitle("Space Jam");

        gsm = new GameStateManager(camera);

        Gdx.input.setInputProcessor(new MyKeys());
        /*batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
        font = new FreeTypeFontGenerator(Gdx.files.internal("orangejuice2.ttf"));
        font1 = new BitmapFont();
        FreeTypeFontGenerator.FreeTypeFontParameter para = new FreeTypeFontGenerator.FreeTypeFontParameter();
        para.size=72;
        font1 = font.generateFont(para);
        */

	}

	@Override
	public void render () {
        Gdx.gl.glClearColor(0, 0, 0, 1);//THIS FUKCING FIXED IT IM FUKCING MAD
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		dt = Gdx.graphics.getDeltaTime();
        gsm.update(dt);
        gsm.draw();
	}
}
