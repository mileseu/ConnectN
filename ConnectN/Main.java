/*
 * Code has been reused from MyConnectFour.java
 * Special thanks to Thomas Powell for creating an example board game where code has been reused and repurposed for this program.
 */

class Main {
	public static void main(String[] args) {
		Output.printWelcome();
		// create players.
		Player player = new HumanPlayer("Fry");
		Player flexo = new BotPlayer("Flexo");
		Player bender = new BotPlayer("Bender");
		
		//Checks if an argument is entered for N
		if (args.length > 0) {
			try {
				Board.winN = Integer.parseInt(args[0]);
				if(Board.winN<3||Board.winN>6) {
					Board.winN = 4;
					Output.printErrorN();
					}
				else {
					//Print the command line argument. Placed here and not in Output due to local variable args.
					System.out.println("N = " + args[0]);
					}
				} catch (NumberFormatException e) {
					System.err.println("Argument " + args[0] + " must be an integer.");
					System.exit(1);
					}
			}
		else {
			//defaults to Connect4 if no argument found.
			Board.winN = 4;
			System.out.println("N = 4");
			}
		
		//Create new game object and call playGame method
		Game game = new Game(6, 7, player, flexo, bender);
		game.playGame();
	}
	}