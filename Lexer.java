package 중간고사;
// Lexer.java
import java.io.*;

public class Lexer {

    private char ch = ' '; 
    private BufferedReader input;
    private String line = "";
    private int col = 1;
    private int con=0;
    private boolean gubun=false;
    private final String letters = "abcdefghijklmnopqrstuvwxyz"
        + "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private final String digits = "0123456789";
    private final char eolnCh = '\n';

    public Lexer (String fileName) { // source filename
        try {
            input = new BufferedReader (new FileReader(fileName));
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
            System.exit(1);
        }
    }

	public Lexer ( ) { // from standard input 
            input = new BufferedReader (new InputStreamReader(System.in));
			System.out.print(">");
	}
	public int getline() {
		return line.length();
		
	}
	public int getcol(){
		return col;
	}

    private char nextChar() { // Return next char
        col++;
        if (col >= line.length()) {
            try {
            	if(gubun) {
            		System.out.println("Syntax eerror");
            		System.exit(1);
            	}
				System.out.print("    ");
                line = input.readLine( );
                System.out.println(line);
                gubun=true;
               
            } catch (IOException e) {
                System.err.println(e);
                System.exit(1);
            } // try
            col = 0;
        } // if col
        return line.charAt(col);
    }
            

    public Token next( ) { // Return next token
        do {
            if (isLetter(ch)) { // ident 
                String spelling = concat(letters + digits);
                if(spelling.equals("true"))
                	return Token.T;
                else if(spelling.equals("false"))
                	return Token.F;
                else if(spelling.equals("if"))
                	return Token.IFTok;
                else if(spelling.equals("then"))
                	return Token.THENTok;
                else if(spelling.equals("else"))
                	return Token.ELSETok;
                else if(spelling.equals("while"))
                	return Token.WHILETok;
                else if(spelling.equals("read"))
                	return Token.READTok;
                else if(spelling.equals("print"))
                	return Token.PRINTTok;
                else if(spelling.equals("let"))
                	return Token.LetTok;
                else if(spelling.equals("in"))
                	return Token.InTok;
                else if(spelling.equals("end"))
                	return Token.endTok;
                else if(spelling.equals("int"))
                	return Token.IntTok;
                else if(spelling.equals("bool"))
                	return Token.BoolTok;
                else
                	return Token.mkIdentTok(spelling);
            } else if (isDigit(ch)) { // int 
                String number = concat(digits);
                return Token.mkIntLiteral(number);
            } else 
			switch (ch) {
            case ' ': case '\t': case '\r': case eolnCh:
                ch = nextChar();
                break;
            case '=': ch = nextChar();
            	if(ch == '=') {
            		ch = nextChar();
            		return Token.SamesameTok;
            	}
            	else {
            		return Token.SameTok;
            	}
            	
            case '<':ch =nextChar();
            	if(ch=='=') {
            		ch=nextChar();
            		return Token.RightsameTok;
            	}
            	else {
            		return Token.RightbigTok;
            	}
			case '>':ch=nextChar();
            	if(ch=='=') {
            		ch=nextChar();
            		return Token.LeftsameTok;
            	}
            	else {
            		return Token.LeftbigTok;
            	}
			case '{':ch=nextChar();
				return Token.leftmidParenTok;
				
			case '}':
				if(col+1<line.length()) {
            		ch=nextChar();
            		return Token.RightmidParenTok;
            	}            
            	else
            		return Token.RightmidParenTok;
				
				
			case '!':ch=nextChar();
            	if(ch=='=') {
            		ch=nextChar();
            		return Token.NotSameTok;
            	}
            	else {
            		return Token.NotTok;
            	}
			case '&':ch=nextChar();
				return Token.AndTok;
			case '|':ch=nextChar();
				return Token.ORTok; 
			
			case '/':  // divide 
                ch = nextChar();
                return Token.divideTok;
            
//            case eofCh:  case '.': 
//				return Token.eofTok;
            
            case '+': ch = nextChar();
                return Token.plusTok;
            case '-': ch = nextChar();
                return Token.minusTok;
            case '*': ch = nextChar();
                return Token.multiplyTok;
            case '(': ch = nextChar();
                return Token.leftParenTok;
            case ')': ch = nextChar();
                return Token.rightParenTok;
            case ';': //ch = nextChar();
            	if(col+1<line.length()) {
            		ch=nextChar();
            		return Token.semicolonTok;
            	}            
            	else
            		return Token.semicolonTok;
            case '.':
            	return Token.JumTok;
            } // switch
        } while (true);
    } // next


    private boolean isLetter(char c) {
        return (c>='a' && c<='z' || c>='A' && c<='Z');
    }
  
    private boolean isDigit(char c) {
        return (c>='0' && c<='9'); 
    }

    private String concat(String set) {
        String r = "";
        do {
            r += ch;
            ch = nextChar();
        } while (set.indexOf(ch) >= 0);
        return r;
    }

    public void error (String msg) {
        System.err.print(line);
        System.err.println("Error: column " + col + " " + msg);
        System.exit(1);
    }

    static public void main ( String[] args ) {
        Lexer lexer;
		if (args.length == 0)
            lexer = new Lexer( );
		else
            lexer = new Lexer(args[0]);

        Token tok = lexer.next( );
        while (tok != Token.semicolonTok) {
            System.out.println(tok);
             tok = lexer.next( );
        } 
    } // main
}