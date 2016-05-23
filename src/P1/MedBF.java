package P1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class MedBF {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new FileReader("src/Test1.txt"));
		int num[] = new int[10000];
		int count = 0;
		String read;
		long total_value = 0;
		for (int i = 1; i < num.length;i++){
			num[i]=Integer.MAX_VALUE;
		}
		
		while((read = br.readLine()) != null){
			num[count] = Integer.parseInt(read);
			Arrays.sort(num);
			
			double mid =  Math.round((count/2) + 0.1);
			
			total_value += num[(int)mid];
			
			count++;
		}
		
		System.out.println(total_value);

	}

}
