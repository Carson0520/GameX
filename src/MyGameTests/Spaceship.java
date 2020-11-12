package MyGameTests;

import org.newdawn.slick.*;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

public class Spaceship extends BasicGame {

    Image bg, character;
    Shape s1;
    int cx = 100, cy = 350;
    int GAME_WIDTH, GAME_HEIGHT;
    Rectangle tp, rt, bt, lt;
    Rectangle hitBox, computer, brainbox,electrical;

    public Spaceship(String title) {
        super(title);
    }

    public void init(GameContainer gc) throws SlickException {
        bg = new Image("images/spacebg.png");
        s1 = new Circle(cx, cy, 100, 100);
        tp = new Rectangle(0, 350, 1607, 3);
        rt = new Rectangle(1607, 350, 3, 597);
        bt = new Rectangle(0, 597, 1607, 3);
        lt = new Rectangle(0, 350, 3, 597);
        character = new Image("images/character.png");

    }

    public void update(GameContainer gc, int i) throws SlickException {
        bg = new Image("images/spacebg.png");
        Input in = gc.getInput();
        int mx = gc.getInput().getMouseX();
        int my = gc.getInput().getMouseY();

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
           if (in.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
            //   System.out.println("x,"+cx+" y,"+cy);
            System.out.println("x, " + gc.getInput().getMouseX() + " y, " + gc.getInput().getMouseY());
        }

        if (computer.contains(mx, my) && computer.intersects(brainbox) && in.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
            //change game state //working
        }
        ///////////////////////////////////////////////////////////////////////////
/*        if (electrical.contains(mx, my) && electrical.intersects(brainbox) && in.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
            //change game state //working
        }*/
    }

    public void render(GameContainer gc, Graphics g) throws SlickException {
        bg.draw();
        g.setColor(Color.yellow);
        g.fill(s1);
        g.setColor(Color.red);
        character.draw(cx, cy, 178, 200);
        hitBox = new Rectangle(cx + (75 + (25 / 2)), cy + (150 + (25 / 2) - 50), 100 - 75, 75);
        g.setColor(Color.blue);
        computer = new Rectangle(1154, 71, 334, 271);
        g.fill(computer);
        g.fill(hitBox);
        g.setColor(Color.pink);
        brainbox = new Rectangle(cx + (75 + (25 / 2)), cy + 40, 25, 25);
        g.fill(brainbox);
        //border
        g.fill(tp);
        g.fill(bt);
        g.fill(rt);
        g.fill(lt);
    }

    public static void main(String args[]) throws SlickException {
        Spaceship game = new Spaceship("Testing Game");
        AppGameContainer app = new AppGameContainer(game);
        app.setDisplayMode(1610, 600, false);
        app.setShowFPS(false);
        app.setTargetFrameRate(100);
        app.start();
    }

}
