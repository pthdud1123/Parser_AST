package 중간고사;

public class Binary extends Expression {
	Operator op;
	Expression term1,term2;
	Binary(Operator o,Expression I,Expression r){
		op=o;
		term1=I;
		term2=r;
	}
	void printf(int j) {
		for(int i=0;i<j;i++) System.out.print(" ");
		System.out.println("Binary:");
		j++;
		term1.printf(j);
		op.printf(j);
		term2.printf(j);
	}
	
}
