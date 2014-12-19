package demo;

import java.util.HashMap;

public class CheckPair {

	static boolean checkpair(String str) {
		char[] pairLeft = { '(', '[', '{', '<', ')', ']', '}', '>' };
		char[] pairRight = { ')', ']', '}', '>', '(', '[', '{', '<' };

		if (str.length() % 2 != 0) { // 非偶數就代表一定不是一對
			return false;
		}

		HashMap<Character, Character> hm = new HashMap<>();
		for (int i = 0; i < pairLeft.length; i++) {
			hm.put(pairLeft[i],pairRight[i]);
		}
		
		int length = str.length();
		for (int i = 0; i < length; i++) {
			if(hm.get(str.charAt(i))!=str.charAt(length-i-1)){
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(CheckPair.checkpair("({})"));
	}
}
