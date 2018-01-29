package work_0129;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.Format;

public class work1 {

	//원의 넓이와 둘레를 구하는 프로그램을 작성
	//BufferedReader 클래스를 사용하여 반지름을 입력받아 처리 
	
	  /*  
	  원의 넓이 = 반지름 * 반지름 * 3.141592
	  원의 둘레 =반지름 * 2 * 3.141592
	   */
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("원의 반지름 : ");
		int r = Integer.parseInt(br.readLine());
		double area = r * r * 3.141592;
		double round = r *  2 * 3.141592;
		
		System.out.printf("원의 넓이 : %.2f \n", area);
		System.out.printf("원의 둘레 : %.2f" , round);
		
	}
}
