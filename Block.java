package 중간고사;
import java.util.ArrayList;
import java.util.Iterator;

public class Block extends Statement {
	public ArrayList<Statement>members=new ArrayList<Statement>();

	void printf(int j) {
		for(int i=0;i<j;i++)System.out.print(" ");
		System.out.println("Block:");
		j++;
		for(Statement k:members) {
			k.printf(j);
		}
	}
}
