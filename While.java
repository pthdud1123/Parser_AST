package 중간고사;

public class While extends Statement {
	Expression test;
	Statement body;
	While(Expression e,Statement s) {
		test=e;
		body=s;
	
	}
	void printf(int j) {
		for(int i=0;i<j;i++)System.out.print(" ");
		System.out.println("While:");
		j++;
		test.printf(j);
		body.printf(j);
	}
}
