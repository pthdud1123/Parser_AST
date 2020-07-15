package 중간고사;


//Token.java
//Tokens for Expression Grammar

//import java.lang.Enum;
enum TokenType {
  Eof, Semicolon, 
  LeftParen, RightParen, 
  Plus, Minus, Multiply,
  Divide, Identifier, IntLiteral,
  same,LeftmidParen,RightmidParen,
  WHILE,IF,THEN,ELSE,READ,PRINT,
  samesame,notsame,rightbig,leftbig,rightbigsame,leftbigsame,
  and,not,or,True,False,empty,let,in,end,Bool,Int,Jum
}

public class Token {

 public static final Token eofTok = new Token(TokenType.Eof, "<<EOF>>");//final:상수
 public static final Token leftParenTok = new Token(TokenType.LeftParen, "(");//TokenType이라는LeftParen이라는 변수를 TOken 형식으로 새로 객체를 생성해한다.
 public static final Token rightParenTok = new Token(TokenType.RightParen, ")");
 public static final Token semicolonTok = new Token(TokenType.Semicolon, ";");
 public static final Token plusTok = new Token(TokenType.Plus, "+");
 public static final Token minusTok = new Token(TokenType.Minus, "-");
 public static final Token multiplyTok = new Token(TokenType.Multiply, "*");
 public static final Token divideTok = new Token(TokenType.Divide, "/");
 public static final Token SameTok=new Token(TokenType.same,"=");
 public static final Token SamesameTok= new Token(TokenType.samesame,"==");
 public static final Token NotSameTok=new Token(TokenType.notsame,"!=");
 public static final Token RightbigTok=new Token(TokenType.rightbig,"<");
 public static final Token LeftbigTok=new Token(TokenType.leftbig,">");
 public static final Token RightsameTok= new Token(TokenType.rightbigsame,"<=");
 public static final Token LeftsameTok=new Token(TokenType.leftbigsame,">=");
 public static final Token AndTok=new Token(TokenType.and,"&");
 public static final Token ORTok=new Token (TokenType.or,"|");
 public static final Token NotTok=new Token(TokenType.not,"!");
 public static final Token T=new Token(TokenType.True,"true");
 public static final Token F=new Token(TokenType.False,"false");
 public static final Token leftmidParenTok=new Token(TokenType.LeftmidParen,"{");
 public static final Token RightmidParenTok=new Token(TokenType.RightmidParen,"}");
 public static final Token WHILETok=new Token(TokenType.WHILE,"while");
 public static final Token IFTok=new Token(TokenType.IF,"if");
 public static final Token THENTok=new Token(TokenType.THEN,"then");
 public static final Token ELSETok=new Token(TokenType.ELSE,"else");
 public static final Token READTok=new Token(TokenType.READ,"read");
 public static final Token PRINTTok=new Token(TokenType.PRINT,"print");
 public static final Token EmptyTok=new Token(TokenType.empty,"");
 public static final Token LetTok=new Token(TokenType.let,"let");
 public static final Token InTok=new Token(TokenType.in,"in");
 public static final Token endTok=new Token(TokenType.end,"end");
 public static final Token BoolTok=new Token(TokenType.Bool,"bool");
 public static final Token IntTok=new Token(TokenType.Int,"int");
 public static final Token JumTok=new Token(TokenType.Jum,".");
 private TokenType type;
 private String value = "";

 private Token (TokenType t, String v) {
     type = t;
     value = v;
 }

 public TokenType type( ) { return type; }

 public String value( ) { return value; }

 public static Token mkIdentTok (String name) {
     return new Token(TokenType.Identifier, name);
 }

 public static Token mkIntLiteral (String name) {
     return new Token(TokenType.IntLiteral, name);
 }

 public String toString ( ) {
     return value;
 } // toString

 public static void main (String[] args) {
     System.out.println(eofTok);
     System.out.println(divideTok);
     System.out.println(multiplyTok);
     System.out.println(rightParenTok);
     
 }
} // Token