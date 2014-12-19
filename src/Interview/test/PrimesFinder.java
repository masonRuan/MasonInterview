package Interview.test;

import java.util.ArrayList;
import java.util.List;

public class PrimesFinder {
	
	// 儲存上下界
	int lowerBound;
	int upperBound;
	
	// 整數物件屬性，暫存發現的質數；List儲存所有發現的質數
	Integer currentPrime;
	List<Integer> primesPack;
	
	// 初始化，判定上下界與合法輸入值
	public PrimesFinder(int lowerBound, int upperBound){
		
		primesPack = new ArrayList<Integer>();
		if(lowerBound >= upperBound){
			this.lowerBound = upperBound;
			this.upperBound = lowerBound;
		}else{
			this.lowerBound = lowerBound;
			this.upperBound = upperBound;	
		}
		
		this.isLegalTestTarget(this.lowerBound);
		
	}
	
	// 判定合法輸入值的方法，如果不通過就結束整支程式
	public void isLegalTestTarget(int testTarget){
		
		if(testTarget < 2){
			System.out.println("Please give integers greater than 1.");
			System.exit(0);
		}
		
	}
	
	// 檢查質數的方法，預設回傳true，由2開始往上除，如果遇到整除就確認不是質數，即可結束方法。如果除到頂都有餘數，
	// 就確認發現質數，並將找到的質數存到PrimesFinder的屬性物件裡。
	public boolean isPrime(int testTarget){
		
		// checkCeiling決定找質數時，由下往上要除到哪裡即可
		// 想法：如果不是質數，因數兩兩配對時，長得像是山一樣，以12為例：2 x 6, 3 X 4, 4 x 3, 6 x 2
		// 立著排起來
		// 2 x 6, 
		// 3 X 4, 
		// 4 x 3, 
		// 6 x 2
		// 發現每一組左右兩個數會越來越接近。如果是平方數，就會匯合在一起，例如5 x 5
		// 找因數的時候，觀察上面兩兩成對的情形，只要找到左邊小的，就不必再找右邊對應大的
		// 所以想法是由2開始，除到待測數的山峰應該就檢查完了。以平方數的特例來說，就是往上除到平方根即可。
		// 平方數除了4之外，越大的數平方根都會比除以2小，這裡懶得去弄平方數，就直接把待測數除以2
		int checkCeiling = 0;
		checkCeiling = testTarget / 2;
		
		for(int i = 2; i <= checkCeiling; i++){
			if(testTarget % i == 0){
//				System.out.println("Gotcha! Current number: " + testTarget + " is not prime, stopped at: " + i);
				return false;
			}
		}
		
		System.out.println("----Got a prime: " + testTarget + "----");
		this.currentPrime = testTarget;
		return true;
	}
	
	// 如果通過質數檢查，用list屬性儲存發現的質數
	public void storePrime(boolean primeCheckOK){
		
		if(primeCheckOK){
			primesPack.add(this.currentPrime);
		}
		
	}
	
	// 從PrimesFinder初始上跑到下界，逐筆檢查，找到質數就存。逐筆跑完後引出結果。
	public void loopCheck(){
		
		for(int i = this.lowerBound; i <= this.upperBound; i++){
			this.storePrime(this.isPrime(i));
		}
		
		this.printPrimes();
		
	}
	
	// 從PrimesFinder的list屬性印出內容的方法
	public void printPrimes(){
		
		int counter = 0;
		StringBuffer primesResult = new StringBuffer();
		for(Integer eachPrime : primesPack){
			primesResult.append(eachPrime).append("\n");
			counter++;
		}
		System.out.println("\n" + primesResult);
		System.out.println("Primes count: " + counter);
	}
	
	public static void main(String[] args) {
        long time1,time2;
        time1 = System.currentTimeMillis();

		PrimesFinder myFinder = new PrimesFinder(2, 5848);
		myFinder.loopCheck();
		time2 = System.currentTimeMillis();
	    System.out.println("執行時間="+(double)(time2-time1)/1000+"秒");
		
	}

}
