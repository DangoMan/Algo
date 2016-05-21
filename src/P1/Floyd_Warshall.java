package P1;
import java.io.*;


public class Floyd_Warshall {
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("src/g3.txt"));
		String str[] = br.readLine().split(" ");
		int nodes = Integer.parseInt(str[0]);

		int arr[][][] = new int[2][nodes][nodes];

		//init the array 
		for(int i = 0; i < nodes; i++){
			for(int j = 0; j < nodes; j++){
				if(i == j){
					arr[0][i][j] = 0;
				}
				else{
					arr[0][i][j]= 100000;
				}
			}
		}

		for(int i = 0; i<Integer.parseInt(str[1]);i++){
			String st[] = br.readLine().split(" ");
			int j = Integer.parseInt(st[0])-1;
			int k = Integer.parseInt(st[1])-1;
			int length = Integer.parseInt(st[2]);
			if(arr[0][j][k] > length){
				arr[0][j][k] = length;
			}
		}

		for(int k= 0; k<nodes;k++){
			for(int i= 0; i<nodes;i++){
				for(int j= 0; j<nodes;j++){
					arr[1][i][j] =100000;
					int v1 = arr[0][i][j];
					int v2 = arr[0][i][k]+arr[0][k][j];
					if(v1 <= v2){
						if(v1  <= 50000){
							arr[1][i][j] = v1;
						}
						
					}

					else{
						if(v2  <= 50000){
							arr[1][i][j] = v2;
						}
					}
				}
			}
			//swap
			int temp[][] = arr[0];
			arr[0] = arr[1];
			arr[1] = temp;

		}
		
		int smallest = 100000;
		
		for(int i= 0; i<nodes;i++){
			for(int j= 0; j<nodes;j++){
				if(arr[0][i][j] <= smallest){
					//System.out.println("Hello");
					smallest = arr[0][i][j];
				}
			}
		}

		System.out.println(smallest);
	}
}
