package 중간고사;

public class Conditional extends Statement {
	Expression test;
	Statement thenbranch,elsebranch;
	Conditional(Expression t,Statement tp){
		test=t;
		thenbranch=tp;
		elsebranch=null;
	}
	Conditional(Expression t,Statement tp,Statement ep){
		test=t;
		thenbranch=tp;
		elsebranch=ep;
	}
	void printf(int j) {
		for(int i=0;i<j;i++) System.out.print(" ");
		
		System.out.println("Conditional:");
		test.printf(j);
		thenbranch.printf(j);
		
		if(elsebranch!=null)
			elsebranch.printf(j);
	}
}
