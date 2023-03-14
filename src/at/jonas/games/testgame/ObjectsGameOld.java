package at.jonas.games.testgame;

import org.newdawn.slick.*;

public class ObjectsGameOld extends BasicGame {

    private float xRec;
    private float yRec;

    private float xOv1;
    private float yOv1;

    private float xCir;
    private float yCir;

    private float speed;
    private boolean ydir;
    private boolean xdir;

    public ObjectsGameOld(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        this.xRec = 100;
        this.yRec = 100;

        this.xOv1 = 100;
        this.yOv1 = 0;

        this.xCir = 0;
        this.yCir = 100;
        this.speed = 2.0f;

        this.ydir = true;
        this.xdir = true;
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {
        if (this.xRec<=600 && this.yRec <=100){
            this.xRec += (float) delta/this.speed;

        } else if(this.yRec <= 400 && this.xRec>=600){
            this.yRec += (float) delta/this.speed;

        } else if(this.xRec>=100 && this.yRec >=400){
            this.xRec -= (float) delta/this.speed;

        } else if(this.yRec>=100 && this.xRec <=100){
            this.yRec -= (float) delta/this.speed;
        }

        if (yCir<400 && ydir == true){
            this.yCir += (float) delta/this.speed;
            if (yCir >=400){
                this.ydir = false;
            }
        } else if (yCir>100 && ydir == false){
            this.yCir -= (float) delta/this.speed;
            if (yCir <= 100){
                this.ydir = true;
            }
        }


        if (xOv1<600 && xdir == true){
            this.xOv1 += (float) delta/this.speed;
            if (xOv1 >=600){
                this.xdir = false;
            }
        } else if (xOv1>100 && xdir == false){
            this.xOv1 -= (float) delta/this.speed;
            if (xOv1 <= 100){
                this.xdir = true;
            }
        }

    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        graphics.drawRect(this.xRec,this.yRec,100,100);
        graphics.drawOval(xOv1,yOv1,80,35);
        graphics.drawOval(xCir,yCir,50,50);
    }


    public static void main(String[] argv) {
        try {
            AppGameContainer container = new AppGameContainer(new ObjectsGameOld("Rectangles"));
            container.setDisplayMode(800,600,false);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }

}
