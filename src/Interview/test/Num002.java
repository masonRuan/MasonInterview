package Interview.test;

/*
 * #數字拆解
3 = 2+1 = 1+1+1 所以3有三種拆法
4 = 3 + 1 = 2 + 2 = 2 + 1 + 1 = 1 + 1 + 1 + 1 共五種
5 = 4 + 1 = 3 + 2 = 3 + 1 + 1 = 2 + 2 + 1 = 2 + 1 + 1 + 1 = 1 + 1 +1 +1 +1 共七種
依此類推，請問一個指定數字NUM的拆解方法個數有多少個？
# 請計算出Num=40共多少解法,需花多少時間(須印出所有合法解法)
num = 40, count = 37337, time = 1.188
# 請同時計算出需花多少時間 (需小於1分鐘)
 */
public class Num002 {  
    /** 
     * 正<strong>整數</strong>加法不同的分解法 
     * @param sum：和 
     * @param max：最大值 
     * @param data：紀錄不同的加法形式 
     * @param index：加法分解數的最大個數 
     * @return 分解個數
     */  
    public static int  splitInteger(int sum, int max, int[] data, int index) {  
        if (max > sum) max = sum;  
        if (sum < 1 || max < 1) return 0;  
        if (sum == 1 || max == 1) {  
            if (sum == 1) {  
                data[index] = sum;  
                print(data, index+1);  
            } else {  
                for (int i = 0; i < sum; i++) {  
                    data[index++] = max;  
                }  
                print(data, index);  
            }  
            return 1;  
        }  
        if (sum == max) {  
            data[index] = max;  
            print(data, index+1);  
            return 1 + splitInteger(sum, max-1, data, index);  
        } else if (sum > max) {  
            data[index] = max;  
            //注意這裡的先後順序 
            return splitInteger(sum-max, max, data, index+1) + splitInteger(sum, max-1, data, index);             
        } else {   
            //sum < max  
            return splitInteger(sum, sum, data, index);  
        }  
    }  
      
    //打印數組  
    public static void print(int[] data, int index) {  
        for (int i = 0; i < index -1; i++) {  
            System.out.print(data[i] + "+");  
        }  
        System.out.println(data[index-1]);  
    }  
     
    public static void main(String[] args) {  
        int n = 3;  
        int[] data = new int[n];  
        long time1,time2;
        time1 = System.currentTimeMillis();
        System.out.println("分解" + n + "的方法有" + splitInteger(n,n,data,0) +"種");
        time2 = System.currentTimeMillis();
        System.out.println("執行時間="+(double)(time2-time1)/1000+"秒");
    }  
}  

