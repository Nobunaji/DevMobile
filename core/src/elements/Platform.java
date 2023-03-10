package elements;

import com.badlogic.gdx.math.Polygon;

public class Platform extends GameElements {
	private String _type;

	@Override
	public void init(){
		this._hitbox = new Polygon(new float[] {
				_x, _y,
				_x, _y + _h,
				_x + _w, _y + _h,
				_x + _w, _y});
		String[] temp = getClass().getName().split("\\.");
		_name = temp[1] + _type;
	}

	public Platform() {}

	public void Deplacement(String direction){}
}
