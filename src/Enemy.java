/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author RP4K
 */
import java.awt.*;
public class Enemy extends Rock {
    public Enemy(){
    shape = new Polygon();
        shape.addPoint(15, 0);
        shape.addPoint(-15, -15);
        shape.addPoint(-5, 0);
        shape.addPoint(-15, 15);
        drawshape = new Polygon();
        drawshape.addPoint(15, 0);
        drawshape.addPoint(-15, -15);
        drawshape.addPoint(-5, 0);
        drawshape.addPoint(-15, 15);
}
    @Override
    public void updatePosition(){
        double a, b;
            a = Asteroids.ship.xposition- xposition;
            b = Asteroids.ship.yposition-yposition;
            angle = Math.atan((double)(-b / a));
            if (a < 0) {
                angle += Math.PI;
            }
            cooldown-=1;
        super.updatePosition();
    }
}
