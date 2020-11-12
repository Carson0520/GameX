package MyGameTests;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

/**
 *
 * @author cars0520
 */
public class Person {
    private Image img;
    private Rectangle hitbox;
    private int Xdir;
    
    public Person(int x, int y) throws SlickException{
        img = new Image("images/character.png");
        hitbox = new Rectangle(x,y,img.getWidth(),25);
    }
    
    public Rectangle getHitBox(){
        return hitbox;
    }
    
    public void draw(){
        img.draw(hitbox.getX(),hitbox.getY());
    }
    
}
