package work_0129;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class work3 {
	
	/*
	BufferedReader 클래스 사용하여 
	   이름, 국어, 영어, 수학 점수를 입력받아 이름과 총점을 
	   출력하는 프로그램을 작성하시오.
	   */
	   
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("이름 : ");
		String name = br.readLine();
		System.out.print("국어점수 : ");
		int kor = Integer.parseInt(br.readLine());
		System.out.print("영어점수: ");
		int eng = Integer.parseInt(br.readLine());
		System.out.print("수학점수 : ");
		int math = Integer.parseInt(br.readLine());
		double total = kor + eng + math;
		
		System.out.println("::::::결과::::::");
		System.out.println("이름 : " + name );
		System.out.println("총점 : " + total);
		
	}

}
