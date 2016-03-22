package package1.game.entity;

import package1.game.Game;

import java.awt.*;
import java.util.Random;

import package1.game.gameUtil.Movement;
/**
 * Created by tyleranson on 3/16/16.
 */
public class Asteroid extends Entity{
    
    private int size = 10;

    public Asteroid(Movement position, Movement speed, double magnitude){
        super(position, speed, magnitude);
        this.deadObject = false;
        this.position = position;
        this.speed = speed;
        this.magnitude = magnitude;
    }

    public Asteroid(Random random){
        super.
    }

    public void draw(Graphics2D g, Game game) {

        g.drawRect(-10,-10,10,10); //Draw the Asteroid.
    }
}
