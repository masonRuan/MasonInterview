package hy.Test;

/**
 * 輸入abcd，求出四數的全部可能總合 EX. A AB ABC ABCD ABD AC ACD AD EX. B BA BAC BACD BC BCD
 * BD. EX. C CA CAB CABD CB CBD CD. EX. D DA DAB DABC DB DBC DC.
 * 
 * 
 */
public class Test3 {
	static void recursive(String[] strArray, int i, int strLength) {
		int count = i+1;
		for (int j = 0; j < strLength; j++) {
			for (int k = 0; k < count; k++) {
				if (count < strLength) {
					System.out.print(strArray[k]+" ");
					++count;
					k--;
				} else {
					count = i;
				}
			}

		}

		// recursive(strArray, ++i, strLength);
	}

	static void execute(String str) {
		String[] strArray = str.split("");// "" = 沒有條件的切割字串
		int count = 0;
		int index = 0;
		int loop = 0;
		int strLength = strArray.length;
		for (int i = 0; i < strLength; i++) {
			recursive(strArray, i, strLength);
			System.out.print("\n");
		}

	}

	public static void main(String[] args) {
		Test3.execute("ABCD");
	}
}
