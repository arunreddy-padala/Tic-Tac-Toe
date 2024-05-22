# TicTacToe_Java_MVC
Tic-Tac-Toe game designed in Java using MVC architecture 

Languages and Frameworks: Java, Java Swing, MVC  

- Implementing the classic game of Tic-Tac-Toe with a graphical user interface utilizing Java's Swing library.
  
- The TicTacToeController interface includes two primary methods:
      - playGame(TicTacToeModel model): Executes a single game session of Tic-Tac-Toe using the provided model. This method terminates once the game concludes.
      - handleCellClick(int row, int col): Manages actions performed on individual cells, such as making a move on the board.
   
- The TicTacToeView interface comprises three essential methods:
      - addClickListener(TicTacToeController controller): Sets up the controller to handle click events within the view.
      - refresh(): Updates the view to reflect any changes in the game's state.
      - makeVisible(): Displays the view to initiate the game session.

- Extends the JPanel class and overrides the paintComponent method to render the game board and display game status, including whose turn it is and the game’s outcome (win, lose, or draw).

- Extends the MouseAdapter class and override the mouseClicked method to capture clicks on the game board, then relay this information to the controller for processing.
