package at.rangel.games.firstgame;

import org.newdawn.slick.*;

public class Rectangles extends BasicGame {
    private float xSquare, ySquare, xCircle, yCircle, xOval, yOval, speedSquare, speedCircle, speedOval;
    private boolean circleGoingUp = false;
    private boolean ovalGoingLeft = false;
    private boolean squareGoingLeft = false;
    private boolean squareGoingRight = true;
    private boolean squareGoingUp = false;
    private boolean squareGoingDown = false;

    public Rectangles(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        this.xSquare = 100;
        this.ySquare = 50;
        this.xCircle = 100;
        this.xOval = 200;
        this.yOval = 100;
        this.speedSquare = 5.00f;
        this.speedCircle = 2.00f;
        this.speedOval = 2.00f;
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {
        float directionSquare = (float) delta / speedSquare;
        float directionCircle = (float) delta / speedCircle;
        float directionOval = (float) delta / speedOval;

        if (this.ySquare < 0) {
            squareGoingUp = false;
            squareGoingRight = true;
        }
        if (this.ySquare > 600 - 100) {
            squareGoingDown = false;
            squareGoingLeft = true;
        }
        if (this.xSquare > 800 - 100) {
            squareGoingRight = false;
            squareGoingDown = true;
        }

        if (this.xSquare < 0) {
            squareGoingLeft = false;
            squareGoingUp = true;
        }

        if (squareGoingDown) {
            this.ySquare += directionSquare;
        }
        if (squareGoingUp) {
            this.ySquare -= directionSquare;
        }
        if (squareGoingLeft) {
            this.xSquare -= directionSquare;
        }
        if (squareGoingRight) {
            this.xSquare += directionSquare;
        }


        if (this.yCircle < 0) {
            circleGoingUp = false;
        }
        if (this.yCircle > 600 - 100) {
            circleGoingUp = true;
        }

        if (circleGoingUp) {
            this.yCircle -= directionCircle;
        } else {
            this.yCircle += directionCircle;
        }


        if (this.xOval < 0) {
            ovalGoingLeft = false;
        }
        if (this.xOval > 800 - 100) {
            ovalGoingLeft = true;
        }

        if (ovalGoingLeft) {
            this.xOval -= directionOval;
        } else {
            this.xOval += directionOval;
        }

    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        graphics.drawRect(this.xSquare, this.ySquare, 100, 100);
        graphics.drawRoundRect(this.xCircle, this.yCircle, 100, 100, 10000);
        graphics.drawOval(this.xOval, this.yOval, 100, 50);
        graphics.drawString("Hello", 0, 0);
    }

    public static void main(String[] args) {
        try {
            AppGameContainer container = new AppGameContainer(new Rectangles("Rectangles"));
            container.setDisplayMode(800, 600, false);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}
