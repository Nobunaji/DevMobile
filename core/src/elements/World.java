package elements;

import com.badlogic.gdx.utils.Array;

public class World {
	Array<GameElements> _world = new Array<GameElements>();

	public World() {}

	public Array<GameElements> getList(){

		return _world;
	}
}
