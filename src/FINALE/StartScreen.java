package FINALE;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

public class StartScreen extends BasicGameState {

    Image bg;

    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {

        bg = new Image("images/titleScreen.png");
       

    }

    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
        Input in = gc.getInput();
        if (in.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
            sbg.enterState(1, new FadeOutTransition(), new FadeInTransition());
            MainGame.setGameSize(1600, 600);
        }
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {

        bg.draw();
    }

    public int getID() {
        return 0;  //this id will be different for each screen
    }

}
