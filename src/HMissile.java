
import java.awt.*;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author RP4K
 */
public class HMissile extends Bullet {

    public HMissile(double x, double y, double a) {
        super(x, y, a);
        shape = new Polygon();
        shape.addPoint(8, 0);
        shape.addPoint(-8, -4);
        shape.addPoint(-8, 4);
        drawshape = new Polygon();
        drawshape.addPoint(8, 0);
        drawshape.addPoint(-8, -4);
        drawshape.addPoint(-8, 4);
    }

    @Override
    public void updatePosition() {
        double m, n;
        if (!Asteroids.RockList.isEmpty()) {
            m = Asteroids.RockList.get(0).xposition;
            n = Asteroids.RockList.get(0).yposition;
            
            for (int i = 1; i < Asteroids.RockList.size(); i++) {
                double x, y, a, b;
                x = Asteroids.RockList.get(i).xposition;
                y = Asteroids.RockList.get(i).yposition;
                a = xposition;
                b = yposition;
                if ((m - a) * (m - a) + (n - b) * (n - b) > (x - a) * (x - a) + (y - b) * (y - b)) {
                    m = x;
                    n = y;
                }
            }
             for (int i = 0; i < Asteroids.EnemyList.size(); i++) {
                double x, y, a, b;
                x = Asteroids.EnemyList.get(i).xposition;
                y = Asteroids.EnemyList.get(i).yposition;
                a = xposition;
                b = yposition;
                if ((m - a) * (m - a) + (n - b) * (n - b) > (x - a) * (x - a) + (y - b) * (y - b)) {
                    m = x;
                    n = y;
                }
            }
             if (Asteroids.boss.active){
            double x, y, c, d;
                x = Asteroids.boss.xposition;
                y = Asteroids.boss.yposition;
                c = xposition;
                d = yposition;
                
                if ((m - c) * (m - c) + (n - d) * (n - d) > (x - c) * (x - c) + (y - d) * (y - d)) {
                    m = x;
                    n = y;
                }
                }
            double a, b;
            a = m - xposition;
            b = n - yposition;
            angle = Math.atan((double)(-b / a));
            if (a < 0) {
                angle += Math.PI;
            }
            xspeed = Math.cos(angle) * Thrust;
            yspeed = -Math.sin(angle) * Thrust;
        }
if (Asteroids.RockList.isEmpty()) {
    if (!Asteroids.EnemyList.isEmpty()){
            m = Asteroids.EnemyList.get(0).xposition;
            n = Asteroids.EnemyList.get(0).yposition;
            
            for (int i = 1; i < Asteroids.EnemyList.size(); i++) {
                double x, y, a, b;
                x = Asteroids.EnemyList.get(i).xposition;
                y = Asteroids.EnemyList.get(i).yposition;
                a = xposition;
                b = yposition;
                if ((m - a) * (m - a) + (n - b) * (n - b) > (x - a) * (x - a) + (y - b) * (y - b)) {
                    m = x;
                    n = y;
                }
            }
            if (Asteroids.boss.active){
            double x, y, c, d;
                x = Asteroids.boss.xposition;
                y = Asteroids.boss.yposition;
                c = xposition;
                d = yposition;
                
                if ((m - c) * (m - c) + (n - d) * (n - d) > (x - c) * (x - c) + (y - d) * (y - d)) {
                    m = x;
                    n = y;
                }
                }
            double a, b;
            a = m - xposition;
            b = n - yposition;
            angle = Math.atan((double)(-b / a));
            if (a < 0) {
                angle += Math.PI;
            }
            
            
            xspeed = Math.cos(angle) * Thrust;
            yspeed = -Math.sin(angle) * Thrust;
        }
}
if (Asteroids.boss.active){
    if (Asteroids.RockList.isEmpty()) {
    if (Asteroids.EnemyList.isEmpty()){
            m = Asteroids.boss.xposition;
            n = Asteroids.boss.yposition;
            double a, b;
            a = m - xposition;
            b = n - yposition;
            angle = Math.atan((double)(-b / a));
            if (a < 0) {
                angle += Math.PI;
            }
            
            xspeed = Math.cos(angle) * Thrust;
            yspeed = -Math.sin(angle) * Thrust;
        }
    }
}
        super.updatePosition();
    }
}
