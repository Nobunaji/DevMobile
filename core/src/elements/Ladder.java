package elements;

import com.badlogic.gdx.math.Polygon;

public class Ladder extends GameElements {
	private String _type;
	public Ladder(String nom, float x, float y, float w, float h, String type) {
		_name = "Single" + nom + type.trim();
		_x = x;
		_y = y;
		_h = h;
		_w = w;
		_hitbox = new Polygon(new float[] {_x, _y, _x, _y + _h, _x + _w, _y + _h, _x + _w, _y});
	}

	@Override
	public void init(){
		this._hitbox = new Polygon(new float[] {
				_x, _y,
				_x, _y + _h,
				_x + _w, _y + _h,
				_x + _w, _y});
		String[] temp = getClass().getName().split("\\.");
		_name = "Single" + temp[1] + _type;;
	}

	public Ladder() {}

	public void Deplacement(String direction) {
	}

}