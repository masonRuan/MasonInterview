package Interview.test;

public class PairChecker {
	
	char[] pairLeft = {'(', '[', '{', '<', ')', ']', '}', '>'};
	char[] pairRight = {')', ']', '}', '>', '(', '[', '{', '<'};
	
	public void checkPair(String sample){
		
		if(sample.length() % 2 != 0){
//			System.out.println("not even a pair");
			System.out.println("false");
			return;
		}
		
		int halfLength = sample.length() / 2;
		int[] indexLeft = new int[halfLength];
		int[] indexRight = new int[halfLength];
		
		for(int i = 0; i < halfLength; i++){
			char charLeft = sample.charAt(i);
			for(int x = 0; x < pairLeft.length; x++){
				if(charLeft == pairLeft[x]){
					indexLeft[i] = x;
					break;
				}
			}
		}
		
		for(int j = halfLength; j < sample.length(); j++){
			char charRight = sample.charAt(j);
			for(int y = 0; y < pairRight.length; y++){
				if(charRight == pairRight[y]){
					indexRight[j - halfLength] = y;
					break;
				}
			}
		}
		
		boolean checkFlag = true;
		for(int z = 0; z < indexLeft.length; z++){
			if(indexLeft[z] != indexRight[indexLeft.length-1-z]){
				checkFlag = false;
				break;
			}
		}
		System.out.println(checkFlag);
	}
	
	public static void main(String[] args) {
		
		PairChecker pc = new PairChecker();
		pc.checkPair("<><>");
		
	}

}
