package demo;

import java.util.LinkedList;

public class PrimesDemo {

	int m;
	int n;

	PrimesDemo(int m, int n) {
		this.m = m; // 最小值
		this.n = n; // 最大值
	}

	void calculate() {
		if (m > n) {
			System.out.println("must left <= right ");
			return;
		}else if (m<0){
			System.out.println("must left > 0 ");
			return;
		}
		LinkedList<Integer> primes = new LinkedList<>();
		int num;
		for (int i = m; i <= n; i++) {

			if (i % 2 == 0 || i == 1) {
				if (i == 2) {
					primes.add(i);
				}
				continue;
			}
			num = i;
			for (int j = i - 2; j >= 1; j -= 2) {
				if (num % j == 0 && j != 1) {
					break;
				} else if (j == 1) {
					primes.add(num);
				}
			}// End: for j
		}// End: for i

		printPrimes(primes);
	}

	void printPrimes(LinkedList<Integer> primes) {
		for (int i : primes) {
			System.out.print(i + " ");
		}
	}

	public static void main(String[] args) {
		long time1, time2;
		time1 = System.currentTimeMillis();
		PrimesDemo pd = new PrimesDemo(0, 5848);
		pd.calculate();
		time2 = System.currentTimeMillis();

		System.out.println("\n執行時間=" + (double) (time2 - time1) / 1000 + "秒");
	}

}
