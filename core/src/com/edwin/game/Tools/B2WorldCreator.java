package com.edwin.game.Tools;

import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.edwin.game.DBZ;
import com.edwin.game.Sprites.Brick;
import com.edwin.game.Sprites.Coin;

/**
 * Created by Edwin on 3/20/2017.
 */
public class B2WorldCreator {

    public B2WorldCreator(World world, TiledMap map){

        BodyDef bdef = new BodyDef();
        PolygonShape shape = new PolygonShape();
        FixtureDef fdef = new FixtureDef();
        Body body;

        //ground tiles

        for(MapObject object: map.getLayers().get(2).getObjects().getByType(RectangleMapObject.class) ){

            Rectangle rect = ((RectangleMapObject)object).getRectangle();
            bdef.type = BodyDef.BodyType.StaticBody;
            bdef.position.set((rect.getX()+rect.getWidth()/2)/ DBZ.PPM, (rect.getY()+rect.getHeight()/2)/DBZ.PPM );

            body = world.createBody(bdef);

            shape.setAsBox(rect.getWidth()/2/DBZ.PPM, rect.getHeight()/2/DBZ.PPM);
            fdef.shape = shape;
            body.createFixture(fdef);

        }

        //pipes tiles

        for(MapObject object: map.getLayers().get(3).getObjects().getByType(RectangleMapObject.class) ){

            Rectangle rect = ((RectangleMapObject)object).getRectangle();
            bdef.type = BodyDef.BodyType.StaticBody;
            bdef.position.set((rect.getX()+rect.getWidth()/2)/DBZ.PPM, (rect.getY()+rect.getHeight()/2)/DBZ.PPM );

            body = world.createBody(bdef);

            shape.setAsBox(rect.getWidth()/2/DBZ.PPM, rect.getHeight()/2/DBZ.PPM);
            fdef.shape = shape;
            body.createFixture(fdef);

        }

        //bricks tiles

        for(MapObject object: map.getLayers().get(5).getObjects().getByType(RectangleMapObject.class) ){

            Rectangle rect = ((RectangleMapObject)object).getRectangle();
            new Brick(world, map, rect);

        }

        //coins tiles

        for(MapObject object: map.getLayers().get(4).getObjects().getByType(RectangleMapObject.class) ){

            Rectangle rect = ((RectangleMapObject)object).getRectangle();

            new Coin(world, map, rect);

        }


    }
}

