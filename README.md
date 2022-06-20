# TicTacToe_MVC
Tic-Tac-Toe game designed using MVC architecture 

Languages and Frameworks: Java, Java Swing 

A) Implementation of the game of Tic-Tac-Toe by implementing a graphical user interface using Java's Swing library.

B) The TicTacToeController interface consists of two methods: **playGame** which executes a single game of TicTacToe given a TicTacToe Model. When the game is over,
   the playGame method ends and **handleCellClick** which handles an action in a single cell of the board, such as to make a move.
   
C) The TicTacToeView interface consists of three methods: **addClickListener** which set's up the controller to handle click events in the view, **refresh** which refreshes the view to reflect any changes in the game state, 
and **makeVisible** which make the view visible to start the game session.  

D) Extended JPanel and overrides paintComponent that draws the game board and game status. Status includes indicating whose turn it is, and if the game is over, who won (or if it was a tie).

E) Extended MouseAdapter and overrides mouseClicked to capture a click on the game board and pass it to the controller.
