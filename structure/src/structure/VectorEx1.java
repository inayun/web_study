package structure;

import java.util.Vector;

public class VectorEx1 {

	private static final String colors[] = {
			"pink","black","white","blue","green","orange",
			"yellow","brown","red","navy","purple","gray",
			"yellow","brown","red","navy","purple","gray",
			"yellow","brown","red","navy","purple","gray"};
	
	public static void main(String[] args) {

		
		int i;
		String str;
		
		Vector v = new Vector();
		
		for(i = 0; i<colors.length; i++) {
			v.add(colors[i]);
			
		}
		
		for(Object o : v) {
			str = (String)o;
			System.out.print(str + " ");
		}
		
		System.out.println(v.size());
	}

}
