
public abstract class Player {	
	private String name;
	
	public Player(String name) {
		this.name = name;
		}
	
	public String getName() {
		return name;
		}
	
  // to be implemented by extensions of abstract class, e.g. by taking a user input, or running an AI algorithm.
	abstract int nextMove();

}