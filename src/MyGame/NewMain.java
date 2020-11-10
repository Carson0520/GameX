package MyGame;

import java.util.ArrayList;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

/**
 *
 * @author cars0520
 */
public class NewMain extends BasicGame {

    ArrayList<Asteroids> rocks;
    int counter;
    int timer, timer2;
    Image bg, reticle;
    int cx,cy;
    Shape s1;

    public NewMain(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gc) throws SlickException {
        bg = new Image("images/weaponsbg.png");
        rocks = new ArrayList();
        timer = 0;
        timer2 = 0;
        Asteroids.setGameSize(800, 600);
        s1= new Circle (cx,cy,25,25);
        reticle = new Image ("images/cursor3.png");
    }

    @Override
    public void update(GameContainer gc, int i) throws SlickException {
        Input in = gc.getInput();
        int mx = gc.getInput().getMouseX();
        int my = gc.getInput().getMouseY();
        
        cx=mx;
        cy=my;
        
        s1.setX(cx);
        s1.setY(cy);

        for (Asteroids a : rocks) {
            a.move();
        }

        for (Asteroids a : rocks) {
            if (a.hit(mx, my) && in.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
                rocks.remove(a);
                break;
            }
        }
        if (rocks.size() > 0) {
            timer++;
            timer2++;

            //add new asteroid every 5 seconds            
            if (timer == 500) {
                timer = 0;
                int rx = (int) (Math.random() * 750);
                int ry = (int) (Math.random() * 500 + 45);
                rocks.add(new Asteroids(rx, ry));
            }
        }
    }

    @Override
    public void render(GameContainer gc, Graphics g) throws SlickException {
        bg.draw();
        g.setColor(Color.yellow);
        g.fill(s1);
        reticle.draw(cx,cy);
        g.fill(new Rectangle(0, 0, 800, 40));
        for (Asteroids a : rocks) {
            a.draw();
        }
        g.setColor(Color.yellow);
        g.drawString("Time: " + (double) timer2 / 100, 10, 10);
        g.drawString("Rocks Remaining: " + rocks.size(), 620, 10);
    }

    public static void main(String args[]) throws SlickException {
        NewMain game = new NewMain("Testing Game");
        AppGameContainer app = new AppGameContainer(game);
        app.setDisplayMode(800, 600, false);
        app.setShowFPS(false);
        app.setTargetFrameRate(100);
        app.start();
    }

}
