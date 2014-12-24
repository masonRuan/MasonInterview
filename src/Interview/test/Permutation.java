package Interview.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;


public class Permutation {
	
	TreeSet<Character> initPool;
	HashMap<Character, Character> mapPool;
	ArrayList<ArrayList<Character>> permutationResults;
	ArrayList<ArrayList<Character>> combinationResults;
	
	public Permutation(String input){
		
		this.initPool = new TreeSet<Character>();
		char[] charArr = input.toCharArray();
		for(char entry : charArr){
			this.initPool.add(entry);
		}
		
		this.mapPool = new HashMap<Character, Character>();
		char[] charArrM = input.toCharArray();
		for(char entry : charArrM){
			this.mapPool.put(entry, 'o');
		}
		
		this.permutationResults = new ArrayList<ArrayList<Character>>();
		this.combinationResults = new ArrayList<ArrayList<Character>>();

	}
	
	public TreeSet<Character> getShrinkedPool(TreeSet<Character> pool, char rmChar){
		
		TreeSet<Character> shrinkedPool = new TreeSet<Character>();
		for(char entry : pool){
			shrinkedPool.add(entry);
		}
		shrinkedPool.remove(rmChar);
		return shrinkedPool;
		
	}
	
	public ArrayList<Character> copyResult(ArrayList<Character> base){
		
		ArrayList<Character> copiedResult = new ArrayList<Character>();
		for(char entry : base){
			copiedResult.add(entry);
		}
		return copiedResult;
		
	}
	
	public void Per(TreeSet<Character> pool, ArrayList<Character> temp){
		
		Iterator<Character> itRound = pool.iterator();
		while(itRound.hasNext()){
			
			ArrayList<Character> result = null;
			if(temp == null){
				result = new ArrayList<Character>();	
			}else{
				result = copyResult(temp);
			}
			
			char currentChar = itRound.next();
			result.add(currentChar);

			if(pool.size() > 1){
				this.Per(getShrinkedPool(pool, currentChar), result);
			}else{
				this.permutationResults.add(result);
				return;
			}
			
		}
		
	}
	
	public void refreshMapPool(){
		Set<Character> keys = this.mapPool.keySet();
		for(char key : keys){
			if(mapPool.get(key) == 'x'){
				mapPool.put(key, 'o');
			}
		}
	}
	
	public TreeSet<Character> getShrinkedKeys(TreeSet<Character> Keys, char rmTarget){
		
		TreeSet<Character> shrinkedKeys = new TreeSet<Character>();
		Iterator<Character> itInputKeys = Keys.iterator();
		boolean load = false;
		while(itInputKeys.hasNext()){
			char currentKey = itInputKeys.next();
			if(currentKey != rmTarget && load != true){
				continue;
			}else if(currentKey == rmTarget){
				load = true;
				continue;
			}else if(currentKey != rmTarget && load == true){
				shrinkedKeys.add(currentKey);
			}
		}
		return shrinkedKeys;
	}
	
	public void getMarkedResult(){
		
		ArrayList<Character> result = new ArrayList<Character>();
		Set<Character> keys = this.mapPool.keySet();
		TreeSet<Character> orderedKeys = new TreeSet<Character>(keys);
		for(char key : orderedKeys){
			if(mapPool.get(key) == 'o'){
				result.add(key);
			}
		}
		this.combinationResults.add(result);
		
	}
	
	public void Com(TreeSet<Character> orderedKeys, int marks){
		
		if(orderedKeys == null){
			Set<Character> mapKeys = this.mapPool.keySet();
			orderedKeys = new TreeSet<Character>(mapKeys);
		}
		
		Iterator<Character> itOrKeys = orderedKeys.iterator();
		
		int marked = 0;
		while(itOrKeys.hasNext()){
			
			if(marks > 0){
				
				marked = 0;
				char currentKey = itOrKeys.next();
				
				if(orderedKeys.subSet(currentKey, true, orderedKeys.last(), true).size() < marks){
					continue;
				}// 檢查剩下來的key還夠不夠遞迴使用
				
				if(orderedKeys.lower(currentKey) != null){
					mapPool.put(orderedKeys.lower(currentKey), 'o');
				}// 把上次的標記洗掉
				mapPool.put(currentKey, 'x');// 移動標記一格
				marked++;
				if(marks > marked){
					int reducedMarks = marks;
					Com(getShrinkedKeys(orderedKeys, currentKey), --reducedMarks);
				}// 如果還需要標記，就遞迴呼叫本方法，傳入小一號的key包，標記數量也減一
				if(marks == 1){
					getMarkedResult();	
				}
			}else{
				getMarkedResult();
				break;
			}
			
		}// end while iteration
		
		if(marks < (mapPool.size() - 1) && orderedKeys.size() == this.mapPool.size()){
			refreshMapPool();
			int increasedMarks = marks; 
			Com(orderedKeys, ++increasedMarks);
		}else if(marks == (mapPool.size() - 1)){
			return;
		}
		
		for(char key : orderedKeys){
			mapPool.put(key, 'o');
		}
	}
	
	public void executeP(){
		
		this.Per(this.initPool, null);
		
		for(ArrayList<Character> result : this.permutationResults){
			for(char seq : result){
				System.out.print(seq);
			}
			System.out.println(" ");
		}
		
	}
	
	public void executeC(){
		
		this.Com(null, 0);
		
		for(ArrayList<Character> result : this.combinationResults){
			for(char seq : result){
				System.out.print(seq);
			}
			System.out.println(" ");
		}
		
	}
	
	public void executeCombo(){
		
		this.Com(null, 0);
		
		for(ArrayList<Character> result : this.combinationResults){
			this.initPool.clear();
			for(char resultEntry : result){
				this.initPool.add(resultEntry);
			}
			this.Per(this.initPool, null);
		}
		
		for(ArrayList<Character> result : this.permutationResults){
			for(char seq : result){
				System.out.print(seq);
			}
			System.out.println(" ");
		}
	}
	
	public static void main(String[] args) {
		 
		Permutation p0 = new Permutation("ABCD");

//		executeP() 只會跑排列
//		p0.executeP();

//		executeC() 只會跑組合
//		p0.executeC();
		
//		executeCombo() 會先跑組合，再依據組合的內容跑排列
		p0.executeCombo();
	}

}
