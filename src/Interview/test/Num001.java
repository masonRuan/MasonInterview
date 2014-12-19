package Interview.test;

/*
 將1-24共24個正整數平均分成三組，
每組8個數字，且8個數字合為100
請問有幾種分法??
# 答案1025113; 
# 同時計算出需花多少時間 (需小於1分鐘;最佳化可達1 Sec)
 */
import java.util.Arrays;

public class Num001 {
	public static int countSolutions(int[] sums, int[] groupSizes,
			int MAX_GROUP_SIZE, int n, int TARGET, int K) {
		// if no more number, check all sum equals the value of TARGET
		if (n == 0) {
			boolean isFoundTraget = true;
			for (int i = 0; i <= K - 1; i++) {
				isFoundTraget = isFoundTraget && (sums[i] == TARGET);
			}
			return (isFoundTraget) ? 1 : 0;
		}
		// Find all combination for this n and
		int total = 0;
		for (int i = 0; i <= K - 1; i++) {
			// Add n to sum which is zero (only once)
			if (sums[i] == 0) {
				sums[i] += n;
				groupSizes[i]++;
				total += countSolutions(sums, groupSizes, MAX_GROUP_SIZE,
						n - 1, TARGET, K);
				break;
			}
			// Add n to sums which are nonzero
			if (sums[i] + n <= TARGET && groupSizes[i] < MAX_GROUP_SIZE) {
				// Copy sums and each group size for next level validation
				int[] newSums = Arrays.copyOf(sums, sums.length);
				newSums[i] += n;
				int[] newGroupSizes = Arrays.copyOf(groupSizes,
						groupSizes.length);
				newGroupSizes[i]++;
				total += countSolutions(newSums, newGroupSizes, MAX_GROUP_SIZE,
						n - 1, TARGET, K);
			}
		}
		return total;
	}

	public static void  main(String[] args) { 
		Num001 one24= new Num001();
		int[] sums = {0,0,0}; //初始sum都是0
		int[] groupSizes = {0,0,0}; //初始群組size也是0
		int MAX_GROUP_SIZE = 8;  //每一組最大的size =8
		int n= 24; //1~24
		int TARGET = 100; //每組目標100
		int K = 3; //有 3 組
		int result =0; //存有多少總解法
		long time1,time2;
		
		time1 = System.currentTimeMillis();
		result = one24.countSolutions(sums, groupSizes, MAX_GROUP_SIZE, n, TARGET, K);
		time2 = System.currentTimeMillis();
		System.out.println("總共有="+result+"種組合");
		System.out.println("執行時間="+(double)(time2-time1)/1000+"秒");
	}
}