package P1;

import java.io.*;
import java.util.*;

class obj{
	
	public obj next = null;
	long key_value;
	boolean isuse = false;
	
	obj(long key){
		key_value = key;
	}
	
	
}

public class two_Sum {
	
	final public static int HASH_KEY = 500029;
	public static obj po_Li[] = new obj[HASH_KEY];
	public static ArrayList ne_Li = new ArrayList<Long>();
	public static boolean[] answer = new boolean[20001];
	
	static void insert(obj o, long k){
		
		if(o == null){
			o = new obj(k);
		}
		
		else if(o.next != null){
			insert(o.next,k);
		}
		
		else{
			o.next = new obj(k);
		}
	}
	
	static void insert(int o, long k){
		
		if(po_Li[o] == null){
			po_Li[o] = new obj(k);
		}
		
		else if(po_Li[o].next != null){
			insert(po_Li[o].next,k);
		}
		
		else{
			po_Li[o].next = new obj(k);
		}
	}
	
	static boolean search(obj o, long k){
		
		if (o == null|| (o.next == null && o.key_value != k)){
			return false;
		}
		
		else if(o.key_value == k){
			return true;
		}
		
		else{
			return search(o.next,k);
		}
		
	}
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new FileReader("src/algo1_programming_prob_2sum.txt"));
		
		//init the list
		for(int i = 0; i < po_Li.length;i++){
			po_Li[i] = null;
		}
		
		//read from file
		String read;
		while((read = br.readLine()) != null){
			long value = Long.parseLong(read);
			
			if (value < 0 ){
				ne_Li.add(value);
			}
			
			else if (value > 0 ){
				long v = value%HASH_KEY;
				//System.out.println(v);
				insert((int) v,value);
				
				//System.out.println(po_Li[(int) v].key_value);
			}
		}
		
		int counter = 0;
		
		//System.out.println(ne_Li.size());
		/*
		for(int i = 0; i < po_Li.length;i++){
			if(po_Li[i] != null){
				counter++;
			}
		}
		*/
		//System.out.println(counter);
		for(int i =0; i< answer.length;i++){
			answer[i] = false;
		}
		
		for(int i = 0; i < ne_Li.size();i++){
			
			long k = Math.abs((long) ne_Li.get(i));
			
			A: for(long l = k - 10000; l <= k+10000;l++){
				
				int v = (int) (l % HASH_KEY);
				
				//System.out.println(v);
				//System.out.println(((long)ne_Li.get(i)) + l );
				
				if(search (po_Li[v],l)){
					//System.out.println(k-l);
					int aa =(int) (((long) ne_Li.get(i)) + l) + 10000;
					answer[aa] = true;
				}
			}
		}
		
		for(int i =0; i< answer.length;i++){
			if(answer[i]){
				counter++;
			}
		}
		System.out.println(counter);
	}

}
