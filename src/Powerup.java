/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author RP4K
 */
import java.awt.*;
public class Powerup extends VectorSprite {
    public void MakePowerup(double x, double y, int size){
    size=1;
    double radius=10;
        shape = new Polygon();
        //shape.addPoint(5 * size,5 * size);
        //shape.addPoint(5 * size, -5 * size);
        //shape.addPoint(-5 * size, -5 * size);
        //shape.addPoint(-5 * size, 5 * size);
        drawshape = new Polygon();
        for (int i=0;i<360;i++){
            shape.addPoint((int)Math.round( Math.cos(((double)i/180)*Math.PI)*radius), (int)Math.round( Math.sin(((double)i/180)*Math.PI)*radius));
        drawshape.addPoint((int)Math.round( Math.cos(((double)i/180)*Math.PI)*radius), (int)Math.round( Math.sin(((double)i/180)*Math.PI)*radius));
        }
        
        //drawshape.addPoint(5 * size, 5 * size);
        //drawshape.addPoint(5 * size, -5 * size);
        //drawshape.addPoint(-5 * size, -5 * size);
        //drawshape.addPoint(-5 * size, 5 * size);
        
        xspeed=0;
        yspeed=0;   
        life=500;
        xposition=x;
        yposition=y;

}
    public Powerup() {
        double a,h, x, y;
        a=Math.random()*Math.PI*2;
        h=Math.random()*250+50;
        x = Math.cos(a)*h+450;
        y = Math.sin(a)*h+300;
        type=(int) Math.random()*2;
        MakePowerup(x,y,size);
        
}
    //public Powerup(double x, double y, int size){
    //    MakePowerup(x,y,size);
    //}
    @Override
    public void updatePosition() {
        life -= 1;
        super.updatePosition();
    }
}
