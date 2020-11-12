package FINALE;

import MyGameTests.wire;
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

public class Wires extends BasicGameState {

    ArrayList<wire> wires;
    Image bg;
    int cx, cy;
    int nx, ny;
    Shape redw, bluew, yelloww, whitew;
    Circle s1, s4;
    /*red*/ Rectangle rstartbox, rextend, rendbox;
    /*blue*/ Rectangle bstartbox, bextend, bendbox;
    /*yellow*/ Rectangle ystartbox, yextend, yendbox;
    /*white*/ Rectangle wstartbox, wextend, wendbox;
    boolean keepr, keepb, keepy, keepw, allgood = false;
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        wires = new ArrayList();
        bg = new Image("images/wires.png");
        s4 = new Circle(90, 500, 50, 50);

        redw = new Rectangle(145, 146, 15, 15);
        rstartbox = new Rectangle(145 - 5, 146 - 5, 25, 25);
        rendbox = new Rectangle(640 - 5, 146 - 5, 25, 25);

        bstartbox = new Rectangle(145 - 5, 235 - 5, 25, 25);
        bendbox = new Rectangle(640 - 5, 235 - 5, 25, 25);

        ystartbox = new Rectangle(145 - 5, 308 - 5, 25, 25);
        yendbox = new Rectangle(640 - 5, 308 - 5, 25, 25);

        wstartbox = new Rectangle(145 - 5, 393 - 5, 25, 25);
        wendbox = new Rectangle(640 - 5, 393 - 5, 25, 25);
    }

    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
        Input in = gc.getInput();
        int mx = gc.getInput().getMouseX();
        int my = gc.getInput().getMouseY();

        /*if (in.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
            System.out.println("x, " + gc.getInput().getMouseX() + " y, " + gc.getInput().getMouseY());
        }*/
        
        if (rstartbox.contains(mx, my) && in.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {

            //   System.out.println("working");
        }
        if (bstartbox.contains(mx, my) && in.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {

            //   System.out.println("working");
        }
        if (ystartbox.contains(mx, my) && in.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {

            //   System.out.println("working");
        }
        if (wstartbox.contains(mx, my) && in.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {

            //   System.out.println("working");
        }
        //if all  wires green for next
        if (allgood == true) {
            allgood=true;
            System.out.println("wiregood");
            if (s4.contains(mx, my) && in.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
                //  System.out.println("work");
                sbg.enterState(4,new FadeOutTransition(), new FadeInTransition());
            }
        }
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        Input in = gc.getInput();
        bg.draw();

        g.setColor(Color.red);
        //   g.fill(w.redwire());
        g.fill(redw);
        /*   g.setColor(Color.blue);
        g.fill(w.bluewire());
        g.setColor(Color.yellow);
        g.fill(w.yellowwire());
        g.setColor(Color.white);
        g.fill(w.whitewire());*/
        g.fill(rstartbox);
        g.fill(rendbox);
        g.setColor(Color.blue);
        g.fill(bstartbox);
        g.fill(bendbox);
        g.setColor(Color.yellow);
        g.fill(ystartbox);
        g.fill(yendbox);
        g.setColor(Color.white);
        g.fill(wstartbox);
        g.fill(wendbox);

        for (wire w : wires) {
            w.getHitBox();
            g.fill(w.getHitBox());
        }
        if (rstartbox.contains(gc.getInput().getMouseX(), gc.getInput().getMouseY()) && in.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
            rextend = new Rectangle(145, 146, 512, 15);
            g.fill(rextend);
            if (rendbox.intersects(rextend)) {
                System.out.println("yup");
                keepr = true;
                g.fill(rextend);

            }
        }
        if (bstartbox.contains(gc.getInput().getMouseX(), gc.getInput().getMouseY()) && in.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
            bextend = new Rectangle(145, 235, 512, 15);
            g.fill(bextend);
            if (bendbox.intersects(bextend)) {
                System.out.println("yup");
                keepb = true;
                g.fill(bextend);

            }
        }
        if (ystartbox.contains(gc.getInput().getMouseX(), gc.getInput().getMouseY()) && in.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
            yextend = new Rectangle(145, 308, 512, 15);
            g.fill(yextend);
            if (yendbox.intersects(yextend)) {
                System.out.println("yup");
                keepy = true;
                g.fill(yextend);

            }
        }
        if (wstartbox.contains(gc.getInput().getMouseX(), gc.getInput().getMouseY()) && in.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
            wextend = new Rectangle(145, 393, 512, 15);
            g.fill(wextend);
            if (wendbox.intersects(wextend)) {
                System.out.println("yup");
                keepw = true;
                g.fill(wextend);

            }
        }
        keepr(g);
        keepb(g);
        keepy(g);
        keepw(g);

        g.setColor(Color.black);
        Circle s2 = new Circle(705, 500, 55, 55);
        Circle s3 = new Circle(90, 500, 55, 55);
        g.fill(s2);
        g.fill(s3);

        if (keepr == true && keepb == true && keepy == true && keepw == true) {
            allgood = true;
            g.setColor(Color.green);
            s1 = new Circle(705, 500, 50, 50);
            g.fill(s1);
            g.setColor(Color.yellow);
            s4 = new Circle(90, 500, 50, 50);
            g.fill(s4);
            g.setColor(Color.red);
            g.drawString("Back", 75, 500);
        } else {
            g.setColor(Color.red);
            s1 = new Circle(705, 500, 50, 50);
            g.fill(s1);
        }
    }

    public void keepr(Graphics g) {
        if (keepr == true) {
            g.setColor(Color.red);
            g.fill(rextend);
        }
    }

    public void keepb(Graphics g) {
        if (keepb == true) {
            g.setColor(Color.blue);
            g.fill(bextend);
        }
    }

    public void keepy(Graphics g) {
        if (keepy == true) {
            g.setColor(Color.yellow);
            g.fill(yextend);
        }
    }

    public void keepw(Graphics g) {
        if (keepw == true) {
            g.setColor(Color.white);
            g.fill(wextend);
        }
    }

    public int getID() {
        return 3;  //this id will be different for each screen
    }

}
