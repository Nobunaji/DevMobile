package elements;

import com.badlogic.gdx.math.Polygon;

public class DonkeyKong extends GameElements {
	float _speed;
	float _delta;

	public DonkeyKong(){
		//TODO Auto-generated constructor stub
	}

	public DonkeyKong(String nom, float x, float y, float w, float h,float s, float d) {
		_name = nom;
		_x = x;
		_y = y;
		_h = h;
		_w = w;
		_hitbox = new Polygon(new float[] {_x, _y,
				_x, _y + _h,
				_x + _w, _y + _h,
				_x + _w, _y});
		_speed = s;
		_delta = d;
	}

	@Override
	public void Deplacement(String direction) {
		if(direction == "right"){
			_x += _speed;
			_hitbox.translate(_speed,0);
		}
		if(direction == "left"){
			_x -= _speed;
			_hitbox.translate(-_speed,0);
		}
	}
	public float getDelta() {
		return _delta;
	}

}