import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
	public static void main(String[] args) {
		String s = "Salesforce is the best company to work for";
		s = s.toLowerCase();
		int ht[] = new int[127];
		LinkedList<Character> list = new LinkedList<Character>();
		for (int i=0; i < s.length(); i++) {
			final char ch = s.charAt(i);
			list.add(i, ch);
			if (ht[ch] != -1) {
				ht[ch]++;
				if (ht[ch] > 1) {
					ht[ch] = -1;
				}
			}
		}
		for (Character c : list) {
			if (ht[c.charValue()] != -1 && ht[c.charValue()] == 1) {
				System.out.println("First non-repeat character: " + c);
				break;
			}
		}
	}

	/* (non-Java-doc)
	 * @see java.lang.Object#Object()
	 */
	public Main() {
		super();
	}
	
	
	private class Entry {
		Character v;
		int count;
	}

}