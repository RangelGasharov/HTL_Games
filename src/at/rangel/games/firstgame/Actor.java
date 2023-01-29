package at.rangel.games.firstgame;

import org.newdawn.slick.Graphics;

public interface Actor {
    public void render(Graphics graphics);

    public void update(int delta);
}
