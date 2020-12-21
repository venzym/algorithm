package function;

public class Func_Second {
	public static void main(String[] args) {
		
		int[] arr = new int[10000];
		
		for (int i=0; i<arr.length; i++) {
			if (d(i) >= 10000) {
				continue;
			}
			
			arr[d(i)] = 1;
		}
		
		for (int i=0; i<arr.length; i++) {
			if (arr[i] != 1) {
				System.out.println(i);
			}
		}
		
	}

	private static int d(int i) {

		int a = i/1000;
		int b = (i%1000)/100;
		int c = (i%100)/10;
		int d = i%10;
		
		return i+a+b+c+d;
	}
}
