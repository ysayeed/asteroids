/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author RP4K
 */
import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.Timer;
import java.applet.AudioClip;
public class Asteroids extends Applet implements KeyListener, ActionListener {
    //for documentation   
    public static SpaceShip ship;
    public static Boss boss;
    Timer timer=new Timer(35, this);
    public static ArrayList<Rock> RockList;
    ArrayList<Bullet>BulletList;
    ArrayList<Bullet>EnemyBulletList;
    ArrayList<Debris>DebrisList;
    ArrayList<Powerup>PowerupList;
    public static ArrayList<Enemy>EnemyList;
    public static ArrayList<Blackhole>BlackholeList;
    long fpsCount;
    Image offScreen;
    Graphics offg;
    boolean upkey, downkey, leftkey, rightkey, spacekey, enterkey,escapekey;
    Font font1=new Font("Comic Sans Ms",Font.PLAIN,30);
    int tempscore, score, bullettype, powerupspawn, poweruptime, BHCounter;
    int lives=3;
    int level=1;
AudioClip laser, thruster, elaser, explosion0, explosion1,bgm;
    @Override
    public void init() {
        //google java API
        this.setSize(900, 600);
        this.addKeyListener(this);
        //timer = new Timer(35, this);
        offScreen = createImage(this.getWidth(), this.getHeight());
        offg = offScreen.getGraphics();
        RockList = new ArrayList();
        for (int i = 0; i < level; i++) {
            RockList.add(new Rock());
        }
        BulletList = new ArrayList();
DebrisList=new ArrayList();
PowerupList=new ArrayList();
EnemyList=new ArrayList();
EnemyBulletList=new ArrayList();
BlackholeList=new ArrayList();
for (int i = 0; i < level-4; i++) {
            EnemyList.add(new Enemy());
            EnemyList.get(i).cooldown=(int)((Math.random())*20+35);
        }
BHCounter=950+50*level;
        ship = new SpaceShip();
        boss= new Boss();
        powerupspawn=0;
        poweruptime=-1;
        laser=getAudioClip(getCodeBase(),"laser80.wav");
        thruster=getAudioClip(getCodeBase(),"thruster.wav");
        elaser=getAudioClip(getCodeBase(),"laser79.wav");
        explosion1=getAudioClip(getCodeBase(),"explode1.wav");
        explosion0=getAudioClip(getCodeBase(),"explode0.wav");
        bgm=getAudioClip(getCodeBase(),"Asteroids Game Boy Title Music.mp3");
        bgm.loop();
        if (level<10){
            boss.active=false;
        }
        timer.start();
        //fpsCount=System.currentTimeMillis();
    }
    @Override
    public void paint(Graphics g) { 
        offg.setColor(Color.BLACK);
        offg.fillRect(0, 0, 900, 600);
        //offg.setColor(Color.YELLOW);     
        offg.setColor(Color.CYAN);
        if (ship.active) {
            ship.paint(offg);
        }
        offg.setColor(Color.WHITE);
        for (int i = 0; i < RockList.size(); i++) {
            RockList.get(i).paint(offg);
        }
        for (int i=0;i<BlackholeList.size();i++){
            BlackholeList.get(i).paint(offg);
        }
        offg.setColor(Color.GREEN);
        for (int i = 0; i < BulletList.size(); i++) {
            BulletList.get(i).paint(offg);
        }
        for (int i=0;i<PowerupList.size();i++){
            PowerupList.get(i).paint(offg);
        }
        offg.setColor(Color.RED);
        for (int i=0;i<EnemyBulletList.size();i++){
            EnemyBulletList.get(i).paint(offg);
           }
        if (boss.active){
                boss.paint(offg);
            }
        for (int i=0;i<EnemyList.size();i++){
            EnemyList.get(i).paint(offg);
        }
        for (int i=0; i<DebrisList.size();i++){
            offg.setColor(DebrisList.get(i).color);
            DebrisList.get(i).paint(offg);
        }
        offg.setFont(font1);
        if(RockList.isEmpty()&&EnemyList.isEmpty()&&lives>=0&&boss.active==false){
            offg.drawString("You Win!", 400, 300);
            offg.drawString("Press Enter to Restart", 325, 250);
        }
        if(lives<0){
            offg.drawString("You Lose :(", 400, 300);
            offg.drawString("Press Enter to Restart", 325, 250);
        }
        offg.drawString("Level:"+level,10,575);
        offg.drawString("Score:"+score, 10, 30);
        if (BlackholeList.isEmpty()){
        offg.drawString("Danger! "+BHCounter,700,575);
        }
        if (!BlackholeList.isEmpty()){
        offg.drawString("NO ESCAPE",700,550);
        }
        if (lives>=0){
        offg.drawString("Lives:"+lives, 800, 30);
        }
        g.drawImage(offScreen, 0, 0, this);
        repaint();      
    }
    @Override
    public void update(Graphics g) {
        paint(g);
    }
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            //=makes into
            //==checks if true or false
            rightkey = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            leftkey = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            upkey = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            downkey = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            spacekey = true;
        }
        if (e.getKeyCode()==KeyEvent.VK_ENTER){
            enterkey=true;
        }
        if (e.getKeyCode()==KeyEvent.VK_0){
            bullettype=0;
        }
        if (e.getKeyCode()==KeyEvent.VK_1){
            bullettype=1;
        }
        if (e.getKeyCode()==KeyEvent.VK_2){
            bullettype=2;
        }
        if (e.getKeyCode()==KeyEvent.VK_8){
            bullettype=8;
        }
        if (e.getKeyCode()==KeyEvent.VK_9){
            bullettype=9;
        }
        if (e.getKeyCode()==KeyEvent.VK_ESCAPE){
            escapekey=true;
        }
    }
//x1=x*costheta-y*sintheta
    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            //=makes into
            //==checks if true or false
            rightkey = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            leftkey = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            upkey = false;
            if (ship.Thrust > 1) {
                ship.Thrust -= 1;
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            downkey = false;
            ship.Thrust = -0.1;
        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            spacekey = false;
        }
        if (e.getKeyCode()==KeyEvent.VK_ENTER){
            enterkey=false;
        }
        if (e.getKeyCode()==KeyEvent.VK_ESCAPE){
            escapekey=false;
        }
    }
    public boolean Collision(VectorSprite v1, VectorSprite v2) {
        int x, y;
        for (int i = 0; i < v1.drawshape.npoints; i++) {
            x = v1.drawshape.xpoints[i];
            y = v1.drawshape.ypoints[i];
            if (v2.drawshape.contains(x, y)) {
                return true;
            }
        }
        for (int i = 0; i < v2.drawshape.npoints; i++) {
            x = v2.drawshape.xpoints[i];
            y = v2.drawshape.ypoints[i];
            if (v1.drawshape.contains(x, y)) {
                return true;
            }
        }
        return false;
    }
    @Override
    public void keyTyped(KeyEvent e) {
    }
    public void keyCheck() {
        if (rightkey) {
            ship.Rotateright();
        }
        if (leftkey) {
            ship.Rotateleft();
        }
        if (upkey) {
            ship.accelerate();
            thruster.play();
        }
        if (downkey) {
            ship.decelerate();
            thruster.play();
        }
        if(spacekey&&ship.active&&ship.cooldown<0){
            if (bullettype==0){
            BulletList.add(new Bullet(ship.xposition, ship.yposition,ship.angle));
            laser.play();
            ship.cooldown=5;
            }
            if (bullettype==1){
            BulletList.add(new HMissile(ship.xposition, ship.yposition,ship.angle));
            ship.cooldown=20;
            laser.play();
            }
            if (bullettype==2){
            BulletList.add(new Bullet(ship.xposition, ship.yposition,ship.angle));
            BulletList.add(new Bullet(ship.xposition, ship.yposition,ship.angle-0.1));
            BulletList.add(new Bullet(ship.xposition, ship.yposition,ship.angle-0.05));
            BulletList.add(new Bullet(ship.xposition, ship.yposition,ship.angle-0.0375));
            BulletList.add(new Bullet(ship.xposition, ship.yposition,ship.angle-0.025));
            BulletList.add(new Bullet(ship.xposition, ship.yposition,ship.angle-0.0675));
            BulletList.add(new Bullet(ship.xposition, ship.yposition,ship.angle-0.075));
            BulletList.add(new Bullet(ship.xposition, ship.yposition,ship.angle-0.0875));
            BulletList.add(new Bullet(ship.xposition, ship.yposition,ship.angle+0.1));
            BulletList.add(new Bullet(ship.xposition, ship.yposition,ship.angle+0.05));
            BulletList.add(new Bullet(ship.xposition, ship.yposition,ship.angle+0.025));
            BulletList.add(new Bullet(ship.xposition, ship.yposition,ship.angle+0.075));
            BulletList.add(new Bullet(ship.xposition, ship.yposition,ship.angle+0.0375));
            BulletList.add(new Bullet(ship.xposition, ship.yposition,ship.angle+0.0675));
            BulletList.add(new Bullet(ship.xposition, ship.yposition,ship.angle+0.0875));
            ship.cooldown=30;
            laser.play();
            }
            if (bullettype==8){
            BulletList.add(new Missile(ship.xposition, ship.yposition,ship.angle));
            ship.cooldown=50;
            laser.play();
            }
            if (bullettype==9){
            BulletList.add(new HMissile(ship.xposition, ship.yposition,ship.angle));
            BulletList.add(new Bullet(ship.xposition, ship.yposition,ship.angle-0.1));
            BulletList.add(new Bullet(ship.xposition, ship.yposition,ship.angle-0.05));
            BulletList.add(new Bullet(ship.xposition, ship.yposition,ship.angle+0.1));
            BulletList.add(new Bullet(ship.xposition, ship.yposition,ship.angle+0.05));
            ship.cooldown=1;
            laser.play();
            }
        }
        if (EnemyList.isEmpty()&&enterkey&&RockList.isEmpty()&&boss.active==false){
            if (lives>=0){
                level+=1;
            }
            if (lives<0){
                lives=3;
                level=1;
                score=0;
                tempscore=0;
            }
          init();  
        }
        if (escapekey){
            ship.xspeed=0;
            ship.yspeed=0;
            ship.Thrust=0;
        }
    }
    public void checkCollision() {
        for (int i = 0; i < RockList.size(); i++) {
            if (Collision(ship, RockList.get(i))) {
                if (ship.active){
                for (int j = 0; j < 100; j++) {
DebrisList.add(new Debris(ship.xposition,ship.yposition,1));
                }
                RockList.get(i).active=false;
                ship.counter = 0;
                lives-=1;
                explosion1.play();
            ship.active = false;
                    }
            }
            for (int j=0;j<BulletList.size();j++){
                if (Collision(RockList.get(i),BulletList.get(j))){
                    RockList.get(i).active=false;
                    BulletList.get(j).life=0;
                    explosion0.play();
                }
            }
        }
        for (int i = 0; i < EnemyBulletList.size(); i++) {
            if (Collision(ship, EnemyBulletList.get(i))) {
                if (ship.active){
                for (int j = 0; j < 100; j++) {
DebrisList.add(new Debris(ship.xposition,ship.yposition,1));
                }
                EnemyBulletList.get(i).active=false;
                ship.counter = 0;
                lives-=1;
            ship.active = false;
            explosion1.play();
                    }
            }
            for (int j=0;j<RockList.size();j++){
                if (Collision(RockList.get(j),EnemyBulletList.get(i))){
                    EnemyBulletList.get(i).life=0;
                }
            }
            for (int k=0; k<BulletList.size();k++){
                if (Collision(BulletList.get(k),EnemyBulletList.get(i))){
                    BulletList.get(k).life=0;
                    EnemyBulletList.get(i).life=0;
                }
            }
        }
//        for (int k = 0; k < DebrisList.size(); k++) {
//            if (Collision(ship, DebrisList.get(k))) {
//                ship.active = false;
//                ship.counter = 0;
//            }
//        }
        for (int i=0;i<PowerupList.size();i++){
            if (Collision(ship,PowerupList.get(i))&&ship.active&&PowerupList.get(i).active){
                PowerupList.get(i).active=false;
                score+=300;
                tempscore+=300;
            }
        }
        for (int i = 0; i < EnemyList.size(); i++) {
            if (Collision(ship, EnemyList.get(i))) {
                if (ship.active){
                for (int j = 0; j < 100; j++) {
DebrisList.add(new Debris(ship.xposition,ship.yposition,1));
                }
                EnemyList.get(i).active=false;
                ship.counter = 0;
                lives-=1;
            ship.active = false;
            explosion1.play();
                    }
            }
            for (int j=0;j<BulletList.size();j++){
                if (Collision(EnemyList.get(i),BulletList.get(j))){
                    EnemyList.get(i).active=false;
                    BulletList.get(j).life=0;
                    explosion0.play();
                }
            }
        }
        if (Collision(ship, boss)) {
                if (ship.active&&boss.active){
                for (int j = 0; j < 100; j++) {
DebrisList.add(new Debris(ship.xposition,ship.yposition,1));
                }
                ship.counter = 0;
                lives-=1;
                boss.life-=5;
            ship.active = false;
            score+=500;
            tempscore+=500;
            explosion1.play();
            if (boss.life<0){
                    for (int j = 0; j < 50; j++) {
DebrisList.add(new Debris(boss.xposition,boss.yposition,1));
                }
                    explosion0.play();
                    score+=5000;
                    tempscore+=5000;
                }
                    }
    }
        for (int i=0; i<BulletList.size();i++){
            if (Collision(boss,BulletList.get(i))&&boss.active){
                BulletList.get(i).life=0;
                boss.life-=2;
                tempscore+=200;
                score+=200;
                if (boss.life<0){
                    for (int j = 0; j < 50; j++) {
DebrisList.add(new Debris(boss.xposition,boss.yposition,1));
                }
                    explosion0.play();
                    score+=5000;
                    tempscore+=5000;
                }
            }
        }
    }
    public void restartShip() {
        if (ship.active == false && ship.counter > 50 && isRespawnSafe()&&lives>=0) {
            ship.xposition = 450;
            ship.yposition = 300;
            ship.xspeed = 0;
            ship.yspeed = 0;
            ship.Thrust = 0;
            boss.cooldown=100;
            ship.angle = -Math.PI / 2;
            for(int j=0;j<DebrisList.size();j++){
                DebrisList.remove(j);
            }
            ship.active = true;
        }   
    }
    public boolean isRespawnSafe() {
        double a, b, c,d,e,f,g,h,j;
        for (int i = 0; i < RockList.size(); i++) {
            a = RockList.get(i).xposition - 450;
            b = RockList.get(i).yposition - 300;
            c = Math.sqrt(a * a + b * b);
            if (c < 100) {
                return false;
            }
        }
        for (int i=0; i<EnemyList.size();i++){
            d=EnemyList.get(i).xposition-450;
            e=EnemyList.get(i).yposition-300;
            f=Math.sqrt(d*d+e*e);
            if (f<100){
                return false;
            }
        }
        g=boss.xposition-450;
        h=boss.yposition-300;
        j=Math.sqrt(g*g+h*h);
        if (j<200){
            return false;
        }
        return true;
    }
public void removeOldBullets(){
    for (int i=0; i<BulletList.size();i++){
        if (BulletList.get(i).life<0){
            BulletList.remove(i);
            return;
        }
    }
    for (int i=0; i<EnemyBulletList.size();i++){
        if (EnemyBulletList.get(i).life<0){
            EnemyBulletList.remove(i);
            return;
        }
    }
}
public void removeBoss(){
    if (boss.life<0){
        boss.active=false;
            }
    if (lives<0){
            boss.active=false;
            level=0;
    }
}
public void createPowerup(){
    powerupspawn+=1;
    if (powerupspawn>(int)(Math.random()*200+500)){
        PowerupList.add(new Powerup());
        powerupspawn=0;
    }
}
public void removeOldPowerups(){
    for (int i=0; i<PowerupList.size();i++){
        if (PowerupList.get(i).active==false){
                poweruptime=400;
                for(int j=0;j<RockList.size();j++){
                    RockList.get(j).xspeed/=10;
                    RockList.get(j).yspeed/=10;
                    RockList.get(j).Rotation/=10;
                    RockList.get(j).slow=true;
                }
                for(int j=0;j<EnemyList.size();j++){
                    EnemyList.get(j).xspeed/=10;
                    EnemyList.get(j).yspeed/=10;
                    EnemyList.get(j).Rotation/=10;
                    EnemyList.get(j).slow=true;
                }
                for(int j=0;j<EnemyBulletList.size();j++){
                    EnemyBulletList.get(j).xspeed/=10;
                    EnemyBulletList.get(j).yspeed/=10;
                    EnemyBulletList.get(j).Rotation/=10;
                    EnemyBulletList.get(j).slow=true;
                }
                boss.xspeed/=10;
                boss.yspeed/=10;
                boss.slow=true;
            PowerupList.remove(i);
            return;
        }
    }
    for (int i=0; i<PowerupList.size();i++){
        if (PowerupList.get(i).life<0){
            PowerupList.remove(i);
            return;
        }
    }
}
public void removeOldDebris(){
    for (int i=0; i<DebrisList.size();i++){
        if (DebrisList.get(i).life<0){
            DebrisList.remove(i);
            return;
        }
    }
    for(int i=0;i<DebrisList.size();i++){
        if (lives<0){
            DebrisList.remove(i);
        }
}
}
public void removeRocks(){
    for(int i=0;i<RockList.size();i++){
        if (RockList.get(i).active==false){
            score+=100;
            tempscore+=100;
            if(RockList.get(i).size>1){
            RockList.add(new Rock(RockList.get(i).xposition,RockList.get(i).yposition,RockList.get(i).size-1));
            RockList.add(new Rock(RockList.get(i).xposition,RockList.get(i).yposition,RockList.get(i).size-1));
                    for (int j = 0; j < 25; j++) {
DebrisList.add(new Debris(RockList.get(i).xposition,RockList.get(i).yposition,1));
                    }
            }
            RockList.remove(i);  
        } 
    }
    for(int i=0;i<RockList.size();i++){
        if (lives<0){
            RockList.remove(i);
            level=0;
        }
    }
}
public void removeEnemy(){
    for(int i=0;i<EnemyList.size();i++){
        if (EnemyList.get(i).active==false){
            score+=500;
            tempscore+=500;
                    for (int j = 0; j < 25; j++) {
DebrisList.add(new Debris(EnemyList.get(i).xposition,EnemyList.get(i).yposition,1));
                    }
            EnemyList.remove(i);  
        }
        }
        for(int i=0;i<EnemyList.size();i++){
        if (lives<0){
            EnemyList.remove(i);
            level=0;
        }
    } 
}
public void MakeBlackhole(){
    double a,h, x, y;
        a=Math.random()*Math.PI*2;
        h=Math.random()*250+50;
        x = Math.cos(a)*h+450;
        y = Math.sin(a)*h+300;
    for (int i = 0; i < 10; i++) {
            BlackholeList.add(new Blackhole(x,y,Math.PI/10*i));
        }
}
public void AsteroidHoming(){
    double a,b,newA,xshift,yshift;
    int slowmotion=1;
    if (ship.active){
    for (int i=0; i<RockList.size();i++){
        a=ship.xposition-RockList.get(i).xposition;
    b=ship.yposition-RockList.get(i).yposition;
    newA=Math.atan((double)(-b/a));
    if (a<0){
        newA+=Math.PI;
    }
    if (RockList.get(i).slow){
        slowmotion=10;
    }
    if (RockList.get(i).slow==false){
        slowmotion=1;
    }
    xshift=Math.cos(newA)/slowmotion;
    yshift=-Math.sin(newA)/slowmotion;
    RockList.get(i).xposition+=xshift;
    RockList.get(i).yposition+=yshift;
    }
    }
}
public void BlackholeEffect(){
    double a,b,newA,xshift,yshift;
    a=BlackholeList.get(0).xposition-ship.xposition;
    b=BlackholeList.get(0).yposition-ship.yposition;
    newA=Math.atan((double)(-b/a));
    if (a<0){
        newA+=Math.PI;
    }
    xshift=Math.cos(newA)*5;
    yshift=-Math.sin(newA)*5;
    ship.xposition+=xshift;
    ship.yposition+=yshift;
    a=BlackholeList.get(0).xposition-boss.xposition;
    b=BlackholeList.get(0).yposition-boss.yposition;
    newA=Math.atan((double)(-b/a));
    if (a<0){
        newA+=Math.PI;
    }
    xshift=Math.cos(newA)*3;
    yshift=-Math.sin(newA)*3;
    boss.xposition+=xshift;
    boss.yposition+=yshift;
    for (int i=0; i<RockList.size();i++){
        a=BlackholeList.get(0).xposition-RockList.get(i).xposition;
    b=BlackholeList.get(0).yposition-RockList.get(i).yposition;
    newA=Math.atan((double)(-b/a));
    if (a<0){
        newA+=Math.PI;
    }
    xshift=Math.cos(newA)*16/RockList.get(i).size+1;
    yshift=-Math.sin(newA)*16/RockList.get(i).size+1;
    RockList.get(i).xposition+=xshift;
    RockList.get(i).yposition+=yshift;
    }
    for (int i=0; i<EnemyList.size();i++){
        a=BlackholeList.get(0).xposition-EnemyList.get(i).xposition;
    b=BlackholeList.get(0).yposition-EnemyList.get(i).yposition;
    newA=Math.atan((double)(-b/a));
    if (a<0){
        newA+=Math.PI;
    }
    xshift=Math.cos(newA)*7;
    yshift=-Math.sin(newA)*7;
    EnemyList.get(i).xposition+=xshift;
    EnemyList.get(i).yposition+=yshift;
    }
    for (int i=0; i<EnemyBulletList.size();i++){
        a=BlackholeList.get(0).xposition-EnemyBulletList.get(i).xposition;
    b=BlackholeList.get(0).yposition-EnemyBulletList.get(i).yposition;
    newA=Math.atan((double)(-b/a));
    if (a<0){
        newA+=Math.PI;
    }
    xshift=Math.cos(newA)*10;
    yshift=-Math.sin(newA)*10;
    EnemyBulletList.get(i).xposition+=xshift;
    EnemyBulletList.get(i).yposition+=yshift;
    }
    for (int i=0; i<BulletList.size();i++){
        a=BlackholeList.get(0).xposition-BulletList.get(i).xposition;
    b=BlackholeList.get(0).yposition-BulletList.get(i).yposition;
    newA=Math.atan((double)(-b/a));
    if (a<0){
        newA+=Math.PI;
    }
    xshift=Math.cos(newA)*10;
    yshift=-Math.sin(newA)*10;
    BulletList.get(i).xposition+=xshift;
    BulletList.get(i).yposition+=yshift;
    }
    for (int i=0; i<PowerupList.size();i++){
        a=BlackholeList.get(0).xposition-PowerupList.get(i).xposition;
    b=BlackholeList.get(0).yposition-PowerupList.get(i).yposition;
    newA=Math.atan((double)(-b/a));
    if (a<0){
        newA+=Math.PI;
    }
    xshift=Math.cos(newA)*6;
    yshift=-Math.sin(newA)*6;
    PowerupList.get(i).xposition+=xshift;
    PowerupList.get(i).yposition+=yshift;
    }
}
    @Override
    public void actionPerformed(ActionEvent e) {
         //if(System.currentTimeMillis()>fpsCount){
           // fpsCount+=System.currentTimeMillis()+(1000/60);
        for (int i = 0; i < RockList.size(); i++) {
            RockList.get(i).updatePosition();
        }
        for (int i = 0; i < BulletList.size(); i++) {
            BulletList.get(i).updatePosition();
        }
        for (int i=0;i<DebrisList.size();i++){
            DebrisList.get(i).updatePosition();
        }
        for (int i=0;i<PowerupList.size();i++){
            PowerupList.get(i).updatePosition();
        }
        for (int i=0;i<EnemyList.size();i++){
            EnemyList.get(i).updatePosition();
        }
        for (int i=0;i<EnemyBulletList.size();i++){
            EnemyBulletList.get(i).updatePosition();
        }
        for (int i=0;i<BlackholeList.size();i++){
            BlackholeList.get(i).updatePosition();
        }
        ship.updatePosition();
        boss.updatePosition();
        removeOldBullets();
        removeRocks();
        removeOldDebris();
        createPowerup();
        removeOldPowerups();
        removeEnemy();
        removeBoss();
        checkCollision();
        for (int i=0;i<EnemyList.size();i++){
            if (EnemyList.get(i).cooldown<0){
                if (EnemyList.get(i).slow==false){
                EnemyList.get(i).cooldown=125;
                }
                if (EnemyList.get(i).slow){
                    EnemyList.get(i).cooldown=250;
                }
                EnemyBulletList.add(new Bullet(EnemyList.get(i).xposition,EnemyList.get(i).yposition,EnemyList.get(i).angle));
                elaser.play();
                }
        }
        if (boss.cooldown<0&&boss.active){
            if (boss.slow==false){
                boss.cooldown=75;
            }
            if (boss.slow){
                boss.cooldown=150;
            }
            EnemyBulletList.add(new Bullet(boss.xposition,boss.yposition,boss.angle));
            EnemyBulletList.add(new Bullet(boss.xposition,boss.yposition,boss.angle-0.5));
            EnemyBulletList.add(new Bullet(boss.xposition,boss.yposition,boss.angle+0.5));
            elaser.play();
        }
        poweruptime--;
        if(poweruptime==0){
            for(int j=0;j<RockList.size();j++){
                if (RockList.get(j).slow==true){
                    RockList.get(j).xspeed*=10;
                    RockList.get(j).yspeed*=10;
                    RockList.get(j).Rotation*=10;
                    RockList.get(j).slow=false;
                }
                }
            for(int j=0;j<EnemyList.size();j++){
                if (EnemyList.get(j).slow==true){
                    EnemyList.get(j).xspeed*=10;
                    EnemyList.get(j).yspeed*=10;
                    EnemyList.get(j).Rotation*=10;
                    EnemyList.get(j).slow=false;
                }
                }
            for(int j=0;j<EnemyBulletList.size();j++){
                if (EnemyBulletList.get(j).slow==true){
                    EnemyBulletList.get(j).xspeed*=10;
                    EnemyBulletList.get(j).yspeed*=10;
                    EnemyBulletList.get(j).Rotation*=10;
                    EnemyBulletList.get(j).slow=false;
                }
                }
            if (boss.slow==true){
                boss.xspeed*=10;
                boss.yspeed*=10;
                boss.slow=false;
            }
        }
        AsteroidHoming();
        if (!BlackholeList.isEmpty()){
        BlackholeEffect();
        }
        if (ship.active){
        if (!RockList.isEmpty()){
        BHCounter--;
        }
        if (!EnemyList.isEmpty()&&RockList.isEmpty()){
            BHCounter--;
        }
        if (boss.active&&EnemyList.isEmpty()&&RockList.isEmpty()){
            BHCounter--;
        }
        }
        if(BHCounter<0){
            BHCounter=(int)Math.random()*100+300;
            BlackholeList.clear();
            MakeBlackhole();
        //} else if (BHCounter<100){
        //    MakeBlackhole();
        } 
        if (tempscore>100000){
            tempscore-=100000;
            lives+=1;
        } 
        keyCheck();
        restartShip();
        //repaint();
        // }
    }
}