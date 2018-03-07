package web_work;

public class work2 {

	public static void main(String[] args) {


		for(int i = 0; i < 6; i++) {
			for(int j = 0; j < 6; j++) {
				if(i+j >= 5) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		} //1
		
		System.out.println();

		for(int i = 0; i < 6; i++) {
			for(int j = 0; j < 6; j++) {
				if(i+j <= 5) {
					System.out.print("*");
				} 
			}
			System.out.println();
		} //2
		
		System.out.println();

		
		int star = 1; 
		for(int i = 0; i < 6; i++) {
			for(int j = 0; j < star; j++) {
				
					System.out.print("*");
			}
			star++;
			System.out.println();
		} //3
		
		
		System.out.println();

		int star2 = 6; 
		for(int i = 0; i < 6; i++) {
			for(int j = 0; j < star2; j++) {
				
					System.out.print("*");
			}
			star2--;
			System.out.println();
		} //4
		
	}

	
}
	

