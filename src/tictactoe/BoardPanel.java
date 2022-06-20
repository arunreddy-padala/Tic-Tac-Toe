package tictactoe;

import java.awt.Graphics;
import java.awt.Font;
import java.awt.Graphics2D;

import javax.swing.JPanel;


/**
 * BoardPanel class which comprises the TicTacToeSwingView class and represents
 * end user visualization. The class extends JPanel from java's swing library.
 */

class BoardPanel extends JPanel {

  private final ReadonlyTttModel model;

  /**
   * Constructor for BoardPanel class which comprises the TicTacToeSwingView
   * class and represents end user visualization. The class extends JPanel
   * from java's swing library.
   */

  public BoardPanel(ReadonlyTttModel model) {
    this.model = model;
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g;
    int panel_width = TicTacToeSwingView.PANEL_WIDTH;
    int panel_height = TicTacToeSwingView.PANEL_HEIGHT;
    int panel_position = TicTacToeSwingView.PANEL_POSITION;

    g2d.drawLine(0, (panel_height - panel_position) / 3,
            panel_width, (panel_height - panel_position) / 3);
    g2d.drawLine(0, 2 * (panel_height - panel_position) / 3,
            panel_width, 2 * (panel_height - panel_position) / 3);
    g2d.drawLine(panel_width / 3, 0, panel_width / 3,
            panel_height - panel_position);
    g2d.drawLine(2 * panel_width / 3, 0, 2 * panel_width / 3,
            panel_height - panel_position);

    Player[][] board = model.getBoard();
    g2d.setFont(new Font("Times", Font.ITALIC, 25));
    for (int row = 1; row <= board.length; row++) {
      for (int col = 1; col <= board[0].length; col++) {
        int pos1 = (col * panel_width / board.length) - (panel_width / (board.length * 2));
        int pos2 = (row * (panel_height - panel_position) / board.length)
                - ((panel_height - panel_position) / (board.length * 2));
        if (model.getMarkAt(row - 1, col - 1) != null) {
          if (model.getMarkAt(row - 1, col - 1) == Player.X) {
            g2d.drawString("X", pos1 - (25), pos2 + 25);
          } else if (model.getMarkAt(row - 1, col - 1) == Player.O) {
            g2d.drawString("O", pos1 - (25), pos2 + 25);
          }
        }
      }
    }

    if (model.getWinner() != null) {
      g2d.drawString("Game State:" + "Player "
                      + model.getWinner().toString() + " won!", panel_width / 10,
              panel_height - (panel_position / 2));
    } else if (model.isGameOver()) {
      g2d.drawString("Game State:" + "Game is tied!", panel_width / 10,
              panel_height - (panel_position / 2));
    } else {
      g2d.drawString("Game State:" + "Player "
                      + model.getTurn().toString() + "'s turn", panel_width / 10,
              panel_height - (panel_position / 2));
    }
  }
  