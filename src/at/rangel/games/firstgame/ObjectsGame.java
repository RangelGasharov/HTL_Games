package at.rangel.games.firstgame;

import org.newdawn.slick.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ObjectsGame extends BasicGame {
    private List<Rectangle> rectangles;
    private Rectangle rectangle;
    private Rectangle rectangle2;

    public ObjectsGame(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        this.rectangles = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            Rectangle rectangle = new Rectangle(random.nextInt(600), random.nextInt(600), random.nextInt(1,30));
            this.rectangles.add(rectangle);
        }
        this.rectangle = new Rectangle(100, 100, 5);
        this.rectangle2 = new Rectangle(0, 400, 30);
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {
        for(Rectangle rectangle: this.rectangles) {
            rectangle.update(delta);
        }
    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        for(Rectangle rectangle: this.rectangles) {
           rectangle.render(graphics);
        }
        graphics.drawString("Hello", 0, 0);
    }

    public static void main(String[] args) {
        try {
            AppGameContainer container = new AppGameContainer(new ObjectsGame("Rectangles"));
            container.setDisplayMode(800, 600, false);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}
