package package1.game.entity;

import package1.game.Game;
import package1.game.gameUtil.Movement;

import java.awt.*;

/**
 * Created by tyleranson on 3/30/16.
 */
public class Bullet extends Entity {

    private static final double SPEED = 6;

    private static final int BULLET_LIFE = 60;

    private int life;

    public Bullet(Entity origin, double angle){
        super(new Movement(origin.position), new Movement(angle).scale(SPEED), 2.0);
        this.life = BULLET_LIFE;
    }

    @Override
    public void update(Game game){
        super.update(game);

        this.life--;
        if(life <= 0)
            deadObject = true;
    }

    @Override
    public void draw(Graphics2D g, Game game){
        g.drawOval(-1, -1, 2, 2);
    }
}
