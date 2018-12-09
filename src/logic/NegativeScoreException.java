package logic;

public class NegativeScoreException extends Exception {

	public NegativeScoreException() {
        super("the score would not be negative!");
    }
	
}
