package hy.Test;

/**
 * 輸入abcd，求出四數的全部可能總合 EX. A AB ABC ABCD ABD AC ACD AD EX. B BA BAC BACD BC BCD
 * BD. EX. C CA CAB CABD CB CBD CD. EX. D DA DAB DABC DB DBC DC.
 * 
 * 
 */
public class Test3 {
	static void recursive(String[] strArray, int[] strIndex) {
		int count = 1;
		int strlength = strIndex.length;
		
		for (int j = 0; j < strlength; j++) {
			
				for (int k = 0; k < count; k++) {
					System.out.print(strArray[k]+" ");
				}
				++count;
				System.out.print("\n");
		}

		// recursive(strArray, ++i, strLength);
	}

	static void execute(String str) {
		String[] strArray = str.split("");// "" = 沒有條件的切割字串
		int[] strIndex = new int[strArray.length];
		for (int i =0;i < strArray.length; i++){
			strIndex[i] = i;
		}
				
//		int count = 0;
//		int index = 0;
//		int loop = 0;
		
//		for (int i = 0; i < strLength; i++) {
			recursive(strArray,strIndex);
//			System.out.print("\n");
//		}

	}

	public static void main(String[] args) {
		Test3.execute("ABCD");
	}
}
