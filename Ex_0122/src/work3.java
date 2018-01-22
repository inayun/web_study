import java.util.Scanner;

public class work3 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int input = scanner.nextInt();
		
		for(int d = 0; d <input; d++) {
			
			for(int i = 1; i <= 9; i++) {
			
				for(int j = 1; j <= 9; j++) {
					System.out.printf("%d * %d = %d",i,j,i*j);
					System.out.println();
				}
			}
			
		}
		
	}
}
