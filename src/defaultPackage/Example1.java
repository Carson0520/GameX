package defaultPackage;


import org.newdawn.slick.*;
import org.newdawn.slick.geom.*;

public class Example1 extends BasicGame {

    Shape s1, s2;
    Color boxColor;
    int cx = 20, cy = 20;
    Image rock;
    Rectangle hitBox;


    public Example1(String title) {
        super(title);
    }

    public void init(GameContainer gc) throws SlickException {
        s1 = new Circle(cx, cy, 20);
        s2 = new Rectangle(100, 300, 200, 75);
        boxColor = Color.red;
        rock = new Image("images/astroid.png");
        hitBox = new Rectangle(300,200,rock.getWidth(),rock.getHeight());

        
    }

    public void update(GameContainer gc, int i) throws SlickException {
        //this is where we change drawing
        Input in = gc.getInput();

        if (in.isKeyDown(Input.KEY_D)) {
            cx+=3;
        }
        if (in.isKeyDown(Input.KEY_A)) {
            cx-=3;
        }
        if (in.isKeyDown(Input.KEY_W)) {
            cy-=3;
        }
        if (in.isKeyDown(Input.KEY_S)) {
            cy+=3;
        }
        
        //read mouse x/y
        int mx = in.getMouseX();
        int my = in.getMouseY();
        
        if(in.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)){
            if(hitBox.contains(mx,my)){ // clicking the yellow ball
                cx=(int)(Math.random() * 700 + 50);
                cy=(int)(Math.random() * 500 + 50);
        }
        }

        s1.setX(cx);
        s1.setY(cy);
        
        //collision detection
        if (s2.intersects(s1)){
            boxColor = Color.green;
        }
        else{
            boxColor = Color.red;
        }
    
    }

    public void render(GameContainer gc, Graphics g) throws SlickException {
        //this is where we draw
        g.setColor(boxColor);
        g.fill(s2);

        g.setColor(Color.yellow);
        g.fill(s1);
        
        g.fill(hitBox);

        
        rock.draw(300,200);

    }

    public static void main(String args[]) throws SlickException {
        Example1 game = new Example1("Testing Game");
        AppGameContainer app = new AppGameContainer(game);
        app.setDisplayMode(800, 600, false);
        app.setShowFPS(false);
        app.setTargetFrameRate(100);
        app.start();
    }

}
