package vue;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public final class TextureFactory {
	private static TextureFactory instance = null;

	private TextureFactory() {
	}

	public static TextureFactory getInstance() {
		if (instance == null) {
			instance = new TextureFactory();
		}
		return instance;
	}

	public Texture getTexture(String name) {
		return new Texture(Gdx.files.internal(String.format("%s.png",name)));
	}

}
