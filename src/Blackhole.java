/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author RP4K
 */
import java.awt.*;
public class Blackhole extends VectorSprite {
    public Blackhole(double x, double y,double a){
        size=2;
    shape = new Polygon();
        shape.addPoint(0/size, 0/size);
        shape.addPoint(2/size, 5/size);
        shape.addPoint(3/size, 9/size);
        shape.addPoint(4/size, 18/size);
        shape.addPoint(5/size, 22/size);
        shape.addPoint(7/size, 32/size);
        shape.addPoint(9/size, 40/size);
        shape.addPoint(11/size, 45/size);
        shape.addPoint(14/size, 51/size);
        shape.addPoint(16/size, 56/size);
        shape.addPoint(18/size, 60/size);
        shape.addPoint(20/size, 62/size);
        shape.addPoint(27/size, 66/size);
        shape.addPoint(33/size, 67/size);
        shape.addPoint(38/size, 69/size);
        shape.addPoint(42/size, 70/size);
        shape.addPoint(47/size, 71/size);
        shape.addPoint(57/size, 72/size);
        shape.addPoint(64/size, 73/size);
        shape.addPoint(72/size, 74/size);
        //shape.addPoint(77, 73);
        shape.addPoint(65/size, 67/size);
        shape.addPoint(56/size, 63/size);
        shape.addPoint(50/size, 59/size);
        shape.addPoint(43/size, 54/size);
        shape.addPoint(38/size, 51/size);
        shape.addPoint(33/size, 46/size);
        shape.addPoint(26/size, 38/size);
        shape.addPoint(20/size, 30/size);
        shape.addPoint(16/size, 24/size);
        shape.addPoint(10/size, 16/size);
        shape.addPoint(7/size, 10/size);
        shape.addPoint(4/size, 6/size);
        
        shape.addPoint(0/size, 0/size);
        shape.addPoint(-2/size, -5/size);
        shape.addPoint(-3/size, -9/size);
        shape.addPoint(-4/size, -18/size);
        shape.addPoint(-5/size, -22/size);
        shape.addPoint(-7/size, -32/size);
        shape.addPoint(-9/size, -40/size);
        shape.addPoint(-11/size, -45/size);
        shape.addPoint(-14/size, -51/size);
        shape.addPoint(-16/size, -56/size);
        shape.addPoint(-18/size, -60/size);
        shape.addPoint(-20/size, -62/size);
        shape.addPoint(-27/size, -66/size);
        shape.addPoint(-33/size, -67/size);
        shape.addPoint(-38/size, -69/size);
        shape.addPoint(-42/size, -70/size);
        shape.addPoint(-47/size, -71/size);
        shape.addPoint(-57/size, -72/size);
        shape.addPoint(-64/size, -73/size);
        shape.addPoint(-72/size, -74/size);
        //shape.addPoint(-77, -73);
        shape.addPoint(-65/size, -67/size);
        shape.addPoint(-56/size, -63/size);
        shape.addPoint(-50/size, -59/size);
        shape.addPoint(-43/size, -54/size);
        shape.addPoint(-38/size, -51/size);
        shape.addPoint(-33/size, -46/size);
        shape.addPoint(-26/size, -38/size);
        shape.addPoint(-20/size, -30/size);
        shape.addPoint(-16/size, -24/size);
        shape.addPoint(-10/size, -16/size);
        shape.addPoint(-7/size, -10/size);
        shape.addPoint(-4/size, -6/size);
        
        drawshape = new Polygon();
        drawshape.addPoint(0/size, 0/size);
        drawshape.addPoint(2/size, 5/size);
        drawshape.addPoint(3/size, 9/size);
        drawshape.addPoint(4/size, 18/size);
        drawshape.addPoint(5/size, 22/size);
        drawshape.addPoint(7/size, 32/size);
        drawshape.addPoint(9/size, 40/size);
        drawshape.addPoint(11/size, 45/size);
        drawshape.addPoint(14/size, 51/size);
        drawshape.addPoint(16/size, 56/size);
        drawshape.addPoint(18/size, 60/size);
        drawshape.addPoint(20/size, 62/size);
        drawshape.addPoint(27/size, 66/size);
        drawshape.addPoint(33/size, 67/size);
        drawshape.addPoint(38/size, 69/size);
        drawshape.addPoint(42/size, 70/size);
        drawshape.addPoint(47/size, 71/size);
        drawshape.addPoint(57/size, 72/size);
        drawshape.addPoint(64/size, 73/size);
        drawshape.addPoint(72/size, 74/size);
        //drawshape.addPoint(77, 73);
        drawshape.addPoint(65/size, 67/size);
        drawshape.addPoint(56/size, 63/size);
        drawshape.addPoint(50/size, 59/size);
        drawshape.addPoint(43/size, 54/size);
        drawshape.addPoint(38/size, 51/size);
        drawshape.addPoint(33/size, 46/size);
        drawshape.addPoint(26/size, 38/size);
        drawshape.addPoint(20/size, 30/size);
        drawshape.addPoint(16/size, 24/size);
        drawshape.addPoint(10/size, 16/size);
        drawshape.addPoint(7/size, 10/size);
        drawshape.addPoint(4/size, 6/size);
        
        drawshape.addPoint(0/size, 0/size);
        drawshape.addPoint(-2/size, -5/size);
        drawshape.addPoint(-3/size, -9/size);
        drawshape.addPoint(-4/size, -18/size);
        drawshape.addPoint(-5/size, -22/size);
        drawshape.addPoint(-7/size, -32/size);
        drawshape.addPoint(-9/size, -40/size);
        drawshape.addPoint(-11/size, -45/size);
        drawshape.addPoint(-14/size, -51/size);
        drawshape.addPoint(-16/size, -56/size);
        drawshape.addPoint(-18/size, -60/size);
        drawshape.addPoint(-20/size, -62/size);
        drawshape.addPoint(-27/size, -66/size);
        drawshape.addPoint(-33/size, -67/size);
        drawshape.addPoint(-38/size, -69/size);
        drawshape.addPoint(-42/size, -70/size);
        drawshape.addPoint(-47/size, -71/size);
        drawshape.addPoint(-57/size, -72/size);
        drawshape.addPoint(-64/size, -73/size);
        drawshape.addPoint(-72/size, -74/size);
        //shape.addPoint(-77, -73);
        drawshape.addPoint(-65/size, -67/size);
        drawshape.addPoint(-56/size, -63/size);
        drawshape.addPoint(-50/size, -59/size);
        drawshape.addPoint(-43/size, -54/size);
        drawshape.addPoint(-38/size, -51/size);
        drawshape.addPoint(-33/size, -46/size);
        drawshape.addPoint(-26/size, -38/size);
        drawshape.addPoint(-20/size, -30/size);
        drawshape.addPoint(-16/size, -24/size);
        drawshape.addPoint(-10/size, -16/size);
        drawshape.addPoint(-7/size, -10/size);
        drawshape.addPoint(-4/size, -6/size);
angle=a;
        xposition = x;
        yposition = y;
        Rotation = 0.1;
}
     @Override
    public void updatePosition(){
         angle+=Rotation;
         super.updatePosition();
     }
}
