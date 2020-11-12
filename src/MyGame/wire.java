package MyGame;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

/**
 *
 * @author cars0520
 */
public class wire {

    private Image img;
    private Rectangle hitbox, redwire, bluewire, yellowwire, whitewire;
    private int rwx = 145, rwy = 146;
    private int bwx = 142, bwy = 229;
    private int ywx = 140, ywy = 307;
    private int wwx = 139, wwy = 389;

    public wire(int x, int y) throws SlickException {

    }

    public wire(int x, int y, int i, int i0) {
        hitbox = new Rectangle(x, y, 25, 25);
        redwire = new Rectangle(rwx, rwy, 15, 15);
        bluewire = new Rectangle(bwx, bwy, 50, 15);
        yellowwire = new Rectangle(ywx, ywy, 50, 15);
        whitewire = new Rectangle(wwx, wwy, 50, 15);
    }

    public Rectangle redwire() {
        return redwire;
    }

    public Rectangle bluewire() {
        return redwire;
    }

    public Rectangle yellowwire() {
        return redwire;
    }

    public Rectangle whitewire() {
        return redwire;
    }

    public int getRedX() {
        return rwx;
    }

    public int getRedY() {
        return rwy;
    }

    public int getBlueX() {
        return bwx;
    }

    public int getBlueY() {
        return bwy;
    }

    public int getYellowX() {
        return ywx;
    }

    public int getYellowY() {
        return ywy;
    }

    public int getWhiteX() {
        return wwx;
    }

    public int getWhiteY() {
        return wwy;
    }

    public Rectangle getHitBox() {
        return hitbox;
    }

    public boolean hit(int x, int y) {
        if (hitbox.contains(x, y)) {
            return true;
        } else {
            return false;
        }
    }

}
