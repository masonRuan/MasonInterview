package Interview.test;

public class Hopper_Recursive {
	int maxStarts;
	
    public void checkAndExcute(int n){
    	if (n < 5 || n % 2 == 0) {
			System.out.println("請輸入大等於5的奇數");
			return ;
		}
		this.maxStarts = n;
		printAll(n);//為了方便直接呼叫
    }
	public void printAll(int nowStarts) {
		if(nowStarts<1) //小於1時就不再繼續呼叫
			return;
		print(nowStarts);
		printAll(nowStarts-2);//遞迴呼叫自己
		if(nowStarts>1) //返回時遞增時大於1才印出來
			print(nowStarts);	
	}
	public void print(int nowStarts) {	//印出該行的空白與星星	
			for (int j = 0; j < (maxStarts-nowStarts)/2; j++)//扣掉星星除以2就是前面空白
				System.out.print(" "); // 印出每列之空白
			for (int j = 0; j < nowStarts; j++)
				System.out.print("*"); // 印出每列之＊
			System.out.print("\n");// 換行			
	}// end_if
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hopper_Recursive hopper = new Hopper_Recursive();
		hopper.checkAndExcute(7);
	}
}
