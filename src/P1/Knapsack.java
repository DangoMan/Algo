package P1;
import java.io.*;

public class Knapsack {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("src/knapsack_big.txt"));
		
		int[][] arr;
		int items[][];
		int titem;
		int max_weight;
		
		String st[] = br.readLine().split(" ");
		titem = Integer.parseInt(st[1]);
		max_weight = Integer.parseInt(st[0])+1;
		items = new int[titem][2];
		arr = new int[2][max_weight];
		
		for (int i = 0; i<titem; i++){
			//System.out.println(i);
			st = br.readLine().split(" ");
			
			items[i][0]= Integer.parseInt(st[0]);
			items[i][1]= Integer.parseInt(st[1]);
		}
		
		//init first roll
		for(int i = 0; i<max_weight; i++ ){
			arr[0][i] = 0;
		}
		
		for(int i = 0; i<titem; i++ ){
			
			for(int j = 0;j<max_weight;j++){
				
				int V1 = arr[0][j];
				int V2;
				
				if(j >  items[i][1]){
					V2 = items[i][0] + arr[0][j - items[i][1]];
				}
				
				else{
					V2 = 0;
				}
				
				if (V1 > V2){
					arr[1][j] = V1;
				}
				
				else{
					arr[1][j] = V2;
				}
			}

			
			
			int temp[] =  arr[0];
			arr[0] = arr[1];
			arr[1] = temp;
		}
		
		System.out.println(arr[0][max_weight-1]);
	}
}
