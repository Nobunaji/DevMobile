package elements;

import com.badlogic.gdx.math.Polygon;

public class Mario extends GameElements {
	String _orientation;
	float _speed;
	boolean _canMove = true;
	boolean _canClimb = true;

	public Mario(String nom, float x, float y, float w, float h, String o) {
		_x = x;
		_y = y;
		_h = h;
		_w = w;
		_hitbox = new Polygon(new float[] {_x, _y,
				_x, _y + _h,
				_x + _w, _y + _h,
				_x + _w, _y});
		_orientation = o;
		_name = nom + "Idle" + o.trim();
	}

	@Override
	public void init(){
		this._hitbox = new Polygon(new float[] {
				_x, _y,
				_x, _y + _h,
				_x + _w, _y + _h,
				_x + _w, _y});
		String[] temp = getClass().getName().split("\\.");
		_name = temp[1] + "IdleRight";
	}

	public Mario() {}

	public void Deplacement(String direction) {
		if(_canMove) {
			if(direction == "right") {
				_x += _speed;
				_orientation = "Right";
				_hitbox.translate(_speed, 0);
			}
			else if(direction == "left") {
				_x -= _speed;
				_orientation = "Left";
				_hitbox.translate(-_speed, 0);
			}
		}
		_name = "MarioIdle" + _orientation.trim();
	}

	public void Climb(String direction) {
		if(_canClimb) {
			if(direction == "up") {
				_y += _speed;
				_hitbox.translate(0, _speed);
			}
			else if(direction == "down") {
				_y -= _speed;
				_hitbox.translate(0, - _speed);
			}
		}
	}

	public void setMovable(boolean b) {
		this._canMove = b;
	}

	public void setClimbable(boolean b) {
		this._canClimb = b;
	}
}