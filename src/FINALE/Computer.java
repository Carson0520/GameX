package FINALE;

import MyGame.Asteroids;
import java.util.ArrayList;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

public class Computer extends BasicGameState {

    ArrayList<Asteroids> rocks;
    int counter;
    int timer, timer2;
    Image bg, reticle;
    int cx, cy;
    Shape s1, s2;
    String str = "ALL 30! GOOD JOB!";
    public Rectangle reticlehb;
    boolean allgood=false;

    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        bg = new Image("images/weaponsbg.png");

        rocks = new ArrayList();
        timer = 0;
        timer2 = 0;
        Asteroids.setGameSize(800, 600);
        reticle = new Image("images/cursor3.png");
        s1 = new Circle(100, 500, 100, 100);
        s2 = new Rectangle(cx, cy, reticle.getWidth() - 50, reticle.getHeight() - 50);

        int ry = (int) (Math.random() * 550);
        rocks.add(new Asteroids(830, ry));

    }

    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
        Input in = gc.getInput();
        int mx = gc.getInput().getMouseX();
        int my = gc.getInput().getMouseY();

        cx = mx;
        cy = my;

        s2.setX(cx - 25);
        s2.setY(cy - 25);

        for (Asteroids a : rocks) {
            a.move();
        }

        for (Asteroids a : rocks) {
            if (a.hit(mx, my) && s2.intersects(a.getHitBox()) && in.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
                rocks.remove(a);
                counter++;
                break;
            } else if (counter >= 30) {
                break;
            }
        }
        if (rocks.size() >= 0 && counter < 30) {
            timer++;
            timer2++;

            int q = (int) (Math.random() * 80 + 1);
            int ry = (int) (Math.random() * 500 + 45);
            if (q == 60) {
                rocks.add(new Asteroids(830, ry));
            }
        }
        if (counter >= 30) {
            if (s1.contains(mx, my) && in.isMousePressed(Input.MOUSE_LEFT_BUTTON)) //change screen to walking guy
            {
                System.out.println("compgood");
                allgood=true;
                sbg.enterState(1,new FadeOutTransition(), new FadeInTransition());
                
               // System.out.println("WOKRING");
                //get  rid of rocks remaining
                //set boundry
                //time not neccessary
            }
            return;
        }
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        //  gc.setFullscreen(true);
                
        bg.draw();
        g.setColor(Color.red);
        reticle.draw(cx - 50, cy - 50);
        g.fill(new Rectangle(0, 0, 800, 40));
        if (counter != 30) {
            for (Asteroids a : rocks) {

                a.draw();
                reticle.draw(cx - 50, cy - 50);
                g.draw(s2);
            }
        }/* else if (counter != 30) {
            g.drawString(str, 485, 10);
            return;
        }*/
        g.setColor(Color.yellow);
        g.drawString("Time: " + (double) timer2 / 100, 10, 10);
        g.drawString("Score: " + counter, 400, 10);
        if (counter >= 30) {
            g.setColor(Color.red);
            g.fill(new Rectangle(0, 0, 800, 40));
            g.setColor(Color.yellow);
            g.drawString(str, 485, 10);
            g.fill(s1);
            g.setColor(Color.red);
            g.drawString("BACK", 70, 580);
        }
    }

    public int getID() {
        return 2;  //this id will be different for each screen
    }

}
