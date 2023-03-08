package at.rangel.games.owngame;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class Weapon implements Actor {
    private float x, y;
    private double speedOfWeaponCharge = 1;

    public Weapon(float x, float y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void render(Graphics graphics) {
        graphics.setColor(Color.red);
        graphics.fillOval(this.x, this.y, 10, 10);
        graphics.setColor(Color.white);
    }

    @Override
    public void update(GameContainer gameContainer, int delta) {
        this.y -= speedOfWeaponCharge;
    }
}
