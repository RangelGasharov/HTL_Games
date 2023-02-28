package at.rangel.games.owngame;

import org.newdawn.slick.*;

public class Player implements Actor {
    private Image playerImage;
    private float x, y;
    private int playerWidth = 43;
    private int playerHeight = 33;
    private double overallSpeed = 1;

    public Player() throws SlickException {
        Image tmp = new Image("src/at/rangel/games/owngame/assets/player-sprite.png");
        this.playerImage = tmp.getScaledCopy(this.playerWidth, this.playerHeight);
        this.x = 100;
        this.y = 100;
    }

    @Override
    public void render(Graphics graphics) {
        playerImage.draw(this.x, this.y);
    }

    public float getX() {
        return x + (float) this.playerWidth / 2 - 5;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    @Override
    public void update(GameContainer gameContainer, int delta) {
        int containerWidth = gameContainer.getWidth();
        int containerHeight = gameContainer.getHeight();

        if (this.x >= containerWidth - playerWidth) {
            this.x = containerWidth - playerWidth;
        }

        if (this.x <= 0) {
            this.x = 0;
        }

        if (this.y <= 0) {
            this.y = 0;
        }

        if (this.y >= containerHeight - playerHeight) {
            this.y = containerHeight - playerHeight;
        }

        if (gameContainer.getInput().isKeyDown(Input.KEY_RIGHT) || (gameContainer.getInput().isKeyDown(Input.KEY_D))) {
            this.x += overallSpeed;
        }

        if (gameContainer.getInput().isKeyDown(Input.KEY_LEFT) || (gameContainer.getInput().isKeyDown(Input.KEY_A))) {
            this.x -= overallSpeed;
        }

        if (gameContainer.getInput().isKeyDown(Input.KEY_DOWN) || (gameContainer.getInput().isKeyDown(Input.KEY_S))) {
            this.y += overallSpeed;
        }

        if (gameContainer.getInput().isKeyDown(Input.KEY_UP) || (gameContainer.getInput().isKeyDown(Input.KEY_W))) {
            this.y -= overallSpeed;
        }

    }
}
