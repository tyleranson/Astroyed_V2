package package1.game;

import jdk.nashorn.internal.runtime.WithObject;
import package1.game.Game;
import package1.game.entity.Entity;
import package1.game.gameUtil.Movement;

import javax.swing.*;
import java.awt.*;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.util.Iterator;

/**********************************************************************
 * GUI class for the asteroid sets up the JPanel and JFrame for the
 * asteroid game and calls on player and asteroid to instantiate the
 * new objects.
 * Created by tyleranson on 2/15/16.
 *********************************************************************/
public class GUI extends JPanel {

    /** menuBar object**/
    //private JMenuBar menuBar;

    /** File object for the menuBar*/
    //private JMenu File;

    /** restart menuItem **/
    //private JMenuItem restart;

    /** exit menu item **/
    //private JMenuItem exit;

    /**
     * The game instance for the GUI
     */
    private Game game;

    /**
     * The size of the world
     */
    public static final int WORLD_SIZE = 600;
    public static final double DWORLD_SIZE = 600;

    /******************************************************************
     * GUI constructor (default)  instantiates a new asteroid and a
     * player
     *****************************************************************
     * @param game*/
    public GUI(Game game) {
        //Player s = new Player();
        //Asteroid a = new Asteroid();

        this.game = game;


//        JFrame gameFrame = new JFrame();
//
//        setupGUI();
//
//        gameFrame.setJMenuBar(menuBar);
//        gameFrame.add(menuBar, BorderLayout.NORTH);
//        gameFrame.add(s);
//        //gameFrame.add(a);
        setPreferredSize(new Dimension(WORLD_SIZE, WORLD_SIZE));
        setBackground(Color.GRAY);

//        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        gameFrame.setVisible(true);
//        gameFrame.setTitle("ASTROYED!");

    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.setColor(Color.BLACK); //Set the draw color to white.

        AffineTransform identity = g2d.getTransform();

        Iterator<Entity> iter = game.getEntities().iterator();
        while(iter.hasNext()) {
            Entity entity = iter.next();

            Movement position = entity.getPosition();

            drawEntity(g2d, entity, position.x, position.y);

            g2d.setTransform(identity);
        }


    }
//    /******************************************************************
//    Add any GUI options to be built in setupGUI (buttons,menus,othe panels)
//     *****************************************************************/
//    public void setupGUI(){
//        File = new JMenu("File");
//        menuBar = new JMenuBar();
//        restart = new JMenuItem("Restart");
//        exit = new JMenuItem("Exit");
//        restart.addActionListener(this);
//        exit.addActionListener(this);
//
//        menuBar.add(File);
//        File.add(restart);
//        File.add(exit);
//    }
//
//    /******************************************************************
//     *
//     * @param e
//     *****************************************************************/
//    public void actionPerformed(ActionEvent e){
//        if(exit == e.getSource()){
//            System.exit(0);
//        }
//    }


    private void drawEntity(Graphics2D g2d, Entity entity, double x, double y) {
        g2d.translate(x, y);
        double rotation = entity.getRotation();
        if(rotation != 0.0f) {
            g2d.rotate(entity.getRotation());
        }
        entity.draw(g2d, game);
    }
}
