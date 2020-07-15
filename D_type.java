package 중간고사;

public class D_type {
	String t;
	Identifier id;
	D_type(String ty,Identifier a){
		t=ty;
		id=a;
	}
	
	void printf(int j) {
		j++;
		for(int i=0;i<j;i++) System.out.print(" ");
		System.out.println("type: "+t);
		id.printf(j);
	}
}
