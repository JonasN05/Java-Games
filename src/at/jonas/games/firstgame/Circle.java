package at.jonas.games.firstgame;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import java.util.Random;


public class Circle implements Actor{
    private float x,y;
    private float speed;
    private int diameter;

    public Circle() {
        Random random = new Random();
        this.x = random.nextInt(800);
        this.y = random.nextInt(600);
        this.speed = random.nextInt(40)+10;
        this.diameter = random.nextInt(20)+20;
    }

    public void update(int delta){
        this.y += (float)delta/this.speed;
        if (this.y > 600){
            this.y = 0;
        }
    }

    public void render(Graphics graphics){
        graphics.drawOval(this.x,this.y,this.diameter,this.diameter);
    }
}
