/**
 * 
 */
package model;

import java.util.Hashtable;

/**
 * @author Albex
 *
 */
public class Variable implements Unifiable {

	private String printName = null;
	private static int nextId = 1;
	private int id;
	
	/**
	 * 
	 */
	public Variable() {
		this.id = nextId++;
	}
	
	public Variable(String printName) {
		this();
		this.printName = printName;
	}
	
	public Variable(Variable v) {
		this();
		this.printName = v.printName;
	}

	/* (non-Javadoc)
	 * @see model.Unifiable#unfiy()
	 */
	@Override
	public SubstitutionSet unify(Unifiable expr, SubstitutionSet s) {
		// Unification with self always succeeds
		if (this == expr) {
			return s;
		// Find existing binding and unify with it, if one exists
		} else if (s.isBound(this)) {
			return s.getBinding(this).unify(expr, s);
		// Otherwise make a new binding to expr and succeed
		} else {
			SubstitutionSet sNew = new SubstitutionSet(s);
			sNew.add(this, expr);

			return sNew;
		}
	}
	
	/* (non-Javadoc)
	 * @see model.PCExpression#replaceVariables(model.SubstitutionSet)
	 */
	@Override
	public PCExpression replaceVariables(SubstitutionSet s) throws CloneNotSupportedException {
		if (s.isBound(this)) {
			return s.getBinding(this).replaceVariables(s);
		} else {
			return this;
		}
	}

	/* (non-Javadoc)
	 * @see model.PCExpression#standardizeVariablesApart(java.util.Hashtable)
	 */
	@Override
	public PCExpression standardizeVariablesApart(Hashtable<Variable, Variable> newVars) throws CloneNotSupportedException {
		Variable newVar = newVars.get(this);
		
		//Try to see if the current expression already has a substitute variable.
		if (newVar == null) {
			// if not create one.
			newVar = new Variable(this);
			newVars.put(this, newVar);
		}
		
		return newVar;
	}

	@Override
	public String toString() {
		if (this.printName != null) {
			return this.printName + "_" + this.id;
		}
		
		return "V" + this.id;
	}

}
