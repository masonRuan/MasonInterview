package demo;

public class ClockStarRecursive {

	public static Object drawStar(int n, int max, boolean reversion) {
		if (n > max) {
			return null; // 最後一層遞迴的中止條件
		}

		if (max % 2 == 0 || n % 2 == 0) {
			System.out.print("請傳入奇數");
			return null;
		}

		int count = (max - n) / 2; // 這次遞迴比起上次遞迴 n的差距/2 = 要印的空白數量

		for (int i = 0; i < n; i++) {
			if (count > 0) {
				System.out.print(" "); // 印空白
				--count; // 已經印1個空白，所以-1
				--i; // 讓印空白的迴圈數重置(才不會影響星星的數量)
			} else {
				System.out.print("*");
			}
		}
		System.out.print("\n");
		if (n == 1 || reversion) { // 反轉條件
			reversion = true;
			return drawStar(n + 2, max, reversion);
		}
		return drawStar(n - 2, max, reversion); // 跑下一層遞迴
	}

	public static void main(String[] args) {
		int max = 9;
		boolean reversion = false;
		ClockStarRecursive.drawStar(max, max, reversion);
	}

}
