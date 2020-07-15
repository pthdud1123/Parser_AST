package 중간고사;

public class boolLiteral extends Expression{
	String e;
	
	boolLiteral(String ex) {
		e=ex;
	}
	void printf(int j) {
		for(int i=0;i<j;i++) System.out.print(" ");
		System.out.println("boolLiteral:"+e);
	}
}
