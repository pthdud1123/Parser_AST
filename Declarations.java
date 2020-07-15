package 중간고사;

import java.util.ArrayList;

public class Declarations extends Statement  {
	public ArrayList<D_type>members=new ArrayList<D_type>();
	
	void printf(int j) {
		for(int i=0;i<j;i++) System.out.print(" ");
		System.out.println("Declarations:");
		j++;
		for(D_type d : members) {
			for(int i=0;i<j;i++) System.out.print(" ");
			System.out.println("Declaration:");
			d.printf(j);
		}
	}
}
