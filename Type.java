package 중간고사;

public class Type extends Expression {
	String ty;
	Type(String a){
		ty=a;
	}
	void printf(int j) {
		System.out.println("Type:"+ty);
	}

}
