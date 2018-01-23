import java.util.Scanner;

public class work3 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int input = scanner.nextInt();
		
		String arr[][] = new String[9/input + 9%input][input];
		
			
			for(int i = 1; i <= 9; i++) {
			
				String gugu  = "";
				for(int j = 1; j <= 9; j++) {
					gugu+= String.format("%d * %d = %d \n",i,j,i*j);
				}
				//arr[][]
			}
			

		
	}
}
