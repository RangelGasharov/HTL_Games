package at.rangel.games.owngame;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

import java.util.Random;

public class Enemy implements Actor {

    private float x, y;
    private float speed;
    private float diameter;

    public Enemy() {
        Random random = new Random();
        this.x = random.nextInt(1600);
        this.y = random.nextInt(900);
        this.speed = random.nextInt();
        this.diameter = 30;
    }

    public void render(Graphics graphics) {
        graphics.drawOval(this.x, this.y, this.diameter, this.diameter);
    }

    public void update(GameContainer gameContainer, int delta) {
        this.y += (float) delta / this.speed;
        if (this.y > gameContainer.getHeight()) {
            this.y = 0;
        }

        if (this.y < 0) {
            this.y = 0;
        }
    }
}
