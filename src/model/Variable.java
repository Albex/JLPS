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

	/* 
	 * (non-Javadoc)
	 * 
	 * @see model.Unifiable#unfiy()
	 * 
	 */
	@Override
	public SubstitutionSet unify(Unifiable expr, SubstitutionSet s) {
		// Equal variables are unified
		if (this == expr) {
			
			return s;
			
		// If the variable has a binding, try to unify the binding with expr
		} else if (s.isBound(this)) {
			
			return s.getBinding(this).unify(expr, s);
			
		// Otherwise bind the variable to expr and succeed
		} else {
			SubstitutionSet sNew = new SubstitutionSet(s);
			sNew.add(this, expr);

			return sNew;
		}
	}
	
	/* 
	 * (non-Javadoc)
	 * 
	 * @see model.PCExpression#replaceVariables(model.SubstitutionSet)
	 * 
	 */
	@Override
	public PCExpression replaceVariables(SubstitutionSet s) throws CloneNotSupportedException {
		// If the variable is bound replace the variable by its binding.
		if (s.isBound(this)) {
			
			return s.getBinding(this).replaceVariables(s);
			
		// Otherwise don't replace it since it can't be
		} else {
			
			return this;
		}
	}

	/* 
	 * (non-Javadoc)
	 * 
	 * @see model.PCExpression#standardizeVariablesApart(java.util.Hashtable)
	 * 
	 */
	@Override
	public PCExpression standardizeVariablesApart(Hashtable<Variable, Variable> newVars) throws CloneNotSupportedException {
		// Get the standardize version of the variable
		Variable newVar = newVars.get(this);
		
		// If the variable hasn't already be standardized, standardize it
		if (newVar == null) {
			// To standardize it, just create a new one (different id) with same other parameters
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

	@Override
	public String getName() {
		return this.printName;
	}

}
