package 중간고사;

public class Identifier extends Expression{
	String e;
	
	Identifier(String s) {
		e=s;
	}
	void printf(int j) {
		for(int i=0;i<j;i++) System.out.print(" ");
		System.out.println("Identifier:"+e);
	}
}
