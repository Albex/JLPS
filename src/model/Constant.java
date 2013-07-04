/**
 * 
 */
package model;

import java.util.Hashtable;

/**
 * @author Albex
 *
 */
public class Constant implements Unifiable {

	private String printName = null;
	private static int nextId = 1;
	private int id;
	
	/**
	 * 
	 */
	public Constant() {
		this.id = nextId++;
	}
	
	public Constant(String printName) {
		this();
		this.printName = printName;
	}

	/* (non-Javadoc)
	 * @see model.Unifiable#unfiy()
	 */
	@Override
	public SubstitutionSet unify(Unifiable expr, SubstitutionSet s) {
		if (this == expr) {
			return new SubstitutionSet(s);
		} else if (expr instanceof Variable) {
			return expr.unify(this, s);
		} else {
			return null;
		}
	}

	/* (non-Javadoc)
	 * @see model.PCExpression#replaceVariables(model.SubstitutionSet)
	 */
	@Override
	public PCExpression replaceVariables(SubstitutionSet s) throws CloneNotSupportedException {
		return this;
	}

	/* (non-Javadoc)
	 * @see model.PCExpression#standardizeVariablesApart(java.util.Hashtable)
	 */
	@Override
	public PCExpression standardizeVariablesApart(Hashtable<Variable, Variable> newVars) throws CloneNotSupportedException {
		return this;
	}

	@Override
	public String toString() {
		if (this.printName != null) {
			return this.printName;
		}
		
		return "constant_" + this.id;
	}
	
}
