package hy.Test;

import java.util.LinkedList;
import java.util.Stack;

public class Test10 {
	/**
	 * 請作出小算盤的功能(傳入一String x= "1 +2-3  +4+5" 忘記有沒有) 然後，按下"=" 會發生 ????計算結果?
	 */

	private static int priority(String c) {
        return c.equals("+")  || c.equals("-") ? 1 : c.equals("*") || c.equals("/") ? 2 : 0;
    }
	
	//中序式轉為後序式
	static String toPostfix(String str) {
		LinkedList<String> stack = new LinkedList<>();
		StringBuilder output = new StringBuilder();
		String[] strArray = str.replace(" ", "").split("");
		String toStack = "(";
		String toOutput = ")";

		for (int i = 0; i < strArray.length; i++) {
			String c = strArray[i];
			if (c.equals(toStack)) {
				stack.add(c);
			} else if ("+-*/".indexOf(c) != -1) { 
				while (!stack.isEmpty() // LinkedList.getLast() : 取最後一個元素出來看(不remove)
						&& priority(stack.getLast()) >= priority(c)) {
					output.append(stack.removeLast()); //LinkedList.removeLast() 取最後一個元素出來(等同於stack.pop())
				}
				stack.add(c);
			} else if (c.equals(toOutput)) {
				while (!stack.getLast().equals(toStack) ) {
					output.append(stack.removeLast());
				}
				stack.removeLast();
			} else {
				output.append(c);
			}
		}

		while (!stack.isEmpty()) {
			output.append(stack.removeLast());
		}
		return output.toString();
	}

	static int execute(String str) {
		int result = 0;
		System.out.println(toPostfix(str));

		return result;
	}

	public static void main(String[] args) {
		String str = "1 +2 - 4 /2 +4 *5"; // 21
		System.out.println(Test10.execute(str));

	}

}
