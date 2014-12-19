package Interview.test;


public class ClockStar {

	public static void drawStar(int n){
		
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				
				/*
				判斷的邏輯：
				
				以n=5為例，用兩個跑 0 ~ n-1的迴圈，前三行的(i,j)情形如下
				(0,0) (0,1) (0,2) (0,3) (0,4)
				(1,0) (1,1) (1,2) (1,3) (1,4)
				(2,0) (2,1) (2,2) (2,3) (2,4)
				產生漏斗時，把第一行要印星星的坐標值相減(j - i)，會發現差值剛好是0~4
				然後第二行的星星坐標差值是0~2
				第三行的星星坐標差值是0
				
				所以歸納出要印星星的坐標模式為 0 <= (j - i) <= diff(i)
				diff(0)需要得到4、diff(1)需要得到2、diff(2)需要得到0
				利用n與i，可以組合出diff(i)的算式：
				(j - i) <= (n - 1 - 2i)
				化簡得到 
				j <= (n - i - 1)
				
				另外0 <= (j - i)也化簡，得到
				j >= i 
				
				所以對於漏斗上半部，只要是符合
				j >= i && j <= (n - i - 1) 這樣的條件
				就引出星星，其餘則印空白
				
				*/
				
				// 這一段處理上半部的倒三角形
				if(i < (n/2 + 1)){
					if(j >= i && j <= (n - i - 1)){
						System.out.print('*');	
					}else{
						System.out.print(' ');
					}	
				
				// 這一段處理下半部的正三角形
				}else{ 
					if(j <= i && j >= (n - i - 1)){
						System.out.print('*');
					}else{
						System.out.print(' ');	
					}
				}// end if
				
			}// 負責每一行內容的內層迴圈結束
			System.out.println("");// 斷行
		}// 負責逐行進行的迴圈結束，到此完成一個漏斗
		System.out.println("\n");
	}
	
	public static void main(String[] args) {
		ClockStar.drawStar(5);
		ClockStar.drawStar(9);
		ClockStar.drawStar(13);
		ClockStar.drawStar(27);
	}

}
