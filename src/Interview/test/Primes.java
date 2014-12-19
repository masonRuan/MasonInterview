package Interview.test;
import java.util.LinkedList;

//求m,n間所有的質數 if m<n
public class Primes {
	int m;
	int n;

	Primes(int m, int n) {
		this.m = m;
		this.n = n;
	}

	void calculate() {
		LinkedList<Integer> primes = new LinkedList<>();
		boolean isRight = false;
		if (m > n) {
			System.out.println(" must m<=n ");
			return;
		}
		for (int i = m; i <= n; i++) {
			for (int j = 2; j <= i; j++) {// 剔除1因為1可以整除任何數
				isRight = true; // 每次檢查前都先預設為true
				if (i % j == 0 && i != j) { // 質數除了1和自己之外不可以被其他數整除
					isRight = false; // 若有錯誤則設成false
					break; // 非質數就不用再檢查下去
				}
			}// 檢查完沒有錯誤進到下一行
			if (isRight == true) // 若還是true表示為質數
				primes.add(i); // 將質數加入
		}
		printPrimes(primes);// 印出該範圍的質數
	}// end calculate()

	void printPrimes(LinkedList<Integer> primes) {
		for (int i : primes) {
			System.out.print(i + " ");
		}
	}

	public static void main(String[] args) {
        long time1,time2;
        time1 = System.currentTimeMillis();
		Primes primes = new Primes(0, 5848);// 裡面參數為m與n的範圍 m<=n 0~5848  LinkedList長度限制
		primes.calculate();
		time2 = System.currentTimeMillis();
        System.out.println("\n執行時間="+(double)(time2-time1)/1000+"秒");
	}

}

