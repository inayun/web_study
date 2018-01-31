package work_0131;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class work1 {

	public static void main(String[] args) throws IOException {

		String input="";
		char alph[];
		char letter[];
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		input = br.readLine();
		alph = new char[input.length()];
		
		for(int i = 0; i<input.length(); i++) {
			alph[i] = input.charAt(i);
		}
		
		letter = new char[input.length()];

		for(int i = 0; i<input.length(); i++) {
			
		}
		
	}

}
