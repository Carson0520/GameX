package statebasedGame;

import defaultPackage.Astroid;
import java.util.ArrayList;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.*;
import org.newdawn.slick.state.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

public class mainGame extends BasicGameState {
    ArrayList<Astroid> rocks;
    int timer;
    int timer2;
    Color darkGreen;
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        rocks = new ArrayList();
        timer = 0;
        timer2 = 0;
        Astroid.setGameSize(800, 600);
        //get 10 asteroids
        for (int i = 0; i < 10; i++) {
            int rx = (int) (Math.random() * 750);
            int ry = (int) (Math.random() * 550);
            rocks.add(new Astroid(rx, ry));
        }
    }
    

    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
        Input in = gc.getInput();
        int mx = gc.getInput().getMouseX();
        int my = gc.getInput().getMouseY();

        for (Astroid a : rocks) {
            a.move();
        }

        for (Astroid a : rocks) {
            if (a.hit(mx, my)
                    && in.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)
                    && a.isChosen()) {
                rocks.remove(a);
                break;
            }
        }
        if (rocks.size() > 0) {
            rocks.get(0).setChosen();
            timer++;
            timer2++;

            timer++;
            if (timer == 500) {
                timer = 0;
                int rx = (int) (Math.random() * 750);
                int ry = (int) (Math.random() * 500 + 45);
                rocks.add(new Astroid(rx, ry));
            }
            else {
            sbg.enterState(2, new FadeOutTransition(), new FadeInTransition());
        }
        }
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        g.setColor(darkGreen);
        g.fill(new Rectangle(0,0,800,40));
        g.setColor(Color.red);
        for (Astroid a : rocks) {
            if (a.isChosen()) {
                g.fill(a.getHitBox());
            }
            a.draw();
        }
        g.setColor(Color.yellow);
        g.drawString("Time: " + (double) timer2 / 100, 10, 10);
        g.drawString("Rocks Remaining: " + rocks.size(),620,10);
    }

    public int getID() {
        return 1;  //this id will be different for each screen
    }

}
