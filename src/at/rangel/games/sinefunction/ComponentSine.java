package at.rangel.games.sinefunction.assets;

import at.rangel.games.sinefunction.Actor;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class ComponentSine implements Actor {
    public float x, y;
    public int width, height;

    public ComponentSine() {
        this.x = x;
        this.y = y;
    }

    @Override
    public void render(Graphics graphics) {
        graphics.fillOval(this.x, this.y, 10, 10);
    }

    @Override
    public void update(GameContainer gameContainer, int delta) {
        this.x += 1;
    }
}
