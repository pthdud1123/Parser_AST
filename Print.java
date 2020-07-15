package 중간고사;

public class Print extends Statement {
	Expression ex;
	Print(Expression e){
		ex=e;
	}
	void printf(int j) {
		for(int i=0;i<j;i++)System.out.print(" ");
		System.out.println("Print:");
		j++;
		ex.printf(j);
	}
}
