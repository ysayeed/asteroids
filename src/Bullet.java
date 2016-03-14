/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author RP4K
 */
import java.awt.*;

public class Bullet extends VectorSprite {
boolean slow;
    public Bullet(double x, double y, double a) {
        shape = new Polygon();
        shape.addPoint(3, 2);
        shape.addPoint(3, -2);
        shape.addPoint(-3, -2);
        shape.addPoint(-3, 2);
        drawshape = new Polygon();
        drawshape.addPoint(3, 2);
        drawshape.addPoint(3, -2);
        drawshape.addPoint(-3, -2);
        drawshape.addPoint(-3, 2);
        Thrust = 21;
        Rotation = 5;
        angle = a;
        xspeed = Math.cos(angle) * Thrust;
        yspeed = -Math.sin(angle) * Thrust;
        xposition = x;
        yposition = y;
        life = 30;
        slow=false;
    }

    @Override
    public void updatePosition() {
        life -= 1;
        super.updatePosition();
    }
    @Override
    public void paint (Graphics g){
        g.fillPolygon(drawshape);
    }
}
