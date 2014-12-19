package Interview.test;
public class RecursiveFor {

	public static int factorial(int n) {
		for (int i = n-1; i > 1; i--) {
			n*=i;
		}
		return n;
	}

	public static void main(String[] args) {

		System.out.println("5! = " + factorial(5));

	}

}
