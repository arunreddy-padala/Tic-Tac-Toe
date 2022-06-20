package tictactoe;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.WindowConstants;
import javax.swing.JOptionPane;



/**
 * TicTacToe view class which represents the view section of the MVC. The class implements
 * the TicTacToeView interface and extends JFrame from java's swing library.
 */

public class TicTacToeSwingView extends JFrame implements TicTacToeView {

  private BoardPanel boardPanel;
  public static int PANEL_WIDTH = 500;
  public static int PANEL_HEIGHT = 500;
  public static int PANEL_POSITION = 100;

  /**
   * Constructor for TicTacToe view class which represents the view section of the MVC.
   * The class implements the TicTacToeView interface and extends JFrame
   * from java's swing library.
   */

  public TicTacToeSwingView(ReadonlyTttModel model) throws IllegalArgumentException {
    super("Tic-Tac-Toe");

    if (model == null) {
      throw new IllegalArgumentException("Invalid! model cannot be null");
    }

    this.setSize(PANEL_WIDTH, PANEL_HEIGHT);
    this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    boardPanel = new BoardPanel(model);
    add(boardPanel);
  }

  @Override
  public void addClickListener(TicTacToeController listener) {
    MouseAdapter clickAdapter = new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);
        int rows = e.getY() / (PANEL_HEIGHT / 3);
        int cols = e.getX() / (PANEL_WIDTH / 3);
        listener.handleCellClick(rows, cols);
      }
    };
    boardPanel.addMouseListener(clickAdapter);
  }

  @Override
  public void refresh() {
    repaint();
  }

  @Override
  public void makeVisible() {
    setVisible(true);
  }

  @Override
  public void showErrorMessage(String error) {
    JOptionPane.showMessageDialog(this, error,
            "Error", JOptionPane.ERROR_MESSAGE);
  }

}
