public class BotPlayer extends Player{
	
	public BotPlayer(String name) {
		super(name);
		}
	
	public int nextMove() {
		// make sure the bot returns a valid random move
		int max = 7;
		int min = 1;
		int random_int = (int)(Math.random() * (max - min + 1) + min);
		int move = random_int;
		//Prints the move for extra clarity, similar to how a player input would be displayed
		System.out.println(move);
		return move;	
		}
	}