package P1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
/**
 * 
 * @author Randy Lin
 * Date: 2013/7/17
 *
 */

public class QuickSort {

	public static int arrays[] = new int [10001];
	public static long solutions = 0;
	
	public static int sort(int o, int t, int th){
		int i[] = new int[3];
		i[0] = arrays[o];
		i[1] = arrays[t];
		i[2] = arrays[th];
		
		Arrays.sort(i);
		if(i[1] == arrays[o]){
			return o;
		}
		
		else if(i[1] == arrays[t]){
			return t;
		}
		else {
			return th;
		}
	}
	
	public static void swap(int a, int b){
		int temp = arrays[a];
		arrays[a] = arrays[b];
		arrays[b] = temp;
	}
	
	public static void QS(int up, int low){

		if(low-up >= 1){
			
			//System.out.println();


			//reset variable
			int pivot = sort(up,(int) Math.floor((low+up-1)/2),low-1);
			int i = up+1;

			//swap the first element with the pivot
			//System.out.println(arrays[up] + " " + arrays[pivot]);

			swap(up,pivot);
			
			//System.out.println(pivot);

			//System.out.println("s");

			//the run through loop
			for (int j = i; j < low; j++){
				if(arrays[j] < arrays[up]){
					swap(i,j);
					i++;

					//System.out.println("s");
				}
			}

			swap(i-1,up);

			QS(up,i-1);
			QS(i,low);
			
			solutions += low-up-1;

		}


	}

	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("src/QuickSort.txt"));

		int counter = 0;

		String read;
		while((read = br.readLine()) != null){
			arrays[counter] = Integer.parseInt(read);
			counter++;
		}
		
		
		QS(0,counter);
		
		
		for (int i = 0; i<counter; i++){
			System.out.println(arrays[i]);
		}	
		
		System.out.println(solutions);


	}
}
