package FINALE;

import org.newdawn.slick.*;
import org.newdawn.slick.state.StateBasedGame;

public class MainGame extends StateBasedGame {
    
     static AppGameContainer app;

    public MainGame(String title) {
        super(title);
    }

    public void initStatesList(GameContainer gc) throws SlickException {
        //list other screens in here - first one is opening screen
        this.addState(new StartScreen());
        this.addState(new Ship());
        this.addState(new Computer());
        this.addState(new Wires());
        this.addState(new EndScreen());
       

    }
    
    public static void setGameSize(int x, int y)throws SlickException{
     app.setDisplayMode(x, y, false);
    }

    public static void main(String args[]) throws SlickException {
        MainGame game = new MainGame("Repair the Spaceship!");
        app = new AppGameContainer(game);
        app.setDisplayMode(800,600,false);
        app.setShowFPS(false);
        app.setTargetFrameRate(100);
        app.start();
        
    }

}
