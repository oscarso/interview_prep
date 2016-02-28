import java.util.Stack;


public class Main {
	public static void main(String[] args) {
		String s = "(((((A))((B))))(()))";
		System.out.println("isBalanced: " + isBalanced(s));
	}
	
	private static boolean isBalanced(String s) {
		Stack<Character> sk = new Stack<Character>();
		boolean bNeverHad = true;
		for (char c: s.toCharArray()) {
		    if ((c != ')') && (c != '}') && (c != ']')) {
		    	// ( ( A ( B
		    	if (!bNeverHad && sk.isEmpty()) {
		    		return false;
		    	}
		    	sk.push(c);
		    	bNeverHad = false;
		    	System.out.println("push: " + c);
		    } else {
		    	// )
		    	char popc;
		    	if (!sk.isEmpty()) {
		    		popc = sk.pop();
		    		System.out.println(" POP: " + popc);
		    		while ((!sk.isEmpty()) &&
		    				(popc != '(') && (popc != '{') && (popc != '[')) {
		    			popc = sk.pop();
		    			System.out.println(" POP: " + popc);
		    			break;
		    		}
		    	} else {
		    		return false;
		    	}
		    }
		} // for
		if (sk.size() > 0)
			return false;
		return true;
	}

	/* (non-Java-doc)
	 * @see java.lang.Object#Object()
	 */
	public Main() {
		super();
	}

}