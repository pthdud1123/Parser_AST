package 중간고사;
// Parser.java
// Recursive descent parser for Expression Grammar

import java.io.*;

public class Parser {
	Token token;          // current token from the input stream
    Lexer lexer;
    String funcId = "";

  
    
    public Parser(Lexer ts) throws IOException { // Open the Clite source program
        lexer = ts;				// as a token stream, and
        token = lexer.next(); // retrieve its first Token
    }
  
	private void getToken() throws IOException {
		token = lexer.next();
	}
	
	private void parse() throws IOException {
		command();
	}

	private void command() throws IOException {
		 int L=lexer.getline();
	    int C=lexer.getcol();
	    //Expression e = expr();
		Statement e=prgm();
		/*
	    prgm();
	    
		if(C<=L) {
			System.out.println(token.type());
			System.out.println("Syntax OKkkkk");
			
		
		}
		else
			System.out.println(";is required");
			*/
	}

	private Statement prgm() throws IOException{
		Statement e;
		e=stmt();
		
		if(token.type()==TokenType.Jum) {
			System.out.println("Syntax OX");
			System.out.println("Program(AST):");
			e.printf(1);
			System.exit(1);
		}
		else {
			System.out.println("systax error");
			System.exit(-1);
		}
		return e;
	}
	
	
	private Statement stmt() throws IOException{
		Statement e= null;
		
		if(token.type()==TokenType.Identifier) {
			Identifier v=new Identifier(token.value());
			getToken();
			
			
			if(token.type()==TokenType.same) {
			
				getToken();
				Expression e2=expr();
				
				
				
				if(token.type()==TokenType.Semicolon) {
					
					e=new Assignment(v,e2);
					getToken();
				}
				else {
					System.out.print("Systax Errord");
					System.exit(1);
				}
				
			}
			else {
				System.out.println("Syntax ERROR");
				System.exit(1);
				}
		}
		
		
		
		else if (token.type() == TokenType.LeftmidParen) {
			
			getToken();
	
			e=block();
			if(token.type() == TokenType.RightmidParen) { 
				getToken();
			}
			else {
				System.out.println(")is required");
				System.exit(0);
			}
			
		}
		
		
		else if(token.type()==TokenType.IF) {
			
			getToken();
			
			if(token.type()==TokenType.LeftParen) {
				getToken();
				Expression t=expr();
				
				if(token.type()==TokenType.RightParen) {
					getToken();
					if(token.type()==TokenType.THEN) {
						getToken();
						Statement tp=stmt();
						System.out.println(token.value());
					
						if(token.type()==TokenType.ELSE) {
							
							getToken();
							
							Statement ep=stmt();
							System.out.println(token.value());
							e=new Conditional(t,tp,ep);
							
							
						}
						else {
							e=new Conditional(t,tp);
						}
					}
				}
				else {
					System.out.println(")is required");
					System.exit(0);
				}
				
				
			}
			
		}
		
		else if(token.type()==TokenType.WHILE) {
			
			getToken();
			if(token.type()==TokenType.LeftParen) {
				
				getToken();
				Expression ex=expr();
				
				if(token.type()==TokenType.RightParen) {
					getToken();
					if(token.type()==TokenType.LeftmidParen) {
						getToken();
						Statement tem=new Statement();
						while(token.type()!=TokenType.RightmidParen) {
							Statement k=stmt();
							tem=k;
						}
						getToken();
						e=new While(ex,tem);
					}
				}
				else {
					System.out.println(")is required");
					System.exit(0);
				}
				
				
				
			}
			
		}
		
		else if(token.type()==TokenType.READ) {
			getToken();
			
			if(token.type()==TokenType.Identifier) {
				Identifier i=new Identifier(token.value());
				getToken();
				
				
				if(token.type()==TokenType.Semicolon) {
					e=new Read(i);
					getToken();
				}
				else {
					System.out.print("Systax Error");
					System.exit(1);
				}
			}
			else {
				System.out.print("Systax Error");
				System.exit(1);
			}
		
		}
		
		else if(token.type()==TokenType.PRINT) {
			getToken();
			Expression ex=expr();
			e=new Print(ex);
			getToken();
			if(token.type()==TokenType.Semicolon) {
				getToken();
			}
			else {
				System.out.print("Systax Error");
				System.exit(1);
			}
			
		}
		
		else if(token.type()==TokenType.let) {
			getToken();
			Declarations d=decls();
			
			if(token.type()==TokenType.in) {
				
				getToken();
				
				
				Block b=new Block();
				
				while(token.type() != TokenType.end) {
					Statement s = stmt();
					
					b.members.add(s);
					
				}
				
			
				
				if(token.type()==TokenType.end) {
					e=new Let(d,b);
					//e.printf(1);
					getToken();
				}
				else {
					System.out.println("systax error");
					System.exit(-1);
				}
			}
			else {
				System.out.println("systax error");
				System.exit(-1);
			}
			
			
		}
		
		
		return e;
	}

	private Declarations decls() throws IOException{
		Declarations d=new Declarations();
		while(token.type()==TokenType.Bool||token.type()==TokenType.Int) {
			String s = token.value();
			getToken();
			Identifier id = new Identifier(token.value());
			D_type temp=new D_type(s,id);
			getToken();
			d.members.add(temp);
			
	
			
			if(token.type()==TokenType.Semicolon) {
				getToken();
			}
			
		}
		return d;
	}
	
	private Statement block()throws IOException{

		Block b = new Block();
		
			
			while(token.type() != TokenType.RightmidParen||token.type()!=TokenType.end) {
				
				Statement S=stmt();
				
				b.members.add(S);
				
				
				if(token.type() == TokenType.RightmidParen||token.type()==TokenType.end) {
					//getToken();
					
					break;
				}
			}
	
		return b;
		
		
	}
	
	private Expression expr() throws IOException {
		Expression e=bexp();
		
		while(token.type()==TokenType.and||token.type()==TokenType.or) {
			Operator op=new Operator(token.value());
			getToken();
			Expression e2=bexp();
			e=new Binary(op,e,e2);
		}
		
		if(token.type()==TokenType.not) {
			Operator op=new Operator(token.value());
			getToken();
			e=expr();
			getToken();
			e=new Unary(op,e);
		}
		else if(token.type()==TokenType.True||token.type()==TokenType.False) {
			e=new Boolvalue(token.value());
			getToken();
			
		}
		return e;
		
		
	}
	private Expression bexp() throws IOException {
		Expression e=aexp();
		
		
		if(relop()) {
			
			Operator op=new Operator(token.value());
			getToken();
			Expression e2=aexp();
			e=new Binary(op,e,e2);
		}
		
		return e;
	}
	
	private boolean relop() throws IOException{
	if(token.type()==TokenType.samesame||token.type()==TokenType.rightbigsame||token.type()==TokenType.leftbigsame||token.type()==TokenType.rightbig||token.type()==TokenType.leftbig||token.type()==TokenType.notsame) {
		return true;
	}
	return false;
	}


	private Expression aexp() throws IOException {
		Expression e=term();
		while(token.type() == TokenType.Plus||token.type()==TokenType.Minus) {
			Operator op=new Operator(token.value());
			getToken();
			Expression e2=term();
			e=new Binary(op,e,e2);
		}
		return e;
	}
	

	private Expression term() throws IOException {
		Expression e=factor();
		while(token.type() == TokenType.Multiply||token.type() == TokenType.Divide) {
			Operator op=new Operator(token.value());
			getToken();
			Expression e2=factor();
			e=new Binary(op,e,e2);
		}
		return e;
	}
	
	private Expression factor() throws IOException {
		Expression e=null;
		if(token.type() == TokenType.Minus) {
			System.out.println(token.value());
			Operator op=new Operator(token.value());
			getToken();
			System.out.println(token.value());
			Expression e1=primary();
			System.out.println("야");
			e=new Unary(op,e1);
		}
		else {
			Expression e1=primary();
			e=e1;
		}
		return e;
	}
	

	private Expression primary() throws IOException {
		Expression e=null;
		if(token.type().equals(TokenType.Identifier)) {
			Identifier v=new Identifier(token.value());
			e=v;
			getToken();
			
		}
		else if(token.type().equals(TokenType.IntLiteral)) {
			IntLiteral v=new IntLiteral(token.value());
			e=v;
			getToken();
			
		}
		else if(token.type().equals(TokenType.LeftmidParen)){
			getToken();
			e=aexp();
			if(token.type() == TokenType.RightParen)
				getToken();
		}
	return e;	
	}
 
    public static void main(String args[]) throws IOException {
		Parser parser;

		if (args.length == 0) {
            System.out.println("Begin parsing... ");
		    parser  = new Parser(new Lexer());
		    parser.parse();
		}
    	else {
			System.out.println("Begin parsing... " + args[0]);
			parser  = new Parser(new Lexer(args[0]));
		    parser.parse();
	    }
    } //main

} // Parser
