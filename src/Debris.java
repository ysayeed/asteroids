/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author RP4K
 */
import java.awt.*;
import java.util.*;
public class Debris extends VectorSprite {
ArrayList<Color>ColorList;
    public void MakeDebris(double x, double y, int size){
    shape = new Polygon();
        shape.addPoint(2 * size,-1 * size);
        shape.addPoint(1 * size, 0 * size);
        shape.addPoint(-2 * size, 1 * size);
        shape.addPoint(-1 * size, -2 * size);
        drawshape = new Polygon();
        drawshape.addPoint(2 * size, -1 * size);
        drawshape.addPoint(1 * size, 0 * size);
        drawshape.addPoint(-2 * size, 1 * size);
        drawshape.addPoint(-1 * size, -2 * size);
        double a, h;
        a = Math.random() * Math.PI * 2;
        h = Math.random() *3+0.5;
        xspeed = Math.cos(a) * h;
        yspeed = Math.sin(a) * h;
        life=1;
        this.size=10;
        xposition=x;
        yposition=y;
        
        
}
    public Debris(double x, double y, int size){
        MakeDebris(x,y,size);
        ColorList=new ArrayList();
        ColorList.add(Color.BLUE);
        ColorList.add(Color.CYAN);
        ColorList.add(Color.GREEN);
        ColorList.add(Color.ORANGE);
        ColorList.add(Color.PINK);
        ColorList.add(Color.RED);
        ColorList.add(Color.WHITE);
        ColorList.add(Color.YELLOW);
        color=ColorList.get((int)Math.round(Math.random()*(ColorList.size()-1)));
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
