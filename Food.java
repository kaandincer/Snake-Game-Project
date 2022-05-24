package project;

import edu.princeton.cs.introcs.StdDraw;

import java.awt.*;

public class Food {
    int xPos, yPos;

    public Food(Snake s){
        StdDraw.setPenColor(Color.RED);
        yPos = (int)(Math.random()*30+1);
        xPos = (int)(Math.random()*30+1);
        StdDraw.filledCircle(xPos,yPos,0.30);
    }

    public void update(Snake s){
        StdDraw.setPenColor(Color.RED);
        boolean t;

        while(s.covered(xPos,yPos)){
            yPos = (int)(Math.random()*30+1);
            xPos = (int)(Math.random()*30+1);
        }

        StdDraw.filledCircle(xPos,yPos,0.30);
    }
}
