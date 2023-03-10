package game;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import game.MyGdxGame;

public class Desktop {
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setForegroundFPS(60);
		config.setWindowedMode(1500, 1000);
		config.setTitle("Donkey Kong 一 二 三");
		new Lwjgl3Application(new MyGdxGame(), config);
	}
}
