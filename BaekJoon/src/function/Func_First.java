package function;

public class Func_First {
	public static void main(String[] args) {
		
		int[] a = {10, 33, 32, 62, 68};
		
		sum(a);
		
	}

	private static long sum(int[] a) {
			
		long sum = 0;
		for (int i=0; i<a.length; i++) {
			sum += a[i];
		}
		
		return sum;
	}
}
