
public class work2 {

	public static void main(String[] args) {

		int arr[][] = new int[4][4];
		int cnt = 16;
		
		
		for(int i = 0; i < 4; i++) {
			
			if(i%2==0) { //i가 짝수일때
				for(int j = 0; j < 4; j++) {
					arr[j][i] = cnt;
					cnt--;

				}
			} else { //i가 홀수일때
				for(int j = 0; j < 4; j++) {
					cnt ++;
					arr[j][i] = cnt;
					
				}
			}
			cnt-=4;
			System.out.println();
		}
		
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j <4; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println("");
		}
		
	}

}
