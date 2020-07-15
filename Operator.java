package 중간고사;

public class Operator {
	final static String PLUS="+";
	final static String MINUS="-";
	final static String TIMES="*";
	final static String DIV="/";
	final static String SS="==";
	final static String NS="!=";
	final static String R="<";
	final static String L=">";
	final static String RS="<=";
	final static String LS=">=";
	final static String AND="&";
	final static String OR="|";
	
	String val;
	Operator(String s){
		val=s;
	}
	public String toString() {
		return val;
	}
	public boolean equals(Object obj) {
		return val.equals(obj);
	}
	void printf(int j) {
		for(int i=0;i<j;i++) System.out.print(" ");
		System.out.println("Operator:"+val);
	}
}
