﻿package Interview.test;
import java.io.*;
import java.util.*;

public class TEST0by_Antai {
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
				if (!hm.containsKey(st)) {//假如沒有重複
					hm.put(st, 1);					
				}else{ //若有重複就把值取出來加1再放回去
					int tem_count;
					tem_count=(int)hm.get(st)+1;
					hm.put(st,tem_count);				
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
			System.out.print(key+":"+hm.get(key)+"  ");
		}		
	}
	/* You can test your program here*/
	public static void main(String[] args) {
		TEST0by_Antai.execute("I, Jimmy, saw a saw saw a saw");
	}
	
}
