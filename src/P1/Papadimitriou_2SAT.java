package P1;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

class clause{
	public int C1;
	public int C2;

	clause(int C1,int C2){
		this.C1 = C1;
		this.C2 = C2;
	}

	boolean checkB(boolean arr[]){
		boolean one = false;
		boolean two = false;

		if (C1 > 0){
			one = arr[C1];
		}

		else{
			one = !arr[Math.abs(C1)];
		}

		if (C2 > 0){
			two = arr[C2];
		}

		else{
			two = !arr[Math.abs(C2)];
		}

		//System.out.println(one + " " + two);
		return (one || two);

	}

}

public class Papadimitriou_2SAT {

	public static void main(String ags[]) throws IOException{
		Scanner sc = new Scanner(new FileReader("src/Test1.txt"));
		Random rd = new Random();
		int size = sc.nextInt();

		clause [] cla = new clause[size+1]; 
		int z = 0;
		
		while(sc.hasNext()){
			cla[z] = new clause(sc.nextInt(),sc.nextInt());
			z++;
		}

		for(int times = 0; times< Math.log(size);times++){

			//System.out.println(times);
			boolean b[] = new boolean[size+1];

			//random generation
			for(int i = 1; i <= size; i++){
				b[i] = rd.nextBoolean();
			}

			for(int i = 0; i <2*size*size; i++){
				//System.out.println(size);
				ArrayList arr = new ArrayList<clause>();

				for(int k = 0;k< size;k++){
					//System.out.println(cla[k].C1);
					//System.out.println(cla[k].checkB(b));
					if(cla[k].checkB(b) == false ){
						arr.add(cla[k]);
					}

				}
				
				//System.exit(0);

				//System.out.println();

				if (arr.size() == 0){
					//for(int k = 0; k<size;k++){
					//	System.out.println(b[k]);
					//}
					System.out.println("IT WORKs!!!!!!");
					System.exit(0);
				}

				int rad = rd.nextInt(arr.size());
				int var = rd.nextInt(2);
				clause c  = (clause) arr.get(rad);

				if (var == 0){
					b[Math.abs(c.C1)] = !b[Math.abs(c.C1)] ;
				}

				else {
					b[Math.abs(c.C2)] = !b[Math.abs(c.C2)] ;
				}
				
				/*for (int j= 1;j<=size;j++){
					System.out.println(b[j]);
				}
				System.out.println();*/
			
			}
		}



		System.out.println("Nope");

	}
}
