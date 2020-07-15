package 중간고사;

class Assignment extends Statement {
	// Assignment = Identifier target; Expression source
	Identifier target;
	Expression source;
	Assignment (Identifier t, Expression e) {
	target = t;
	source = e;
	}
	
	void printf(int j) {
		for(int i=0;i<j;i++) System.out.print(" ");
		System.out.println("Assignment:");
		j++;
		target.printf(j);
		source.printf(j);
	}
	}