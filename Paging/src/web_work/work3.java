package web_work;

public class work3 {

	public static void main(String[] args) {

		
		// 0 + 1 - (1*2) + (1*2*3) - (1*2*3*4) + (1*2*3*4*5) = 101
		// 1 - 2 + 6 -  24 + 120 = 101
		int flag1 = 1; //outer 연산자
		int result1 = 0;
		int temp1 = 0; //팩토리얼을 위한 변수
		
		for(int i = 1; i <= 5; i++) {
			temp1 = 1;
			for(int j = 1; j <= i; j++) {
				temp1 *= j;
			}
			result1 += temp1*(flag1);
			flag1 *= -1;
		}
		System.out.println(result1);
		
		
		// 1 + (1-2) - (1-2+3) + (1-2+3-4) - (1-2+3-4+5) = -7
		int flag2 = 1; //outer 연산자 
		int result2 = 1;
		int temp2 = 0; //팩토리얼을 위한 변수
		int oper = 1; //inner 연산자 flag
		
		for(int i = 2; i <= 5; i++) {
			temp2 = 1;
			oper = 1;
			for(int j = 1; j <= i; j++) {
				temp2 += j*oper;
				oper *= -1;
			
			}
			result2 += temp2*(flag2);
			flag2 *= -1;
		}
		System.out.println(result2);
		
		
		
		
	}

}
