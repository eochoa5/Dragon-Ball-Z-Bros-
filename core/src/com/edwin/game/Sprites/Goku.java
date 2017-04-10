package com.edwin.game.Sprites;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.edwin.game.DBZ;
import com.edwin.game.Screens.PlayScreen;

/**
 * Created by Edwin on 3/20/2017.
 */
public class Goku extends Sprite {
    public World world;
    public Body b2body;
    private TextureRegion gokuStand;

    public Goku(World world, PlayScreen screen){
        super(screen.getAtlas().findRegion("goku_sprite"));
        this.world = world;
        defineGoku();
        gokuStand = new TextureRegion(getTexture(), 5,12,59,85);
        setBounds(0,0,59/DBZ.PPM,85/DBZ.PPM);
        setRegion(gokuStand);

    }

    public void defineGoku(){
        BodyDef bdef = new BodyDef();
        bdef.position.set(32/DBZ.PPM,32/DBZ.PPM);
        bdef.type = BodyDef.BodyType.DynamicBody;
        b2body = world.createBody(bdef);

        FixtureDef fdef = new FixtureDef();
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(59/2/DBZ.PPM, 85/2/DBZ.PPM);

        fdef.shape = shape;
        b2body.createFixture(fdef);

    }

    public void update(float dt){
        setPosition(b2body.getPosition().x - getWidth()/2, b2body.getPosition().y - getHeight()/2 );

    }

}

