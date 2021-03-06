package Level;

import GameObject.Frame;
import GameObject.ImageEffect;
import GameObject.Rectangle;
import GameObject.SpriteSheet;

import java.awt.image.BufferedImage;
import java.util.HashMap;

// This class is a base class for all enemies in the game -- all enemies should extend from it
public class Enemy extends MapEntity {

    public Enemy(float x, float y, SpriteSheet spriteSheet, String startingAnimation) {
        super(x, y, spriteSheet, startingAnimation, null);
    }

    public Enemy(float x, float y, HashMap<String, Frame[]> animations, String startingAnimation) {
        super(x, y, animations, startingAnimation, null);
    }

    public Enemy(BufferedImage image, float x, float y, String startingAnimation) {
        super(image, x, y, startingAnimation, null);
    }

    public Enemy(BufferedImage image, float x, float y) {
        super(image, x, y, null);
    }

    public Enemy(BufferedImage image, float x, float y, float scale) {
        super(image, x, y, scale, null);
    }

    public Enemy(BufferedImage image, float x, float y, float scale, ImageEffect imageEffect) {
        super(image, x, y, scale, imageEffect, null);
    }

    public Enemy(BufferedImage image, float x, float y, float scale, ImageEffect imageEffect, Rectangle bounds) {
        super(image, x, y, scale, imageEffect, bounds, null);
    }

    @Override
    public void initialize() {
        super.initialize();
    }

    public void update(Player player) {
        super.update();
        if (intersects(player)) {
            touchedPlayer(player);
        }
    }

    // A subclass can override this method to specify what it does when it touches the player
    	public void touchedPlayer(Player player) {
    	if(getTileType()==TileType.KILLER) {
    		player.hurtPlayer(this);
    	}else {
    		player.hurtPlayer(this);
    	}
    }
}
