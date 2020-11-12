/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyGameTests;

import org.newdawn.slick.*;
import org.newdawn.slick.geom.*;

/**
 *
 * @author cars0520
 */
public class Asteroids {

    private Image img;
    
    Rectangle hitbox;
    private int Xdir, Ydir;

    private static int GAME_WIDTH, GAME_HEIGHT;

    public Asteroids(int x, int y) throws SlickException {
        img = new Image("images/astroid.png");
        hitbox = new Rectangle(x, y, img.getWidth(), img.getHeight());

        while (true) {
            //  Xdir = (int) (Math.random() * 7 - 3);
            Xdir = (int) (Math.random() * (-7)) + (-1);
            Ydir = (int) (Math.random() * 7 - 3);
            if (Xdir != 0 && Ydir != 0) {
                break;
            }
        }
    }
  

    public Rectangle getHitBox() {
        return hitbox;
    }

    public static void setGameSize(int x, int y) {
        GAME_WIDTH = x;
        GAME_HEIGHT = y;
    }

    public boolean hit(int x, int y) {
        if (hitbox.contains(x, y)) {
            return true;
        } else {
            return false;
        }
    }
    public void move() {
        hitbox.setX(hitbox.getX() + Xdir);
        hitbox.setY(hitbox.getY() + Ydir);

        //bounce when we hit a side
        //except there is no bouncing in this game soooo 
        /* if (hitbox.getX() <= 40 || hitbox.getX() > GAME_WIDTH - img.getWidth()) {
            Xdir = -Xdir;
        }*/
        if (hitbox.getY() <= 40 || hitbox.getY() > GAME_HEIGHT - img.getHeight()) {
            Ydir = -Ydir;
        }
    }

    public void draw() {
        img.draw(hitbox.getX(), hitbox.getY());
    }
}
