import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferStrategy;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;

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


    public class tie_fighter implements Runnable, KeyListener, MouseListener, MouseMotionListener {
        final int WIDTH = 1000;
        final int HEIGHT = 700;

        //Declare the variables needed for the graphics
        public JFrame frame;
        public Canvas canvas;
        public JPanel panel;

        public BufferStrategy bufferStrategy;
        public Image TIEPic;
        public Image background;


        //Declare the objects used in the program
        //These are things that are made up of more than one variable type
        private Boba[] tie;

        // Main method definition
        // This is the code that runs first and automatically
        public static void main(String[] args) {
            tie_fighter ex = new tie_fighter();   //creates a new instance of the game
            new Thread(ex).start();                 //creates a threads & starts up the code in the run( ) method
        }


        // Constructor Method
        // This has the same name as the class
        // This section is the setup portion of the program
        // Initialize your variables and construct your program objects here.
        public tie_fighter() {

            tie = new Boba[18];
            setUpGraphics();
            canvas.addKeyListener(this);

            //variable and objects
            //create (construct) the objects needed for the game and load up
            TIEPic = Toolkit.getDefaultToolkit().getImage("tie_fighter.png"); //load the picture
            background = Toolkit.getDefaultToolkit().getImage("star_wars.jpeg");
            tie[0] = new Boba(270, 25, 1, 0);

            for (int b=0;b<18;b++) {
                if (b<6) {
                    tie[b] = new Boba(270 + (85*b), 25, 1, 0);
                }
                else if (b>5 && b<12) {
                    tie[b] = new Boba(270 + (85*(b-6)), 100, 1, 0);
                }
                else{
                    tie[b] = new Boba(270 + (85*(b-12)), 185, 1, 0);
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
            for (int m=0;m<tie.length;m++) {
                tie[m].bounce();
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
            for (int p=0;p<tie.length;p++) {
                g.drawImage(TIEPic, tie[p].xpos, tie[p].ypos, 60, 60, null);
                g.draw(new Rectangle(tie[p].xpos, tie[p].ypos, 60, 60));
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

