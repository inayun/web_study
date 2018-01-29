package work_0122;

public class work1 {

	public static void main(String[] args) {

		int cnt = 0;
		
		for(int i = 0; i < 4; i++) {
			if(i%2 == 0) { //i가 짝수일경우
				for(int j = 0; j < 4; j++) {
					cnt++;
					System.out.print(cnt+" ");
				}
			} else { //i가 홀수일경우
				for(int j = 4; j > 0; j--) {
					System.out.print(cnt+" ");
					cnt--;
				}
			}
			System.out.println();
			cnt+=4;
		}
	}
}
