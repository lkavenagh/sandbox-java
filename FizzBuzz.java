
public class FizzBuzz {
	
	public static void main (String args[]){
		
		int N = 50;
		
		for (int i=1; i <= N; ++i){
			if(i%(3*5)==0){ System.out.println("FizzBuzz"); }
			else if(i%3==0){ System.out.println("Fizz"); }
			else if(i%5==0){ System.out.println("Buzz"); }
			else { System.out.println(i); }
		}
	}
}
