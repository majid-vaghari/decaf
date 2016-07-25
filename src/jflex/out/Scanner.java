/* The following code was generated by JFlex 1.6.1 */


package compiler;

import java.util.HashSet;

/**
 * This class is a scanner generated by <a href="http://www.jflex.de/">JFlex</a> 1.6.1 from the specification file
 * <tt>src/jflex/Decaf.jflex</tt>
 */
public final class Scanner {

    /**
     * This character denotes the end of file
     */
    public static final int YYEOF = -1;
    /**
     * lexical states
     */
    public static final int YYINITIAL   = 0;
    public static final int STRING      = 2;
    public static final int CHARLITERAL = 4;
    public static final int INCLUDE     = 6;
    /**
     * initial size of the lookahead buffer
     */
    private static final int ZZ_BUFFERSIZE = 16384;
    /**
     * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l ZZ_LEXSTATE[l+1] is the state in the DFA for the
     * lexical state l at the beginning of a line l is of the form l = 2*k, k a non negative integer
     */
    private static final int ZZ_LEXSTATE[] = {
            0, 0, 1, 1, 2, 2, 3, 3
    };

    /**
     * Translates characters to character classes
     */
    private static final String ZZ_CMAP_PACKED =
            "\11\0\1\5\1\2\1\62\1\63\1\1\22\0\1\5\1\51\1\0" +
            "\1\61\1\0\1\52\1\56\1\60\1\37\1\40\1\4\1\53\1\44" +
            "\1\50\1\13\1\3\1\11\11\7\1\0\1\43\1\55\1\47\1\54" +
            "\2\0\6\10\21\6\1\12\2\6\1\45\1\14\1\46\1\0\1\6" +
            "\1\0\1\21\1\15\1\25\1\34\1\20\1\33\1\6\1\26\1\30" +
            "\1\6\1\24\1\17\1\6\1\22\1\16\2\6\1\23\1\32\1\27" +
            "\1\31\1\35\1\36\1\12\2\6\1\41\1\57\1\42\7\0\1\62" +
            "\u1fa2\0\1\62\1\62\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\udfe6\0";

    /**
     * Translates characters to character classes
     */
    private static final char[] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);
    private static final String ZZ_ACTION_PACKED_0 =
            "\4\0\1\1\2\2\1\3\1\4\1\5\2\6\2\1" +
            "\11\5\1\7\1\10\1\11\1\12\1\13\1\14\1\15" +
            "\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1\25" +
            "\2\1\1\26\1\1\2\27\2\1\2\30\1\2\1\0" +
            "\1\31\2\0\10\5\1\32\6\5\1\33\1\34\1\35" +
            "\1\36\1\37\1\40\1\41\4\1\3\0\1\6\1\0" +
            "\10\5\1\42\1\43\5\5\1\44\1\45\1\46\1\47" +
            "\2\0\2\5\1\50\3\5\1\51\1\52\2\5\1\53" +
            "\2\5\1\0\1\5\1\54\5\5\1\55\1\56\1\5" +
            "\1\57\1\0\4\5\1\60\4\5\1\0\1\61\1\5" +
            "\1\62\5\5\1\0\1\63\1\5\1\64\1\5\1\65" +
            "\1\5\1\0\1\66\1\67\1\5\1\0\1\70\2\71" +
            "\1\0\1\71\4\0";
    /**
     * Translates DFA states to action switch labels.
     */
    private static final int[] ZZ_ACTION = zzUnpackAction();
    private static final String ZZ_ROWMAP_PACKED_0 =
            "\0\0\0\64\0\150\0\234\0\320\0\u0104\0\320\0\u0138" +
            "\0\320\0\u016c\0\u01a0\0\u01d4\0\u0208\0\u023c\0\u0270\0\u02a4" +
            "\0\u02d8\0\u030c\0\u0340\0\u0374\0\u03a8\0\u03dc\0\u0410\0\320" +
            "\0\320\0\320\0\320\0\320\0\320\0\320\0\320\0\u0444" +
            "\0\320\0\u0478\0\320\0\320\0\u04ac\0\u04e0\0\u0514\0\u0548" +
            "\0\320\0\u057c\0\u05b0\0\320\0\u05e4\0\u0618\0\u064c\0\320" +
            "\0\u0680\0\u06b4\0\u0208\0\u06e8\0\u071c\0\u0750\0\u0784\0\u07b8" +
            "\0\u07ec\0\u0820\0\u0854\0\u0888\0\u08bc\0\u016c\0\u08f0\0\u0924" +
            "\0\u0958\0\u098c\0\u09c0\0\u09f4\0\320\0\320\0\320\0\320" +
            "\0\320\0\320\0\320\0\u0a28\0\u0a5c\0\u0a90\0\u0ac4\0\u0618" +
            "\0\u0af8\0\u0b2c\0\u06e8\0\u0b60\0\u0b94\0\u0bc8\0\u0bfc\0\u0c30" +
            "\0\u0c64\0\u0c98\0\u0ccc\0\u0d00\0\u016c\0\u016c\0\u0d34\0\u0d68" +
            "\0\u0d9c\0\u0dd0\0\u0e04\0\320\0\320\0\320\0\320\0\u0e38" +
            "\0\u0e6c\0\u0ea0\0\u0ed4\0\u016c\0\u0f08\0\u0f3c\0\u0f70\0\u016c" +
            "\0\u016c\0\u0fa4\0\u0fd8\0\u016c\0\u100c\0\u1040\0\u1074\0\u10a8" +
            "\0\u016c\0\u10dc\0\u1110\0\u1144\0\u1178\0\u11ac\0\u016c\0\u016c" +
            "\0\u11e0\0\u016c\0\u1214\0\u1248\0\u127c\0\u12b0\0\u12e4\0\u016c" +
            "\0\u1318\0\u134c\0\u1380\0\u13b4\0\u13e8\0\u016c\0\u141c\0\u016c" +
            "\0\u1450\0\u1484\0\u14b8\0\u14ec\0\u1520\0\u1554\0\u016c\0\u1588" +
            "\0\u016c\0\u15bc\0\u016c\0\u15f0\0\u1624\0\u016c\0\u016c\0\u1658" +
            "\0\u168c\0\u016c\0\u16c0\0\320\0\u16f4\0\u1728\0\u175c\0\u1790" +
            "\0\u17c4\0\u17f8";
    /**
     * Translates a state to a row index in the transition table
     */
    private static final int[] ZZ_ROWMAP = zzUnpackRowMap();
    private static final String ZZ_TRANS_PACKED_0 =
            "\1\5\1\6\1\7\1\10\1\11\1\7\1\12\1\13" +
            "\1\12\1\14\1\12\1\15\1\16\1\17\2\12\1\20" +
            "\2\12\1\21\1\12\1\22\1\12\1\23\1\24\2\12" +
            "\1\25\1\12\1\26\1\27\1\30\1\31\1\32\1\33" +
            "\1\34\1\35\1\36\1\37\1\40\1\41\1\42\1\43" +
            "\1\44\1\45\1\46\1\47\1\50\1\51\2\5\1\7" +
            "\64\5\1\52\1\53\1\54\11\52\1\55\43\52\1\5" +
            "\3\52\1\56\1\57\1\60\61\56\66\0\1\7\64\0" +
            "\1\61\1\62\65\0\5\12\2\0\22\12\34\0\1\13" +
            "\1\0\1\13\1\0\1\63\57\0\1\13\1\0\1\13" +
            "\1\64\1\63\57\0\1\63\1\0\1\63\133\0\1\65" +
            "\10\0\5\12\2\0\1\12\1\66\4\12\1\67\13\12" +
            "\33\0\5\12\2\0\2\12\1\70\17\12\33\0\5\12" +
            "\2\0\3\12\1\71\16\12\33\0\5\12\2\0\1\12" +
            "\1\72\7\12\1\73\10\12\33\0\5\12\2\0\6\12" +
            "\1\74\13\12\33\0\5\12\2\0\5\12\1\75\10\12" +
            "\1\76\3\12\33\0\5\12\2\0\1\12\1\77\1\100" +
            "\1\12\1\101\15\12\33\0\5\12\2\0\1\12\1\102" +
            "\20\12\33\0\5\12\2\0\6\12\1\103\2\12\1\104" +
            "\10\12\74\0\1\105\63\0\1\106\63\0\1\107\63\0" +
            "\1\110\72\0\1\111\64\0\1\112\64\0\1\113\5\0" +
            "\1\54\61\0\1\5\2\0\11\5\1\114\5\5\1\115" +
            "\4\5\1\116\30\5\1\117\1\5\2\0\1\120\1\57" +
            "\1\60\61\120\2\0\1\60\61\0\1\61\1\6\1\7" +
            "\61\61\4\121\1\122\57\121\7\0\3\123\3\0\1\123" +
            "\2\0\2\123\3\0\1\123\5\0\2\123\57\0\1\124" +
            "\41\0\5\12\2\0\1\12\1\125\20\12\33\0\5\12" +
            "\2\0\3\12\1\126\16\12\33\0\5\12\2\0\15\12" +
            "\1\127\4\12\33\0\5\12\2\0\4\12\1\130\5\12" +
            "\1\131\7\12\33\0\5\12\2\0\5\12\1\132\14\12" +
            "\33\0\5\12\2\0\4\12\1\133\15\12\33\0\5\12" +
            "\2\0\14\12\1\134\5\12\33\0\5\12\2\0\12\12" +
            "\1\135\7\12\33\0\5\12\2\0\6\12\1\136\13\12" +
            "\33\0\5\12\2\0\1\12\1\137\20\12\33\0\5\12" +
            "\2\0\2\12\1\140\17\12\33\0\5\12\2\0\13\12" +
            "\1\141\6\12\33\0\5\12\2\0\13\12\1\142\6\12" +
            "\33\0\5\12\2\0\13\12\1\143\6\12\105\0\1\144" +
            "\63\0\1\145\63\0\1\146\63\0\1\147\3\0\4\121" +
            "\1\150\57\121\3\0\1\7\1\122\101\0\1\151\47\0" +
            "\5\12\2\0\2\12\1\152\17\12\33\0\5\12\2\0" +
            "\4\12\1\153\15\12\33\0\5\12\2\0\3\12\1\154" +
            "\16\12\33\0\5\12\2\0\17\12\1\155\2\12\33\0" +
            "\5\12\2\0\14\12\1\156\5\12\33\0\5\12\2\0" +
            "\12\12\1\157\7\12\33\0\5\12\2\0\6\12\1\160" +
            "\13\12\33\0\5\12\2\0\3\12\1\161\16\12\33\0" +
            "\5\12\2\0\4\12\1\162\15\12\33\0\5\12\2\0" +
            "\15\12\1\163\4\12\33\0\5\12\2\0\17\12\1\164" +
            "\2\12\33\0\5\12\2\0\12\12\1\165\7\12\33\0" +
            "\5\12\2\0\2\12\1\166\17\12\25\0\3\121\1\7" +
            "\1\150\57\121\25\0\1\167\44\0\5\12\2\0\3\12" +
            "\1\170\16\12\33\0\5\12\2\0\7\12\1\171\12\12" +
            "\33\0\5\12\2\0\10\12\1\172\2\12\1\173\2\12" +
            "\1\174\3\12\33\0\5\12\2\0\6\12\1\175\13\12" +
            "\33\0\5\12\2\0\13\12\1\176\6\12\33\0\5\12" +
            "\2\0\12\12\1\177\7\12\33\0\5\12\2\0\3\12" +
            "\1\200\16\12\33\0\5\12\2\0\3\12\1\201\16\12" +
            "\33\0\5\12\2\0\3\12\1\202\16\12\44\0\1\203" +
            "\52\0\5\12\2\0\4\12\1\204\15\12\33\0\5\12" +
            "\2\0\11\12\1\205\10\12\33\0\5\12\2\0\5\12" +
            "\1\206\14\12\33\0\5\12\2\0\2\12\1\207\17\12" +
            "\33\0\5\12\2\0\5\12\1\210\14\12\33\0\5\12" +
            "\2\0\5\12\1\211\14\12\33\0\5\12\2\0\10\12" +
            "\1\212\2\12\1\213\2\12\1\214\3\12\56\0\1\215" +
            "\40\0\5\12\2\0\5\12\1\216\14\12\33\0\5\12" +
            "\2\0\4\12\1\217\15\12\33\0\5\12\2\0\12\12" +
            "\1\220\7\12\33\0\5\12\2\0\1\12\1\221\20\12" +
            "\33\0\5\12\2\0\14\12\1\222\5\12\33\0\5\12" +
            "\2\0\11\12\1\223\10\12\33\0\5\12\2\0\5\12" +
            "\1\224\14\12\33\0\5\12\2\0\2\12\1\225\17\12" +
            "\61\0\1\226\35\0\5\12\2\0\6\12\1\227\13\12" +
            "\33\0\5\12\2\0\4\12\1\230\15\12\33\0\5\12" +
            "\2\0\3\12\1\231\16\12\33\0\5\12\2\0\4\12" +
            "\1\232\15\12\33\0\5\12\2\0\12\12\1\233\7\12" +
            "\33\0\5\12\2\0\1\12\1\234\20\12\45\0\1\235" +
            "\51\0\5\12\2\0\12\12\1\236\7\12\33\0\5\12" +
            "\2\0\6\12\1\237\13\12\33\0\5\12\2\0\4\12" +
            "\1\240\15\12\57\0\1\241\37\0\5\12\2\0\12\12" +
            "\1\242\7\12\26\0\1\243\1\244\1\245\1\0\1\244" +
            "\55\0\1\244\2\0\1\244\64\0\1\246\1\247\57\0" +
            "\1\246\1\243\1\244\61\246\4\250\1\251\63\250\1\252" +
            "\57\250\3\0\1\244\1\251\57\0\3\250\1\244\1\252" +
            "\57\250";
    /**
     * The transition table of the DFA
     */
    private static final int[] ZZ_TRANS = zzUnpackTrans();
    /* error codes */
    private static final int ZZ_UNKNOWN_ERROR = 0;
    private static final int ZZ_NO_MATCH      = 1;
    private static final int ZZ_PUSHBACK_2BIG = 2;
    /* error messages for the codes above */
    private static final String ZZ_ERROR_MSG[] = {
            "Unknown internal scanner error",
            "Error: could not match input",
            "Error: pushback value was too large"
    };
    private static final String ZZ_ATTRIBUTE_PACKED_0 =
            "\4\0\1\11\1\1\1\11\1\1\1\11\16\1\10\11" +
            "\1\1\1\11\1\1\2\11\4\1\1\11\2\1\1\11" +
            "\3\1\1\11\1\1\1\0\1\1\2\0\17\1\7\11" +
            "\4\1\3\0\1\1\1\0\17\1\4\11\2\0\15\1" +
            "\1\0\13\1\1\0\11\1\1\0\10\1\1\0\6\1" +
            "\1\0\3\1\1\0\2\1\1\11\1\0\1\1\4\0";
    /**
     * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
     */
    private static final int[] ZZ_ATTRIBUTE = zzUnpackAttribute();
    /**
     * the input device
     */
    private java.io.Reader zzReader;
    /**
     * the current state of the DFA
     */
    private int zzState;
    /**
     * the current lexical state
     */
    private int zzLexicalState = YYINITIAL;
    /**
     * this buffer contains the current text to be matched and is the source of the yytext() string
     */
    private char zzBuffer[] = new char[ZZ_BUFFERSIZE];
    /**
     * the textposition at the last accepting state
     */
    private int zzMarkedPos;
    /**
     * the current text position in the buffer
     */
    private int zzCurrentPos;
    /**
     * startRead marks the beginning of the yytext() string in the buffer
     */
    private int zzStartRead;
    /**
     * endRead marks the last character in the buffer, that has been read from input
     */
    private int zzEndRead;
    /**
     * number of newlines encountered up to the start of the matched text
     */
    private int yyline;
    /**
     * the number of characters up to the start of the matched text
     */
    private int yychar;
    /**
     * the number of characters from the last newline up to the start of the matched text
     */
    private int yycolumn;
    /**
     * zzAtBOL == true <=> the scanner is currently at the beginning of a line
     */
    private boolean zzAtBOL = true;
    /**
     * zzAtEOF == true <=> the scanner is at the EOF
     */
    private boolean zzAtEOF;
    /**
     * denotes if the user-EOF-code has already been executed
     */
    private boolean zzEOFDone;
    /**
     * The number of occupied positions in zzBuffer beyond zzEndRead. When a lead/high surrogate has been read from the
     * input stream into the final zzBuffer position, this will have a value of 1; otherwise, it will have a value of
     * 0.
     */
    private int zzFinalHighSurrogate = 0;
    /* user code: */
    private HashSet<Identifier> CV = new HashSet<>();
    private Scanner      includedFile;
    private java.io.File file;

    /**
     * Creates a new scanner
     *
     * @param in the java.io.Reader to read input from.
     */
    public Scanner(java.io.Reader in) {
        this.zzReader = in;
    }

    private static int[] zzUnpackAction() {
        int[] result = new int[170];
        int   offset = 0;
        offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
        return result;
    }

    private static int zzUnpackAction(String packed, int offset, int[] result) {
        int i = 0;       /* index in packed string  */
        int j = offset;  /* index in unpacked array */
        int l = packed.length();
        while (i < l) {
            int count = packed.charAt(i++);
            int value = packed.charAt(i++);
            do result[j++] = value; while (--count > 0);
        }
        return j;
    }

    private static int[] zzUnpackRowMap() {
        int[] result = new int[170];
        int   offset = 0;
        offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
        return result;
    }

    private static int zzUnpackRowMap(String packed, int offset, int[] result) {
        int i = 0;  /* index in packed string  */
        int j = offset;  /* index in unpacked array */
        int l = packed.length();
        while (i < l) {
            int high = packed.charAt(i++) << 16;
            result[j++] = high | packed.charAt(i++);
        }
        return j;
    }

    private static int[] zzUnpackTrans() {
        int[] result = new int[6188];
        int   offset = 0;
        offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
        return result;
    }

    private static int zzUnpackTrans(String packed, int offset, int[] result) {
        int i = 0;       /* index in packed string  */
        int j = offset;  /* index in unpacked array */
        int l = packed.length();
        while (i < l) {
            int count = packed.charAt(i++);
            int value = packed.charAt(i++);
            value--;
            do result[j++] = value; while (--count > 0);
        }
        return j;
    }

    private static int[] zzUnpackAttribute() {
        int[] result = new int[170];
        int   offset = 0;
        offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
        return result;
    }

    private static int zzUnpackAttribute(String packed, int offset, int[] result) {
        int i = 0;       /* index in packed string  */
        int j = offset;  /* index in unpacked array */
        int l = packed.length();
        while (i < l) {
            int count = packed.charAt(i++);
            int value = packed.charAt(i++);
            do result[j++] = value; while (--count > 0);
        }
        return j;
    }

    /**
     * Unpacks the compressed character translation table.
     *
     * @param packed the packed character translation table
     *
     * @return the unpacked character translation table
     */
    private static char[] zzUnpackCMap(String packed) {
        char[] map = new char[0x110000];
        int    i   = 0;  /* index in packed string  */
        int    j   = 0;  /* index in unpacked array */
        while (i < 180) {
            int  count = packed.charAt(i++);
            char value = packed.charAt(i++);
            do map[j++] = value; while (--count > 0);
        }
        return map;
    }

    public String NextToken() throws java.io.IOException {
        if (includedFile != null) {
            String t = includedFile.NextToken();
            if (t != null)
                return t;
            else
                includedFile = null;
        }

        Token t = nextToken();

        if (t instanceof Identifier)
            return "id";
        if (t instanceof BooleanLiteral)
            return "bool_literal";
        if (t instanceof CharacterLiteral)
            return "char_literal";
        if (t instanceof FloatLiteral)
            return "float_literal";
        if (t instanceof IntegerLiteral)
            return "int_literal";

        if (t instanceof PreprocessorDirective) {
            includedFile = new Scanner(new java.io.File(file.getParent(), t.getValue()).getCanonicalPath());
            String token = includedFile.NextToken();
            if (token != null)
                return token;
            else
                includedFile = null;
        }

        return t != null ? t.getValue() : null;
    }

    /**
     * Refills the input buffer.
     *
     * @return <code>false</code>, iff there was new input.
     *
     * @throws java.io.IOException if any I/O-Error occurs
     */
    private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
        if (zzStartRead > 0) {
            zzEndRead += zzFinalHighSurrogate;
            zzFinalHighSurrogate = 0;
            System.arraycopy(zzBuffer, zzStartRead,
                             zzBuffer, 0,
                             zzEndRead - zzStartRead);

      /* translate stored positions */
            zzEndRead -= zzStartRead;
            zzCurrentPos -= zzStartRead;
            zzMarkedPos -= zzStartRead;
            zzStartRead = 0;
        }

    /* is the buffer big enough? */
        if (zzCurrentPos >= zzBuffer.length - zzFinalHighSurrogate) {
      /* if not: blow it up */
            char newBuffer[] = new char[zzBuffer.length * 2];
            System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
            zzBuffer = newBuffer;
            zzEndRead += zzFinalHighSurrogate;
            zzFinalHighSurrogate = 0;
        }

    /* fill the buffer with new input */
        int requested = zzBuffer.length - zzEndRead;
        int numRead   = zzReader.read(zzBuffer, zzEndRead, requested);

    /* not supposed to occur according to specification of java.io.Reader */
        if (numRead == 0) {
            throw new java.io.IOException("Reader returned 0 characters. See JFlex examples for workaround.");
        }
        if (numRead > 0) {
            zzEndRead += numRead;
      /* If numRead == requested, we might have requested to few chars to
         encode a full Unicode character. We assume that a Reader would
         otherwise never return half characters. */
            if (numRead == requested) {
                if (Character.isHighSurrogate(zzBuffer[zzEndRead - 1])) {
                    --zzEndRead;
                    zzFinalHighSurrogate = 1;
                }
            }
      /* potentially more input available */
            return false;
        }

    /* numRead < 0 ==> end of stream */
        return true;
    }


    /**
     * Closes the input stream.
     */
    public final void yyclose() throws java.io.IOException {
        zzAtEOF = true;            /* indicate end of file */
        zzEndRead = zzStartRead;  /* invalidate buffer    */

        if (zzReader != null)
            zzReader.close();
    }


    /**
     * Resets the scanner to read from a new input stream. Does not close the old reader.
     * <p>
     * All internal variables are reset, the old input stream <b>cannot</b> be reused (internal buffer is discarded and
     * lost). Lexical state is set to <tt>ZZ_INITIAL</tt>.
     * <p>
     * Internal scan buffer is resized down to its initial length, if it has grown.
     *
     * @param reader the new input stream
     */
    public final void yyreset(java.io.Reader reader) {
        zzReader = reader;
        zzAtBOL = true;
        zzAtEOF = false;
        zzEOFDone = false;
        zzEndRead = zzStartRead = 0;
        zzCurrentPos = zzMarkedPos = 0;
        zzFinalHighSurrogate = 0;
        yyline = yychar = yycolumn = 0;
        zzLexicalState = YYINITIAL;
        if (zzBuffer.length > ZZ_BUFFERSIZE)
            zzBuffer = new char[ZZ_BUFFERSIZE];
    }


    /**
     * Returns the current lexical state.
     */
    public final int yystate() {
        return zzLexicalState;
    }


    /**
     * Enters a new lexical state
     *
     * @param newState the new lexical state
     */
    public final void yybegin(int newState) {
        zzLexicalState = newState;
    }


    /**
     * Returns the text matched by the current regular expression.
     */
    public final String yytext() {
        return new String(zzBuffer, zzStartRead, zzMarkedPos - zzStartRead);
    }


    /**
     * Returns the character at position <tt>pos</tt> from the matched text.
     * <p>
     * It is equivalent to yytext().charAt(pos), but faster
     *
     * @param pos the position of the character to fetch. A value from 0 to yylength()-1.
     *
     * @return the character at position pos
     */
    public final char yycharat(int pos) {
        return zzBuffer[zzStartRead + pos];
    }

    /**
     * Pushes the specified amount of characters back into the input stream.
     * <p>
     * They will be read again by then next call of the scanning method
     *
     * @param number the number of characters to be read again. This number must not be greater than yylength()!
     */
    public void yypushback(int number) {
        if (number > yylength())
            zzScanError(ZZ_PUSHBACK_2BIG);

        zzMarkedPos -= number;
    }

    /**
     * Returns the length of the matched text region.
     */
    public final int yylength() {
        return zzMarkedPos - zzStartRead;
    }

    /**
     * Reports an error that occured while scanning.
     * <p>
     * In a wellformed scanner (no or only correct usage of yypushback(int) and a match-all fallback rule) this method
     * will only be called with things that "Can't Possibly Happen". If this method is called, something is seriously
     * wrong (e.g. a JFlex bug producing a faulty scanner etc.).
     * <p>
     * Usual syntax/scanner level error handling should be done in error fallback rules.
     *
     * @param errorCode the code of the errormessage to display
     */
    private void zzScanError(int errorCode) {
        String message;
        try {
            message = ZZ_ERROR_MSG[errorCode];
        } catch (ArrayIndexOutOfBoundsException e) {
            message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
        }

        throw new Error(message);
    }

    /**
     * Resumes scanning until the next regular expression is matched, the end of input is encountered or an I/O-Error
     * occurs.
     *
     * @return the next token
     *
     * @throws java.io.IOException if any I/O-Error occurs
     */
    public Token nextToken() throws java.io.IOException {
        int zzInput;
        int zzAction;

        // cached fields:
        int    zzCurrentPosL;
        int    zzMarkedPosL;
        int    zzEndReadL = zzEndRead;
        char[] zzBufferL  = zzBuffer;
        char[] zzCMapL    = ZZ_CMAP;

        int[] zzTransL  = ZZ_TRANS;
        int[] zzRowMapL = ZZ_ROWMAP;
        int[] zzAttrL   = ZZ_ATTRIBUTE;

        while (true) {
            zzMarkedPosL = zzMarkedPos;

            boolean zzR = false;
            int     zzCh;
            int     zzCharCount;
            for (zzCurrentPosL = zzStartRead;
                 zzCurrentPosL < zzMarkedPosL;
                 zzCurrentPosL += zzCharCount) {
                zzCh = Character.codePointAt(zzBufferL, zzCurrentPosL, zzMarkedPosL);
                zzCharCount = Character.charCount(zzCh);
                switch (zzCh) {
                    case '\u000B':
                    case '\u000C':
                    case '\u0085':
                    case '\u2028':
                    case '\u2029':
                        yyline++;
                        yycolumn = 0;
                        zzR = false;
                        break;
                    case '\r':
                        yyline++;
                        yycolumn = 0;
                        zzR = true;
                        break;
                    case '\n':
                        if (zzR)
                            zzR = false;
                        else {
                            yyline++;
                            yycolumn = 0;
                        }
                        break;
                    default:
                        zzR = false;
                        yycolumn += zzCharCount;
                }
            }

            if (zzR) {
                // peek one character ahead if it is \n (if we have counted one line too much)
                boolean zzPeek;
                if (zzMarkedPosL < zzEndReadL)
                    zzPeek = zzBufferL[zzMarkedPosL] == '\n';
                else if (zzAtEOF)
                    zzPeek = false;
                else {
                    boolean eof = zzRefill();
                    zzEndReadL = zzEndRead;
                    zzMarkedPosL = zzMarkedPos;
                    zzBufferL = zzBuffer;
                    if (eof)
                        zzPeek = false;
                    else
                        zzPeek = zzBufferL[zzMarkedPosL] == '\n';
                }
                if (zzPeek) yyline--;
            }
            zzAction = -1;

            zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;

            zzState = ZZ_LEXSTATE[zzLexicalState];

            // set up zzAction for empty match case:
            int zzAttributes = zzAttrL[zzState];
            if ((zzAttributes & 1) == 1) {
                zzAction = zzState;
            }


            zzForAction:
            {
                while (true) {

                    if (zzCurrentPosL < zzEndReadL) {
                        zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
                        zzCurrentPosL += Character.charCount(zzInput);
                    } else if (zzAtEOF) {
                        zzInput = YYEOF;
                        break zzForAction;
                    } else {
                        // store back cached positions
                        zzCurrentPos = zzCurrentPosL;
                        zzMarkedPos = zzMarkedPosL;
                        boolean eof = zzRefill();
                        // get translated positions and possibly new buffer
                        zzCurrentPosL = zzCurrentPos;
                        zzMarkedPosL = zzMarkedPos;
                        zzBufferL = zzBuffer;
                        zzEndReadL = zzEndRead;
                        if (eof) {
                            zzInput = YYEOF;
                            break zzForAction;
                        } else {
                            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
                            zzCurrentPosL += Character.charCount(zzInput);
                        }
                    }
                    int zzNext = zzTransL[zzRowMapL[zzState] + zzCMapL[zzInput]];
                    if (zzNext == -1) break zzForAction;
                    zzState = zzNext;

                    zzAttributes = zzAttrL[zzState];
                    if ((zzAttributes & 1) == 1) {
                        zzAction = zzState;
                        zzMarkedPosL = zzCurrentPosL;
                        if ((zzAttributes & 8) == 8) break zzForAction;
                    }

                }
            }

            // store back cached position
            zzMarkedPos = zzMarkedPosL;

            if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
                zzAtEOF = true;
                return null;
            } else {
                switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
                    case 1: {
                        throw new RuntimeException("Invalid Token at line " + yyline + " = " + yytext());
                    }
                    case 58:
                        break;
                    case 2: { /* ignore */
                    }
                    case 59:
                        break;
                    case 3: {
                        return new Symbol(Symbols.DIV, yyline, yycolumn);
                    }
                    case 60:
                        break;
                    case 4: {
                        return new Symbol(Symbols.MULT, yyline, yycolumn);
                    }
                    case 61:
                        break;
                    case 5: {
                        Identifier id1 = new Identifier(yytext(), yyline, yycolumn);
                        CV.add(id1);
                        return id1;
                    }
                    case 62:
                        break;
                    case 6: {
                        return new IntegerLiteral(yytext(), yyline, yycolumn);
                    }
                    case 63:
                        break;
                    case 7: {
                        return new Symbol(Symbols.LPAREN, yyline, yycolumn);
                    }
                    case 64:
                        break;
                    case 8: {
                        return new Symbol(Symbols.RPAREN, yyline, yycolumn);
                    }
                    case 65:
                        break;
                    case 9: {
                        return new Symbol(Symbols.LBRACE, yyline, yycolumn);
                    }
                    case 66:
                        break;
                    case 10: {
                        return new Symbol(Symbols.RBRACE, yyline, yycolumn);
                    }
                    case 67:
                        break;
                    case 11: {
                        return new Symbol(Symbols.SEMICOLON, yyline, yycolumn);
                    }
                    case 68:
                        break;
                    case 12: {
                        return new Symbol(Symbols.COMMA, yyline, yycolumn);
                    }
                    case 69:
                        break;
                    case 13: {
                        return new Symbol(Symbols.LBRACKET, yyline, yycolumn);
                    }
                    case 70:
                        break;
                    case 14: {
                        return new Symbol(Symbols.RBRACKET, yyline, yycolumn);
                    }
                    case 71:
                        break;
                    case 15: {
                        return new Symbol(Symbols.EQ, yyline, yycolumn);
                    }
                    case 72:
                        break;
                    case 16: {
                        return new Symbol(Symbols.MINUS, yyline, yycolumn);
                    }
                    case 73:
                        break;
                    case 17: {
                        return new Symbol(Symbols.NOT, yyline, yycolumn);
                    }
                    case 74:
                        break;
                    case 18: {
                        return new Symbol(Symbols.MOD, yyline, yycolumn);
                    }
                    case 75:
                        break;
                    case 19: {
                        return new Symbol(Symbols.PLUS, yyline, yycolumn);
                    }
                    case 76:
                        break;
                    case 20: {
                        return new Symbol(Symbols.GT, yyline, yycolumn);
                    }
                    case 77:
                        break;
                    case 21: {
                        return new Symbol(Symbols.LT, yyline, yycolumn);
                    }
                    case 78:
                        break;
                    case 22: {
                        yybegin(CHARLITERAL);
                    }
                    case 79:
                        break;
                    case 23: {
                        throw new RuntimeException("Invalid Token at line " + yyline + " = (newline)");
                    }
                    case 80:
                        break;
                    case 24: {
                        yybegin(YYINITIAL);
                        return new PreprocessorDirective(yytext().trim(), yyline,
                                                         yycolumn);
                    }
                    case 81:
                        break;
                    case 25: {
                        return new FloatLiteral(yytext(), yyline, yycolumn);
                    }
                    case 82:
                        break;
                    case 26: {
                        return new Keyword(Keywords.IF, yyline, yycolumn);
                    }
                    case 83:
                        break;
                    case 27: {
                        return new Symbol(Symbols.EQEQ, yyline, yycolumn);
                    }
                    case 84:
                        break;
                    case 28: {
                        return new Symbol(Symbols.NOTEQ, yyline, yycolumn);
                    }
                    case 85:
                        break;
                    case 29: {
                        return new Symbol(Symbols.GTEQ, yyline, yycolumn);
                    }
                    case 86:
                        break;
                    case 30: {
                        return new Symbol(Symbols.LTEQ, yyline, yycolumn);
                    }
                    case 87:
                        break;
                    case 31: {
                        return new Symbol(Symbols.ANDAND, yyline, yycolumn);
                    }
                    case 88:
                        break;
                    case 32: {
                        return new Symbol(Symbols.OROR, yyline, yycolumn);
                    }
                    case 89:
                        break;
                    case 33: {
                        yybegin(YYINITIAL);
                        return new CharacterLiteral(yytext(), yyline, yycolumn);
                    }
                    case 90:
                        break;
                    case 34: {
                        return new Keyword(Keywords.INT, yyline, yycolumn);
                    }
                    case 91:
                        break;
                    case 35: {
                        return new Keyword(Keywords.FOR, yyline, yycolumn);
                    }
                    case 92:
                        break;
                    case 36: {
                        yybegin(YYINITIAL);
                        return new CharacterLiteral("\\", yyline, yycolumn);
                    }
                    case 93:
                        break;
                    case 37: {
                        yybegin(YYINITIAL);
                        return new CharacterLiteral("\n", yyline, yycolumn);
                    }
                    case 94:
                        break;
                    case 38: {
                        yybegin(YYINITIAL);
                        return new CharacterLiteral("\t", yyline, yycolumn);
                    }
                    case 95:
                        break;
                    case 39: {
                        yybegin(YYINITIAL);
                        return new CharacterLiteral("\'", yyline, yycolumn);
                    }
                    case 96:
                        break;
                    case 40: {
                        return new Keyword(Keywords.ELSE, yyline, yycolumn);
                    }
                    case 97:
                        break;
                    case 41: {
                        return new Keyword(Keywords.CHAR, yyline, yycolumn);
                    }
                    case 98:
                        break;
                    case 42: {
                        return new BooleanLiteral("true", yyline, yycolumn);
                    }
                    case 99:
                        break;
                    case 43: {
                        return new Keyword(Keywords.VOID, yyline, yycolumn);
                    }
                    case 100:
                        break;
                    case 44: {
                        return new Keyword(Keywords.BREAK, yyline, yycolumn);
                    }
                    case 101:
                        break;
                    case 45: {
                        return new Keyword(Keywords.FLOAT, yyline, yycolumn);
                    }
                    case 102:
                        break;
                    case 46: {
                        return new BooleanLiteral("false", yyline, yycolumn);
                    }
                    case 103:
                        break;
                    case 47: {
                        return new Keyword(Keywords.WHILE, yyline, yycolumn);
                    }
                    case 104:
                        break;
                    case 48: {
                        return new Keyword(Keywords.RETURN, yyline, yycolumn);
                    }
                    case 105:
                        break;
                    case 49: {
                        return new Keyword(Keywords.BOOLEAN, yyline, yycolumn);
                    }
                    case 106:
                        break;
                    case 50: {
                        return new Keyword(Keywords.READINT, yyline, yycolumn);
                    }
                    case 107:
                        break;
                    case 51: {
                        return new Keyword(Keywords.READCHAR, yyline, yycolumn);
                    }
                    case 108:
                        break;
                    case 52: {
                        return new Keyword(Keywords.CONTINUE, yyline, yycolumn);
                    }
                    case 109:
                        break;
                    case 53: {
                        return new Keyword(Keywords.WRITEINT, yyline, yycolumn);
                    }
                    case 110:
                        break;
                    case 54: {
                        return new Keyword(Keywords.READFLOAT, yyline, yycolumn);
                    }
                    case 111:
                        break;
                    case 55: {
                        return new Keyword(Keywords.WRITECHAR, yyline, yycolumn);
                    }
                    case 112:
                        break;
                    case 56: {
                        return new Keyword(Keywords.WRITEFLOAT, yyline, yycolumn);
                    }
                    case 113:
                        break;
                    case 57: {
                        yybegin(INCLUDE);
                    }
                    case 114:
                        break;
                    default:
                        zzScanError(ZZ_NO_MATCH);
                }
            }
        }
    }


}
