// $ANTLR 3.4 C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g 2013-08-13 15:48:40

package controller.syntax;

import java.util.HashMap;

import model.Action;
import model.And;
import model.Clause;
import model.Constant;
import model.CycleHandler;
import model.Database;
import model.DPostDeclaration;
import model.DSet;
import model.Equal;
import model.FactSet;
import model.GoalSet;
import model.GoalsList;
import model.Initiator;
import model.Not;
import model.ReactiveRule;
import model.ReactiveRuleSet;
import model.Rule;
import model.RuleSet;
import model.SimpleSentence;
import model.Terminator;
import model.Unifiable;
import model.Variable;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

/**
* @author Alexandre Camus
*/
@SuppressWarnings({"all", "warnings", "unchecked"})
public class JLPSSyntaxParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "COMMENT", "COMMENT_LINE", "CONSTANT", "VARIABLE", "WS", "'!'", "'&'", "'('", "')'", "','", "'->'", "'.'", "':'", "':-'", "'='", "'=='", "'DSet'", "'Database'", "'Domain Theory'", "'DomainTheory'", "'Dset'", "'Events'", "'Facts'", "'Goals'", "'Lext'", "'Lint'", "'Postconditions'", "'Preconditions'", "'ReactiveRules'", "'Rules'", "'['", "']'", "'conditions'", "'conflicts'", "'dSet'", "'database'", "'domain theory'", "'domainTheory'", "'dset'", "'events'", "'facts'", "'goals'", "'initiates'", "'lext'", "'lint'", "'reactiveRules'", "'reactiverules'", "'rules'", "'terminates'", "'true'", "'{'", "'}'"
    };

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
    public Parser[] getDelegates() {
        return new Parser[] {};
    }

    // delegators


    public JLPSSyntaxParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public JLPSSyntaxParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
    }

    public String[] getTokenNames() { return JLPSSyntaxParser.tokenNames; }
    public String getGrammarFileName() { return "C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g"; }


    HashMap<String, Variable> variables = new HashMap<String, Variable>();



    // $ANTLR start "unifiable"
    // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:52:1: unifiable returns [Unifiable unifiable] : ( constant | variable | simpleSentence );
    public final Unifiable unifiable() throws RecognitionException {
        Unifiable unifiable = null;


        Constant constant1 =null;

        Variable variable2 =null;

        SimpleSentence simpleSentence3 =null;


        try {
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:53:3: ( constant | variable | simpleSentence )
            int alt1=3;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==CONSTANT) ) {
                int LA1_1 = input.LA(2);

                if ( (LA1_1==10||(LA1_1 >= 12 && LA1_1 <= 15)) ) {
                    alt1=1;
                }
                else if ( (LA1_1==11) ) {
                    alt1=3;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 1, 1, input);

                    throw nvae;

                }
            }
            else if ( (LA1_0==VARIABLE) ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;

            }
            switch (alt1) {
                case 1 :
                    // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:53:7: constant
                    {
                    pushFollow(FOLLOW_constant_in_unifiable57);
                    constant1=constant();

                    state._fsp--;


                    unifiable = constant1;

                    }
                    break;
                case 2 :
                    // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:54:7: variable
                    {
                    pushFollow(FOLLOW_variable_in_unifiable67);
                    variable2=variable();

                    state._fsp--;


                    unifiable = variable2;

                    }
                    break;
                case 3 :
                    // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:55:7: simpleSentence
                    {
                    pushFollow(FOLLOW_simpleSentence_in_unifiable77);
                    simpleSentence3=simpleSentence();

                    state._fsp--;


                    unifiable = simpleSentence3;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return unifiable;
    }
    // $ANTLR end "unifiable"



    // $ANTLR start "constant"
    // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:58:1: constant returns [Constant constant] : CONSTANT ;
    public final Constant constant() throws RecognitionException {
        Constant constant = null;


        Token CONSTANT4=null;

        try {
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:59:3: ( CONSTANT )
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:59:7: CONSTANT
            {
            CONSTANT4=(Token)match(input,CONSTANT,FOLLOW_CONSTANT_in_constant100); 

            constant = new Constant((CONSTANT4!=null?CONSTANT4.getText():null));

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return constant;
    }
    // $ANTLR end "constant"



    // $ANTLR start "variable"
    // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:62:1: variable returns [Variable variable] : VARIABLE ;
    public final Variable variable() throws RecognitionException {
        Variable variable = null;


        Token VARIABLE5=null;

        try {
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:63:3: ( VARIABLE )
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:63:7: VARIABLE
            {
            VARIABLE5=(Token)match(input,VARIABLE,FOLLOW_VARIABLE_in_variable121); 

            if (!this.variables.containsKey((VARIABLE5!=null?VARIABLE5.getText():null))) {
                      variable = new Variable((VARIABLE5!=null?VARIABLE5.getText():null));
                      this.variables.put((VARIABLE5!=null?VARIABLE5.getText():null), variable);
                  } else {
                      variable = this.variables.get((VARIABLE5!=null?VARIABLE5.getText():null));
                  }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return variable;
    }
    // $ANTLR end "variable"



    // $ANTLR start "parameters"
    // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:72:1: parameters returns [ArrayList<Unifiable> parameters] :par1= unifiable ( ',' par2= unifiable )* ;
    public final ArrayList<Unifiable> parameters() throws RecognitionException {
        ArrayList<Unifiable> parameters = null;


        Unifiable par1 =null;

        Unifiable par2 =null;


        try {
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:73:3: (par1= unifiable ( ',' par2= unifiable )* )
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:73:7: par1= unifiable ( ',' par2= unifiable )*
            {
            parameters = new ArrayList<Unifiable>();

            pushFollow(FOLLOW_unifiable_in_parameters162);
            par1=unifiable();

            state._fsp--;


            parameters.add(par1);

            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:75:7: ( ',' par2= unifiable )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==13) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:75:8: ',' par2= unifiable
            	    {
            	    match(input,13,FOLLOW_13_in_parameters173); 

            	    pushFollow(FOLLOW_unifiable_in_parameters179);
            	    par2=unifiable();

            	    state._fsp--;


            	    parameters.add(par2);

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return parameters;
    }
    // $ANTLR end "parameters"



    // $ANTLR start "simpleSentence"
    // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:78:1: simpleSentence returns [SimpleSentence simpleSentence] : constant '(' ( parameters )? ')' ;
    public final SimpleSentence simpleSentence() throws RecognitionException {
        SimpleSentence simpleSentence = null;


        Constant constant6 =null;

        ArrayList<Unifiable> parameters7 =null;


        try {
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:79:3: ( constant '(' ( parameters )? ')' )
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:79:7: constant '(' ( parameters )? ')'
            {
            Constant name; Unifiable[] parameters = new Unifiable[0];

            pushFollow(FOLLOW_constant_in_simpleSentence213);
            constant6=constant();

            state._fsp--;


            name = constant6;

            match(input,11,FOLLOW_11_in_simpleSentence223); 

            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:82:9: ( parameters )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( ((LA3_0 >= CONSTANT && LA3_0 <= VARIABLE)) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:82:10: parameters
                    {
                    pushFollow(FOLLOW_parameters_in_simpleSentence234);
                    parameters7=parameters();

                    state._fsp--;


                    parameters = parameters7.toArray(parameters);

                    }
                    break;

            }


            match(input,12,FOLLOW_12_in_simpleSentence246); 

            simpleSentence = new SimpleSentence(name, parameters);

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return simpleSentence;
    }
    // $ANTLR end "simpleSentence"



    // $ANTLR start "initiator"
    // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:92:1: initiator returns [Initiator initiator] : 'initiates' '(' event= simpleSentence ',' fact= simpleSentence ')' ;
    public final Initiator initiator() throws RecognitionException {
        Initiator initiator = null;


        SimpleSentence event =null;

        SimpleSentence fact =null;


        try {
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:93:3: ( 'initiates' '(' event= simpleSentence ',' fact= simpleSentence ')' )
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:93:7: 'initiates' '(' event= simpleSentence ',' fact= simpleSentence ')'
            {
            match(input,46,FOLLOW_46_in_initiator275); 

            match(input,11,FOLLOW_11_in_initiator283); 

            pushFollow(FOLLOW_simpleSentence_in_initiator297);
            event=simpleSentence();

            state._fsp--;


            match(input,13,FOLLOW_13_in_initiator299); 

            pushFollow(FOLLOW_simpleSentence_in_initiator305);
            fact=simpleSentence();

            state._fsp--;


            initiator = new Initiator(event, fact);

            match(input,12,FOLLOW_12_in_initiator323); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return initiator;
    }
    // $ANTLR end "initiator"



    // $ANTLR start "terminator"
    // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:100:1: terminator returns [Terminator terminator] : 'terminates' '(' event= simpleSentence ',' fact= simpleSentence ')' ;
    public final Terminator terminator() throws RecognitionException {
        Terminator terminator = null;


        SimpleSentence event =null;

        SimpleSentence fact =null;


        try {
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:101:3: ( 'terminates' '(' event= simpleSentence ',' fact= simpleSentence ')' )
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:101:7: 'terminates' '(' event= simpleSentence ',' fact= simpleSentence ')'
            {
            match(input,52,FOLLOW_52_in_terminator344); 

            match(input,11,FOLLOW_11_in_terminator352); 

            pushFollow(FOLLOW_simpleSentence_in_terminator366);
            event=simpleSentence();

            state._fsp--;


            match(input,13,FOLLOW_13_in_terminator368); 

            pushFollow(FOLLOW_simpleSentence_in_terminator374);
            fact=simpleSentence();

            state._fsp--;


            terminator = new Terminator(event, fact);

            match(input,12,FOLLOW_12_in_terminator392); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return terminator;
    }
    // $ANTLR end "terminator"



    // $ANTLR start "equal"
    // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:113:1: equal returns [Equal equal] : op1= variable '==' op2= unifiable ;
    public final Equal equal() throws RecognitionException {
        Equal equal = null;


        Variable op1 =null;

        Unifiable op2 =null;


        try {
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:114:3: (op1= variable '==' op2= unifiable )
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:114:7: op1= variable '==' op2= unifiable
            {
            pushFollow(FOLLOW_variable_in_equal417);
            op1=variable();

            state._fsp--;


            match(input,19,FOLLOW_19_in_equal419); 

            pushFollow(FOLLOW_unifiable_in_equal425);
            op2=unifiable();

            state._fsp--;


            equal = new Equal(op1, op2);

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return equal;
    }
    // $ANTLR end "equal"



    // $ANTLR start "term"
    // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:118:1: term returns [Clause clause] : ( simpleSentence | equal | '(' and ')' );
    public final Clause term() throws RecognitionException {
        Clause clause = null;


        SimpleSentence simpleSentence8 =null;

        Equal equal9 =null;

        Clause and10 =null;


        try {
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:119:3: ( simpleSentence | equal | '(' and ')' )
            int alt4=3;
            switch ( input.LA(1) ) {
            case CONSTANT:
                {
                alt4=1;
                }
                break;
            case VARIABLE:
                {
                alt4=2;
                }
                break;
            case 11:
                {
                alt4=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;

            }

            switch (alt4) {
                case 1 :
                    // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:119:7: simpleSentence
                    {
                    pushFollow(FOLLOW_simpleSentence_in_term454);
                    simpleSentence8=simpleSentence();

                    state._fsp--;


                    clause = simpleSentence8;

                    }
                    break;
                case 2 :
                    // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:120:7: equal
                    {
                    pushFollow(FOLLOW_equal_in_term464);
                    equal9=equal();

                    state._fsp--;


                    clause = equal9;

                    }
                    break;
                case 3 :
                    // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:121:7: '(' and ')'
                    {
                    match(input,11,FOLLOW_11_in_term474); 

                    pushFollow(FOLLOW_and_in_term476);
                    and10=and();

                    state._fsp--;


                    match(input,12,FOLLOW_12_in_term478); 

                    clause = and10;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return clause;
    }
    // $ANTLR end "term"



    // $ANTLR start "negation"
    // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:124:1: negation returns [Clause clause] : ( '!' )? term ;
    public final Clause negation() throws RecognitionException {
        Clause clause = null;


        Clause term11 =null;


        try {
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:125:3: ( ( '!' )? term )
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:125:7: ( '!' )? term
            {
            boolean flag = false;

            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:126:7: ( '!' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==9) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:126:8: '!'
                    {
                    match(input,9,FOLLOW_9_in_negation510); 

                    flag = true;

                    }
                    break;

            }


            pushFollow(FOLLOW_term_in_negation516);
            term11=term();

            state._fsp--;


            clause = (flag) ? new Not(term11) : term11;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return clause;
    }
    // $ANTLR end "negation"



    // $ANTLR start "and"
    // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:130:1: and returns [Clause clause] :op1= negation ( '&' op2= negation )* ;
    public final Clause and() throws RecognitionException {
        Clause clause = null;


        Clause op1 =null;

        Clause op2 =null;


        try {
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:131:3: (op1= negation ( '&' op2= negation )* )
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:131:7: op1= negation ( '&' op2= negation )*
            {
            boolean flag = false;
                  ArrayList<Clause> operands = new ArrayList<Clause>();

            pushFollow(FOLLOW_negation_in_and557);
            op1=negation();

            state._fsp--;


            operands.add(op1);

            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:133:51: ( '&' op2= negation )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==10) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:133:52: '&' op2= negation
            	    {
            	    match(input,10,FOLLOW_10_in_and562); 

            	    pushFollow(FOLLOW_negation_in_and568);
            	    op2=negation();

            	    state._fsp--;


            	    flag = true; operands.add(op2);

            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);


            clause = (flag) ? new And(operands) : op1;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return clause;
    }
    // $ANTLR end "and"



    // $ANTLR start "truth"
    // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:137:1: truth returns [Clause clause = null] : 'true' ;
    public final Clause truth() throws RecognitionException {
        Clause clause =  null;


        try {
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:138:3: ( 'true' )
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:138:7: 'true'
            {
            match(input,53,FOLLOW_53_in_truth601); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return clause;
    }
    // $ANTLR end "truth"



    // $ANTLR start "reactiveRule"
    // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:146:1: reactiveRule returns [ReactiveRule rule] : (conditions= and |conditions= truth ) '->' simpleSentence '.' ;
    public final ReactiveRule reactiveRule() throws RecognitionException {
        ReactiveRule rule = null;


        Clause conditions =null;

        SimpleSentence simpleSentence12 =null;


        try {
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:147:3: ( (conditions= and |conditions= truth ) '->' simpleSentence '.' )
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:147:7: (conditions= and |conditions= truth ) '->' simpleSentence '.'
            {
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:147:7: (conditions= and |conditions= truth )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( ((LA7_0 >= CONSTANT && LA7_0 <= VARIABLE)||LA7_0==9||LA7_0==11) ) {
                alt7=1;
            }
            else if ( (LA7_0==53) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;

            }
            switch (alt7) {
                case 1 :
                    // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:147:8: conditions= and
                    {
                    pushFollow(FOLLOW_and_in_reactiveRule629);
                    conditions=and();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:147:27: conditions= truth
                    {
                    pushFollow(FOLLOW_truth_in_reactiveRule637);
                    conditions=truth();

                    state._fsp--;


                    }
                    break;

            }


            match(input,14,FOLLOW_14_in_reactiveRule640); 

            pushFollow(FOLLOW_simpleSentence_in_reactiveRule642);
            simpleSentence12=simpleSentence();

            state._fsp--;


            match(input,15,FOLLOW_15_in_reactiveRule644); 

            rule = new ReactiveRule(conditions, simpleSentence12);

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return rule;
    }
    // $ANTLR end "reactiveRule"



    // $ANTLR start "rule"
    // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:151:1: rule returns [Rule rule] : simpleSentence ( ':-' and )? '.' ;
    public final Rule rule() throws RecognitionException {
        Rule rule = null;


        Clause and13 =null;

        SimpleSentence simpleSentence14 =null;


        try {
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:152:3: ( simpleSentence ( ':-' and )? '.' )
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:152:7: simpleSentence ( ':-' and )? '.'
            {
            Clause body = null;

            pushFollow(FOLLOW_simpleSentence_in_rule681);
            simpleSentence14=simpleSentence();

            state._fsp--;


            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:153:22: ( ':-' and )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==17) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:153:23: ':-' and
                    {
                    match(input,17,FOLLOW_17_in_rule684); 

                    pushFollow(FOLLOW_and_in_rule686);
                    and13=and();

                    state._fsp--;


                    body = and13;

                    }
                    break;

            }


            match(input,15,FOLLOW_15_in_rule692); 

            rule = new Rule(simpleSentence14, body);

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return rule;
    }
    // $ANTLR end "rule"



    // $ANTLR start "fluent"
    // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:157:1: fluent returns [SimpleSentence rule] : simpleSentence '.' ;
    public final SimpleSentence fluent() throws RecognitionException {
        SimpleSentence rule = null;


        SimpleSentence simpleSentence15 =null;


        try {
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:158:3: ( simpleSentence '.' )
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:158:7: simpleSentence '.'
            {
            pushFollow(FOLLOW_simpleSentence_in_fluent721);
            simpleSentence15=simpleSentence();

            state._fsp--;


            match(input,15,FOLLOW_15_in_fluent723); 

            rule = simpleSentence15;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return rule;
    }
    // $ANTLR end "fluent"


    public static class lext_return extends ParserRuleReturnScope {
        public boolean w;
        public FactSet set;
    };


    // $ANTLR start "lext"
    // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:166:1: lext returns [boolean w, FactSet set] : ( 'Lext' | 'lext' | 'facts' | 'Facts' ) '{' ( fluent )* '}' ;
    public final JLPSSyntaxParser.lext_return lext() throws RecognitionException {
        JLPSSyntaxParser.lext_return retval = new JLPSSyntaxParser.lext_return();
        retval.start = input.LT(1);


        SimpleSentence fluent16 =null;


        try {
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:167:3: ( ( 'Lext' | 'lext' | 'facts' | 'Facts' ) '{' ( fluent )* '}' )
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:167:7: ( 'Lext' | 'lext' | 'facts' | 'Facts' ) '{' ( fluent )* '}'
            {
            retval.set = new FactSet(); retval.w = true;

            if ( input.LA(1)==26||input.LA(1)==28||input.LA(1)==44||input.LA(1)==47 ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            match(input,54,FOLLOW_54_in_lext772); 

            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:169:7: ( fluent )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==CONSTANT) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:169:8: fluent
            	    {
            	    pushFollow(FOLLOW_fluent_in_lext781);
            	    fluent16=fluent();

            	    state._fsp--;


            	    retval.set.addFact(fluent16); retval.w = false;

            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);


            this.variables = new HashMap<String, Variable>();

            Database.getInstance().setFactsDatabase(retval.set);

            match(input,55,FOLLOW_55_in_lext809); 

            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "lext"


    public static class lint_return extends ParserRuleReturnScope {
        public boolean w;
        public RuleSet set;
    };


    // $ANTLR start "lint"
    // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:175:1: lint returns [boolean w, RuleSet set] : ( 'Lint' | 'lint' | 'rules' | 'Rules' ) '{' ( rule )* '}' ;
    public final JLPSSyntaxParser.lint_return lint() throws RecognitionException {
        JLPSSyntaxParser.lint_return retval = new JLPSSyntaxParser.lint_return();
        retval.start = input.LT(1);


        Rule rule17 =null;


        try {
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:176:3: ( ( 'Lint' | 'lint' | 'rules' | 'Rules' ) '{' ( rule )* '}' )
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:176:7: ( 'Lint' | 'lint' | 'rules' | 'Rules' ) '{' ( rule )* '}'
            {
            retval.set = new RuleSet(); retval.w = true;

            if ( input.LA(1)==29||input.LA(1)==33||input.LA(1)==48||input.LA(1)==51 ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            match(input,54,FOLLOW_54_in_lint854); 

            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:178:7: ( rule )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==CONSTANT) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:178:8: rule
            	    {
            	    pushFollow(FOLLOW_rule_in_lint863);
            	    rule17=rule();

            	    state._fsp--;


            	    retval.set.addRule(rule17); retval.w = false;

            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);


            this.variables = new HashMap<String, Variable>();

            match(input,55,FOLLOW_55_in_lint883); 

            Database.getInstance().setRulesDatabase(retval.set);

            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "lint"


    public static class preconditions_return extends ParserRuleReturnScope {
        public Clause conditions;
        public Clause conflicts;
    };


    // $ANTLR start "preconditions"
    // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:184:1: preconditions returns [Clause conditions, Clause conflicts] : 'Preconditions' '[' ( 'conditions' ':' (cond= and |cond= truth ) '.' )? ( 'conflicts' ':' (conf= and |conf= truth ) '.' )? ']' ;
    public final JLPSSyntaxParser.preconditions_return preconditions() throws RecognitionException {
        JLPSSyntaxParser.preconditions_return retval = new JLPSSyntaxParser.preconditions_return();
        retval.start = input.LT(1);


        Clause cond =null;

        Clause conf =null;


        try {
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:185:3: ( 'Preconditions' '[' ( 'conditions' ':' (cond= and |cond= truth ) '.' )? ( 'conflicts' ':' (conf= and |conf= truth ) '.' )? ']' )
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:185:7: 'Preconditions' '[' ( 'conditions' ':' (cond= and |cond= truth ) '.' )? ( 'conflicts' ':' (conf= and |conf= truth ) '.' )? ']'
            {
            match(input,31,FOLLOW_31_in_preconditions912); 

            match(input,34,FOLLOW_34_in_preconditions914); 

            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:186:7: ( 'conditions' ':' (cond= and |cond= truth ) '.' )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==36) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:186:8: 'conditions' ':' (cond= and |cond= truth ) '.'
                    {
                    match(input,36,FOLLOW_36_in_preconditions923); 

                    match(input,16,FOLLOW_16_in_preconditions925); 

                    // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:186:25: (cond= and |cond= truth )
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( ((LA11_0 >= CONSTANT && LA11_0 <= VARIABLE)||LA11_0==9||LA11_0==11) ) {
                        alt11=1;
                    }
                    else if ( (LA11_0==53) ) {
                        alt11=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 11, 0, input);

                        throw nvae;

                    }
                    switch (alt11) {
                        case 1 :
                            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:186:26: cond= and
                            {
                            pushFollow(FOLLOW_and_in_preconditions932);
                            cond=and();

                            state._fsp--;


                            }
                            break;
                        case 2 :
                            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:186:39: cond= truth
                            {
                            pushFollow(FOLLOW_truth_in_preconditions940);
                            cond=truth();

                            state._fsp--;


                            }
                            break;

                    }


                    match(input,15,FOLLOW_15_in_preconditions943); 

                    retval.conditions = cond;

                    }
                    break;

            }


            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:187:7: ( 'conflicts' ':' (conf= and |conf= truth ) '.' )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==37) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:187:8: 'conflicts' ':' (conf= and |conf= truth ) '.'
                    {
                    match(input,37,FOLLOW_37_in_preconditions956); 

                    match(input,16,FOLLOW_16_in_preconditions958); 

                    // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:187:24: (conf= and |conf= truth )
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( ((LA13_0 >= CONSTANT && LA13_0 <= VARIABLE)||LA13_0==9||LA13_0==11) ) {
                        alt13=1;
                    }
                    else if ( (LA13_0==53) ) {
                        alt13=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 13, 0, input);

                        throw nvae;

                    }
                    switch (alt13) {
                        case 1 :
                            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:187:25: conf= and
                            {
                            pushFollow(FOLLOW_and_in_preconditions965);
                            conf=and();

                            state._fsp--;


                            }
                            break;
                        case 2 :
                            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:187:38: conf= truth
                            {
                            pushFollow(FOLLOW_truth_in_preconditions973);
                            conf=truth();

                            state._fsp--;


                            }
                            break;

                    }


                    match(input,15,FOLLOW_15_in_preconditions976); 

                    retval.conflicts = conf;

                    }
                    break;

            }


            match(input,35,FOLLOW_35_in_preconditions988); 

            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "preconditions"


    public static class postconditions_return extends ParserRuleReturnScope {
        public ArrayList<Terminator> terminators;
        public ArrayList<Initiator> initiators;
    };


    // $ANTLR start "postconditions"
    // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:191:1: postconditions returns [ArrayList<Terminator> terminators, ArrayList<Initiator> initiators] : 'Postconditions' '[' ( terminator '.' )* ( initiator '.' )* ']' ;
    public final JLPSSyntaxParser.postconditions_return postconditions() throws RecognitionException {
        JLPSSyntaxParser.postconditions_return retval = new JLPSSyntaxParser.postconditions_return();
        retval.start = input.LT(1);


        Terminator terminator18 =null;

        Initiator initiator19 =null;


        try {
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:192:3: ( 'Postconditions' '[' ( terminator '.' )* ( initiator '.' )* ']' )
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:192:7: 'Postconditions' '[' ( terminator '.' )* ( initiator '.' )* ']'
            {
            retval.terminators = new ArrayList<Terminator>(); retval.initiators = new ArrayList<Initiator>();

            match(input,30,FOLLOW_30_in_postconditions1017); 

            match(input,34,FOLLOW_34_in_postconditions1019); 

            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:194:7: ( terminator '.' )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==52) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:194:8: terminator '.'
            	    {
            	    pushFollow(FOLLOW_terminator_in_postconditions1028);
            	    terminator18=terminator();

            	    state._fsp--;


            	    match(input,15,FOLLOW_15_in_postconditions1030); 

            	    retval.terminators.add(terminator18);

            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);


            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:195:7: ( initiator '.' )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==46) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:195:8: initiator '.'
            	    {
            	    pushFollow(FOLLOW_initiator_in_postconditions1043);
            	    initiator19=initiator();

            	    state._fsp--;


            	    match(input,15,FOLLOW_15_in_postconditions1045); 

            	    retval.initiators.add(initiator19);

            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);


            match(input,35,FOLLOW_35_in_postconditions1056); 

            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "postconditions"



    // $ANTLR start "action"
    // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:199:1: action returns [Action action] : simpleSentence '=' '{' ( preconditions )? ( postconditions )? '}' ;
    public final Action action() throws RecognitionException {
        Action action = null;


        JLPSSyntaxParser.preconditions_return preconditions20 =null;

        JLPSSyntaxParser.postconditions_return postconditions21 =null;

        SimpleSentence simpleSentence22 =null;


        try {
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:200:3: ( simpleSentence '=' '{' ( preconditions )? ( postconditions )? '}' )
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:200:7: simpleSentence '=' '{' ( preconditions )? ( postconditions )? '}'
            {
            ArrayList<Terminator> terminators = new ArrayList<Terminator>(); 
                  ArrayList<Initiator> initiators = new ArrayList<Initiator>();
                  Clause conditions = null;
                  Clause conflicts = null;
                  

            pushFollow(FOLLOW_simpleSentence_in_action1085);
            simpleSentence22=simpleSentence();

            state._fsp--;


            match(input,18,FOLLOW_18_in_action1087); 

            match(input,54,FOLLOW_54_in_action1089); 

            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:206:7: ( preconditions )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==31) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:206:8: preconditions
                    {
                    pushFollow(FOLLOW_preconditions_in_action1098);
                    preconditions20=preconditions();

                    state._fsp--;


                    conditions = (preconditions20!=null?preconditions20.conditions:null); conflicts = (preconditions20!=null?preconditions20.conflicts:null);

                    }
                    break;

            }


            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:207:7: ( postconditions )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==30) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:207:8: postconditions
                    {
                    pushFollow(FOLLOW_postconditions_in_action1111);
                    postconditions21=postconditions();

                    state._fsp--;


                    initiators = (postconditions21!=null?postconditions21.initiators:null); terminators = (postconditions21!=null?postconditions21.terminators:null);

                    }
                    break;

            }


            match(input,55,FOLLOW_55_in_action1123); 

            action = new Action(simpleSentence22, initiators, terminators, conditions, conflicts);

            this.variables = new HashMap<String, Variable>();

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return action;
    }
    // $ANTLR end "action"


    public static class d_return extends ParserRuleReturnScope {
        public boolean w;
        public DSet set;
    };


    // $ANTLR start "d"
    // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:213:1: d returns [boolean w, DSet set] : ( 'domain theory' | 'Domain Theory' | 'domainTheory' | 'DomainTheory' | 'dset' | 'Dset' | 'dSet' | 'DSet' ) '{' ( action )* '}' ;
    public final JLPSSyntaxParser.d_return d() throws RecognitionException {
        JLPSSyntaxParser.d_return retval = new JLPSSyntaxParser.d_return();
        retval.start = input.LT(1);


        Action action23 =null;


        try {
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:214:3: ( ( 'domain theory' | 'Domain Theory' | 'domainTheory' | 'DomainTheory' | 'dset' | 'Dset' | 'dSet' | 'DSet' ) '{' ( action )* '}' )
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:214:7: ( 'domain theory' | 'Domain Theory' | 'domainTheory' | 'DomainTheory' | 'dset' | 'Dset' | 'dSet' | 'DSet' ) '{' ( action )* '}'
            {
            retval.set = new DSet(); retval.w = true;

            if ( input.LA(1)==20||(input.LA(1) >= 22 && input.LA(1) <= 24)||input.LA(1)==38||(input.LA(1) >= 40 && input.LA(1) <= 42) ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            match(input,54,FOLLOW_54_in_d1199); 

            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:216:7: ( action )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==CONSTANT) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:216:8: action
            	    {
            	    pushFollow(FOLLOW_action_in_d1208);
            	    action23=action();

            	    state._fsp--;


            	    retval.w = false; retval.set.addAction(action23);

            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);


            match(input,55,FOLLOW_55_in_d1220); 

            Database.getInstance().setdSet(retval.set);

            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "d"


    public static class database_return extends ParserRuleReturnScope {
        public boolean wlint;
        public boolean wlext;
        public boolean wdset;
    };


    // $ANTLR start "database"
    // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:221:1: database returns [boolean wlint, boolean wlext, boolean wdset] : ( 'database' | 'Database' ) '{' ( lext )? ( lint )? '}' ;
    public final JLPSSyntaxParser.database_return database() throws RecognitionException {
        JLPSSyntaxParser.database_return retval = new JLPSSyntaxParser.database_return();
        retval.start = input.LT(1);


        JLPSSyntaxParser.lext_return lext24 =null;

        JLPSSyntaxParser.lint_return lint25 =null;


        try {
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:222:3: ( ( 'database' | 'Database' ) '{' ( lext )? ( lint )? '}' )
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:222:7: ( 'database' | 'Database' ) '{' ( lext )? ( lint )? '}'
            {
            retval.wlint =  true; retval.wlext = true; retval.wdset = true;

            if ( input.LA(1)==21||input.LA(1)==39 ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            match(input,54,FOLLOW_54_in_database1265); 

            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:224:7: ( lext )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==26||LA20_0==28||LA20_0==44||LA20_0==47) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:224:8: lext
                    {
                    pushFollow(FOLLOW_lext_in_database1274);
                    lext24=lext();

                    state._fsp--;


                    retval.wlext = (lext24!=null?lext24.w:false);

                    }
                    break;

            }


            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:225:7: ( lint )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==29||LA21_0==33||LA21_0==48||LA21_0==51) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:225:8: lint
                    {
                    pushFollow(FOLLOW_lint_in_database1287);
                    lint25=lint();

                    state._fsp--;


                    retval.wlint = (lint25!=null?lint25.w:false);

                    }
                    break;

            }


            match(input,55,FOLLOW_55_in_database1299); 

            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "database"


    public static class reactiveRules_return extends ParserRuleReturnScope {
        public boolean w;
        public ReactiveRuleSet set;
    };


    // $ANTLR start "reactiveRules"
    // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:229:1: reactiveRules returns [boolean w, ReactiveRuleSet set] : ( 'ReactiveRules' | 'reactiveRules' | 'reactiverules' ) '{' ( reactiveRule )* '}' ;
    public final JLPSSyntaxParser.reactiveRules_return reactiveRules() throws RecognitionException {
        JLPSSyntaxParser.reactiveRules_return retval = new JLPSSyntaxParser.reactiveRules_return();
        retval.start = input.LT(1);


        ReactiveRule reactiveRule26 =null;


        try {
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:230:3: ( ( 'ReactiveRules' | 'reactiveRules' | 'reactiverules' ) '{' ( reactiveRule )* '}' )
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:230:7: ( 'ReactiveRules' | 'reactiveRules' | 'reactiverules' ) '{' ( reactiveRule )* '}'
            {
            retval.set = ReactiveRuleSet.getInstance(); retval.w = true;

            if ( input.LA(1)==32||(input.LA(1) >= 49 && input.LA(1) <= 50) ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            match(input,54,FOLLOW_54_in_reactiveRules1340); 

            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:232:7: ( reactiveRule )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( ((LA22_0 >= CONSTANT && LA22_0 <= VARIABLE)||LA22_0==9||LA22_0==11||LA22_0==53) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:232:8: reactiveRule
            	    {
            	    pushFollow(FOLLOW_reactiveRule_in_reactiveRules1349);
            	    reactiveRule26=reactiveRule();

            	    state._fsp--;


            	    retval.set.addRule(reactiveRule26); retval.w = false;

            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);


            this.variables = new HashMap<String, Variable>();

            match(input,55,FOLLOW_55_in_reactiveRules1369); 

            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "reactiveRules"


    public static class goals_return extends ParserRuleReturnScope {
        public boolean w;
        public GoalSet set;
    };


    // $ANTLR start "goals"
    // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:237:1: goals returns [boolean w, GoalSet set] : ( 'Goals' | 'goals' ) '{' ( rule )* '}' ;
    public final JLPSSyntaxParser.goals_return goals() throws RecognitionException {
        JLPSSyntaxParser.goals_return retval = new JLPSSyntaxParser.goals_return();
        retval.start = input.LT(1);


        Rule rule27 =null;


        try {
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:238:3: ( ( 'Goals' | 'goals' ) '{' ( rule )* '}' )
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:238:7: ( 'Goals' | 'goals' ) '{' ( rule )* '}'
            {
            retval.set = new GoalSet(); retval.w = true;

            if ( input.LA(1)==27||input.LA(1)==45 ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            match(input,54,FOLLOW_54_in_goals1406); 

            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:240:7: ( rule )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==CONSTANT) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:240:8: rule
            	    {
            	    pushFollow(FOLLOW_rule_in_goals1415);
            	    rule27=rule();

            	    state._fsp--;


            	    retval.set.addDefinition(rule27); retval.w = false;

            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);


            this.variables = new HashMap<String, Variable>();

            match(input,55,FOLLOW_55_in_goals1435); 

            GoalsList.getInstance().setGoalsDefinitions(retval.set);

            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "goals"


    public static class events_return extends ParserRuleReturnScope {
        public boolean w;
        public RuleSet set;
    };


    // $ANTLR start "events"
    // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:246:1: events returns [boolean w, RuleSet set] : ( 'Events' | 'events' ) '{' ( fluent )* '}' ;
    public final JLPSSyntaxParser.events_return events() throws RecognitionException {
        JLPSSyntaxParser.events_return retval = new JLPSSyntaxParser.events_return();
        retval.start = input.LT(1);


        SimpleSentence fluent28 =null;


        try {
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:247:3: ( ( 'Events' | 'events' ) '{' ( fluent )* '}' )
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:247:7: ( 'Events' | 'events' ) '{' ( fluent )* '}'
            {
            retval.set = new RuleSet(); retval.w = true;

            if ( input.LA(1)==25||input.LA(1)==43 ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            match(input,54,FOLLOW_54_in_events1480); 

            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:249:7: ( fluent )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==CONSTANT) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:249:8: fluent
            	    {
            	    pushFollow(FOLLOW_fluent_in_events1489);
            	    fluent28=fluent();

            	    state._fsp--;


            	    retval.set.addRule(new Rule(fluent28)); retval.w = false;

            	    }
            	    break;

            	default :
            	    break loop24;
                }
            } while (true);


            this.variables = new HashMap<String, Variable>();

            match(input,55,FOLLOW_55_in_events1509); 

            CycleHandler.getInstance().setEvents(retval.set);

            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "events"



    // $ANTLR start "file"
    // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:255:1: file returns [boolean[] w] : ( database )? ( d )? ( reactiveRules )? ( goals )? ( events )? EOF ;
    public final boolean[] file() throws RecognitionException {
        boolean[] w = null;


        JLPSSyntaxParser.database_return database29 =null;

        JLPSSyntaxParser.d_return d30 =null;

        JLPSSyntaxParser.reactiveRules_return reactiveRules31 =null;

        JLPSSyntaxParser.goals_return goals32 =null;

        JLPSSyntaxParser.events_return events33 =null;


        try {
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:256:3: ( ( database )? ( d )? ( reactiveRules )? ( goals )? ( events )? EOF )
            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:256:7: ( database )? ( d )? ( reactiveRules )? ( goals )? ( events )? EOF
            {
            w = new boolean[6]; w[0] = true; w[1] = true; w[2] = true; w[3] = true; w[4] = true; w[5] = true;

            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:257:7: ( database )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==21||LA25_0==39) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:257:8: database
                    {
                    pushFollow(FOLLOW_database_in_file1547);
                    database29=database();

                    state._fsp--;


                    w[0] = (database29!=null?database29.wlext:false); w[1] = (database29!=null?database29.wlint:false);

                    }
                    break;

            }


            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:258:7: ( d )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==20||(LA26_0 >= 22 && LA26_0 <= 24)||LA26_0==38||(LA26_0 >= 40 && LA26_0 <= 42)) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:258:8: d
                    {
                    pushFollow(FOLLOW_d_in_file1560);
                    d30=d();

                    state._fsp--;


                    w[2] = (d30!=null?d30.w:false);

                    }
                    break;

            }


            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:259:7: ( reactiveRules )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==32||(LA27_0 >= 49 && LA27_0 <= 50)) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:259:8: reactiveRules
                    {
                    pushFollow(FOLLOW_reactiveRules_in_file1573);
                    reactiveRules31=reactiveRules();

                    state._fsp--;


                    w[3] = (reactiveRules31!=null?reactiveRules31.w:false);

                    }
                    break;

            }


            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:260:7: ( goals )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==27||LA28_0==45) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:260:8: goals
                    {
                    pushFollow(FOLLOW_goals_in_file1586);
                    goals32=goals();

                    state._fsp--;


                    w[4] = (goals32!=null?goals32.w:false);

                    }
                    break;

            }


            // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:261:7: ( events )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==25||LA29_0==43) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // C:\\Users\\Albex\\GitHub\\LPS\\src\\controller\\syntax\\JLPSSyntax.g:261:8: events
                    {
                    pushFollow(FOLLOW_events_in_file1599);
                    events33=events();

                    state._fsp--;


                    w[5] = (events33!=null?events33.w:false);

                    }
                    break;

            }


            match(input,EOF,FOLLOW_EOF_in_file1611); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return w;
    }
    // $ANTLR end "file"

    // Delegated rules


 

    public static final BitSet FOLLOW_constant_in_unifiable57 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variable_in_unifiable67 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_simpleSentence_in_unifiable77 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONSTANT_in_constant100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VARIABLE_in_variable121 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unifiable_in_parameters162 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_13_in_parameters173 = new BitSet(new long[]{0x00000000000000C0L});
    public static final BitSet FOLLOW_unifiable_in_parameters179 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_constant_in_simpleSentence213 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_simpleSentence223 = new BitSet(new long[]{0x00000000000010C0L});
    public static final BitSet FOLLOW_parameters_in_simpleSentence234 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_simpleSentence246 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_initiator275 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_initiator283 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_simpleSentence_in_initiator297 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_initiator299 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_simpleSentence_in_initiator305 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_initiator323 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_terminator344 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_terminator352 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_simpleSentence_in_terminator366 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_terminator368 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_simpleSentence_in_terminator374 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_terminator392 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variable_in_equal417 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_equal419 = new BitSet(new long[]{0x00000000000000C0L});
    public static final BitSet FOLLOW_unifiable_in_equal425 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_simpleSentence_in_term454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_equal_in_term464 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_term474 = new BitSet(new long[]{0x0000000000000AC0L});
    public static final BitSet FOLLOW_and_in_term476 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_term478 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_9_in_negation510 = new BitSet(new long[]{0x00000000000008C0L});
    public static final BitSet FOLLOW_term_in_negation516 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_negation_in_and557 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_10_in_and562 = new BitSet(new long[]{0x0000000000000AC0L});
    public static final BitSet FOLLOW_negation_in_and568 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_53_in_truth601 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_and_in_reactiveRule629 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_truth_in_reactiveRule637 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_reactiveRule640 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_simpleSentence_in_reactiveRule642 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_reactiveRule644 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_simpleSentence_in_rule681 = new BitSet(new long[]{0x0000000000028000L});
    public static final BitSet FOLLOW_17_in_rule684 = new BitSet(new long[]{0x0000000000000AC0L});
    public static final BitSet FOLLOW_and_in_rule686 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_rule692 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_simpleSentence_in_fluent721 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_fluent723 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_lext756 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_54_in_lext772 = new BitSet(new long[]{0x0080000000000040L});
    public static final BitSet FOLLOW_fluent_in_lext781 = new BitSet(new long[]{0x0080000000000040L});
    public static final BitSet FOLLOW_55_in_lext809 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_lint838 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_54_in_lint854 = new BitSet(new long[]{0x0080000000000040L});
    public static final BitSet FOLLOW_rule_in_lint863 = new BitSet(new long[]{0x0080000000000040L});
    public static final BitSet FOLLOW_55_in_lint883 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_preconditions912 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_preconditions914 = new BitSet(new long[]{0x0000003800000000L});
    public static final BitSet FOLLOW_36_in_preconditions923 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_preconditions925 = new BitSet(new long[]{0x0020000000000AC0L});
    public static final BitSet FOLLOW_and_in_preconditions932 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_truth_in_preconditions940 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_preconditions943 = new BitSet(new long[]{0x0000002800000000L});
    public static final BitSet FOLLOW_37_in_preconditions956 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_preconditions958 = new BitSet(new long[]{0x0020000000000AC0L});
    public static final BitSet FOLLOW_and_in_preconditions965 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_truth_in_preconditions973 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_preconditions976 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_preconditions988 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_postconditions1017 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_postconditions1019 = new BitSet(new long[]{0x0010400800000000L});
    public static final BitSet FOLLOW_terminator_in_postconditions1028 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_postconditions1030 = new BitSet(new long[]{0x0010400800000000L});
    public static final BitSet FOLLOW_initiator_in_postconditions1043 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_postconditions1045 = new BitSet(new long[]{0x0000400800000000L});
    public static final BitSet FOLLOW_35_in_postconditions1056 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_simpleSentence_in_action1085 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_action1087 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_54_in_action1089 = new BitSet(new long[]{0x00800000C0000000L});
    public static final BitSet FOLLOW_preconditions_in_action1098 = new BitSet(new long[]{0x0080000040000000L});
    public static final BitSet FOLLOW_postconditions_in_action1111 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_55_in_action1123 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_d1167 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_54_in_d1199 = new BitSet(new long[]{0x0080000000000040L});
    public static final BitSet FOLLOW_action_in_d1208 = new BitSet(new long[]{0x0080000000000040L});
    public static final BitSet FOLLOW_55_in_d1220 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_database1257 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_54_in_database1265 = new BitSet(new long[]{0x0089900234000000L});
    public static final BitSet FOLLOW_lext_in_database1274 = new BitSet(new long[]{0x0089000220000000L});
    public static final BitSet FOLLOW_lint_in_database1287 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_55_in_database1299 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_reactiveRules1328 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_54_in_reactiveRules1340 = new BitSet(new long[]{0x00A0000000000AC0L});
    public static final BitSet FOLLOW_reactiveRule_in_reactiveRules1349 = new BitSet(new long[]{0x00A0000000000AC0L});
    public static final BitSet FOLLOW_55_in_reactiveRules1369 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_goals1398 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_54_in_goals1406 = new BitSet(new long[]{0x0080000000000040L});
    public static final BitSet FOLLOW_rule_in_goals1415 = new BitSet(new long[]{0x0080000000000040L});
    public static final BitSet FOLLOW_55_in_goals1435 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_events1472 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_54_in_events1480 = new BitSet(new long[]{0x0080000000000040L});
    public static final BitSet FOLLOW_fluent_in_events1489 = new BitSet(new long[]{0x0080000000000040L});
    public static final BitSet FOLLOW_55_in_events1509 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_database_in_file1547 = new BitSet(new long[]{0x00062F410BD00000L});
    public static final BitSet FOLLOW_d_in_file1560 = new BitSet(new long[]{0x000628010A000000L});
    public static final BitSet FOLLOW_reactiveRules_in_file1573 = new BitSet(new long[]{0x000028000A000000L});
    public static final BitSet FOLLOW_goals_in_file1586 = new BitSet(new long[]{0x0000080002000000L});
    public static final BitSet FOLLOW_events_in_file1599 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_file1611 = new BitSet(new long[]{0x0000000000000002L});

}