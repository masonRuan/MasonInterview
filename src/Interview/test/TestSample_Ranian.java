package Interview.test;

import java.io.*;
import java.util.*;

public class TestSample_Ranian {
	/* * * * * 鴻揚科技面試專用，請勿外洩予他人 * * * * * 
	 * 題目0:
	 * 將一個字串作以下處理
	 * 1. 將",""."全部移除
	 * 2. 切割為WORD後,將句子倒置
	 * 3. 列印出各WORD及其出現次數
	 * * * * * * * * * * * * * * * * * * * * */	
	public static void execute(String stInp) {
		if (stInp==null)
			return;
		//1. 從字串中移除","和".", 切割為WORD
		String[] word = stInp.replace(",", " ").replace(".", " ").split(" ");
		ArrayList<String> arrWord = new ArrayList<String>();
		HashMap hm = new HashMap();
		for (String st:word) {
			if (st!=null && st.length()>0) {
				//2. 將句子倒置
				arrWord.add(0, st);
				if (!hm.containsKey(st)) {
					hm.put(st, st);					
				}
			}
		}
		//3. 列印出各WORD及其出現次數(請練習完成這項功能)
		System.out.println("Reversed String=");
		for (String st:arrWord) {
			System.out.print(st+" ");
		}		
		System.out.println();
		System.out.println();
		System.out.println("All Words=");
		for (Object key:hm.keySet()) {
			int count = 0;							// additional code
			for (String storedWord : arrWord){		// additional code
				if(storedWord.equals(key)){			// additional code
					count += 1;						// additional code
				}									// additional code
			}										// additional code
			System.out.print(key + ":" + count + " ");	// modified code
		}		
	}
	/* You can test your program here*/
	public static void main(String[] args) {
		TestSample_Ranian.execute("I, Jimmy, saw a saw saw a saw");
	}
	
}
