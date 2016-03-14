/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author RP4K
 */
import java.awt.*;

public class VectorSprite {
int type;
    int life;
    int size;
    double xposition;
    double yposition;
    double xspeed;
    double yspeed;
    double angle;
    double Rotation, Thrust;
    Polygon shape;
    Polygon drawshape;
    boolean active = true;
    int counter;
    int cooldown;
    Color color;
    //single, float, double, long, very long are all decimals, each uses different memory amounts

    public void wraparound() {
       if (Asteroids.BlackholeList.isEmpty()){
        if (xposition < 0) {
            xposition = 900;
        }
        if (xposition > 900) {
            xposition = 0;
        }
        if (yposition < 0) {
            yposition = 600;
        }
        if (yposition > 600) {
            yposition = 0;
        }
       }
       if (!Asteroids.BlackholeList.isEmpty()){
        if (xposition < 0) {
            xposition = 0;
            xspeed=0;
            yspeed=0;
            Thrust=0;
        }
        if (xposition > 900) {
            xposition = 900;
            xspeed=0;
            yspeed=0;
            Thrust=0;
        }
        if (yposition < 0) {
            yposition = 0;
            xspeed=0;
            yspeed=0;
            Thrust=0;
        }
        if (yposition > 600) {
            yposition = 600;
            xspeed=0;
            yspeed=0;
            Thrust=0;
        }
       }
    }

    public void paint(Graphics g) {
        g.drawPolygon(drawshape);
    }

    public void updatePosition() {
        int x, y;
        xposition += xspeed;
        yposition += yspeed;
        for (int i = 0; i < shape.npoints; i++) {
            //shape.xpoints[i]+=xspeed;
            //shape.ypoints[i]+=yspeed;
            x = (int) Math.round(shape.xpoints[i] * Math.cos(angle) - shape.ypoints[i] * Math.sin(angle));
            y = -(int) Math.round(shape.xpoints[i] * Math.sin(angle) + shape.ypoints[i] * Math.cos(angle));
            drawshape.xpoints[i] = x;
            drawshape.ypoints[i] = y;
        }
        wraparound();
        drawshape.invalidate();
        drawshape.translate((int) Math.round(xposition), (int) Math.round(yposition));
        counter++;
    }
}
