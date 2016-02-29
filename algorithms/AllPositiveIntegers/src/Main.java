import java.util.Hashtable;

/*
 *	Print all possible integers of a, b, c, and d where a^3 + b^3 = c^3 + d^3
 */
public class Main {
	public static final int N = 4;

	static class Pair {
		public int x;
		public int y;

		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		public String toString() {
			return "(" + x + "," + y + ")";
		}
	}

	public static void compute() {
		int sum = 0;
		Hashtable<Integer,Pair> ht = new Hashtable<Integer,Pair>();
		
		for (int c=1; c <= N; c++) {
			for (int d=1; d <= N; d++) {
				Pair pair1 = new Pair(c,d);
				sum = p3(pair1.x) + p3(pair1.y);
				if (!ht.containsKey(sum)) {
					ht.put(sum, pair1);
					Pair pair2 = new Pair(pair1.y,pair1.x);
					System.out.println("sum:" + sum + "  pair1:" + pair1.toString() + "  pair2:" + pair2.toString());
				}
			}
		}
	}
	
	private static int p3(int x) {
		return (x * x * x);
	}
	
	public static void main(String[] args) {
		Main.compute();
	}
}
