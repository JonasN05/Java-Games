package at.jonas.games.firstgame;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.svg.Gradient;

public class Rectangle implements Actor{

    private enum DIRECTION{
        RIGTH, DOWN, LEFT, UP
    };

    private float x;
    private float y;
    private float speed;


    public Rectangle(int x, int y, float speed) {
        this.x = x;
        this.y = y;
        this.speed = speed;
    }


    public void update(int delta, GameContainer container){
        this.x += (float)delta/this.speed;
        if (this.x > 800){
            this.x = 0;
        }
    }

    public void render(Graphics graphics){
        graphics.drawRect(this.x,this.y,10,10);
    }
}
