package �߰����;

public class IntLiteral extends Expression {
	String e;
	
	IntLiteral(String ex) {
		e=ex;
	}
	void printf(int j) {
		for(int i=0;i<j;i++) System.out.print(" ");
		System.out.println("IntLiteral:"+e);
	}
}
