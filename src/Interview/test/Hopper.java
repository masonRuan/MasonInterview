package Interview.test;

public class Hopper {
	int input;

	Hopper(int input) {
		if (input < 5 || input % 2 == 0) {
			System.out.println("請輸入大等於5的奇數");
			return;
		}
		this.input = input;
	}

	public void print() {
		int x, i, j, k, d;
		x = input;
		k = x; // 每列之＊數
		d = -2; // 每列之差數
		for (i = 0; i < x; i++) { //每執行一次此迴圈代表印完一行
			for (j = 0; j < (x - k) / 2; j++)//該行扣掉星星數除以2就是前面應有的空白
				System.out.print(" "); // 印出每列之空白
			for (j = 0; j < k; j++)
				System.out.print("*"); // 印出每列之＊
			System.out.print("\n");// 換行
			k += d; // 重設每列＊數
			if (k == 1)
				d = 2; // 到中點，差數反轉
		}// end_for_i
	}// end_if

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hopper hopper = new Hopper(5);
		hopper.print();
	}
}
