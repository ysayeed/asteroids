
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author RP4K
 */
import java.awt.*;

public class Rock extends VectorSprite {
boolean slow;
    public void MakeRock(double x, double y, int size) {

        shape = new Polygon();
        //shape.addPoint(20 * size,-5 * size);
       // shape.addPoint(1 * size, 5 * size);
       // shape.addPoint(-10 * size, -5 * size);
       // shape.addPoint(1 * size, 25 * size);
        drawshape = new Polygon();
        //drawshape.addPoint(20 * size, -5 * size);
       // drawshape.addPoint(1 * size, 5 * size);
       // drawshape.addPoint(-10 * size, -5 * size);
       // drawshape.addPoint(1 * size, 25 * size);
        shape.addPoint(4* (size+1),10* (size+1));
        shape.addPoint(10* (size+1),6* (size+1));
        shape.addPoint(12* (size+1),-2* (size+1));
        shape.addPoint(6* (size+1),-4* (size+1));
        shape.addPoint(8* (size+1),-8* (size+1));
        shape.addPoint(4* (size+1),-10* (size+1));
        shape.addPoint(-4* (size+1),-8* (size+1));
        shape.addPoint(-8* (size+1),-4* (size+1));
        shape.addPoint(-6* (size+1),4* (size+1));
        shape.addPoint(-2* (size+1),8* (size+1));
        drawshape.addPoint(4* (size+1),10* (size+1));
        drawshape.addPoint(10* (size+1),6* (size+1));
        drawshape.addPoint(12* (size+1),-2* (size+1));
        drawshape.addPoint(6* (size+1),-4* (size+1));
        drawshape.addPoint(8* (size+1),-8* (size+1));
        drawshape.addPoint(4* (size+1),-10* (size+1));
        drawshape.addPoint(-4* (size+1),-8* (size+1));
        drawshape.addPoint(-8* (size+1),-4* (size+1));
        drawshape.addPoint(-6* (size+1),4* (size+1));
        drawshape.addPoint(-2* (size+1),8* (size+1));
        double a, h;
        a = Math.random() * Math.PI * 2;
        h = Math.random() * 2 + 1.5;
        xspeed = Math.cos(a) * h;
        yspeed = Math.sin(a) * h;
        xposition = x;
        yposition = y;
        Thrust = 0;
        Rotation = Math.random() * 0.6 - 0.3;
        this.size=size;
        slow=false;
    }
    public Rock() {
        double a,h, x, y;
        a=Math.random()*Math.PI*2;
        h=Math.random()*250+150;
        x = Math.cos(a)*h+450;
        y = Math.sin(a)*h+300;
        MakeRock(x,y,3);
    }
    public Rock(double x, double y,int size){
        MakeRock(x,y,size);
    }
    @Override
    public void updatePosition() {
        angle += Rotation;
        super.updatePosition();
    }
}
