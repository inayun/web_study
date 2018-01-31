package structure;

import java.util.Vector;

public class VectorEx2 {
	
	private static final String colors[] = {
			"pink","black","white","blue","green","orange",
			"yellow","brown","red","navy","purple","gray",
			"yellow","brown","red","navy","purple","gray",
			"yellow","brown","red","navy","purple","gray"};
	
	public static void main(String[] args) {

		Vector<String> v = new Vector<String>();
		
		for(String str : colors) {
			v.add(str);
		}
		System.out.println("first :" + v.firstElement());
		System.out.println("last  :" + v.lastElement());

	}

}
