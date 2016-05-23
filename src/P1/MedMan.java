package P1;
import java.io.*;

public class MedMan {

	public static int lowheap[] = new int[5002];
	public static int lowb = 0;

	public static int upheap[] = new int[5002];
	public static int upb = 0;

	static void insertlow(int i){
		lowb ++;

		lowheap[lowb] = i;

		if(lowb != 1){
			bubbleuplow(lowb);
		}

	}

	static void bubbleuplow(int bottom){
		int up = (int) Math.floor(bottom/2);
		//System.out.println(lowheap[up]);

		if (lowheap[bottom] > lowheap[up]){
			int temp = lowheap[bottom];
			lowheap[bottom] = lowheap[up];
			lowheap[up] = temp;

			if(up != 1){
				bubbleuplow(up);
			}
		}
	}

	static int extractMax(){
		int t = lowheap[1];
		lowheap[1] = lowheap[lowb];
		lowb--;

		if(2 < lowb){
			bubbledownlow(1);
		}

		return t;
	}

	static void bubbledownlow(int bottom){
		int up1 = bottom * 2;
		int up2;

		if(bottom * 2+1 >= lowb){
			up2 = bottom * 2+1;
		}

		else{
			up2 = 0;
		}
		//System.out.println(lowheap[up]);
		if (lowheap[bottom] > lowheap[up1] && lowheap[bottom] > lowheap[up2]){
			return;
		}

		else if (lowheap[up1] > lowheap[up2]){
			int temp = lowheap[bottom];
			lowheap[bottom] = lowheap[up1];
			lowheap[up1] = temp;

			if(up1 *2 < lowb){
				bubbledownlow(up1);
			}
		}

		else if (lowheap[up1] < lowheap[up2]){
			int temp = lowheap[bottom];
			lowheap[bottom] = lowheap[up2];
			lowheap[up2] = temp;

			if(up2 *2 < lowb){
				bubbledownlow(up2);
			}
		}

	}


	static void insertup(int i){
		upb ++;

		upheap[upb] = i;

		if(upb != 1){
			bubbleupup(upb);
		}
	}

	static void bubbleupup(int bottom){

		int up = (int) Math.floor(bottom/2);

		if (upheap[bottom] < upheap[up] ){
			int temp =upheap[bottom];
			upheap[bottom] = upheap[up];
			upheap[up] = temp;

			if(up != 1){
				bubbleupup(up);
			}
		}

	}

	static int extractMin(){
		int t = upheap[1];
		upheap[1] = upheap[upb];
		upb--;

		if(2 < upb){
			bubbledownup(1);
		}

		return t;
	}

	private static void bubbledownup(int bottom) {
		
		int up1 = bottom * 2;
		int up2;
		
		if(bottom * 2+1 >= upb){
			up2 = bottom * 2+1;
		}
		
		else{
			up2 = 0;
		}
		//System.out.println(lowheap[up]);
		if (upheap[bottom] < upheap[up1] && upheap[bottom] < upheap[up2]){
			return;
		}
		
		else if (upheap[up1] < upheap[up2]){
			if(upheap[up1] != Integer.MAX_VALUE){
				int temp = upheap[bottom];
				upheap[bottom] = upheap[up1];
				upheap[up1] = temp;

				if(up1 *2 < upb){
					bubbledownup(up1);
				}
			}
		}
		
		else if (upheap[up1] > upheap[up2]){
			if(upheap[up2] != Integer.MAX_VALUE){
				int temp = upheap[bottom];
				upheap[bottom] = upheap[up2];
				upheap[up2] = temp;

				if(up2 *2 < upb){
					bubbledownlow(up2);
				}
			}
		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("src/Median.txt"));

		String read;
		long total_value = 0;
		lowheap[0] = 0;
		upheap[0] = Integer.MAX_VALUE;
		while((read = br.readLine()) != null){
			int value = Integer.parseInt(read);

			if(value > lowheap[1]){
				insertup(value);
				
				if(upb > lowb){
					insertlow(extractMin());
				}
				
				
			}

			else{
				insertlow(value);

				if(upb + 1 < lowb){
					insertup(extractMax());
				}
			}
			
			if(upb <= lowb){
				//System.out.println(total_value );
				total_value += lowheap[1];
			}
			
			else{
				//System.out.println(total_value );
				total_value += upheap[1];
			}
			
			if(Math.abs(upb - lowb) > 1) {
				System.out.println("Error");
			}
		}
		
		System.out.println(total_value);

	}

}
