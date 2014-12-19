package Interview.test;

public class Contest {
    public static void main(String[] args) {
        final int NUM = 40;
        int result = 0;
        long loTimeBefore = System.currentTimeMillis();        
        for(int i=0; i<100; i++){
            result = yoshi(NUM);            
        }
        long loTimeAfter = System.currentTimeMillis();
        System.out.println("yoshi: " + result);        
        System.out.println("time spent: " + (double)(loTimeAfter - loTimeBefore)/1000);
        
    }
 
    private static int yoshi(int num) {        
        // 這兒可寫任何您需要的程式並回傳您的答案
        
        //init
        int[][] table = new int[num+1][num+1];       
        for(int i=0; i<num+1; i++){
            table[i][0] = 1;
            table[i][1] = 1;
        }        
        //dynamic programming
        for(int i=2; i<=num; i++){ //i=num
            for(int j=2; j<=i; j++){ //j=bound
                if(i + j > num)
                    //no use                    
                    continue;
                
                int count = 0;                
                for(int k=1 ; k<=j; k++){ //per  bound
                    count += table[i-k][Math.min(i-k, k)];                    
                }
                table[i][j] = count;
                //System.out.print(count + "\t");                
            }            
            //System.out.println();
        }
        
        //result
        int result = 0;
        for(int k=1 ; k<=num; k++){ //per  bound
            result += table[num-k][Math.min(num-k, k)];                    
        }        
        return result;
    }
}
