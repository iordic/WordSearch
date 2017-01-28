package main;

import java.util.ArrayList;

/**
 * Class for solving and printing word search puzzle
 * @author Jordi Castelló
 *
 */
public class Solver {	
	// Constants for specify directions
	final int TOP = 0;
	final int BOTTOM = 1;
	final int LEFT = 2;
	final int RIGHT = 3;
	final int UPPER_LEFT = 4;
	final int UPPER_RIGHT = 5;
	final int LOWER_LEFT = 6;
	final int LOWER_RIGHT = 7;
	
	char [][] solution;
	ArrayList<String> notFound;
	int iterations;
	boolean wordSolved;
	List solvedWords;

	/**
	 * This procedure initializes all elements for solve the word search puzzle, then
	 * call to another procedure, specifying direction, to search recursively.
	 * And finally prints the solution.
	 * @param grid word search grid
	 * @param list list of words to search
	 */
	public void solve(char [][] grid, String [] list) {
		long timeStart = System.currentTimeMillis();			// For time measuring :)
		solvedWords = new List();								// Contains words and its positions
		solution = new char[grid.length][grid[0].length];		// Same size of grid to resolve
		iterations = 0;											// Iterations measuring
		notFound = new ArrayList<String>();
		Word aux;
		int [] b = new int[2];
		int [] e = new int[2];
		int direction = -1;
		for(int i = 0; i < list.length; i++) {
			wordSolved = false;
			aux = new Word(list[i]);
			for(int j = 0; j < grid.length; j++) {
				for(int k = 0; k < grid[j].length; k++) {
					if(list[i].charAt(0) == grid[j][k]) {
						// If first letter of the word we are searching matches, proceed to look on all directions.
						for(direction = 0; direction < 8; direction++) {		
							// Filters for corners, if direction exits out of the range, skip this iteration and look in next direction.
							if(direction == UPPER_LEFT && (j-1 < 0 || k-1 < 0)) continue;
							else if(direction == TOP && j-1 < 0) continue;
							else if(direction == UPPER_RIGHT && (j-1 < 0 || k+1 >= grid[j].length)) continue;
							else if(direction == RIGHT && k+1 >= grid[j].length) continue;
							else if(direction == LOWER_RIGHT && (j+1 >= grid.length  || k+1 >= grid[j].length)) continue;
							else if(direction == BOTTOM && j+1 >= grid.length) continue;
							else if(direction == LOWER_LEFT && (j+1 >= grid.length || k-1 < 0)) continue;
							else if(direction == LEFT && k-1 < 0) continue;
							// Procedure call for search solution
							e = solveWord(grid, list[i], j, k, direction, 0);
							if(wordSolved) break;
						}						
					}
					if(wordSolved) {
						//  If word is found, add to list with coordinates.
						b[0] = j;
						b[1] = k;
						aux.setBegining(b);
						aux.setEnding(e);
						aux.setDirection(direction);
						solvedWords.insertWord(aux);
						break;
					}
				}
				if(wordSolved) break;
			}
			if(!wordSolved) notFound.add(list[i]);	// If it's the end of matrix and word hasn't found, add to this list.
		}
		long timeEnd = System.currentTimeMillis();		
		System.out.println("Solved in " + (timeEnd - timeStart) + " miliseconds and " + iterations + " iterations.");
		fillSolution();
		printSolution();
		//sol.printList();
		if(!notFound.isEmpty()) { 	// Showing if there has not found words.
			System.out.print(notFound.size() + " element(s) not found: ");
			for(int i = 0; i < notFound.size(); i++) {
				System.out.print(notFound.get(i));
				if(i != notFound.size()-1) System.out.print(", ");
			}
			System.out.println(".");
		}
		else {
			System.out.println("All elements found.");
		}
	}
	
	/**
	 * Recursive method for search a word in the specified direction. If all characters in the
	 * specified direction are same of the word (order and value).
	 * @param grid word search puzzle array.
	 * @param word word we are trying to found.
	 * @param n row position
	 * @param m column position
	 * @param direction where to move for coincidences searching.
	 * @param charPos position of character of the word to compare with grid coordinates.
	 * @return coordinates of end of the word, if it's not the word in this direction returns null.
	 */
	private int [] solveWord(char [][] grid, String word, int n, int m, int direction, int charPos) {
		iterations++;
		if(charPos == word.length()) {
			wordSolved = true;
			int [] end = new int[2];
			// Correction of coordinates
			if(direction == UPPER_LEFT || direction == UPPER_RIGHT || direction == TOP) n = n + 1;
			if(direction == BOTTOM || direction == LOWER_LEFT || direction == LOWER_RIGHT) n = n - 1;
			if(direction == LEFT || direction == LOWER_LEFT || direction == UPPER_LEFT) m = m + 1;
			if(direction == RIGHT || direction == LOWER_RIGHT || direction == UPPER_RIGHT) m = m - 1;
			end[0] = n;
			end[1] = m;
			return end;
		}
		if(n < 0 || m < 0 || n >= grid.length || m >= grid[0].length) { // Searcher out of matrix, not a solution
			wordSolved = false;
			return null;
		}
		if(word.charAt(charPos) != grid[n][m]) {	// If isn't equal we can't found word in this direction
			wordSolved = false;
			return null;
		}
		else {
			switch(direction) {	// Recursive calls depending of its direction
				case UPPER_LEFT:
					return solveWord(grid, word, n-1, m-1, direction, charPos+1);
				case TOP:
					return solveWord(grid, word, n-1, m, direction, charPos+1);
				case UPPER_RIGHT:
					return solveWord(grid, word, n-1, m+1, direction, charPos+1);
				case LEFT:
					return solveWord(grid, word, n, m-1, direction, charPos+1);	
				case RIGHT:
					return solveWord(grid, word, n, m+1, direction, charPos+1);
				case LOWER_LEFT:
					return solveWord(grid, word, n+1, m-1, direction, charPos+1);	
				case BOTTOM:
					return solveWord(grid, word, n+1, m, direction, charPos+1);	
				case LOWER_RIGHT:
					return solveWord(grid, word, n+1, m+1, direction, charPos+1);	
				default:	// Not a valid value
					System.out.println("ERROR: Invalid direction value.");
					return null;
			}
		}
	}
	
	/**
	 * Fills the solution matrix with values of the list and its coordinates
	 */
	public void fillSolution() {
		// Fill all solution array with blank spaces.
		for(int i = 0; i < solution.length; i++) {
			for(int j = 0; j < solution[i].length; j++) {
				solution[i][j] = ' ';	
			}
		}		
		Word aux;
		int j,k,z;		// j for row iteration, k for columns

		for(int i = 0; i < solvedWords.getSize(); i++) {	// iteration of list
			aux = solvedWords.getAt(i);
			z = 0;		// index for iteration over word's chars
			switch(aux.direction) {
			case TOP:
				k = aux.begin[1];
				for(j = aux.begin[0]; j >= aux.end[0]; j--) {
					solution[j][k] = aux.term.charAt(z); 
					z++;
				}
				break;
			case LEFT:
				j = aux.begin[0];
				for(k = aux.begin[1]; k >= aux.end[1]; k--) {
					solution[j][k] = aux.term.charAt(z); 
					z++;
				}
				break;
			case RIGHT:
				j = aux.begin[0];
				for(k = aux.begin[1]; k <= aux.end[1]; k++){
					solution[j][k] = aux.term.charAt(z); 
					z++;
				}
				break;
			case BOTTOM:
				k = aux.begin[1];
				for(j = aux.begin[0]; j <= aux.end[0]; j++) {
					solution[j][k] = aux.term.charAt(z); 
					z++;
				}
				break;
			case UPPER_LEFT:
				for(j = aux.begin[0], k = aux.begin[1]; j >= aux.end[0]; j--, k--){
					solution[j][k] = aux.term.charAt(z); 
					z++;
				}
				break;
			case UPPER_RIGHT:
				for(j = aux.begin[0], k = aux.begin[1]; j >= aux.end[0]; j--, k++){
					solution[j][k] = aux.term.charAt(z); 
					z++;
				}
				break;
			case LOWER_RIGHT:
				for(j = aux.begin[0], k = aux.begin[1]; j <= aux.end[0]; j++, k++){
					solution[j][k] = aux.term.charAt(z); 
					z++;
				}
				break;
			case LOWER_LEFT:
				for(j = aux.begin[0], k = aux.begin[1]; j <= aux.end[0]; j++, k--){
					solution[j][k] = aux.term.charAt(z); 
					z++;
				}
				break;
			}
		}
	}
	
	/**
	 * Prints the matrix that contains the solution
	 */
	public void printSolution() {
		for(int i = 0; i < solution.length; i++) {
			for(int j = 0; j < solution[i].length; j++) {
				System.out.print(solution[i][j] + " ");
			}
			System.out.println();
		}
	}
}
