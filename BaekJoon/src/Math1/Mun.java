package Math1;

public class Mun {
	public static void main(String[] args) {
		
		String a = "hello";
		String b = "hello";
		String c = new String("hello");
		
		System.out.println(a==c);
		System.out.println(a.equals(c));
		
		System.out.println();
		a = "bye";
		System.out.println(b);
		
	}
}
