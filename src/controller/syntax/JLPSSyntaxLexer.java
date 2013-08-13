// $ANTLR 3.4 C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g 2013-08-13 15:48:40

package controller.syntax;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class JLPSSyntaxLexer extends Lexer {
    public static final int EOF=-1;
    public static final int T__9=9;
    public static final int T__10=10;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__19=19;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__50=50;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__55=55;
    public static final int COMMENT=4;
    public static final int COMMENT_LINE=5;
    public static final int CONSTANT=6;
    public static final int VARIABLE=7;
    public static final int WS=8;

    // delegates
    // delegators
    public Lexer[] getDelegates() {
        return new Lexer[] {};
    }

    public JLPSSyntaxLexer() {} 
    public JLPSSyntaxLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public JLPSSyntaxLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);
    }
    public String getGrammarFileName() { return "C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g"; }

    // $ANTLR start "T__9"
    public final void mT__9() throws RecognitionException {
        try {
            int _type = T__9;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:11:6: ( '!' )
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:11:8: '!'
            {
            match('!'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__9"

    // $ANTLR start "T__10"
    public final void mT__10() throws RecognitionException {
        try {
            int _type = T__10;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:12:7: ( '&' )
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:12:9: '&'
            {
            match('&'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__10"

    // $ANTLR start "T__11"
    public final void mT__11() throws RecognitionException {
        try {
            int _type = T__11;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:13:7: ( '(' )
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:13:9: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__11"

    // $ANTLR start "T__12"
    public final void mT__12() throws RecognitionException {
        try {
            int _type = T__12;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:14:7: ( ')' )
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:14:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__12"

    // $ANTLR start "T__13"
    public final void mT__13() throws RecognitionException {
        try {
            int _type = T__13;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:15:7: ( ',' )
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:15:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__13"

    // $ANTLR start "T__14"
    public final void mT__14() throws RecognitionException {
        try {
            int _type = T__14;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:16:7: ( '->' )
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:16:9: '->'
            {
            match("->"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__14"

    // $ANTLR start "T__15"
    public final void mT__15() throws RecognitionException {
        try {
            int _type = T__15;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:17:7: ( '.' )
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:17:9: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__15"

    // $ANTLR start "T__16"
    public final void mT__16() throws RecognitionException {
        try {
            int _type = T__16;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:18:7: ( ':' )
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:18:9: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__16"

    // $ANTLR start "T__17"
    public final void mT__17() throws RecognitionException {
        try {
            int _type = T__17;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:19:7: ( ':-' )
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:19:9: ':-'
            {
            match(":-"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__17"

    // $ANTLR start "T__18"
    public final void mT__18() throws RecognitionException {
        try {
            int _type = T__18;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:20:7: ( '=' )
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:20:9: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__18"

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:21:7: ( '==' )
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:21:9: '=='
            {
            match("=="); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__19"

    // $ANTLR start "T__20"
    public final void mT__20() throws RecognitionException {
        try {
            int _type = T__20;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:22:7: ( 'DSet' )
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:22:9: 'DSet'
            {
            match("DSet"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__20"

    // $ANTLR start "T__21"
    public final void mT__21() throws RecognitionException {
        try {
            int _type = T__21;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:23:7: ( 'Database' )
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:23:9: 'Database'
            {
            match("Database"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__21"

    // $ANTLR start "T__22"
    public final void mT__22() throws RecognitionException {
        try {
            int _type = T__22;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:24:7: ( 'Domain Theory' )
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:24:9: 'Domain Theory'
            {
            match("Domain Theory"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__22"

    // $ANTLR start "T__23"
    public final void mT__23() throws RecognitionException {
        try {
            int _type = T__23;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:25:7: ( 'DomainTheory' )
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:25:9: 'DomainTheory'
            {
            match("DomainTheory"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__23"

    // $ANTLR start "T__24"
    public final void mT__24() throws RecognitionException {
        try {
            int _type = T__24;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:26:7: ( 'Dset' )
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:26:9: 'Dset'
            {
            match("Dset"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__24"

    // $ANTLR start "T__25"
    public final void mT__25() throws RecognitionException {
        try {
            int _type = T__25;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:27:7: ( 'Events' )
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:27:9: 'Events'
            {
            match("Events"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__25"

    // $ANTLR start "T__26"
    public final void mT__26() throws RecognitionException {
        try {
            int _type = T__26;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:28:7: ( 'Facts' )
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:28:9: 'Facts'
            {
            match("Facts"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__26"

    // $ANTLR start "T__27"
    public final void mT__27() throws RecognitionException {
        try {
            int _type = T__27;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:29:7: ( 'Goals' )
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:29:9: 'Goals'
            {
            match("Goals"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__27"

    // $ANTLR start "T__28"
    public final void mT__28() throws RecognitionException {
        try {
            int _type = T__28;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:30:7: ( 'Lext' )
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:30:9: 'Lext'
            {
            match("Lext"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__28"

    // $ANTLR start "T__29"
    public final void mT__29() throws RecognitionException {
        try {
            int _type = T__29;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:31:7: ( 'Lint' )
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:31:9: 'Lint'
            {
            match("Lint"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__29"

    // $ANTLR start "T__30"
    public final void mT__30() throws RecognitionException {
        try {
            int _type = T__30;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:32:7: ( 'Postconditions' )
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:32:9: 'Postconditions'
            {
            match("Postconditions"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__30"

    // $ANTLR start "T__31"
    public final void mT__31() throws RecognitionException {
        try {
            int _type = T__31;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:33:7: ( 'Preconditions' )
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:33:9: 'Preconditions'
            {
            match("Preconditions"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__31"

    // $ANTLR start "T__32"
    public final void mT__32() throws RecognitionException {
        try {
            int _type = T__32;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:34:7: ( 'ReactiveRules' )
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:34:9: 'ReactiveRules'
            {
            match("ReactiveRules"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__32"

    // $ANTLR start "T__33"
    public final void mT__33() throws RecognitionException {
        try {
            int _type = T__33;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:35:7: ( 'Rules' )
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:35:9: 'Rules'
            {
            match("Rules"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__33"

    // $ANTLR start "T__34"
    public final void mT__34() throws RecognitionException {
        try {
            int _type = T__34;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:36:7: ( '[' )
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:36:9: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__34"

    // $ANTLR start "T__35"
    public final void mT__35() throws RecognitionException {
        try {
            int _type = T__35;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:37:7: ( ']' )
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:37:9: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__35"

    // $ANTLR start "T__36"
    public final void mT__36() throws RecognitionException {
        try {
            int _type = T__36;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:38:7: ( 'conditions' )
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:38:9: 'conditions'
            {
            match("conditions"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__36"

    // $ANTLR start "T__37"
    public final void mT__37() throws RecognitionException {
        try {
            int _type = T__37;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:39:7: ( 'conflicts' )
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:39:9: 'conflicts'
            {
            match("conflicts"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__37"

    // $ANTLR start "T__38"
    public final void mT__38() throws RecognitionException {
        try {
            int _type = T__38;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:40:7: ( 'dSet' )
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:40:9: 'dSet'
            {
            match("dSet"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__38"

    // $ANTLR start "T__39"
    public final void mT__39() throws RecognitionException {
        try {
            int _type = T__39;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:41:7: ( 'database' )
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:41:9: 'database'
            {
            match("database"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__39"

    // $ANTLR start "T__40"
    public final void mT__40() throws RecognitionException {
        try {
            int _type = T__40;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:42:7: ( 'domain theory' )
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:42:9: 'domain theory'
            {
            match("domain theory"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__40"

    // $ANTLR start "T__41"
    public final void mT__41() throws RecognitionException {
        try {
            int _type = T__41;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:43:7: ( 'domainTheory' )
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:43:9: 'domainTheory'
            {
            match("domainTheory"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__41"

    // $ANTLR start "T__42"
    public final void mT__42() throws RecognitionException {
        try {
            int _type = T__42;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:44:7: ( 'dset' )
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:44:9: 'dset'
            {
            match("dset"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__42"

    // $ANTLR start "T__43"
    public final void mT__43() throws RecognitionException {
        try {
            int _type = T__43;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:45:7: ( 'events' )
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:45:9: 'events'
            {
            match("events"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__43"

    // $ANTLR start "T__44"
    public final void mT__44() throws RecognitionException {
        try {
            int _type = T__44;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:46:7: ( 'facts' )
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:46:9: 'facts'
            {
            match("facts"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__44"

    // $ANTLR start "T__45"
    public final void mT__45() throws RecognitionException {
        try {
            int _type = T__45;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:47:7: ( 'goals' )
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:47:9: 'goals'
            {
            match("goals"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__45"

    // $ANTLR start "T__46"
    public final void mT__46() throws RecognitionException {
        try {
            int _type = T__46;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:48:7: ( 'initiates' )
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:48:9: 'initiates'
            {
            match("initiates"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__46"

    // $ANTLR start "T__47"
    public final void mT__47() throws RecognitionException {
        try {
            int _type = T__47;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:49:7: ( 'lext' )
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:49:9: 'lext'
            {
            match("lext"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__47"

    // $ANTLR start "T__48"
    public final void mT__48() throws RecognitionException {
        try {
            int _type = T__48;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:50:7: ( 'lint' )
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:50:9: 'lint'
            {
            match("lint"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__48"

    // $ANTLR start "T__49"
    public final void mT__49() throws RecognitionException {
        try {
            int _type = T__49;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:51:7: ( 'reactiveRules' )
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:51:9: 'reactiveRules'
            {
            match("reactiveRules"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__49"

    // $ANTLR start "T__50"
    public final void mT__50() throws RecognitionException {
        try {
            int _type = T__50;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:52:7: ( 'reactiverules' )
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:52:9: 'reactiverules'
            {
            match("reactiverules"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__50"

    // $ANTLR start "T__51"
    public final void mT__51() throws RecognitionException {
        try {
            int _type = T__51;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:53:7: ( 'rules' )
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:53:9: 'rules'
            {
            match("rules"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__51"

    // $ANTLR start "T__52"
    public final void mT__52() throws RecognitionException {
        try {
            int _type = T__52;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:54:7: ( 'terminates' )
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:54:9: 'terminates'
            {
            match("terminates"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__52"

    // $ANTLR start "T__53"
    public final void mT__53() throws RecognitionException {
        try {
            int _type = T__53;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:55:7: ( 'true' )
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:55:9: 'true'
            {
            match("true"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__53"

    // $ANTLR start "T__54"
    public final void mT__54() throws RecognitionException {
        try {
            int _type = T__54;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:56:7: ( '{' )
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:56:9: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__54"

    // $ANTLR start "T__55"
    public final void mT__55() throws RecognitionException {
        try {
            int _type = T__55;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:57:7: ( '}' )
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:57:9: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__55"

    // $ANTLR start "CONSTANT"
    public final void mCONSTANT() throws RecognitionException {
        try {
            int _type = CONSTANT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:275:10: ( ( 'a' .. 'z' | '0' .. '9' ) ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' )* )
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:275:12: ( 'a' .. 'z' | '0' .. '9' ) ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' )*
            {
            if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:275:34: ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0 >= '0' && LA1_0 <= '9')||(LA1_0 >= 'A' && LA1_0 <= 'Z')||LA1_0=='_'||(LA1_0 >= 'a' && LA1_0 <= 'z')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "CONSTANT"

    // $ANTLR start "VARIABLE"
    public final void mVARIABLE() throws RecognitionException {
        try {
            int _type = VARIABLE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:271:10: ( ( 'A' .. 'Z' ) ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' )* )
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:271:12: ( 'A' .. 'Z' ) ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' )*
            {
            if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:271:23: ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0 >= '0' && LA2_0 <= '9')||(LA2_0 >= 'A' && LA2_0 <= 'Z')||LA2_0=='_'||(LA2_0 >= 'a' && LA2_0 <= 'z')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "VARIABLE"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:272:4: ( ( ' ' | '\\t' | '\\n' | '\\r' | '\\f' )+ )
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:272:6: ( ' ' | '\\t' | '\\n' | '\\r' | '\\f' )+
            {
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:272:6: ( ' ' | '\\t' | '\\n' | '\\r' | '\\f' )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0 >= '\t' && LA3_0 <= '\n')||(LA3_0 >= '\f' && LA3_0 <= '\r')||LA3_0==' ') ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:
            	    {
            	    if ( (input.LA(1) >= '\t' && input.LA(1) <= '\n')||(input.LA(1) >= '\f' && input.LA(1) <= '\r')||input.LA(1)==' ' ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);


            _channel = HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "WS"

    // $ANTLR start "COMMENT_LINE"
    public final void mCOMMENT_LINE() throws RecognitionException {
        try {
            int _type = COMMENT_LINE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:273:14: ( '//' ( . )* ( '\\n' | '\\r' ) )
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:273:16: '//' ( . )* ( '\\n' | '\\r' )
            {
            match("//"); 



            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:273:21: ( . )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0=='\n'||LA4_0=='\r') ) {
                    alt4=2;
                }
                else if ( ((LA4_0 >= '\u0000' && LA4_0 <= '\t')||(LA4_0 >= '\u000B' && LA4_0 <= '\f')||(LA4_0 >= '\u000E' && LA4_0 <= '\uFFFF')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:273:21: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            if ( input.LA(1)=='\n'||input.LA(1)=='\r' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            _channel = HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "COMMENT_LINE"

    // $ANTLR start "COMMENT"
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:274:9: ( '/*' ( . )* '*/' )
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:274:11: '/*' ( . )* '*/'
            {
            match("/*"); 



            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:274:16: ( . )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0=='*') ) {
                    int LA5_1 = input.LA(2);

                    if ( (LA5_1=='/') ) {
                        alt5=2;
                    }
                    else if ( ((LA5_1 >= '\u0000' && LA5_1 <= '.')||(LA5_1 >= '0' && LA5_1 <= '\uFFFF')) ) {
                        alt5=1;
                    }


                }
                else if ( ((LA5_0 >= '\u0000' && LA5_0 <= ')')||(LA5_0 >= '+' && LA5_0 <= '\uFFFF')) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:274:16: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);


            match("*/"); 



            _channel = HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "COMMENT"

    public void mTokens() throws RecognitionException {
        // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:1:8: ( T__9 | T__10 | T__11 | T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | CONSTANT | VARIABLE | WS | COMMENT_LINE | COMMENT )
        int alt6=52;
        alt6 = dfa6.predict(input);
        switch (alt6) {
            case 1 :
                // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:1:10: T__9
                {
                mT__9(); 


                }
                break;
            case 2 :
                // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:1:15: T__10
                {
                mT__10(); 


                }
                break;
            case 3 :
                // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:1:21: T__11
                {
                mT__11(); 


                }
                break;
            case 4 :
                // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:1:27: T__12
                {
                mT__12(); 


                }
                break;
            case 5 :
                // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:1:33: T__13
                {
                mT__13(); 


                }
                break;
            case 6 :
                // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:1:39: T__14
                {
                mT__14(); 


                }
                break;
            case 7 :
                // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:1:45: T__15
                {
                mT__15(); 


                }
                break;
            case 8 :
                // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:1:51: T__16
                {
                mT__16(); 


                }
                break;
            case 9 :
                // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:1:57: T__17
                {
                mT__17(); 


                }
                break;
            case 10 :
                // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:1:63: T__18
                {
                mT__18(); 


                }
                break;
            case 11 :
                // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:1:69: T__19
                {
                mT__19(); 


                }
                break;
            case 12 :
                // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:1:75: T__20
                {
                mT__20(); 


                }
                break;
            case 13 :
                // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:1:81: T__21
                {
                mT__21(); 


                }
                break;
            case 14 :
                // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:1:87: T__22
                {
                mT__22(); 


                }
                break;
            case 15 :
                // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:1:93: T__23
                {
                mT__23(); 


                }
                break;
            case 16 :
                // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:1:99: T__24
                {
                mT__24(); 


                }
                break;
            case 17 :
                // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:1:105: T__25
                {
                mT__25(); 


                }
                break;
            case 18 :
                // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:1:111: T__26
                {
                mT__26(); 


                }
                break;
            case 19 :
                // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:1:117: T__27
                {
                mT__27(); 


                }
                break;
            case 20 :
                // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:1:123: T__28
                {
                mT__28(); 


                }
                break;
            case 21 :
                // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:1:129: T__29
                {
                mT__29(); 


                }
                break;
            case 22 :
                // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:1:135: T__30
                {
                mT__30(); 


                }
                break;
            case 23 :
                // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:1:141: T__31
                {
                mT__31(); 


                }
                break;
            case 24 :
                // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:1:147: T__32
                {
                mT__32(); 


                }
                break;
            case 25 :
                // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:1:153: T__33
                {
                mT__33(); 


                }
                break;
            case 26 :
                // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:1:159: T__34
                {
                mT__34(); 


                }
                break;
            case 27 :
                // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:1:165: T__35
                {
                mT__35(); 


                }
                break;
            case 28 :
                // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:1:171: T__36
                {
                mT__36(); 


                }
                break;
            case 29 :
                // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:1:177: T__37
                {
                mT__37(); 


                }
                break;
            case 30 :
                // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:1:183: T__38
                {
                mT__38(); 


                }
                break;
            case 31 :
                // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:1:189: T__39
                {
                mT__39(); 


                }
                break;
            case 32 :
                // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:1:195: T__40
                {
                mT__40(); 


                }
                break;
            case 33 :
                // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:1:201: T__41
                {
                mT__41(); 


                }
                break;
            case 34 :
                // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:1:207: T__42
                {
                mT__42(); 


                }
                break;
            case 35 :
                // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:1:213: T__43
                {
                mT__43(); 


                }
                break;
            case 36 :
                // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:1:219: T__44
                {
                mT__44(); 


                }
                break;
            case 37 :
                // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:1:225: T__45
                {
                mT__45(); 


                }
                break;
            case 38 :
                // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:1:231: T__46
                {
                mT__46(); 


                }
                break;
            case 39 :
                // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:1:237: T__47
                {
                mT__47(); 


                }
                break;
            case 40 :
                // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:1:243: T__48
                {
                mT__48(); 


                }
                break;
            case 41 :
                // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:1:249: T__49
                {
                mT__49(); 


                }
                break;
            case 42 :
                // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:1:255: T__50
                {
                mT__50(); 


                }
                break;
            case 43 :
                // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:1:261: T__51
                {
                mT__51(); 


                }
                break;
            case 44 :
                // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:1:267: T__52
                {
                mT__52(); 


                }
                break;
            case 45 :
                // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:1:273: T__53
                {
                mT__53(); 


                }
                break;
            case 46 :
                // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:1:279: T__54
                {
                mT__54(); 


                }
                break;
            case 47 :
                // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:1:285: T__55
                {
                mT__55(); 


                }
                break;
            case 48 :
                // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:1:291: CONSTANT
                {
                mCONSTANT(); 


                }
                break;
            case 49 :
                // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:1:300: VARIABLE
                {
                mVARIABLE(); 


                }
                break;
            case 50 :
                // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:1:309: WS
                {
                mWS(); 


                }
                break;
            case 51 :
                // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:1:312: COMMENT_LINE
                {
                mCOMMENT_LINE(); 


                }
                break;
            case 52 :
                // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:1:325: COMMENT
                {
                mCOMMENT(); 


                }
                break;

        }

    }


    protected DFA6 dfa6 = new DFA6(this);
    static final String DFA6_eotS =
        "\10\uffff\1\43\1\45\7\37\2\uffff\11\36\12\uffff\15\37\17\36\2\uffff"+
        "\15\37\17\36\1\175\2\37\1\u0080\3\37\1\u0084\1\u0085\4\37\2\36\1"+
        "\u008c\2\36\1\u008f\4\36\1\u0094\1\u0095\3\36\1\u0099\1\uffff\2"+
        "\37\1\uffff\1\37\1\u009d\1\u009e\2\uffff\3\37\1\u00a2\2\36\1\uffff"+
        "\2\36\1\uffff\1\36\1\u00a8\1\u00a9\1\36\2\uffff\1\36\1\u00ac\1\36"+
        "\1\uffff\2\37\1\u00b1\2\uffff\3\37\1\uffff\4\36\1\u00ba\2\uffff"+
        "\2\36\1\uffff\1\36\1\37\1\uffff\1\37\1\uffff\3\37\3\36\1\uffff\1"+
        "\36\1\uffff\3\36\1\u00ca\4\37\2\36\1\u00d1\4\36\1\uffff\4\37\1\36"+
        "\1\u00dc\1\uffff\1\36\1\u00de\3\36\4\37\1\u00e6\1\uffff\1\36\1\uffff"+
        "\2\36\1\u00ea\4\37\1\uffff\3\36\1\uffff\1\u00f2\3\37\1\u00f6\2\36"+
        "\1\uffff\1\37\1\u00fa\1\u00fb\1\uffff\1\u00fc\1\u00fd\1\u00fe\5"+
        "\uffff";
    static final String DFA6_eofS =
        "\u00ff\uffff";
    static final String DFA6_minS =
        "\1\11\7\uffff\1\55\1\75\1\123\1\166\1\141\1\157\1\145\1\157\1\145"+
        "\2\uffff\1\157\1\123\1\166\1\141\1\157\1\156\3\145\5\uffff\1\52"+
        "\4\uffff\1\145\1\164\1\155\2\145\1\143\1\141\1\170\1\156\1\163\1"+
        "\145\1\141\1\154\1\156\1\145\1\164\1\155\2\145\1\143\1\141\1\151"+
        "\1\170\1\156\1\141\1\154\1\162\1\165\2\uffff\1\164\2\141\1\164\1"+
        "\156\1\164\1\154\3\164\2\143\1\145\1\144\1\164\2\141\1\164\1\156"+
        "\1\164\1\154\3\164\1\143\1\145\1\155\1\145\1\60\1\142\1\151\1\60"+
        "\1\164\2\163\2\60\1\143\1\157\1\164\1\163\1\151\1\154\1\60\1\142"+
        "\1\151\1\60\1\164\2\163\1\151\2\60\1\164\1\163\1\151\1\60\1\uffff"+
        "\1\141\1\156\1\uffff\1\163\2\60\2\uffff\1\157\1\156\1\151\1\60\1"+
        "\164\1\151\1\uffff\1\141\1\156\1\uffff\1\163\2\60\1\141\2\uffff"+
        "\1\151\1\60\1\156\1\uffff\1\163\1\40\1\60\2\uffff\1\156\1\144\1"+
        "\166\1\uffff\1\151\1\143\1\163\1\40\1\60\2\uffff\1\164\1\166\1\uffff"+
        "\1\141\1\145\1\uffff\1\150\1\uffff\1\144\1\151\1\145\1\157\1\164"+
        "\1\145\1\uffff\1\150\1\uffff\2\145\1\164\1\60\1\145\1\151\1\164"+
        "\1\122\1\156\1\163\1\60\1\145\1\163\1\122\1\145\1\uffff\1\157\1"+
        "\164\1\151\1\165\1\163\1\60\1\uffff\1\157\1\60\2\165\1\163\1\162"+
        "\1\151\1\157\1\154\1\60\1\uffff\1\162\1\uffff\2\154\1\60\1\171\1"+
        "\157\1\156\1\145\1\uffff\1\171\2\145\1\uffff\1\60\1\156\2\163\1"+
        "\60\2\163\1\uffff\1\163\2\60\1\uffff\3\60\5\uffff";
    static final String DFA6_maxS =
        "\1\175\7\uffff\1\55\1\75\1\163\1\166\1\141\1\157\1\151\1\162\1\165"+
        "\2\uffff\1\157\1\163\1\166\1\141\1\157\1\156\1\151\1\165\1\162\5"+
        "\uffff\1\57\4\uffff\1\145\1\164\1\155\2\145\1\143\1\141\1\170\1"+
        "\156\1\163\1\145\1\141\1\154\1\156\1\145\1\164\1\155\2\145\1\143"+
        "\1\141\1\151\1\170\1\156\1\141\1\154\1\162\1\165\2\uffff\1\164\2"+
        "\141\1\164\1\156\1\164\1\154\3\164\2\143\1\145\1\146\1\164\2\141"+
        "\1\164\1\156\1\164\1\154\3\164\1\143\1\145\1\155\1\145\1\172\1\142"+
        "\1\151\1\172\1\164\2\163\2\172\1\143\1\157\1\164\1\163\1\151\1\154"+
        "\1\172\1\142\1\151\1\172\1\164\2\163\1\151\2\172\1\164\1\163\1\151"+
        "\1\172\1\uffff\1\141\1\156\1\uffff\1\163\2\172\2\uffff\1\157\1\156"+
        "\1\151\1\172\1\164\1\151\1\uffff\1\141\1\156\1\uffff\1\163\2\172"+
        "\1\141\2\uffff\1\151\1\172\1\156\1\uffff\1\163\1\124\1\172\2\uffff"+
        "\1\156\1\144\1\166\1\uffff\1\151\1\143\1\163\1\124\1\172\2\uffff"+
        "\1\164\1\166\1\uffff\1\141\1\145\1\uffff\1\150\1\uffff\1\144\1\151"+
        "\1\145\1\157\1\164\1\145\1\uffff\1\150\1\uffff\2\145\1\164\1\172"+
        "\1\145\1\151\1\164\1\122\1\156\1\163\1\172\1\145\1\163\1\162\1\145"+
        "\1\uffff\1\157\1\164\1\151\1\165\1\163\1\172\1\uffff\1\157\1\172"+
        "\2\165\1\163\1\162\1\151\1\157\1\154\1\172\1\uffff\1\162\1\uffff"+
        "\2\154\1\172\1\171\1\157\1\156\1\145\1\uffff\1\171\2\145\1\uffff"+
        "\1\172\1\156\2\163\1\172\2\163\1\uffff\1\163\2\172\1\uffff\3\172"+
        "\5\uffff";
    static final String DFA6_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\11\uffff\1\32\1\33\11\uffff"+
        "\1\56\1\57\1\60\1\61\1\62\1\uffff\1\11\1\10\1\13\1\12\34\uffff\1"+
        "\63\1\64\71\uffff\1\14\2\uffff\1\20\3\uffff\1\24\1\25\6\uffff\1"+
        "\36\2\uffff\1\42\4\uffff\1\47\1\50\3\uffff\1\55\3\uffff\1\22\1\23"+
        "\3\uffff\1\31\5\uffff\1\44\1\45\2\uffff\1\53\2\uffff\1\16\1\uffff"+
        "\1\21\6\uffff\1\40\1\uffff\1\43\17\uffff\1\15\6\uffff\1\37\12\uffff"+
        "\1\35\1\uffff\1\46\7\uffff\1\34\3\uffff\1\54\7\uffff\1\17\3\uffff"+
        "\1\41\3\uffff\1\27\1\30\1\51\1\52\1\26";
    static final String DFA6_specialS =
        "\u00ff\uffff}>";
    static final String[] DFA6_transitionS = {
            "\2\40\1\uffff\2\40\22\uffff\1\40\1\1\4\uffff\1\2\1\uffff\1\3"+
            "\1\4\2\uffff\1\5\1\6\1\7\1\41\12\36\1\10\2\uffff\1\11\3\uffff"+
            "\3\37\1\12\1\13\1\14\1\15\4\37\1\16\3\37\1\17\1\37\1\20\10\37"+
            "\1\21\1\uffff\1\22\3\uffff\2\36\1\23\1\24\1\25\1\26\1\27\1\36"+
            "\1\30\2\36\1\31\5\36\1\32\1\36\1\33\6\36\1\34\1\uffff\1\35",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\42",
            "\1\44",
            "\1\46\15\uffff\1\47\15\uffff\1\50\3\uffff\1\51",
            "\1\52",
            "\1\53",
            "\1\54",
            "\1\55\3\uffff\1\56",
            "\1\57\2\uffff\1\60",
            "\1\61\17\uffff\1\62",
            "",
            "",
            "\1\63",
            "\1\64\15\uffff\1\65\15\uffff\1\66\3\uffff\1\67",
            "\1\70",
            "\1\71",
            "\1\72",
            "\1\73",
            "\1\74\3\uffff\1\75",
            "\1\76\17\uffff\1\77",
            "\1\100\14\uffff\1\101",
            "",
            "",
            "",
            "",
            "",
            "\1\103\4\uffff\1\102",
            "",
            "",
            "",
            "",
            "\1\104",
            "\1\105",
            "\1\106",
            "\1\107",
            "\1\110",
            "\1\111",
            "\1\112",
            "\1\113",
            "\1\114",
            "\1\115",
            "\1\116",
            "\1\117",
            "\1\120",
            "\1\121",
            "\1\122",
            "\1\123",
            "\1\124",
            "\1\125",
            "\1\126",
            "\1\127",
            "\1\130",
            "\1\131",
            "\1\132",
            "\1\133",
            "\1\134",
            "\1\135",
            "\1\136",
            "\1\137",
            "",
            "",
            "\1\140",
            "\1\141",
            "\1\142",
            "\1\143",
            "\1\144",
            "\1\145",
            "\1\146",
            "\1\147",
            "\1\150",
            "\1\151",
            "\1\152",
            "\1\153",
            "\1\154",
            "\1\155\1\uffff\1\156",
            "\1\157",
            "\1\160",
            "\1\161",
            "\1\162",
            "\1\163",
            "\1\164",
            "\1\165",
            "\1\166",
            "\1\167",
            "\1\170",
            "\1\171",
            "\1\172",
            "\1\173",
            "\1\174",
            "\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
            "\1\176",
            "\1\177",
            "\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
            "\1\u0081",
            "\1\u0082",
            "\1\u0083",
            "\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
            "\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
            "\1\u0086",
            "\1\u0087",
            "\1\u0088",
            "\1\u0089",
            "\1\u008a",
            "\1\u008b",
            "\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "\1\u008d",
            "\1\u008e",
            "\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "\1\u0090",
            "\1\u0091",
            "\1\u0092",
            "\1\u0093",
            "\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "\1\u0096",
            "\1\u0097",
            "\1\u0098",
            "\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "",
            "\1\u009a",
            "\1\u009b",
            "",
            "\1\u009c",
            "\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
            "\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
            "",
            "",
            "\1\u009f",
            "\1\u00a0",
            "\1\u00a1",
            "\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
            "\1\u00a3",
            "\1\u00a4",
            "",
            "\1\u00a5",
            "\1\u00a6",
            "",
            "\1\u00a7",
            "\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "\1\u00aa",
            "",
            "",
            "\1\u00ab",
            "\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "\1\u00ad",
            "",
            "\1\u00ae",
            "\1\u00af\63\uffff\1\u00b0",
            "\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
            "",
            "",
            "\1\u00b2",
            "\1\u00b3",
            "\1\u00b4",
            "",
            "\1\u00b5",
            "\1\u00b6",
            "\1\u00b7",
            "\1\u00b8\63\uffff\1\u00b9",
            "\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "",
            "",
            "\1\u00bb",
            "\1\u00bc",
            "",
            "\1\u00bd",
            "\1\u00be",
            "",
            "\1\u00bf",
            "",
            "\1\u00c0",
            "\1\u00c1",
            "\1\u00c2",
            "\1\u00c3",
            "\1\u00c4",
            "\1\u00c5",
            "",
            "\1\u00c6",
            "",
            "\1\u00c7",
            "\1\u00c8",
            "\1\u00c9",
            "\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
            "\1\u00cb",
            "\1\u00cc",
            "\1\u00cd",
            "\1\u00ce",
            "\1\u00cf",
            "\1\u00d0",
            "\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "\1\u00d2",
            "\1\u00d3",
            "\1\u00d4\37\uffff\1\u00d5",
            "\1\u00d6",
            "",
            "\1\u00d7",
            "\1\u00d8",
            "\1\u00d9",
            "\1\u00da",
            "\1\u00db",
            "\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "",
            "\1\u00dd",
            "\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "\1\u00df",
            "\1\u00e0",
            "\1\u00e1",
            "\1\u00e2",
            "\1\u00e3",
            "\1\u00e4",
            "\1\u00e5",
            "\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "",
            "\1\u00e7",
            "",
            "\1\u00e8",
            "\1\u00e9",
            "\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "\1\u00eb",
            "\1\u00ec",
            "\1\u00ed",
            "\1\u00ee",
            "",
            "\1\u00ef",
            "\1\u00f0",
            "\1\u00f1",
            "",
            "\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
            "\1\u00f3",
            "\1\u00f4",
            "\1\u00f5",
            "\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "\1\u00f7",
            "\1\u00f8",
            "",
            "\1\u00f9",
            "\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
            "\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
            "",
            "\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA6_eot = DFA.unpackEncodedString(DFA6_eotS);
    static final short[] DFA6_eof = DFA.unpackEncodedString(DFA6_eofS);
    static final char[] DFA6_min = DFA.unpackEncodedStringToUnsignedChars(DFA6_minS);
    static final char[] DFA6_max = DFA.unpackEncodedStringToUnsignedChars(DFA6_maxS);
    static final short[] DFA6_accept = DFA.unpackEncodedString(DFA6_acceptS);
    static final short[] DFA6_special = DFA.unpackEncodedString(DFA6_specialS);
    static final short[][] DFA6_transition;

    static {
        int numStates = DFA6_transitionS.length;
        DFA6_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA6_transition[i] = DFA.unpackEncodedString(DFA6_transitionS[i]);
        }
    }

    class DFA6 extends DFA {

        public DFA6(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 6;
            this.eot = DFA6_eot;
            this.eof = DFA6_eof;
            this.min = DFA6_min;
            this.max = DFA6_max;
            this.accept = DFA6_accept;
            this.special = DFA6_special;
            this.transition = DFA6_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__9 | T__10 | T__11 | T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | CONSTANT | VARIABLE | WS | COMMENT_LINE | COMMENT );";
        }
    }
 

}