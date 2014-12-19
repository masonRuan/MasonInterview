package Interview.test;

import java.util.HashMap;

public class CheckPair {

    public static boolean checkpair(String str){
    	char[] pairLeft = {'(', '[', '{', '<', ')', ']', '}', '>'};
    	char[] pairRight = {')', ']', '}', '>', '(', '[', '{', '<'};
    	  	
		if(str.length() % 2 != 0){ //如果字串長度不成偶數一定不成對return false
			return false;
		}
		
		HashMap hm = new HashMap();
		//把對應的字串存進key和value key:{ => value:}
		for(int i=0;i<pairLeft.length;i++){
			hm.put(pairLeft[i], pairRight[i]);
		}
		int length = str.length();
		//先取str字串第1個字去Hashmap找該對應的符號value，再去跟對稱的符號比對，不一樣就回傳false。
		//例如: ({  |  })  中間切一半，比對( 與 )  再來比對  { 與  } 發現都一樣return true
		for(int i=0;i<length/2;i++){
			if((char)hm.get(str.charAt(i))!=str.charAt(length-i-1)){
				return false;
			}
		}
		return true;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(CheckPair.checkpair("({){}(})"));

	}

}
