package tictactoe;

/**
 * Tic Tac Toe controller class which represents the controller aspect of the MVC.
 * The class implements the TicTacToeController interface and takes in the model and view.
 */

public class TicTacToeControllerImpl implements TicTacToeController {

  private TicTacToe model;
  private TicTacToeView view;

  /**
   * Constructor for Tic Tac Toe controller class which represents the controller aspect of the MVC.
   * The class implements the TicTacToeController interface and takes in the model and view.
   */

  public TicTacToeControllerImpl(TicTacToe model, TicTacToeView view)
          throws IllegalArgumentException {
    if (model == null || view == null) {
      throw new
              IllegalArgumentException("Invalid!, Model & View cannot be null");
    }
    this.model = model;
    this.view = view;
  }

  @Override
  public void playGame(TicTacToe m) throws IllegalArgumentException {
    if (m == null) {
      throw new IllegalArgumentException("Invalid! Model cannot be null");
    }
    try {
      this.model = m;
      view.addClickListener(this);
      view.makeVisible();
    }
    catch (Exception e) {
      StringBuilder sb = new StringBuilder();
      sb.append(e);
    }
  }

  @Override
  public void handleCellClick(int row, int col) throws IllegalArgumentException {
    if (row < 0 || col < 0) {
      throw new IllegalArgumentException("Invalid values for row and column");
    }
    try {
      this.model.move(row, col);
      view.refresh();
    } catch (Exception e) {
      view.showErrorMessage(e.getMessage());
    }
  }
}
