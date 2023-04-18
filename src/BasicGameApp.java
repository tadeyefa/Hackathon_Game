import java.awt.*;
//Basic Game Application
//Version 2
// Basic Object, Image, Movement
// Astronaut moves to the right.
// Threaded

//K. Chun 8/2018

//*******************************************************************************
//Import Section
//Add Java libraries needed for the game
//import java.awt.Canvas;

//Graphics Libraries

import java.awt.Graphics2D;
import java.awt.event.*;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class BasicGameApp implements Runnable, KeyListener, MouseListener, MouseMotionListener {
    final int WIDTH = 1000;
    final int HEIGHT = 700;

    //Declare the variables needed for the graphics
    public JFrame frame;
    public Canvas canvas;
    public JPanel panel;

    public BufferStrategy bufferStrategy;
    public Image bobaPic;
    public Image background;


    //Declare the objects used in the program
    //These are things that are made up of more than one variable type
    private Boba[] boba;
    private Boba boba2;
    private Boba boba3;
    private Boba boba4;
    private Boba boba5;
    private Boba boba6;
    private Boba boba7;
    private Boba boba8;
    private Boba boba9;
    private Boba boba10;
    private Boba boba11;
    private Boba boba12;
    private Boba boba13;
    private Boba boba14;
    private Boba boba15;
    private Boba boba16;
    private Boba boba17;
    private Boba boba18;

    // Main method definition
    // This is the code that runs first and automatically
    public static void main(String[] args) {
        BasicGameApp ex = new BasicGameApp();   //creates a new instance of the game
        new Thread(ex).start();                 //creates a threads & starts up the code in the run( ) method
    }


    // Constructor Method
    // This has the same name as the class
    // This section is the setup portion of the program
    // Initialize your variables and construct your program objects here.
    public BasicGameApp() {

        boba = new Boba[18];
        setUpGraphics();
        canvas.addKeyListener(this);

        //variable and objects
        //create (construct) the objects needed for the game and load up
        bobaPic = Toolkit.getDefaultToolkit().getImage("boba.png"); //load the picture
        background = Toolkit.getDefaultToolkit().getImage("space_invaders.jpeg");
        boba[0] = new Boba(270, 25, 1, 0);
        boba2 = new Boba(355, 25, 1, 0);
        boba3 = new Boba(440, 25, 1, 0);
        boba4 = new Boba(525, 25, 1, 0);
        boba5 = new Boba(610, 25, 1, 0);
        boba6 = new Boba(695, 25, 1,0);
        boba7 = new Boba(270, 100, 1, 1);
        boba8 = new Boba(355, 100, 1, 1);
        boba9 = new Boba(440, 100, 1, 1);
        boba10 = new Boba(525, 100, 1, 1);
        boba11 = new Boba(610, 100, 1, 1);
        boba12 = new Boba(695, 100, 1, 1);
        boba13 = new Boba(270, 185, 1, 1);
        boba14 = new Boba(355, 185, 1, 1);
        boba15 = new Boba(440, 185, 1, 1);
        boba16 = new Boba(525, 185, 1, 1);
        boba17 = new Boba(610, 185, 1, 1);
        boba18 = new Boba(695, 185, 1, 1);

        for (int b=0;b<18;b++) {
            if (b<6) {
                boba[b] = new Boba(270 + (85*b), 25, 1, 0);
            }
            else if (b>5 && b<12) {
                boba[b] = new Boba(270 + (85*(b-6)), 100, 1, 0);
            }
            else{
                boba[b] = new Boba(270 + (85*(b-12)), 185, 1, 0);
            }
        }

    }

    public void run() {

        //for the moment we will loop things forever.
        while (true) {

            moveThings();  //move all the game objects
            render();  // paint the graphics
            //pause(20); // sleep for 10 ms
        }
    }
    public void moveThings() {
       for (int m=0;m<boba.length;m++) {
           boba[m].bounce();
       }
    }

    private void setUpGraphics() {
        frame = new JFrame("Application Template");   //Create the program window or frame.  Names it.

        panel = (JPanel) frame.getContentPane();  //sets up a JPanel which is what goes in the frame
        panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));  //sizes the JPanel
        panel.setLayout(null);   //set the layout

        // creates a canvas which is a blank rectangular area of the screen onto which the application can draw
        // and trap input events (Mouse and Keyboard events)
        canvas = new Canvas();
        canvas.setBounds(0, 0, WIDTH, HEIGHT);
        canvas.setIgnoreRepaint(true);

        panel.add(canvas);  // adds the canvas to the panel.

        canvas.addMouseListener(this);
        canvas.addMouseMotionListener(this);

        // frame operations
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //makes the frame close and exit nicely
        frame.pack();  //adjusts the frame and its contents so the sizes are at their default or larger
        frame.setResizable(false);   //makes it so the frame cannot be resized
        frame.setVisible(true);      //IMPORTANT!!!  if the frame is not set to visible it will not appear on the screen!

        // sets up things so the screen displays images nicely.
        canvas.createBufferStrategy(2);
        bufferStrategy = canvas.getBufferStrategy();
        canvas.requestFocus();
        System.out.println("DONE graphic setup");
    }

    private void render() {
        Graphics2D g = (Graphics2D) bufferStrategy.getDrawGraphics();
        g.clearRect(0, 0, WIDTH, HEIGHT);

        //draw the image of the astronaut
        g.drawImage(background, 0, 0, WIDTH, HEIGHT, null);
        for (int p=0;p<boba.length;p++) {
            g.drawImage(bobaPic, boba[p].xpos, boba[p].ypos, 60, 60, null);
            g.draw(new Rectangle(boba[p].xpos, boba[p].ypos, 60, 60));
        }

        g.dispose();

            bufferStrategy.show();
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
