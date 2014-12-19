package demo;

public class RecursiveForDemo {
	
	static long factorial(long n){
		long sum = 1;
		for (long i = n; i > 1; i--){
			sum*=i;
		}
		
		return sum;
	}
	
	public static void main(String[] args){
		System.out.println(factorial(25));
	}
}
