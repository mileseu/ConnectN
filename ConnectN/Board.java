public class Board {
	private int maxRow;
	private int maxCol;
	private int[][] board;
	public static char token1 = 'r';
	public static char token2 = 'y';
	public static char token3 = 'g';
	public static int winN;
	
	// initialise empty board
	public Board(int maxCol, int maxRow) {
		this.maxRow = maxRow;
		this.maxCol = maxCol;
		this.board = new int[maxCol][maxRow];
	}
	
	// access row size
	public int getMaxRow() {
		return maxRow;
	}
	
	// access column size
	public int getMaxCol() {
		return maxCol;
	}
	
	// access board entry
	public int getSquare(int col, int row) {
		return board[col][row];
	}
	
	// player moves at column position
	// returns a 1 if successfully placed
	public int placeCounter(int player, int position) {
		if(player == 1){
			for(int i=board.length-1; i>=0; i--){
				if(board[i][position-1] == token2||board[i][position-1] == token3){
					// skip
					}
				else if(board[i][position-1] != token1){
					board[i][position-1] = token1;
					return 1;
					}
				}
			}
		else if (player == 2){
			for(int i=board.length-1; i>=0; i--){
				if(board[i][position-1] == token1||board[i][position-1] == token3){
					// skip
					}
				else if(board[i][position-1] != token2){
					board[i][position-1] = token2;
					return 1;
					} 
				}
			}
		else {
			for(int i=board.length-1; i>=0; i--){
				if(board[i][position-1] == token1||board[i][position-1] == token2){
					// skip
					}
				else if(board[i][position-1] != token3){
					board[i][position-1] = token3;
					return 1;
					} 
				}
			}
		// returns 0 if token cannot be placed.
		return 0;
		}
	
	// check if board is full
	public boolean full() {
		for(int i = 0; i < maxCol; i++) {
			for(int j = 0; j < maxRow; j++) {
				if(board[i][j] == 0) {
					// found empty square, return false
					return false;
					}
				}
			}
		// else have not found empty square
		return true;
	}
	
	public boolean hasWon() {
		char tokens[] = {token1, token2, token3};
		int count;
		// check each player's token
		for(int l=0; l<tokens.length; l++) {
			char t = tokens[l];
			//check horizontal
			for(int i=0; i<board.length; i++){
				count = 0;
				for(int j=0; j<board[i].length; j++){
					if(board[i][j] == t){
						count = count + 1;
						if(count >= winN){
							return true;
							}
						}
					else {
						count = 0;
						}
					}
				}
			// check vertical 
			for(int i=0; i<board[0].length; i++){
				count = 0;
				for(int j=0; j<board.length; j++){
					if(board[j][i] == t){
						count = count + 1;
						if(count >= winN){
							return true;
							}
						}
					else {
						count = 0;
						}
					}
				}
			//check diagonal \ iterating down
			for(int i=0; i<board.length; i++){
				count = 0;
				for(int j=i, k=0; j<board.length && k<board[0].length; j++,k++){
					if(board[j][k] == t){
						count = count + 1;
						if(count >= winN){
							return true;
							}
						}
					else{
						count = 0;
						}
					}
				}
			//check diagonal \ iterating across
			for(int i=1; i<board[0].length; i++){
				count = 0;
				for(int j=0, k=i; j<board.length&&k<board[0].length; j++,k++){
					if(board[j][k] == t){
						count = count + 1;
						if(count >= winN){
							return true;
							}
						}
					else {
						count = 0;
						}
					}
				}
			//check diagonal / iterating up
			for(int i=board.length-1; i>=0; i--){
				count = 0;
				for(int j=i, k=0; j>=0 && k<board[0].length; j--,k++){
					if(board[j][k] == t){
						count = count + 1;
						if(count >= winN){
							return true;
							}
						}
					else {
						count = 0;
						}
					}
				}
			//check diagonal / iterating across
			for(int i=1; i<board[0].length; i++){
				count = 0;
				for(int j=i, k=board.length-1; j<board[0].length && k>=0; j++,k--){
					if(board[k][j] == t){
						count = count + 1;
						if(count >= winN){
							return true;
							}
						}
					else{
						count = 0;
						}
					}
				}
			}
		return false;
		}
	}