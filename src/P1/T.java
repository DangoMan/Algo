package P1;
/**
 * 
 * @author Randy Lin
 */

import java.util.Arrays;

public class T {
	
	public static int arrays[] = {4,2,8,5,7,1};
	
	public static void main(String[] args) {
		int up = 0;
		int low = arrays.length;
		
		System.out.println(sort(up,(int) Math.floor((low+up-1)/2),low-1));
		
		

	}
	
	public static int sort(int o, int t, int th){
		int i[] = new int[3];
		i[0] = arrays[o];
		i[1] = arrays[t];
		i[2] = arrays[th];
		
		Arrays.sort(i);
		System.out.println(i[0] + " " + i[1] + " " + i[2]);
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

}
