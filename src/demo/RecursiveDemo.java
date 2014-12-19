package demo;

public class RecursiveDemo {

	static int factorial(int n) {
		if (n == 1) {
			return n; // 遞迴算完會加回到n
		} else {
			return n * factorial(n - 1);
		}

	}

	public static void main(String[] args) {
		int num = 5;
		System.out.println(num+"! = "+factorial(num));

	}

}
