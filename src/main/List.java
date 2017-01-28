package main;

/**
 * List of solved words
 * @author Jordi Castelló
 *
 */
public class List {
	Word first;
	
	public boolean isEmpty() {
		if(first == null)
			return true;
		return false;
	}

	public void insertWord(Word w) {
		if(isEmpty()) {
			first = w;
		}
		else {
			Word aux = first;
			while(aux.next != null) {
				aux = aux.next;
			}
			aux.next = w;
		}
	}
	
	public int getSize() {
		int i = 0;
		if(isEmpty())
			return i;
		Word aux = first;
		while(aux.next != null) {
			i++;
			aux = aux.next;
		}
		return i;
	}
	
	public Word getAt(int at) {
		if(at < 0 || at >= getSize()) {
			return null;
		}
		Word aux = first;
		int i = 0;
		while(aux.next != null) {
			if(i == at) return aux;
			aux = aux.next;
			i++;
		}
		return null;
	}
	
	public void printList() {
		if(isEmpty()){ 
			System.out.println("List is empty.");
		}
		else {
			Word aux = first;
			while(aux != null) {
				System.out.println("Value: " + aux.term);
				System.out.println("Size: " + aux.size);
				System.out.println("Begin: " + aux.begin[0] + ", " + aux.begin[1]);
				System.out.println("End: " + aux.end[0] + ", " + aux.end[1]);
				System.out.println("Direction: " + aux.direction);
				System.out.println();
				aux = aux.next;
			}
		}
	}
}
