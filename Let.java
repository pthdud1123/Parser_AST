package 중간고사;

public class Let extends Statement{
	Declarations decls;
	Block body;
	Let(Declarations ds,Block b){
		decls=ds;
		body=b;
	}
	void printf(int j) {
		for(int i=0;i<j;i++) System.out.print(" ");
		System.out.println("Let:");
		j++;
		decls.printf(j);
		body.printf(j);
	}
}
