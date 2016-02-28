import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static String reverse_word(String s) {
	    StringTokenizer st = new StringTokenizer(s);
	    Stack<String> sk = new Stack<String>();
	    while (st.hasMoreTokens()) {
	    	sk.push(st.nextToken());
	    }
	    String rs = "";
	    while (!sk.isEmpty()) {
	    	rs += sk.pop() + " ";
	    }
		return rs.trim();
	}
	
	public static void main(String[] args) {
		String s = "I am no good";
		System.out.println("Before: " + s);
		System.out.println(" After: " + reverse_word(s));
	}

	/* (non-Java-doc)
	 * @see java.lang.Object#Object()
	 */
	public Main() {
		super();
	}

}