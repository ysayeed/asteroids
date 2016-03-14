/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author RP4K
 */
import java.awt.*;
public class Boss extends VectorSprite {
    boolean slow;
    public void MakeBoss(double x, double y){
    shape=new Polygon();
    shape.addPoint(-60, 20);
    shape.addPoint(-80, 20);
    shape.addPoint(-80, 40);
    shape.addPoint(-60, 40);
    shape.addPoint(-60, 60);
    shape.addPoint(60, 60);
    shape.addPoint(20, 50);
    shape.addPoint(140, 0);
    shape.addPoint(20, -50);
    shape.addPoint(60, -60);
    shape.addPoint(-60, -60);
    shape.addPoint(-60, -40);
    shape.addPoint(-80, -40);
    shape.addPoint(-80, -20);
    shape.addPoint(-60, -20);
    drawshape=new Polygon();
    drawshape.addPoint(-60, 20);
    drawshape.addPoint(-80, 20);
    drawshape.addPoint(-80, 40);
    drawshape.addPoint(-60, 40);
    drawshape.addPoint(-60, 60);
    drawshape.addPoint(60, 60);
    drawshape.addPoint(20, 50);
    drawshape.addPoint(140, 0);
    drawshape.addPoint(20, -50);
    drawshape.addPoint(60, -60);
    drawshape.addPoint(-60, -60);
    drawshape.addPoint(-60, -40);
    drawshape.addPoint(-80, -40);
    drawshape.addPoint(-80, -20);
    drawshape.addPoint(-60, -20);
    xposition=x;
    yposition=y;
    life=50;
    cooldown=50;
    double a, h;
        a = Math.random() * Math.PI * 2;
        h = Math.random() * 2 + 1.5;
        xspeed = Math.cos(a) * h;
        yspeed = Math.sin(a) * h;
    slow=false;
}
    public Boss(){
    double a,h, x, y;
        a=Math.random()*Math.PI*2;
        h=Math.random()*150+250;
        x = Math.cos(a)*h+450;
        y = Math.sin(a)*h+300;
        MakeBoss(x,y);
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
            cooldown--;
        super.updatePosition();
    }
}
