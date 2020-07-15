package 중간고사;

public class Read extends Statement {
	Identifier target;
	Read(Identifier r){
		target=r;
	}
	void printf(int j) {
		for(int i=0;i<j;i++)System.out.print(" ");
		System.out.println("Read:");
		j++;
		target.printf(j);
		
	}
}
