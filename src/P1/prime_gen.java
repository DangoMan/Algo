package P1;

public class prime_gen {
	
	public static boolean CP(int value){
		for (int i = 2; i < Math.sqrt(value); i++){
			if(value%i == 0){
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		
		int base = 500010;
		
		while (!CP(base)){
			base++;
		}
		
		System.out.println(base);
	}

}
