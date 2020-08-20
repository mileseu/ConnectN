import java.util.Scanner;

public class HumanPlayer extends Player {
	
  // human player represented by scanner
	private Scanner scan;
	
	public HumanPlayer(String name) {
		super(name);
		scan = new Scanner(System.in); // open input stream
		}
	
	public int nextMove() {
		int move;
		//Only allows ints 1-7
		while (!scan.hasNext("[1-7]")) {
			Output.invalidInput();
			scan.next();
			}
		move = scan.nextInt();
		return move;
		}
	}