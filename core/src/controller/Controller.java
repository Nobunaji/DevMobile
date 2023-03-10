package controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Json;
import elements.DonkeyKong;
import elements.GameElements;
import elements.Mario;
import elements.World;
import vue.TextureFactory;

public class Controller {
    private static TextureFactory _texture;
    private final ShapeRenderer _shapeRenderer;

    private final World _world;
    private Sprite _DKSprite;
    private Sprite _MarioSprite;
    private Sprite sprite;

    private Array<Sprite> SpriteList = new Array<>();
    private Mario _player;
    private DonkeyKong _dk;
    private float fulldelta;

    double rdm;

    SpriteBatch _batch = new SpriteBatch();
    public Controller() {
        _texture = TextureFactory.getInstance();
        _shapeRenderer = new ShapeRenderer();
        Json json = new Json();
        _world = json.fromJson(World.class, Gdx.files.internal("config.json"));


        for(GameElements v : _world.getList()) {
            v.init();
            if(v.getClass().getName().equals("elements.Mario")) {
                _player = (Mario) v;
                _MarioSprite = new Sprite(_texture.getTexture(v.getName()));
                _MarioSprite.setPosition(v.getX(),v.getY());
            }
            else if(v.getClass().getName().equals("elements.DonkeyKong")) {
                _dk = (DonkeyKong) v;
                _DKSprite = new Sprite(_texture.getTexture(v.getName()));
                _DKSprite.setPosition(v.getX(),v.getY());
            }
            else {
                Texture texture = _texture.getTexture(v.getName());
                texture.setWrap(Texture.TextureWrap.Repeat, Texture.TextureWrap.Repeat);
                sprite = new Sprite(texture, (int) v.getWidth(), (int) v.getHeight());
                sprite.setPosition(v.getX(), v.getY());
                SpriteList.add(sprite);
            }
        }
    }

    public void update(float delta) {

        DonkeyMove(delta);

        if(Gdx.input.isKeyPressed(Input.Keys.A) && _player.getX() > 0) {
            _player.setMovable(true);
            _player.Deplacement("left");
            _MarioSprite.setFlip(true, false);
            _MarioSprite.setPosition(_player.getX(), _player.getY());
        }
        if(Gdx.input.isKeyPressed(Input.Keys.D) && _player.getX() + _player.getWidth() < Gdx.graphics.getWidth()) {
            _player.setMovable(true);
            _player.Deplacement("right");
            _MarioSprite.setFlip(false, false);
            _MarioSprite.setPosition(_player.getX(), _player.getY());
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            System.out.println("X: " + _player.getX() + " Y: " + _player.getY());
        }

        _batch.begin();
        _shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        _shapeRenderer.setColor(0, 0, 1, 1);
        for(GameElements e : _world.getList()) {
            _shapeRenderer.polygon(e.getHitbox().getTransformedVertices());
            if(e instanceof DonkeyKong) {
                _DKSprite.setPosition(e.getX(), e.getY());
            }
        }
        for (Sprite s : SpriteList){
            s.draw(_batch);
        }
        _MarioSprite.draw(_batch);

        _DKSprite.draw(_batch);
        _batch.end();
        _shapeRenderer.end();
    }

    private void DonkeyMove(float delta) {
        fulldelta += delta;
        if(Math.round(fulldelta) % _dk.getDelta() == 0) {
            if(rdm == 1 && (_dk.getX() + _dk.getWidth()) < Gdx.graphics.getWidth()) {
                _dk.Deplacement("right");
            }
            else if (_dk.getX() > 0) {
                _dk.Deplacement("left");
            }
        }
        else {
            rdm = Math.random();
            // Si Donkey Kong est déjà le plus a gauche alors on le fait partir à droite
            if(rdm > 0.5 || _dk.getX() == 0) {
                rdm = 1;
            }
            // Inversement, si Donkey Kong est le plus a droite alors il part vers la gauche
            else if (rdm <= 0.5 || _dk.getX() + _dk.getWidth() == Gdx.graphics.getWidth()){
                rdm = 0;
            }
        }
    }
}
