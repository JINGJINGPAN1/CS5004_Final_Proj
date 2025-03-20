package view;

import controller.GameController;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.Timer;

public class GameWin extends JFrame {
  private GameController gameController;
  private GamePanel gamePanel;

  public GameWin() {
    gameController = new GameController();
    gamePanel = new GamePanel(gameController);
    add(gamePanel);
  }

  public void launch() {
    setTitle("Gold Miner");
    setSize(768, 1000);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);

    addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON1) {
          gameController.startGrabbing();
        }
      }
    });

    // set time, update every 16 millisecond
    Timer timer = new Timer(16, e-> {
        System.out.println("Timer triggered");
        gameController.update();
        repaint();
    });
    timer.start();
    System.out.println("Timer started");
  }

  @Override
  public void paint(Graphics g) {
    System.out.println("paint method called");
    super.paint(g);
    gameController.draw(g);
  }
}