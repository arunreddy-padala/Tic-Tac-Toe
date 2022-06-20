package tictactoe;

/**
 * Run a TicTacToe game interactively.
 */
public class Main {
  /**
   * Run a TicTacToe game interactively.
   */
  public static void main(String[] args) {

    TicTacToe model = new TicTacToeModel();
    TicTacToeView view = new TicTacToeSwingView(model);
    TicTacToeController controller = new TicTacToeControllerImpl(model, view);
    controller.playGame(model);

  }
}
