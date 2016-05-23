package P1;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class C1 {

	public static int arrays[] = new int [100001];
	public static long solutions = 0;

	public static int[] run(int lower, int upper){

		//base case
		if(upper - lower <= 1){
			int output[] = new int[1];
			output[0] = arrays[lower];
			
			//System.out.println(arrays[upper]);
			
			return output;
		}


		//general case
		else{

			int mid = (int) (upper - (upper-lower)/2);

			int[] lower_array = run(lower,mid);
			int[] upper_array = run(mid,upper);

			return merge(lower_array, upper_array);
		}
	}


	private static int[] merge(int[] smaller, int[] bigger) {
		int length = smaller.length + bigger.length;
		int [] output  = new int[length];
		int up = 0;
		int low = 0;

		//copying array
		for(int i = 0; i < length; i++){

			//if all element is copy over
			if (up >= smaller.length){
				//copy the rest of the element over
				while (low  < bigger.length){
					output[i] = bigger[low];
					
					low++;
					i++;
				}
			}

			else if (low  >= bigger.length){
				//copy the rest of the element over
				while (up < smaller.length){
					output[i] = smaller[up];
			
					
					up++;
					i++;
				}
			}

			else if (smaller[up] < bigger[low]){
				output[i] = smaller[up];
				
				up ++;
			}

			else if (smaller[up] > bigger[low]){
				output[i] = bigger[low];
				
				solutions += smaller.length - up;
				//System.out.println(smaller.length - up);
				low ++;
			}


		}

		return output;
	}

	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("src/IntegerArray.txt"));

		int counter = 0;

		String read;
		while((read = br.readLine()) != null){
			arrays[counter] = Integer.parseInt(read);
			counter++;
		}
		
		
		int result[] = run(0,counter);
		
		
		for (int i = 0; i<counter; i++){
			System.out.println(result[i]);
		}	
		
		System.out.println(solutions);
		
	}
}
