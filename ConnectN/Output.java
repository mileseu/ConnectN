
public class Output {
	
	// print whole board as matrix
	public static void printBoard(Board board) {
		String fillR = "| " + Board.token1 + " ";
		String fillY = "| " + Board.token2 + " ";
		String fillG = "| " + Board.token3 + " ";
		
		for(int i=0; i<board.getMaxCol(); i++){
			for(int j=0; j<board.getMaxRow(); j++){
				if(board.getSquare(i, j) == Board.token1){
					System.out.print(fillR);
					}
				else if(board.getSquare(i, j) == Board.token2){
					System.out.print(fillY);
					}
				else if(board.getSquare(i, j) == Board.token3){
					System.out.print(fillG);
					}
				else{
					System.out.print("|   ");
					}
				}
			System.out.println("|");
			}
		System.out.println("  1   2   3   4   5   6   7");
		}
	
	// print welcome message
	public static void printWelcome() {
		System.out.println("Welcome to ConnectN");
		System.out.println("To play the game type in the number of the column you want to drop you counter in");
		System.out.println("A player wins by connecting N counters in a row - vertically, horizontally or diagonally");
		System.out.println("N can be set in the command line as 2 < N < 7");	
	} 
	
	// announce players
	public static void printPlayers(Player player1, Player player2, Player player3){
		System.out.println("\nThere are 3 players " + Board.token1 + ", " + Board.token2 + ", " + Board.token3);
		System.out.println(player1.getName() + " is " + Board.token1 + ", " + player2.getName() + " is " + Board.token2 + ", " + player3.getName() + " is " + Board.token3);
		System.out.println("\n******************************************");	
		System.out.println(player1.getName() + " vs " + player2.getName() + " vs " + player3.getName());
		System.out.println("******************************************");	
		}
	
	// ask player to move
	public static void requestMove(Player player) {
		System.out.println("\n" + player.getName() + "'s move:");
		}
	
	// print error message for column full
	public static void printColumnFull() {
		System.out.println("\nColumn full!");
		}
	
	// print error message for invalid input
	public static void invalidInput() {
		System.out.println("\nPlease enter a valid number!");
		}
	
	// print winning player
	public static void printWinner(Player player) {
		System.out.println("\n" + player.getName() + " wins!");
		}
	
	// print draw
	public static void printDraw(){
		System.out.println("\nBoard full. It's a draw!");
		}
	
	// command line error
	public static void printErrorN() {
    	System.out.println("Argument N must be 2 < N < 7");
        System.out.println("N = 4");
        }
	}