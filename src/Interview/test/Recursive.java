package Interview.test;

public class Recursive {

	public static int factorial(int n){
		    if (n == 1)  {  //When will the function stop 
		      return 1;
		    } else {
		      return n * factorial(n -1 );
		    }
		  }
	
	public static void main(String[] args) {
		
		 System.out.println("5! = " + factorial(5));

	}

}
