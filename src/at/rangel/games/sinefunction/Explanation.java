package at.rangel.games.sinefunction;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Explanation extends BasicGameState {
    public int getID() {
        return 1;
    }

    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {

    }

    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        graphics.drawString("State 1", 100, 100);
    }

    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {
        if (gameContainer.getInput().isKeyPressed(Input.KEY_2)) {
            stateBasedGame.enterState(2);
        }
    }
}
