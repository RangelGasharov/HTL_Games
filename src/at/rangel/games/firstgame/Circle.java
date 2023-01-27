package at.rangel.games.firstgame;

import org.newdawn.slick.Graphics;

import java.util.Random;

public class Circle {
    private float x, y;
    private float speed;
    private int diameter;

    public Circle() {
        Random random = new Random();
        this.x = random.nextInt(800);
        this.y = random.nextInt(600);
        this.speed = random.nextInt(30) + 5;
        this.diameter = random.nextInt(10) + 10;
    }

    public void render(Graphics graphics) {
        graphics.drawOval(this.x, this.y, this.diameter, this.diameter);
    }

    public void update(int delta) {
        this.y += (float) delta / this.speed;
        if (this.y > 600) {
            this.y = 0;
        }
    }
}
