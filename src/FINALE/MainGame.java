package FINALE;

import org.newdawn.slick.*;
import org.newdawn.slick.state.StateBasedGame;

public class MainGame extends StateBasedGame {

    public MainGame(String title) {
        super(title);
    }

    public void initStatesList(GameContainer gc) throws SlickException {
        //list other screens in here - first one is opening screen
        this.addState(new Ship());
        this.addState(new Computer());
        this.addState(new Wires());
       

    }

    public static void main(String args[]) throws SlickException {
        MainGame game = new MainGame("Repair the Spaceship!");
        AppGameContainer app = new AppGameContainer(game);
        app.setDisplayMode(1600,600,false);
        app.setShowFPS(false);
        app.setTargetFrameRate(100);
        app.start();
        
    }

}
