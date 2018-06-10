import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.Dimension;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Random;
import java.util.HashMap;

/**
 * Class BallDemo - a short demonstration showing animation with the 
 * Canvas class. 
 *
 * @author Michael Kölling and David J. Barnes
 * @version 05.06.2018
 */

public class BallDemo   
{
    public static final boolean LEAVE_TRACES_ON_GROUND = false;
    public static final boolean LEAVE_TRACE = false;
    private Canvas myCanvas;
    //private HashMap <Integer, BouncingBall> ballMap;
    private ArrayList<BouncingBall> ballCollection;
    private BouncingBall ball;
  
  /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", 600, 500,LEAVE_TRACE);
       
        drawFrame2();
    }

    /**
     * Simulate multiple bouncing balls
     * @param numBalls The amount of balls to be bounced.
     */
    public void bounce(int numBalls)
    {
      //  ballMap = new HashMap<Integer, BouncingBall>();
        ballCollection = new ArrayList<>();
        
        int ground = 400;   // position of the ground line
        Random random = new Random();
        Random xpos = new Random();

        myCanvas.setVisible(true);
        // draw the ground
    myCanvas.setForegroundColor(Color.BLACK);
    if (LEAVE_TRACES_ON_GROUND)
            myCanvas.drawLine(50, ground, 550, ground);
    else
            myCanvas.drawLine(50, ground+1, 550, ground+1);
           
         //create and show the balls
        for (int n=0; n < numBalls; n++){
     
       BouncingBall ball = new BouncingBall
       
       (xpos.nextInt(300),50, random.nextInt(100), Color.BLUE, ground, myCanvas);
       
      // ballMap.put(n, ball);
       ballCollection.add (ball);
    }
           // make them bounce  
        boolean finished =  false;
        while (!finished) {
            finished = true;
            //for (int j=0; j<ballMap.size(); j++){
           for (int j=0; j<ballCollection.size(); j++){
          //HashMap: BouncingBall selectedBall = ballMap.get (j);
          BouncingBall selectedBall = ballCollection.get (j);
         
          selectedBall.draw();
            // stop once ball has travelled a certain distance on x axis
            if(selectedBall.getXPosition() < 460){ 
                selectedBall.move();
            }
            
            if(selectedBall.getXPosition() < 460){ 
                finished = false;
            }
        }
        
    }
    myCanvas.wait(50);  // small delay
  }


 /**
     * Demonstrate some of the drawing operations that are
     * available on a Canvas object.
     */
public void drawDemo()
    {
        myCanvas.setFont(new Font("helvetica", Font.BOLD, 14));
        myCanvas.setForegroundColor(Color.red);

        myCanvas.drawString("We can draw text, ...", 20, 30);
        myCanvas.wait(1000);

        myCanvas.setForegroundColor(Color.black);
        myCanvas.drawString("...draw lines...", 60, 60);
        myCanvas.wait(500);
        myCanvas.setForegroundColor(Color.gray);
        myCanvas.drawLine(200, 20, 300, 50);
        myCanvas.wait(500);
        myCanvas.setForegroundColor(Color.blue);
        myCanvas.drawLine(220, 100, 370, 40);
        myCanvas.wait(500);
        myCanvas.setForegroundColor(Color.green);
        myCanvas.drawLine(290, 10, 320, 120);
        myCanvas.wait(1000);
        myCanvas.setForegroundColor(Color.orange);//new
        myCanvas.drawLine(500, 20, 200, 50);
        myCanvas.wait(500);

        myCanvas.setForegroundColor(Color.gray);
        myCanvas.drawString("...and shapes!", 110, 90);

        myCanvas.setForegroundColor(Color.red);

        // the shape to draw and move
        int xPos = 30;
        Rectangle rect = new Rectangle(xPos, 150, 30, 20);

        // move the rectangle across the screen
        for(int i = 0; i < 200; i ++) {
            myCanvas.fill(rect);
            myCanvas.wait(10);
            myCanvas.erase(rect);
            xPos++;
            rect.setLocation(xPos, 150);
        }
        // at the end of the move, draw once more so that it remains visible
        myCanvas.fill(rect);
        
        myCanvas.setForegroundColor(Color.blue);
        myCanvas.drawString("...many shapes!", 110, 200);
        myCanvas.wait(500);
        
        myCanvas.setForegroundColor(Color.green);
  
        // the shape to draw and move
        int xPos2 = 50;
        Rectangle rect2 = new Rectangle(xPos2, 140, 20, 20);

        // move the 2nd rectangle across the screen
        for(int i = 0; i < 200; i ++) {
            myCanvas.fill(rect2);
            myCanvas.wait(20);
            myCanvas.erase(rect2);
            xPos2++;
            rect2.setLocation(xPos2, 130);
        }
        // at the end of the move, draw once more so that it remains visible
        myCanvas.fill(rect2);
        }
        
/**
     * Draws the frame around the canvas by drawing a rectangle 20px 
     * inside the window borders. 
     */
    public void drawFrame(){
       int width = myCanvas.getSize().width;
       int height = myCanvas.getSize().height;
       myCanvas.setForegroundColor(Color.GRAY); 
       myCanvas.drawLine(20, 20, 20, height-20); //x,y,x1,y2
       myCanvas.drawLine(20, height-20, width-20, height-20);
       myCanvas.drawLine(width-20, height-20, width-20, 20);
       myCanvas.drawLine(width-20, 20, 20, 20);  
    }
    
/**
     * Another option with Dimension class:
     * Draws the frame around the canvas by drawing a rectangle 20px 
     * inside the window borders. 
     */ 
    public void drawFrame2(){
     int space = 20; 
     Dimension dim = myCanvas.getSize();//
     int height = dim.height;
     int width = dim.width; //canvas width
    
     myCanvas.setForegroundColor(Color.GRAY); //big rectangle color
     myCanvas.fillRectangle(space, space, 
     width = width - space*2, 
     height = height - space*2);
     
     myCanvas.setForegroundColor(Color.WHITE); //small rectangle color
     myCanvas.fillRectangle(space*2, space*2,
     width = width-space*2, height = height - space*2);
     
    }

}


