package at.jonas.games.firstgame;

import org.newdawn.slick.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Slider implements Actor {
    private float x, y;
    private float speed;
    private int diameter;
    private boolean isPressed = false;
    private List<EventListener> eventListeners;

    public Slider() {
        Random random = new Random();
        this.x = random.nextInt(800);
        this.y = random.nextInt(600);
        this.speed = random.nextInt(40) + 10;
        this.diameter = random.nextInt(20) + 20;
        this.eventListeners = new ArrayList<>();
    }

    public void addListener(EventListener eventListener){
        this.eventListeners.add(eventListener);
    }

    public void informAllObservers(){
        for (EventListener eventListener: this.eventListeners) {
            eventListener.onChange(17);
        }
    }

    public void update(int delta, GameContainer container) {
        if (container.getInput().isKeyDown(Input.KEY_SPACE)) {
            isPressed = true;
            informAllObservers();
        } else {
            isPressed = false;
        }


        this.y += (float) delta / this.speed;
        if (this.y > 600) {
            this.y = 0;
        }
    }

    public void render(Graphics graphics) {
        if (this.isPressed) {
            graphics.setColor(Color.red);
        } else {
            graphics.setColor(Color.white);
        }

        graphics.drawOval(this.x, this.y, this.diameter, this.diameter);
        graphics.setColor(Color.white);
    }

}
