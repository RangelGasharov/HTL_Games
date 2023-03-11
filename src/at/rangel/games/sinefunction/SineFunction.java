package at.rangel.games.sinefunction;

import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import java.util.ArrayList;
import java.util.List;

public class SineFunction extends BasicGameState {
    private List<Actor> actors;
    private List<SineComponent> sineComponents;
    private boolean amplitudeIsChanging = false;
    private boolean yAxeIsChanging = true;
    private boolean xAxeIsChanging = true;

    public int getID() {
        return 2;
    }

    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        this.actors = new ArrayList<>();
        this.sineComponents = new ArrayList<>();
        double containerHeight = gameContainer.getHeight();
        double containerWidth = gameContainer.getWidth();

        Axes xAxes = new Axes(0, (float) containerHeight / 2, (float) containerWidth, 2);
        this.actors.add(xAxes);

        Axes yAxes = new Axes((float) containerWidth / 2, 0, 2, (float) containerHeight);
        this.actors.add(yAxes);

        int amountOfComponents = 1000;
        for (int i = 1; i <= amountOfComponents; i++) {
            SineComponent sineComponent = new SineComponent();
            this.actors.add(sineComponent);
            this.sineComponents.add(sineComponent);

            double positionRelative = (double) i / amountOfComponents;
            sineComponent.x = (float) (positionRelative * containerWidth);

            double amountOfPeriodDurations = 3;
            double factor = -1;
            if (amountOfPeriodDurations % 2 != 0) {
                factor = 1;
            }
            double angleOfComponent = positionRelative * 360 * Math.PI / (180) * amountOfPeriodDurations;
            System.out.println(angleOfComponent);
            sineComponent.y = (float) (factor * sineComponent.amplitude * Math.sin(angleOfComponent) + containerHeight / 2);
        }
    }

    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        graphics.drawString("Sine Function", 100, 100);
        for (Actor actor : this.actors) {
            actor.render(graphics);
        }
        graphics.setColor(Color.red);
        for (SineComponent component : this.sineComponents) {
            component.render(graphics);
        }
        graphics.setColor(Color.white);
    }

    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {
        if (gameContainer.getInput().isKeyPressed(Input.KEY_1)) {
            stateBasedGame.enterState(1);
        }
        if (gameContainer.getInput().isKeyPressed(Input.KEY_A)) {
            amplitudeIsChanging = true;
            yAxeIsChanging = false;
        }

        if (gameContainer.getInput().isKeyPressed(Input.KEY_X)) {
            xAxeIsChanging = true;
        }

        if (gameContainer.getInput().isKeyPressed(Input.KEY_Y)) {
            yAxeIsChanging = true;
            amplitudeIsChanging = false;
        }

        if (gameContainer.getInput().isKeyPressed(Input.KEY_LEFT)) {
            for (SineComponent sineComponent : sineComponents) {
                if (xAxeIsChanging) {
                    sineComponent.x -= 1;
                }
            }
        }

        if (gameContainer.getInput().isKeyPressed(Input.KEY_RIGHT)) {
            for (SineComponent sineComponent : sineComponents) {
                if (xAxeIsChanging) {
                    sineComponent.x += 1;
                }
            }
        }

        if (gameContainer.getInput().isKeyPressed(Input.KEY_UP)) {
            for (SineComponent sineComponent : sineComponents) {
                if (yAxeIsChanging) {
                    sineComponent.y -= 1;
                }
                if (amplitudeIsChanging) {
                    sineComponent.amplitude += 1;
                }
            }
        }

        if (gameContainer.getInput().isKeyPressed(Input.KEY_DOWN)) {
            for (SineComponent sineComponent : sineComponents) {
                if (yAxeIsChanging) {
                    sineComponent.y += 1;
                }
                if (amplitudeIsChanging) {
                    sineComponent.amplitude -= 1;
                    System.out.println(sineComponent.amplitude);
                }
            }
        }

        for (Actor actor : this.actors) {
            actor.update(gameContainer, i);
        }
    }
}
