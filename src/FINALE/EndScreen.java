package FINALE;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class EndScreen extends BasicGameState {


    Image bg;
 
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        
        bg = new Image("images/youdidit.png");
    
    }

    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
       
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        
        bg.draw();
    }
    public int getID() {
        return 4;  //this id will be different for each screen
    }

}
