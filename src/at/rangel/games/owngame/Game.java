package at.rangel.games.owngame;

import org.newdawn.slick.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game extends BasicGame {
    private List<Actor> actors;
    private Player player;

    public Game(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        this.actors = new ArrayList<>();
        Random random = new Random();

        Player player = new Player();
        this.player = player;
        this.actors.add(player);
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {
        for (Actor actor : this.actors) {
            actor.update(gameContainer, delta);
        }
    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        for (Actor actor : this.actors) {
            actor.render(graphics);
        }
    }

    @Override
    public void keyPressed(int key, char c) {
        if (key == Input.KEY_SPACE || key == Input.KEY_L) {
            Weapon wp = new Weapon(this.player.getX(), this.player.getY());
            this.actors.add(wp);
        }
    }

    public static void main(String[] args) {
        try {
            AppGameContainer container = new AppGameContainer(new Game("Rectangles"));
            container.setDisplayMode(2550, 1440, false);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}
