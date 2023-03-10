package game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.FPSLogger;
import vue.GameScreen;

public class MyGdxGame extends Game {

	FPSLogger _fpsLogger;
	
	@Override
	public void create () {
		_fpsLogger = new FPSLogger();
		setScreen (new GameScreen());
	}

	@Override
	public void render () {
		super.render();
		_fpsLogger.log();
	}
	
	@Override
	public void dispose () {}
}
