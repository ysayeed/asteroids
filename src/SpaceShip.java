/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author RP4K
 */
import java.awt.*;

public class SpaceShip extends VectorSprite {

    public SpaceShip() {
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
        xposition = 450;
        yposition = 300;
        Rotation = Math.PI/12;
        Thrust = 0;
    }

    public void accelerate() {
        xspeed = Math.cos(angle) * Thrust;
        yspeed = -Math.sin(angle) * Thrust;
        if(Thrust<20){
                Thrust += 1.2;
        }
    }

    public void decelerate() {
        if (Thrust>-10){
        Thrust -= 1;
        }
        if (Thrust>=0){
        xspeed = -Math.cos(angle) * Thrust;
        yspeed = Math.sin(angle) * Thrust;
        }
        if(Thrust<0){
        xspeed = Math.cos(angle) * Thrust;
        yspeed = -Math.sin(angle) * Thrust;
        }
    }

    public void Rotateleft() {
        angle -= Rotation;
    }

    public void Rotateright() {
        angle += Rotation;
    }
    @Override
        public void updatePosition() {
cooldown-=1;
        super.updatePosition();
    }
}
