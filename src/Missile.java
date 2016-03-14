/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author RP4K
 */
import java.awt.*;
public class Missile extends Bullet {
    public Missile(double x,double y, double a){
    super(x,y,a);
    shape = new Polygon();
        shape.addPoint(4, 1);
        shape.addPoint(-4, 1);
        shape.addPoint(-4, -1);
        shape.addPoint(4, -1);
        drawshape = new Polygon();
        drawshape.addPoint(4, 1);
        drawshape.addPoint(-4, 1);
        drawshape.addPoint(-4, -1);
        drawshape.addPoint(4, -1);
        life=999999999;
}
    @Override
    public void updatePosition(){
        super.updatePosition();
        life=999999999;
    }
}
