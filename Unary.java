package 중간고사;

public class Unary extends Expression {
	Operator O;
	Expression E;
Unary(Operator op,Expression e){
	O=op;
	E=e;
}
void printf(int j) {
	for(int i=0;i<j;i++) System.out.print(" ");
	System.out.println("Unary:");
	j++;
	O.printf(j);
	E.printf(j);
}
}
