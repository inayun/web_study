package work_0129;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class work2 {
	
	/*
	   삼각형의 밑변과 높이를 입력받아 
	   삼각형의 넓이를 구하는 프로그램 사용
	  
	   삼각형 넓이 = 높이 * 밑변 / 2
	*/
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("삼각형의 밑변 : ");
		double bottom = Integer.parseInt(br.readLine());
		System.out.print("삼각형의 높이 : ");
		double height = Integer.parseInt(br.readLine());
		double area = height * bottom / 2;

		System.out.println("삼각형 넓이 : " + area);
	}

}
