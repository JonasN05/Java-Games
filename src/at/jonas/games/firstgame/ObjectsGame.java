package at.jonas.games.firstgame;

import org.newdawn.slick.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ObjectsGame extends BasicGame implements EventListener{
    private List<Actor> actors;
    private RiedmannListener rl = new RiedmannListener();

    public ObjectsGame(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        this.actors = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 100; i++) {
            Rectangle rectangle = new Rectangle(random.nextInt(800),random.nextInt(600),random.nextInt(49)+1);
            this.actors.add(rectangle);
        }



        for (int i = 0; i < 2; i++) {
            Slider slider = new Slider();
            slider.addListener(this);
            slider.addListener(rl);

            slider.addListener(new EventListener() {
                @Override
                public void onChange(int val) {
                    System.out.println("new Listener");
                }
            });
            this.actors.add(slider);
        }




        for (int i = 0; i < 25; i++) {
            Ellipse ellipse = new Ellipse(random.nextInt(800),random.nextInt(600));
            this.actors.add(ellipse);
        }
    }


    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {
        for (Actor actor: this.actors) {
            actor.update(delta, gameContainer);
        }

    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        for (Actor actor: this.actors) {
            actor.render(graphics);
        }
    }



    public static void main(String[] argv) {
        try {
            AppGameContainer container = new AppGameContainer(new ObjectsGame("Rectangles"));
            container.setDisplayMode(800,600,false);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onChange(int val) {
        System.out.println("this");
    }
}
