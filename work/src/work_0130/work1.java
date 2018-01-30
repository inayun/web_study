package work_0130;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/*
 * 사용자로부터 임의의 정수를 입력받아 입력받은 정수가 
 * 짝수인지, 홀수인지 를 판정하는 프로그램
 * 조건 : 삼항연산자 사용
 * 입력 : BufferdReader 사용
 * 
 */
public class work1 {

	public static void main(String[] args) throws Exception {

		int input=0; //입력 값
		String result=""; //결과
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("값 입력 : ");
		input = Integer.parseInt(br.readLine());
		result = input % 2 == 0 ? "짝수" : "홀수";
		System.out.println(result);
		
	}

}
