package P1;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

class ver{
	double x;
	double y;
	int next;

	ver(double x, double y){
		this.x = x;
		this.y = y;
	}
}


public class TSP {

	public static void main(String[] args) throws IOException  {
		double min = Double.MAX_VALUE;
		for(int a = 0;a< 1000;a++){
			Scanner sc = new Scanner(new FileReader("src/tsp.txt"));
			int size = sc.nextInt();
			ver node[] = new ver[size];


			for(int i = 0; i< size; i++){
				node[i] = new ver(sc.nextDouble(), sc.nextDouble());
			}

			//randomize
			shuffleArray(node);

			//init
			double mintour = 0;
			node[0].next = 0;

			//checking every single possibility
			for (int i = 1; i<size;++i){
				double minI = Double.MAX_VALUE;
				ver add = node[i];
				int position = 0;

				for (int j = 0 ;j < i;++j){
					ver cur = node[j];
					double distance = Distance(cur,add) + Distance(node[cur.next],add) -  Distance(cur,node[cur.next]);

					if (distance < minI){
						minI = distance;
						position = j;
					}

				}
				//insert the data
				int temp = node[position].next;
				node[position].next = i;
				node[i].next = temp;
				mintour += minI;
			}

			//System.out.println(mintour);
			if(mintour < min){
				min = mintour;
			}
		}
		System.out.println(min);

	}


	// Implementing Fisher¨CYates shuffle
	static void shuffleArray(ver[] ar)
	{
		Random rnd = new Random();
		for (int i = ar.length - 1; i > 0; i--)
		{
			int index = rnd.nextInt(i + 1);
			// Simple swap
			ver a = ar[index];
			ar[index] = ar[i];
			ar[i] = a;
		}
	}

	static double Distance(ver a, ver b){
		
		double d = Math.sqrt(((a.x - b.x)*(a.x - b.x)) + ((a.y - b.y)*(a.y - b.y)));
		return d;


	}


}
