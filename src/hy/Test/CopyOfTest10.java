package hy.Test;

import java.util.ArrayList;
import java.util.LinkedList;

public class CopyOfTest10 {
	/**
	 * 請作出小算盤的功能(傳入一String x= "1 +2-3  +4+5" 忘記有沒有) 然後，按下"=" 會發生 ????計算結果?
	 * 
	 * 傳入字串限制： 數字只能個位數，[0-9]+,-,*,/,=,?  以外的字元傳進去都會掛掉
	 * 
	 * 程式碼觀念應用到
	 */

	private static int priority(String c) {
		return c.equals("+") || c.equals("-") ? 1 : c.equals("*")
				|| c.equals("/") ? 2 : 0;
	}

	// 中序式轉為後序式
	static ArrayList<String> toPostfix(String str) {
		LinkedList<String> stack = new LinkedList<>(); // 經過條件排序，push +,-,*,/
		ArrayList<String> output = new ArrayList<>();  // 完整的後序式算式存在這
		String[] strSplit = str.replace(" ", "").replace("=", " ") //處理字串中不必要的字元並切割成陣列
				.replace("?", " ").trim().split("");
		String toStack = "(";
		String toOutput = ")";
		StringBuilder sb = new StringBuilder();
		ArrayList<String> strArray = new ArrayList<>();
		
		for(int i =0;i< strSplit.length; i++){
			String c = strSplit[i];
			if (c.matches("\\d")){
				sb.append(c);
				continue;
			} else {
				strArray.add(sb.toString());
				strArray.add(c);
				sb.setLength(0); //把sb初始化
			}
		}
		if(sb.length()!= 0){
			strArray.add(sb.toString());
		}
		
		
		for (int i = 0; i < strArray.size(); i++) {
			String c = strArray.get(i);
			if (c.equals(toStack)) { //遇到 "(" 存進stack
				stack.add(c);
			} else if ("+-*/".indexOf(c) != -1) { // c為+,-,*,/ 其中一個
				while (!stack.isEmpty() 
						&& priority(stack.getLast()) >= priority(c)) {
					// priority(stack.getLast()) >= priority(c)
					// 比對優先順序(有點難解釋...)
					// 取最後一個元素出來看(不remove)
					output.add(stack.removeLast()); // LinkedList.removeLast()
													// 取最後一個元素出來(等同於stack.pop())
				}
				stack.add(c);
			} else if (c.equals(toOutput)) { // 遇到   ")"
				while (!stack.getLast().equals(toStack)) {
					//把 stack裡面的+,-,*,/ add到output內，直到遇到 "("  為止
					output.add(stack.removeLast());
				}
				stack.removeLast(); // 把"("給remove
			} else {
				output.add(c); //數字直接add到output
			}
		}

		while (!stack.isEmpty()) { //stack還有值的話也全加進output內
				output.add(stack.removeLast());
		}
		return output;
	}

	static int execute(String str) {
		int result = 0;
		ArrayList<String> output = toPostfix(str); // 後序式算式
		LinkedList<Integer> numList = new LinkedList<>();//計算時存放數字的stack
		int[] numArray = new int[2]; // 兩個運算元與運算子計算時 存放的位置 
		for (String postfixStr : output) {
			if (postfixStr.matches("[0-9]+")) {
				numList.add(Integer.parseInt(postfixStr)); //postfixStr為數字時存進numList
				continue;
			}
			
			numArray[1] = numList.pollLast(); //取出numList內的數字  (按照stack方式取
			numArray[0] = numList.pollLast();
			//四則運算，把結果存回numList
			if (postfixStr.equals("+")) {
				numList.add(numArray[0] + numArray[1]);
				continue;
			} else if (postfixStr.equals("-")) {
				numList.add(numArray[0] - numArray[1]);
				continue;
			} else if (postfixStr.equals("*")) {
				numList.add(numArray[0] * numArray[1]);
				continue;
			} else if (postfixStr.equals("/")) {
				numList.add(numArray[0] / numArray[1]);
				continue;
			}
		}
		result = numList.pollLast(); //正常的話numList只剩結果這個數字而已

		System.out.print("\n");
		return result;
	}

	public static void main(String[] args) {
		String str = "1 +2 - 4 /2 +4 *5 =?"; // 21
		System.out.println(CopyOfTest10.execute(str));

	}

}
