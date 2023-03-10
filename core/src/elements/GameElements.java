package elements;

import com.badlogic.gdx.math.Polygon;

public abstract class GameElements {

	float _x, _y, _h, _w;
	String _name;
	Polygon _hitbox;

	public Polygon getHitbox() {
		return _hitbox;
	}

	public void init(){
		this._hitbox = new Polygon(new float[] {
				_x, _y,
				_x, _y + _h,
				_x + _w, _y + _h,
				_x + _w, _y});
		String[] temp = getClass().getName().split("\\.");
		_name = temp[1];
	}

	public void setX ( float x) {
		_x = x;
	}

	public void setY ( float y) {
		_y = y;
	}

	public float getX () {
		return _x;
	}

	public float getY () {
		return _y;
	}

	public float getWidth() {
		return _w;
	}

	public float getHeight() {
		return _h;
	}

	public String getName() {
		return _name;
	}

	public abstract void Deplacement(String direction);
}
