package P1;
import javax.crypto.*;

public class FP {
	
	
	public static int solution = 0;
	
	static int FastPower(int a,int d){
		if (d == 1){
			return a;
		}
		
		else{
			int c = a*a;
			solution++;
			
			int ans = FastPower(c, (int)Math.floor(d/2));
			solution++;
			
			if (d%2 == 1){
				solution++;
				return a* ans;
			}
			else{
				solution++;
				return ans;
			}
		}
	}
	
	public static void main(String[] args) {
		FastPower(2,4);
		System.out.println(solution);

	}

}
