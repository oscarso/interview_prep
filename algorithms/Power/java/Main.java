
public class Main {
	public static int power(int x, int n) {
		if (n == 0) return 1;
		else if (n == 1) return x;
		else if (n % 2 == 1) {
			return x * power(x, n-1);
		} else {
			int r = power(x, n/2);
			return r * r;
		}
	}
	
	public static void main(String[] args) {
		int r;

		r = Main.power(2,0);
		System.out.println("power(2,0) = " + r);
		r = Main.power(2,1);
		System.out.println("power(2,1) = " + r);
		r = Main.power(2,3);
		System.out.println("power(2,3) = " + r);
		r = Main.power(2,4);
		System.out.println("power(2,4) = " + r);
	}

	/* (non-Java-doc)
	 * @see java.lang.Object#Object()
	 */
	public Main() {
		super();
	}

}