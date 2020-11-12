package FINALE;

import org.newdawn.slick.AppGameContainer;
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

public class Ship extends BasicGameState {

    Wires w = new Wires();
    Computer c = new Computer();
    boolean allgood = false;
    Image bg, character;
    Shape s1;
    int cx = 100, cy = 350;
    int GAME_WIDTH, GAME_HEIGHT;
    Rectangle tp, rt, bt, lt;
    Rectangle hitBox, computer, brainbox, electrical;

    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        bg = new Image("images/spacebg.png");
        s1 = new Circle(1480, 460, 100, 100);
        tp = new Rectangle(0, 350, 1607, 3);
        rt = new Rectangle(1607, 350, 3, 597);
        bt = new Rectangle(0, 597, 1607, 3);
        lt = new Rectangle(0, 350, 3, 597);
        character = new Image("images/character.png");

        w.allgood = false;
        c.allgood = false;

    }

    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
        bg = new Image("images/spacebg.png");
        Input in = gc.getInput();
        int mx = gc.getInput().getMouseX();
        int my = gc.getInput().getMouseY();

        if (in.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
            System.out.println("x, " + gc.getInput().getMouseX() + " y, " + gc.getInput().getMouseY());
        }

        if (in.isKeyDown(Input.KEY_W)) {
            cy -= 3;
            if (hitBox.intersects(tp)) {
                cy += 3;
            }
        }
        if (in.isKeyDown(Input.KEY_A)) {
            cx -= 3;
            if (hitBox.intersects(lt)) {
                cx += 3;
            }
        }
        if (in.isKeyDown(Input.KEY_S)) {
            cy += 3;
            if (hitBox.intersects(bt)) {
                cy -= 3;
            }
        }
        if (in.isKeyDown(Input.KEY_D)) {
            cx += 3;
            if (hitBox.intersects(rt)) {
                cx -= 3;
            }
        }
        /*   if (in.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
            //   System.out.println("x,"+cx+" y,"+cy);
            System.out.println("x, " + gc.getInput().getMouseX() + " y, " + gc.getInput().getMouseY());
        }*/

        if (computer.contains(mx, my) && computer.intersects(brainbox) && in.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
            //change game state //working
            Graphics g = new Graphics();
            sbg.enterState(2, new FadeOutTransition(), new FadeInTransition());
            MainGame.setGameSize(800, 600);

        }
        if (electrical.contains(mx, my) && electrical.intersects(brainbox) && in.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
            //change game state 
            Graphics g = new Graphics();
            sbg.enterState(3, new FadeOutTransition(), new FadeInTransition());
            MainGame.setGameSize(800, 600);

        }
        if (w.allgood == true && c.allgood == true) {
            allgood = true;

            /*      if (s1.contains(gc.getInput().getMouseX(), gc.getInput().getMouseY()) && in.isMousePressed(Input.MOUSE_LEFT_BUTTON)) //change screen to walking guy
            {
                System.out.println("workign");
            }*/
        }
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        Input in = gc.getInput();

        bg.draw();
        g.setColor(Color.yellow);
        g.setColor(Color.red);
        character.draw(cx, cy, 178, 200);
        hitBox = new Rectangle(cx + (75 + (25 / 2)), cy + (150 + (25 / 2) - 50), 100 - 75, 75);
        g.setColor(Color.blue);
        computer = new Rectangle(1154, 71, 334, 271);
        electrical = new Rectangle(390, 79, 312, 284);
        //   g.fill(computer);
        //   g.fill(electrical);
        //   g.fill(hitBox);
        g.setColor(Color.pink);
        brainbox = new Rectangle(cx + (75 + (25 / 2)), cy + 40, 25, 25);
        //    g.fill(brainbox);
        //border
        g.setColor(Color.black);
        // g.fill(tp);
        g.fill(bt);
        g.fill(rt);
        g.fill(lt);
        drawfinal(g);
        if (computer.contains(gc.getInput().getMouseX(), gc.getInput().getMouseY()) && computer.intersects(brainbox) && in.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {

            sbg.enterState(2, new FadeOutTransition(), new FadeInTransition());

            System.out.println("YES!");
        }
        if (electrical.contains(gc.getInput().getMouseX(), gc.getInput().getMouseY()) && electrical.intersects(brainbox) && in.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {

            g.drawString("go to the Computer!", 250, 50);
            sbg.enterState(3, new FadeOutTransition(), new FadeInTransition());
        }

    }

    public int getID() {
        return 1;  //this id will be different for each screen
    }

    private void drawfinal(Graphics g) {
        if (allgood == true) {
            System.out.println("hear ya");
            s1 = new Circle(1480, 460, 100, 100);
            g.fill(s1);
            g.setColor(Color.red);
            g.drawString("HERE TO WIN!", 1400, 460);
        }
    }

}
