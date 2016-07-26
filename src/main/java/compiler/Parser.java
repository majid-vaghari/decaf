package compiler;

import model.*;
import model.ast.AbstractSyntaxTree;
import model.ast.Block;
import model.ast.Function;
import model.ast.Node;
import model.type.Types;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by Majid Vaghari on 5/29/2016.
 */
public class Parser {
    private final Scanner lexer;
    private Token current     = null;
    private Node  currentNode = null;

    public Parser(String filePath) throws FileNotFoundException {
        this.lexer = new Scanner(filePath);
    }

    private static boolean isType(Token token) {
        if (token instanceof Keyword) {
            Keywords k = ((Keyword) token).getKeyword();
            if (k == Keywords.BOOLEAN || k == Keywords.CHAR || k == Keywords.FLOAT || k == Keywords.INT)
                return true;
        }

        return false;
    }

    private static boolean isArithOp1(Token token) {
        return (token instanceof Symbol) &&
               (((Symbol) token).getSymbol() == Symbols.MULT || ((Symbol) token).getSymbol() == Symbols.MOD ||
                ((Symbol) token).getSymbol() == Symbols.DIV);
    }

    private static boolean isArithOp2(Token token) {
        return (token instanceof Symbol) &&
               (((Symbol) token).getSymbol() == Symbols.PLUS || ((Symbol) token).getSymbol() == Symbols.MINUS);

    }

    private static boolean isRelOp(Token token) {
        return (token instanceof Symbol) &&
               (((Symbol) token).getSymbol() == Symbols.LT || ((Symbol) token).getSymbol() == Symbols.LTEQ
                || ((Symbol) token).getSymbol() == Symbols.GT || ((Symbol) token).getSymbol() == Symbols.GTEQ);
    }

    private static boolean isEqOp(Token token) {
        return (token instanceof Symbol) &&
               (((Symbol) token).getSymbol() == Symbols.NOTEQ || ((Symbol) token).getSymbol() == Symbols.EQEQ);
    }

    public void parse() throws UnexpectedTokenException, IOException {
        current = lexer.nextToken();
        currentNode = new Block(null);
        AbstractSyntaxTree.getInstance().setRoot(currentNode); // set the root node of the syntax tree
        program();
    }

    private boolean isReturnType(Token token) {
        return isType(token) || token instanceof Keyword && ((Keyword) token).getKeyword() == Keywords.VOID;
    }

    private Token checkTerminal(boolean predicate) throws UnexpectedTokenException, IOException {
        if (predicate) {
            Token returnValue = current;
            current = lexer.nextToken();
            return returnValue;
        } else {
            throw new UnexpectedTokenException(current);
        }
    }

    private void program() throws UnexpectedTokenException, IOException {
        if (isReturnType(current)) {
            subprogram();
            program();
        } else if (current == null) {
            // do nothing
        } else {
            throw new UnexpectedTokenException(current);
        }
    }

    private void subprogram() throws UnexpectedTokenException, IOException {
        if (isType(current)) {
            Types type = Types.parse(current.getValue());
            current = lexer.nextToken();
            String name = checkTerminal(current instanceof Identifier).getValue();
            afterId(type, name);
        } else if (current instanceof Keyword && ((Keyword) current).getKeyword() == Keywords.VOID) {
            current = lexer.nextToken();
            String name = checkTerminal(current instanceof Identifier).getValue();
            addNode(new Function(currentNode, Types.VOID, name));
            checkTerminal(current instanceof Symbol && ((Symbol) current).getSymbol() == Symbols.LPAREN);
            args();
            checkTerminal(current instanceof Symbol && ((Symbol) current).getSymbol() == Symbols.RPAREN);
            block();
        } else {
            throw new UnexpectedTokenException(current);
        }
    }

    private void addNode(Node node) {
        currentNode = node;
        AbstractSyntaxTree.getInstance().getNodes().add(currentNode);
    }

    private void afterId(Types type, String name) throws UnexpectedTokenException, IOException {

        if (current instanceof Symbol && ((Symbol) current).getSymbol() == Symbols.LPAREN) {
            current = lexer.nextToken();
            args();
            checkTerminal(current instanceof Symbol && ((Symbol) current).getSymbol() == Symbols.RPAREN);
            block();
        } else if (current instanceof Symbol && (((Symbol) current).getSymbol() == Symbols.LBRACKET
                                                 || ((Symbol) current).getSymbol() == Symbols.COMMA
                                                 || ((Symbol) current).getSymbol() == Symbols.SEMICOLON)) {
            arrayDec();
            moreDec();
            checkTerminal(current instanceof Symbol && ((Symbol) current).getSymbol() == Symbols.SEMICOLON);
        } else {
            throw new UnexpectedTokenException(current);
        }
    }

    private void arrayDec() throws UnexpectedTokenException, IOException {
        if (current instanceof Symbol && ((Symbol) current).getSymbol() == Symbols.LBRACKET) {
            current = lexer.nextToken();
            checkTerminal(current instanceof IntegerLiteral);
            checkTerminal(current instanceof Symbol && ((Symbol) current).getSymbol() == Symbols.RBRACKET);
            arrayDec();
        } else if (current instanceof Symbol && (((Symbol) current).getSymbol() == Symbols.COMMA
                                                 || ((Symbol) current).getSymbol() == Symbols.SEMICOLON) ||
                   current == null) {
            // do nothing
        } else {
            throw new UnexpectedTokenException(current);
        }
    }

    private void moreDec() throws UnexpectedTokenException, IOException {
        if (current instanceof Symbol && ((Symbol) current).getSymbol() == Symbols.COMMA) {
            current = lexer.nextToken();
            varList();
        } else if (current instanceof Symbol && ((Symbol) current).getSymbol() == Symbols.SEMICOLON
                   || current == null) {
            // do nothing
        } else {
            throw new UnexpectedTokenException(current);
        }
    }

    private void varList() throws UnexpectedTokenException, IOException {
        if (current instanceof Identifier) {
            current = lexer.nextToken();
            arrayDec();
            moreDec();
        } else {
            throw new UnexpectedTokenException(current);
        }
    }

    private void args() throws UnexpectedTokenException, IOException {
        if (isType(current)) {
            // current = lexer.nextToken();
            argList();
        } else if (current instanceof Symbol && ((Symbol) current).getSymbol() == Symbols.RPAREN || current == null) {
            // do nothing
        } else {
            throw new UnexpectedTokenException(current);
        }
    }

    private void argList() throws UnexpectedTokenException, IOException {
        if (isType(current)) {
            Types type = Types.parse(current.getValue());
            current = lexer.nextToken();
            String name = checkTerminal(current instanceof Identifier).getValue();
            moreArg();
        } else {
            throw new UnexpectedTokenException(current);
        }
    }

    private void moreArg() throws UnexpectedTokenException, IOException {
        if (current instanceof Symbol && ((Symbol) current).getSymbol() == Symbols.COMMA) {
            current = lexer.nextToken();
            argList();
        } else if (current instanceof Symbol && ((Symbol) current).getSymbol() == Symbols.RPAREN || current == null) {
            // do nothing
        } else {
            throw new UnexpectedTokenException(current);
        }
    }

    private void block() throws UnexpectedTokenException, IOException {
        if (current instanceof Symbol && ((Symbol) current).getSymbol() == Symbols.LBRACE) {
            current = lexer.nextToken();
            e();
            checkTerminal(current instanceof Symbol && ((Symbol) current).getSymbol() == Symbols.RBRACE);
        } else {
            throw new UnexpectedTokenException(current);
        }
    }

    private void e() throws UnexpectedTokenException, IOException {
        if (isType(current)) {
            current = lexer.nextToken();
            checkTerminal(current instanceof Identifier);
            arrayDec();
            moreDec();
            checkTerminal(current instanceof Symbol && ((Symbol) current).getSymbol() == Symbols.SEMICOLON);
            e();
        } else if (current instanceof Symbol && ((Symbol) current).getSymbol() == Symbols.LBRACE) {
            block();
            e();
        } else if (current instanceof Keyword && ((Keyword) current).getKeyword() == Keywords.IF) {
            current = lexer.nextToken();
            checkTerminal(current instanceof Symbol && ((Symbol) current).getSymbol() == Symbols.LPAREN);
            expr();
            checkTerminal(current instanceof Symbol && ((Symbol) current).getSymbol() == Symbols.RPAREN);
            block();
            f();
            e();
        } else if (current instanceof Keyword && ((Keyword) current).getKeyword() == Keywords.WHILE) {
            current = lexer.nextToken();
            checkTerminal(current instanceof Symbol && ((Symbol) current).getSymbol() == Symbols.LPAREN);
            expr();
            checkTerminal(current instanceof Symbol && ((Symbol) current).getSymbol() == Symbols.RPAREN);
            block();
            e();
        } else if (current instanceof Keyword && ((Keyword) current).getKeyword() == Keywords.FOR) {
            current = lexer.nextToken();
            checkTerminal(current instanceof Symbol && ((Symbol) current).getSymbol() == Symbols.LPAREN);
            assignment();
            checkTerminal(current instanceof Symbol && ((Symbol) current).getSymbol() == Symbols.SEMICOLON);
            expr();
            checkTerminal(current instanceof Symbol && ((Symbol) current).getSymbol() == Symbols.SEMICOLON);
            assignment();
            checkTerminal(current instanceof Symbol && ((Symbol) current).getSymbol() == Symbols.RPAREN);
            block();
            e();
        } else if (current instanceof Keyword && ((Keyword) current).getKeyword() == Keywords.RETURN) {
            current = lexer.nextToken();
            e3();
            checkTerminal(current instanceof Symbol && ((Symbol) current).getSymbol() == Symbols.SEMICOLON);
            e();
        } else if (current instanceof Keyword && (((Keyword) current).getKeyword() == Keywords.BREAK
                                                  || ((Keyword) current).getKeyword() == Keywords.CONTINUE)) {
            current = lexer.nextToken();
            checkTerminal(current instanceof Symbol && ((Symbol) current).getSymbol() == Symbols.SEMICOLON);
            e();
        } else if (current instanceof Keyword && (((Keyword) current).getKeyword() == Keywords.READCHAR
                                                  || ((Keyword) current).getKeyword() == Keywords.READFLOAT
                                                  || ((Keyword) current).getKeyword() == Keywords.READINT)) {
            current = lexer.nextToken();
            location();
            checkTerminal(current instanceof Symbol && ((Symbol) current).getSymbol() == Symbols.SEMICOLON);
            e();
        } else if (current instanceof Keyword && (((Keyword) current).getKeyword() == Keywords.WRITECHAR
                                                  || ((Keyword) current).getKeyword() == Keywords.WRITEFLOAT
                                                  || ((Keyword) current).getKeyword() == Keywords.WRITEINT)) {
            current = lexer.nextToken();
            expr();
            checkTerminal(current instanceof Symbol && ((Symbol) current).getSymbol() == Symbols.SEMICOLON);
            e();
        } else if (current instanceof Identifier) {
            current = lexer.nextToken();
            e2();
            e();
        } else if (current instanceof Symbol && ((Symbol) current).getSymbol() == Symbols.RBRACE || current == null) {
            // do nothing
        } else {
            throw new UnexpectedTokenException(current);
        }
    }

    private void e2() throws UnexpectedTokenException, IOException {
        if (current instanceof Symbol) {
            if (((Symbol) current).getSymbol() == Symbols.LPAREN) {
                current = lexer.nextToken();
                i();
                checkTerminal(current instanceof Symbol && ((Symbol) current).getSymbol() == Symbols.RPAREN);
                checkTerminal(current instanceof Symbol && ((Symbol) current).getSymbol() == Symbols.SEMICOLON);
            } else if (((Symbol) current).getSymbol() == Symbols.LBRACKET
                       || ((Symbol) current).getSymbol() == Symbols.EQ) {
                k();
                checkTerminal(current instanceof Symbol && ((Symbol) current).getSymbol() == Symbols.EQ);
                expr();
                checkTerminal(current instanceof Symbol && ((Symbol) current).getSymbol() == Symbols.SEMICOLON);
            }
        } else {
            throw new UnexpectedTokenException(current);
        }
    }

    private void e3() throws UnexpectedTokenException, IOException {
        if ((current instanceof Symbol
             && (((Symbol) current).getSymbol() == Symbols.NOT || ((Symbol) current).getSymbol() == Symbols.MINUS))
            || current instanceof Literal || current instanceof Identifier) {
            expr();
        } else if (current instanceof Symbol && ((Symbol) current).getSymbol() == Symbols.SEMICOLON
                   || current == null) {
            // do nothing
        } else {
            throw new UnexpectedTokenException(current);
        }
    }

    private void f() throws UnexpectedTokenException, IOException {
        if (current instanceof Keyword && ((Keyword) current).getKeyword() == Keywords.ELSE) {
            current = lexer.nextToken();
            block();
        } else if (isType(current)
                   || (current instanceof Symbol && (((Symbol) current).getSymbol() == Symbols.LBRACE
                                                     || ((Symbol) current).getSymbol() == Symbols.RBRACE))
                   || (current instanceof Keyword && (((Keyword) current).getKeyword() == Keywords.IF
                                                      || ((Keyword) current).getKeyword() == Keywords.WHILE
                                                      || ((Keyword) current).getKeyword() == Keywords.FOR
                                                      || ((Keyword) current).getKeyword() == Keywords.RETURN
                                                      || ((Keyword) current).getKeyword() == Keywords.BREAK
                                                      || ((Keyword) current).getKeyword() == Keywords.CONTINUE
                                                      || ((Keyword) current).getKeyword() == Keywords.READCHAR
                                                      || ((Keyword) current).getKeyword() == Keywords.READFLOAT
                                                      || ((Keyword) current).getKeyword() == Keywords.READINT
                                                      || ((Keyword) current).getKeyword() == Keywords.WRITECHAR
                                                      || ((Keyword) current).getKeyword() == Keywords.WRITEFLOAT
                                                      || ((Keyword) current).getKeyword() == Keywords.WRITEINT))
                   || current instanceof Identifier || current == null) {
            // do nothing
        } else {
            throw new UnexpectedTokenException(current);
        }
    }

    private void assignment() throws UnexpectedTokenException, IOException {
        if (current instanceof Identifier) {
            location();
            checkTerminal(current instanceof Symbol && ((Symbol) current).getSymbol() == Symbols.EQ);
            expr();
        } else {
            throw new UnexpectedTokenException(current);
        }
    }

    private void i() throws UnexpectedTokenException, IOException {
        if (current instanceof Symbol
            && (((Symbol) current).getSymbol() == Symbols.NOT || ((Symbol) current).getSymbol() == Symbols.MINUS)
            || current instanceof Literal || current instanceof Identifier) {
            parameterList();
        } else if (current instanceof Symbol && ((Symbol) current).getSymbol() == Symbols.RPAREN || current == null) {
            // do nothing
        } else {
            throw new UnexpectedTokenException(current);
        }
    }

    private void parameterList() throws UnexpectedTokenException, IOException {
        if (current instanceof Symbol
            && (((Symbol) current).getSymbol() == Symbols.NOT || ((Symbol) current).getSymbol() == Symbols.MINUS)
            || current instanceof Literal || current instanceof Identifier) {
            expr();
            j();
        } else {
            throw new UnexpectedTokenException(current);
        }
    }

    private void j() throws UnexpectedTokenException, IOException {
        if (current instanceof Symbol && ((Symbol) current).getSymbol() == Symbols.COMMA) {
            current = lexer.nextToken();
            parameterList();
        } else if (current instanceof Symbol && ((Symbol) current).getSymbol() == Symbols.RPAREN || current == null) {
            // do nothing
        } else {
            throw new UnexpectedTokenException(current);
        }
    }

    private void location() throws UnexpectedTokenException, IOException {
        if (current instanceof Identifier) {
            current = lexer.nextToken();
            k();
        } else {
            throw new UnexpectedTokenException(current);
        }
    }

    private void k() throws UnexpectedTokenException, IOException {
        if (current instanceof Symbol && ((Symbol) current).getSymbol() == Symbols.LBRACKET) {
            current = lexer.nextToken();
            expr();
            checkTerminal(current instanceof Symbol && ((Symbol) current).getSymbol() == Symbols.RBRACKET);
            k();
        } else if (current instanceof Symbol && ((Symbol) current).getSymbol() == Symbols.EQ || current == null
                   || current instanceof Symbol && ((Symbol) current).getSymbol() == Symbols.SEMICOLON
                   || current instanceof Symbol && ((Symbol) current).getSymbol() == Symbols.RPAREN
                   || current instanceof Symbol && isArithOp1(current) ||
                   current instanceof Symbol && isArithOp2(current)
                   || current instanceof Symbol && isEqOp(current) || current instanceof Symbol && isRelOp(current)) {
            // do nothing
        } else {
            throw new UnexpectedTokenException(current);
        }
    }

    private void expr() throws UnexpectedTokenException, IOException {
        if (current instanceof Symbol
            && (((Symbol) current).getSymbol() == Symbols.NOT || ((Symbol) current).getSymbol() == Symbols.MINUS)
            || current instanceof Literal || current instanceof Identifier
            || ((Symbol) current).getSymbol() == Symbols.LPAREN) {
            exp1();
            exp0();
        }
        /*
         * else if (current instanceof Symbol && ((Symbol) current).getSymbol()
		 * == Symbols.LPAREN) { current = lexer.nextToken(); System.out.println(
		 * "inside parentheses"); expr(); checkTerminal(current instanceof
		 * Symbol && ((Symbol) current).getSymbol() == Symbols.RPAREN); }
		 */
        else {
            throw new UnexpectedTokenException(current);
        }
    }

    private void exp0() throws UnexpectedTokenException, IOException {
        if (current instanceof Symbol && ((Symbol) current).getSymbol() == Symbols.OROR) {
            current = lexer.nextToken();
            expr();
        } else if (current instanceof Symbol && (((Symbol) current).getSymbol() == Symbols.RPAREN
                                                 || ((Symbol) current).getSymbol() == Symbols.RBRACKET ||
                                                 ((Symbol) current).getSymbol() == Symbols.COMMA
                                                 || ((Symbol) current).getSymbol() == Symbols.SEMICOLON) ||
                   current == null) {
            // do nothing
        } else {
            throw new UnexpectedTokenException(current);
        }
    }

    private void exp1() throws UnexpectedTokenException, IOException {
        if (current instanceof Symbol
            && (((Symbol) current).getSymbol() == Symbols.NOT || ((Symbol) current).getSymbol() == Symbols.MINUS)
            || current instanceof Literal || current instanceof Identifier
            || ((Symbol) current).getSymbol() == Symbols.LPAREN) {

            exp2();
            exp10();
        } else {
            throw new UnexpectedTokenException(current);
        }
    }

    private void exp10() throws UnexpectedTokenException, IOException {
        if (current instanceof Symbol && ((Symbol) current).getSymbol() == Symbols.ANDAND) {
            current = lexer.nextToken();
            // exp1();
            expr();
        } else if (current instanceof Symbol && (((Symbol) current).getSymbol() == Symbols.RPAREN
                                                 || ((Symbol) current).getSymbol() == Symbols.RBRACKET ||
                                                 ((Symbol) current).getSymbol() == Symbols.COMMA
                                                 || ((Symbol) current).getSymbol() == Symbols.SEMICOLON
                                                 || ((Symbol) current).getSymbol() == Symbols.OROR) ||
                   current == null) {
            // do nothing
        } else {
            throw new UnexpectedTokenException(current);
        }
    }

    private void exp2() throws UnexpectedTokenException, IOException {
        if (current instanceof Symbol
            && (((Symbol) current).getSymbol() == Symbols.NOT || ((Symbol) current).getSymbol() == Symbols.MINUS)
            || current instanceof Literal || current instanceof Identifier
            || ((Symbol) current).getSymbol() == Symbols.LPAREN) {

            exp3();
            exp20();
        } else {
            throw new UnexpectedTokenException(current);
        }
    }

    private void exp20() throws UnexpectedTokenException, IOException {
        if (current instanceof Symbol && (((Symbol) current).getSymbol() == Symbols.EQEQ
                                          || ((Symbol) current).getSymbol() == Symbols.NOTEQ)) {
            current = lexer.nextToken();
            // exp2();
            expr();
        } else if (current instanceof Symbol && (((Symbol) current).getSymbol() == Symbols.RPAREN
                                                 || ((Symbol) current).getSymbol() == Symbols.RBRACKET ||
                                                 ((Symbol) current).getSymbol() == Symbols.COMMA
                                                 || ((Symbol) current).getSymbol() == Symbols.SEMICOLON ||
                                                 ((Symbol) current).getSymbol() == Symbols.OROR
                                                 || ((Symbol) current).getSymbol() == Symbols.ANDAND) ||
                   current == null) {
            // do nothing
        } else {
            throw new UnexpectedTokenException(current);
        }
    }

    private void exp3() throws UnexpectedTokenException, IOException {
        if (current instanceof Symbol
            && (((Symbol) current).getSymbol() == Symbols.NOT || ((Symbol) current).getSymbol() == Symbols.MINUS)
            || current instanceof Literal || current instanceof Identifier
            || ((Symbol) current).getSymbol() == Symbols.LPAREN) {

            exp4();
            exp30();
        } else {
            throw new UnexpectedTokenException(current);
        }
    }

    private void exp30() throws UnexpectedTokenException, IOException {
        if (current instanceof Symbol && (((Symbol) current).getSymbol() == Symbols.LT
                                          || ((Symbol) current).getSymbol() == Symbols.LTEQ ||
                                          ((Symbol) current).getSymbol() == Symbols.GT
                                          || ((Symbol) current).getSymbol() == Symbols.GTEQ)) {
            current = lexer.nextToken();
            // exp3();
            expr();
        } else if (current instanceof Symbol && (((Symbol) current).getSymbol() == Symbols.RPAREN
                                                 || ((Symbol) current).getSymbol() == Symbols.RBRACKET ||
                                                 ((Symbol) current).getSymbol() == Symbols.COMMA
                                                 || ((Symbol) current).getSymbol() == Symbols.SEMICOLON ||
                                                 ((Symbol) current).getSymbol() == Symbols.OROR
                                                 || ((Symbol) current).getSymbol() == Symbols.ANDAND ||
                                                 ((Symbol) current).getSymbol() == Symbols.EQEQ
                                                 || ((Symbol) current).getSymbol() == Symbols.NOTEQ) ||
                   current == null) {
            // do nothing
        } else {
            throw new UnexpectedTokenException(current);
        }
    }

    private void exp4() throws UnexpectedTokenException, IOException {
        if (current instanceof Symbol
            && (((Symbol) current).getSymbol() == Symbols.NOT || ((Symbol) current).getSymbol() == Symbols.MINUS)
            || current instanceof Literal || current instanceof Identifier
            || ((Symbol) current).getSymbol() == Symbols.LPAREN) {

            exp5();
            exp40();
        } else {
            throw new UnexpectedTokenException(current);
        }
    }

    private void exp40() throws UnexpectedTokenException, IOException {
        if (current instanceof Symbol && (((Symbol) current).getSymbol() == Symbols.PLUS
                                          || ((Symbol) current).getSymbol() == Symbols.MINUS)) {
            current = lexer.nextToken();
            // exp4();
            expr();
        } else if (current instanceof Symbol && (((Symbol) current).getSymbol() == Symbols.RPAREN
                                                 || ((Symbol) current).getSymbol() == Symbols.RBRACKET ||
                                                 ((Symbol) current).getSymbol() == Symbols.COMMA
                                                 || ((Symbol) current).getSymbol() == Symbols.SEMICOLON ||
                                                 ((Symbol) current).getSymbol() == Symbols.OROR
                                                 || ((Symbol) current).getSymbol() == Symbols.ANDAND ||
                                                 ((Symbol) current).getSymbol() == Symbols.EQEQ
                                                 || ((Symbol) current).getSymbol() == Symbols.NOTEQ ||
                                                 ((Symbol) current).getSymbol() == Symbols.LT
                                                 || ((Symbol) current).getSymbol() == Symbols.LTEQ ||
                                                 ((Symbol) current).getSymbol() == Symbols.GT
                                                 || ((Symbol) current).getSymbol() == Symbols.GTEQ) ||
                   current == null) {
            // do nothing
        } else {
            throw new UnexpectedTokenException(current);
        }
    }

    private void exp5() throws UnexpectedTokenException, IOException {
        if (current instanceof Symbol
            && (((Symbol) current).getSymbol() == Symbols.NOT || ((Symbol) current).getSymbol() == Symbols.MINUS)
            || current instanceof Literal || current instanceof Identifier
            || ((Symbol) current).getSymbol() == Symbols.LPAREN) {
            exp6();
            exp50();
        } else {
            throw new UnexpectedTokenException(current);
        }
    }

    private void exp50() throws UnexpectedTokenException, IOException {
        if (current instanceof Symbol && (((Symbol) current).getSymbol() == Symbols.MULT
                                          || ((Symbol) current).getSymbol() == Symbols.DIV ||
                                          ((Symbol) current).getSymbol() == Symbols.MOD)) {
            current = lexer.nextToken();
            // exp5();
            expr();
        } else if (current instanceof Symbol && (((Symbol) current).getSymbol() == Symbols.RPAREN
                                                 || ((Symbol) current).getSymbol() == Symbols.RBRACKET ||
                                                 ((Symbol) current).getSymbol() == Symbols.COMMA
                                                 || ((Symbol) current).getSymbol() == Symbols.SEMICOLON ||
                                                 ((Symbol) current).getSymbol() == Symbols.OROR
                                                 || ((Symbol) current).getSymbol() == Symbols.ANDAND ||
                                                 ((Symbol) current).getSymbol() == Symbols.EQEQ
                                                 || ((Symbol) current).getSymbol() == Symbols.NOTEQ ||
                                                 ((Symbol) current).getSymbol() == Symbols.LT
                                                 || ((Symbol) current).getSymbol() == Symbols.LTEQ ||
                                                 ((Symbol) current).getSymbol() == Symbols.GT
                                                 || ((Symbol) current).getSymbol() == Symbols.GTEQ ||
                                                 ((Symbol) current).getSymbol() == Symbols.PLUS
                                                 || ((Symbol) current).getSymbol() == Symbols.MINUS) ||
                   current == null) {
            // do nothing
        } else {
            throw new UnexpectedTokenException(current);
        }
    }

    private void exp6() throws UnexpectedTokenException, IOException {
        if (current instanceof Symbol
            && (((Symbol) current).getSymbol() == Symbols.NOT || ((Symbol) current).getSymbol() == Symbols.MINUS)) {
            current = lexer.nextToken();
            exp6();
            //TODO <exp6> : !<exp6> | - <exp6>
            // age not umade typesh mishe hamun type e bachash va valuesh mishe not e hasele exp6
            // age - umade typesh again mishe type e hasele exp6 va valuesh mishe manfie oon
        } else if (current instanceof Literal || current instanceof Identifier
                   || current instanceof Symbol && ((Symbol) current).getSymbol() == Symbols.LPAREN) {
            exp7();
            //TODO <exp6> : <exp7>
            // age bere be in be olaviate avval mirese yani ya meghdare yechizio mikhad yani ya meghdare ye variable
            //ya ye khune array ya hasele method ya meghdare tooye parantez
        } else {
            throw new UnexpectedTokenException(current);
        }
    }

    private void exp7() throws UnexpectedTokenException, IOException {
        if (current instanceof Identifier) {
            current = lexer.nextToken();
            exp71();
            // TODO
            // <exp7> : <id> <exp71>
            // Type <exp7> = Type <exp71>
            // Value <exp7> = Value <exp71>
            // bere be in dastoor yani mikhaym yechizi seda bezanim meghdaresho
            // biabim. hala ya method calle ya meghdare ye variable ya ye khune
            // array
        } else if (current instanceof Literal) {
            current = lexer.nextToken();
            // TODO
            // <exp7> : <Literal>
            // Type <exp7> = Type <Literal> (char,int,bool,hex)
            // Value <exp7> = Value <Literal>
            // injake be tah reside hamin meghdar va type e literalero mizarim
        } else if (current instanceof Symbol && ((Symbol) current).getSymbol() == Symbols.LPAREN) {
            current = lexer.nextToken();
            expr();
            checkTerminal(current instanceof Symbol && ((Symbol) current).getSymbol() == Symbols.RPAREN);
            // TODO
            // <exp7> : (<expr>)
            // Type <exp7> = Type <expr>
            // Value <exp7> = Value <expr>
            // age be in dastoor bere yani expr e too parantez umade pas type va
            // meghdaresh mishe type va meghdare hasele tooye parantez
        } else {
            throw new UnexpectedTokenException(current);
        }
    }

    private void exp71() throws UnexpectedTokenException, IOException {
        if (current instanceof Symbol && ((Symbol) current).getSymbol() == Symbols.LPAREN) {
            current = lexer.nextToken();
            i();
            checkTerminal(current instanceof Symbol && ((Symbol) current).getSymbol() == Symbols.RPAREN);
            // TODO
            // <exp71> : ( <I> )
            // age bere be in dastoor I neshoon dahandeye parametr haye
            // vooroodie tabast
        } else if (current instanceof Symbol && (((Symbol) current).getSymbol() == Symbols.RPAREN
                                                 || ((Symbol) current).getSymbol() == Symbols.RBRACKET
                                                 || ((Symbol) current).getSymbol() == Symbols.LBRACKET ||
                                                 ((Symbol) current).getSymbol() == Symbols.COMMA
                                                 || ((Symbol) current).getSymbol() == Symbols.SEMICOLON ||
                                                 ((Symbol) current).getSymbol() == Symbols.OROR
                                                 || ((Symbol) current).getSymbol() == Symbols.ANDAND ||
                                                 isArithOp1(current)) || isArithOp2(current)
                   || isEqOp(current) || isRelOp(current) || current == null) {
            k();
            // TODO
            // <exp71> : <K>
            // Type <exp71> = Type <K>
            // Value <exp71> = Value <K>
            // alan in exp71 be K ke mire yani ya access be arayas vase inke
            // bege chand bodie
            // masalan K age variable bekhaym epsilon miad chon bo'd nadare ya
            // age biad [expr][expr][expr] mishe 3 bodi

        } else {
            throw new UnexpectedTokenException(current);
        }
    }
}
