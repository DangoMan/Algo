package P1;

import java.io.*;
import java.math.BigDecimal;

class jobs{
	public int weight;
	public int time;
	public double score;
	
	jobs(int weight, int time){
		this.time = time;
		this.weight = weight;
		score = (double) weight/time;
	}
	
}
public class Jobscode {
	
	public static jobs J[];
	
	public static void swap(int a, int b){
		jobs temp = J[a];
		J[a] = J[b];
		J[b] = temp;
	}
	
	
	public static void QS(int up, int low){

		if(low-up >= 1){
			
			//System.out.println();


			//reset variable
			int pivot = up;
			int i = up+1;

			//swap the first element with the pivot
			//System.out.println(arrays[up] + " " + arrays[pivot]);

			swap(up,pivot);
			
			//System.out.println(pivot);

			//System.out.println("s");

			//the run through loop
			for (int j = i; j < low; j++){
				if(J[j].score > J[up].score){
					swap(i,j);
					i++;

					//System.out.println("s");
				}
				
			}

			swap(i-1,up);

			QS(up,i-1);
			QS(i,low);
		}


	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("src/jobs.txt"));
		int data_size = Integer.parseInt(br.readLine());
		J = new jobs[data_size];
		
		String input;
		String[] st = new String[2];
		
		for(int i = 0; i<data_size; i++){
			input = br.readLine();
			st = input.split(" ");
			J[i] = new jobs(Integer.parseInt(st[0]),Integer.parseInt(st[1]));
		}
		
		QS(0, data_size);
		
		long times = 0, solution = 0;
		
		for(int i = 0; i<data_size; i++){
			times += J[i].time;
			solution += times * J[i].weight;
			
			/*
			System.out.println(J[i].weight + " " + J[i].time);
			System.out.println(J[i].score);
			System.out.println(times * J[i].weight);
			*/
			
			
		}
		System.out.println(solution);
	}

}
