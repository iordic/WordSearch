package main;

/**
 * Word solved and where is located
 * @author Jordi Castelló
 *
 */
public class Word {
	Word next;
	int size;
	String term;
	int [] begin;
	int [] end;
	int direction;

	public Word(String t) {
		term = t;
		size = t.length();
		begin = new int[2];
		end = new int[2];
	}
	
	public void setBegining(int [] b) {
		System.arraycopy(b, 0, begin, 0, 2);
	}
	
	public void setEnding(int [] e) {
		System.arraycopy(e, 0, end, 0, 2);
	}
	
	public void setDirection(int d) {
		direction = d;
	}
	
	public int getSize() {
		return size;
	}
	
	public int [] getBegining() {	
		return begin;
	}
	
	public int [] getEnding() {
		return end;
	}
	
	public int getDirection() {
		return direction;
	}
}
