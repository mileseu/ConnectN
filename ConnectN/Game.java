public class Game {
	private Board board;
	private Player player1;
	private Player player2;
	private Player player3;
	
	// game defined by board size and three players
	public Game(int rowSize, int colSize, Player player1, Player player2, Player player3) {
		board = new Board(rowSize, colSize);
		this.player1 = player1;
		this.player2 = player2;
		this.player3 = player3;
		}
	
	public void playGame() {
		int status;
		int currentPlayer = 1; 
		int nextMove;
		Output.printPlayers(player1, player2, player3);
		// main loop represents player turn, executes as long as game is not won 
		while(!board.full() && !board.hasWon()) {
			//Brings currentPlayer back to 1 after 3.
			if (currentPlayer == 4){
				currentPlayer = 1;
				}
			Output.printBoard(board);
			// inner loop prompts player until valid move is entered
			do {
				if(currentPlayer == 1) {
					Output.requestMove(player1);
					nextMove = player1.nextMove(); // player 1's move method
				}
				else if (currentPlayer == 2){
					Output.requestMove(player2);
					nextMove = player2.nextMove(); // player 2's move method
				}
				else {
					Output.requestMove(player3);
					nextMove = player3.nextMove(); // player 3's move method
					}
				
				// implement move on board
				status = board.placeCounter(currentPlayer, nextMove);

				if(status == 0) {
					Output.printColumnFull(); // in case column full error returned
					}
				}
			while(status != 1);
			currentPlayer = currentPlayer+1; // turn successful, switch to next player
			}
		
		// if loop condition fails, game has ended. Print final board and identify outcome.
		Output.printBoard(board);
		if (board.full() && !board.hasWon()){
			Output.printDraw();
			}
		else{
			if(currentPlayer == 2) {
				Output.printWinner(player1);
				}
			else if (currentPlayer == 3) {
				Output.printWinner(player2);
				}
			else {
				Output.printWinner(player3);
				}
			}
		}
	}