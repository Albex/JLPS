/**
* @author Alexandre Camus
*/
grammar JLPSSyntax;

options {
  language = Java;
}

@header {
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
}

@lexer::header {
package controller.syntax;
}

@members {
HashMap<String, Variable> variables = new HashMap<String, Variable>();
}

/**
*
* Unifiable
*
**/
unifiable returns [Unifiable unifiable]
  :   constant {$unifiable = $constant.constant;}
  |   variable {$unifiable = $variable.variable;}
  |   simpleSentence {$unifiable = $simpleSentence.simpleSentence;}
  ;
  
constant returns [Constant constant]
  :   CONSTANT {$constant = new Constant($CONSTANT.text);}
  ;

variable returns [Variable variable]
  :   VARIABLE
      {if (!this.variables.containsKey($VARIABLE.text)) {
          $variable = new Variable($VARIABLE.text);
          this.variables.put($VARIABLE.text, $variable);
      } else {
          $variable = this.variables.get($VARIABLE.text);
      }}
  ;
  
parameters returns [ArrayList<Unifiable> parameters]
  :   {$parameters = new ArrayList<Unifiable>();}
      par1 = unifiable {$parameters.add($par1.unifiable);}
      (',' par2 = unifiable {$parameters.add($par2.unifiable);})* 
  ;
  
simpleSentence returns [SimpleSentence simpleSentence]
  :   {Constant name; Unifiable[] parameters = new Unifiable[0];}
      constant {name = $constant.constant;}
      '('
        (parameters {parameters = $parameters.parameters.toArray(parameters);})?
      ')'
      {$simpleSentence = new SimpleSentence(name, parameters);}
  ;

/**
*
* DPost declarations
*
**/
initiator returns [Initiator initiator]
  :   'initiates'
      '('
        event = simpleSentence ',' fact = simpleSentence
        {$initiator = new Initiator($event.simpleSentence, $fact.simpleSentence);}
      ')'
  ;
  
terminator returns [Terminator terminator]
  :   'terminates'
      '('
        event = simpleSentence ',' fact = simpleSentence
        {$terminator = new Terminator($event.simpleSentence, $fact.simpleSentence);}
      ')'
  ;

/**
*
* Clauses definitions
*
*/
equal returns [Equal equal]
  :   op1 = variable '==' op2 = unifiable
      {$equal = new Equal($op1.variable, $op2.unifiable);}
  ;
  
term returns [Clause clause]
  :   simpleSentence {$clause = $simpleSentence.simpleSentence;}
  |   equal {$clause = $equal.equal;}
  |   '(' and ')' {$clause = $and.clause;}
  ;
  
negation returns [Clause clause]
  :   {boolean flag = false;}
      ('!' {flag = true;})? term
      {$clause = (flag) ? new Not($term.clause) : $term.clause;}
  ;
  
and returns [Clause clause]
  :   {boolean flag = false;
      ArrayList<Clause> operands = new ArrayList<Clause>();}
      op1 = negation {operands.add($op1.clause);} ('&' op2 = negation {flag = true; operands.add($op2.clause);})*
      {$clause = (flag) ? new And(operands) : $op1.clause;}
  ;
  
truth returns [Clause clause = null]
  :   'true'
  ;
  
/**
*
* Rules definitions
*
**/
reactiveRule returns [ReactiveRule rule]
  :   (conditions = and | conditions = truth) '->' simpleSentence '.'
      {$rule = new ReactiveRule($conditions.clause, $simpleSentence.simpleSentence);}
  ;
  
rule returns [Rule rule]
  :   {Clause body = null;}
      simpleSentence (':-' and {body = $and.clause;})? '.'
      {$rule = new Rule($simpleSentence.simpleSentence, body);}
  ;
  
fluent returns [SimpleSentence rule]
  :   simpleSentence '.' {$rule = $simpleSentence.simpleSentence;}
  ;
  
/**
*
* Sets definitions
*
**/
lext returns [boolean w, FactSet set]
  :   {$set = new FactSet(); $w = true;}
      ('Lext' | 'lext' | 'facts' | 'Facts') '{'
      (fluent {$set.addFact($fluent.rule); $w = false;})*
      {this.variables = new HashMap<String, Variable>();}
      {Database.getInstance().setFactsDatabase($set);}
      '}'
  ;
  
lint returns [boolean w, RuleSet set]
  :   {$set = new RuleSet(); $w = true;}
      ('Lint' | 'lint' | 'rules' | 'Rules') '{'
      (rule {$set.addRule($rule.rule); $w = false;})*
      {this.variables = new HashMap<String, Variable>();}
      '}'
      {Database.getInstance().setRulesDatabase($set);}
  ;
  
preconditions returns [Clause conditions, Clause conflicts]
  :   'Preconditions' '['
      ('conditions' ':' (cond = and | cond = truth) '.' {$conditions = $cond.clause;})?
      ('conflicts' ':' (conf = and | conf = truth) '.' {$conflicts = $conf.clause;})?
      ']'
  ;
  
postconditions returns [ArrayList<Terminator> terminators, ArrayList<Initiator> initiators]
  :   {$terminators = new ArrayList<Terminator>(); $initiators = new ArrayList<Initiator>();}
      'Postconditions' '['
      (terminator '.' {$terminators.add($terminator.terminator);})*
      (initiator '.'{$initiators.add($initiator.initiator);})*
      ']'
  ;
  
action returns [Action action]
  :   {ArrayList<Terminator> terminators = new ArrayList<Terminator>(); 
      ArrayList<Initiator> initiators = new ArrayList<Initiator>();
      Clause conditions = null;
      Clause conflicts = null;
      }
      simpleSentence '=' '{'
      (preconditions {conditions = $preconditions.conditions; conflicts = $preconditions.conflicts;})?
      (postconditions {initiators = $postconditions.initiators; terminators = $postconditions.terminators;})?
      '}'
      {$action = new Action($simpleSentence.simpleSentence, initiators, terminators, conditions, conflicts);}
      {this.variables = new HashMap<String, Variable>();}
  ;
 
d returns [boolean w, DSet set]
  :   {$set = new DSet(); $w = true;}
      ('domain theory' | 'Domain Theory' | 'domainTheory' | 'DomainTheory' | 'dset' | 'Dset' | 'dSet' | 'DSet') '{'
      (action {$w = false; $set.addAction($action.action);})*
      '}'
      {Database.getInstance().setdSet($set);}
  ;
  
database returns [boolean wlint, boolean wlext, boolean wdset]
  :   {$wlint =  true; $wlext = true; $wdset = true;}
      ('database' | 'Database') '{'
      (lext {$wlext = $lext.w;})?
      (lint {$wlint = $lint.w;})?
      '}'
  ;
  
reactiveRules returns [boolean w, ReactiveRuleSet set]
  :   {$set = ReactiveRuleSet.getInstance(); $w = true;}
      ('ReactiveRules' | 'reactiveRules' | 'reactiverules') '{'
      (reactiveRule {$set.addRule($reactiveRule.rule); $w = false;})*
      {this.variables = new HashMap<String, Variable>();}
      '}'
  ;
  
goals returns [boolean w, GoalSet set]
  :   {$set = new GoalSet(); $w = true;}
      ('Goals' | 'goals') '{'
      (rule {$set.addDefinition($rule.rule); $w = false;})*
      {this.variables = new HashMap<String, Variable>();}
      '}'
      {GoalsList.getInstance().setGoalsDefinitions($set);}
  ;
  
events returns [boolean w, RuleSet set]
  :   {$set = new RuleSet(); $w = true;}
      ('Events' | 'events') '{'
      (fluent {$set.addRule(new Rule($fluent.rule)); $w = false;})*
      {this.variables = new HashMap<String, Variable>();}
      '}'
      {CycleHandler.getInstance().setEvents($set);}
  ;
  
file returns [boolean[\] w]
  :   {$w = new boolean[6]; $w[0] = true; $w[1] = true; $w[2] = true; $w[3] = true; $w[4] = true; $w[5] = true;}
      (database {$w[0] = $database.wlext; $w[1] = $database.wlint;})?
      (d {$w[2] = $d.w;})?
      (reactiveRules {$w[3] = $reactiveRules.w;})?
      (goals {$w[4] = $goals.w;})?
      (events {$w[5] = $events.w;})?
      EOF
  ;

/**
*
* Tokens
*
**/
CONSTANT : ('a'..'z' | '0'..'9') ('A'..'Z' | 'a'..'z' | '0'..'9' | '_')*;
VARIABLE : ('A'..'Z') ('A'..'Z' | 'a'..'z' | '0'..'9' | '_')*;
WS : (' ' | '\t' | '\n' | '\r' | '\f')+  {$channel = HIDDEN;};
COMMENT_LINE : '//' .* ('\n' | '\r') {$channel = HIDDEN;};
COMMENT : '/*' .* '*/' {$channel = HIDDEN;};
  