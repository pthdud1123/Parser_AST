package 중간고사;

public class Boolvalue extends Expression {
	String a;
	Boolvalue(String b){
		a=b;
	}
	void printf(int j) {
		for(int i=0;i<j;i++) System.out.print(" ");
		System.out.println("Boolvalue:"+a);
	}
}
