/**
 * 
 */
package model;

import java.util.ArrayList;
import java.util.Hashtable;

/**
 * This class is the abstract class that gathers all the operator classes. It
 * implements {@link Clause}.
 * 
 * @author Alexandre Camus
 * 
 */
public abstract class AbstractOperator implements Clause {

	protected ArrayList<Clause> operands;
	
	/**
	 * Constructor of the class.
	 * 
	 * @param operands
	 *            the operands of the operator in an array or as independent
	 *            variables.
	 */
	public AbstractOperator(Clause... operands) {
		Clause[] operandArray = operands;
		
		this.operands = new ArrayList<Clause>();
		
		for (int i = 0; i < operandArray.length; i++) {
			this.operands.add(operandArray[i]);
		}
	}
	
	/**
	 * Constructor of the class.
	 * 
	 * @param operands
	 *            the operands of the operator in an {@code ArrayList} object.
	 */
	public AbstractOperator(ArrayList<Clause> operands) {
		this.operands = operands;
	}
	
	/**
	 * Sets all the operands to the specified operands.
	 * 
	 * @param operands
	 *            the new operands in an {@code ArrayList} object.
	 */
	public void setOperands(ArrayList<Clause> operands) {
		this.operands = operands;
	}
	
	/**
	 * Gets the size of the operator in terms of operands.
	 * 
	 * @return the number of operands of the operator.
	 */
	public int operandCount() {
		return this.operands.size();
	}
	
	/**
	 * Gets the operand number {@code index}.
	 * 
	 * @param index
	 *            of the operand to get.
	 * @return return the operand number {@code index}.
	 */
	public Clause getOperand(int index) {
		return this.operands.get(index);
	}
	
	/**
	 * Gets the first positive operand of the operator.
	 * 
	 * @return the first operand.
	 */
	public Clause getFirstPositiveOperand() {
		int i = 0;
		while (this.operands.get(i) instanceof Not) {
			i++;
			
			if (i >= this.operandCount()) {
				
				return this.operands.get(0);
			}
		}
		
		return this.operands.get(i);
	}
	
	/**
	 * Gets the tail of the operator. An operator is seen as its head (the first
	 * operand) and its tail (all the other operands).
	 * 
	 * @return the tail of the operator as an object of the same class if there
	 *         are several tail operands or as the operand itself if there is
	 *         only one.
	 */
	public Clause getOperatorTail() {
		ArrayList<Clause> tail = new ArrayList<Clause>(this.operands);
		tail.remove(0);
		Clause tailOperator;
		if (tail.size() == 1) {
			tailOperator = tail.get(0);
		} else {
			tailOperator = this.create(tail);
		}
		
		return tailOperator;
	}
	
	/**
	 * Gets all the operands of the operator.
	 * 
	 * @return an {@code ArrayList} object containing all the operands of the
	 *         operator.
	 */
	public ArrayList<Clause> getOperands() {
		return this.operands;
	}
	
	/**
	 * Checks if the operator has operands or not.
	 * 
	 * @return true if the operator is empty.
	 */
	public boolean isEmpty() {
		return this.operands.isEmpty();
	}
	
	/**
	 * Generic constructor of sub-objects. It allows the methods of the abstract
	 * class to create correct sub-objects very easily.
	 * 
	 * @see model.And#create(java.util.ArrayList)
	 * @see model.Not#create(java.util.ArrayList)
	 */
	protected abstract AbstractOperator create(ArrayList<Clause> operands);
	
	/**
	 * Replaces all the variables in the clause according to the specified
	 * bindings.
	 * <p>
	 * This method is recursive over all {@link PCExpression} implementations.
	 * 
	 * @param s
	 *            the {@code SubstitutionSet} that contains the bindings of the
	 *            variables so far.
	 * @return an object of the same class representing the bound clause.
	 * @see model.PCExpression#replaceVariables(model.SubstitutionSet)
	 */
	@Override
	public AbstractOperator replaceVariables(SubstitutionSet s) {
		// Create the operands of the new bound operator
		ArrayList<Clause> newOperands = new ArrayList<Clause>();
		
		// Bind each operand recursively
		for (int i = 0; i < this.operandCount(); i++) {
			newOperands.add((Clause) this.getOperand(i).replaceVariables(s));
		}
		
		// Create the bound operator
		AbstractOperator copy = this.create(newOperands);
		
		return copy;
	}

	/**
	 * Standardizes the variables in order to be sure that there won't be any
	 * variable clashes.
	 * <p>
	 * This method is recursive over all {@code PCExpression} implementations.
	 * 
	 * @param newVars
	 *            is a parameter to save over the recursion all the variable
	 *            replacements done so far.
	 * @return an object of the same class representing the standardized clause.
	 * @see model.PCExpression#standardizeVariablesApart(java.util.Hashtable)
	 */
	@Override
	public AbstractOperator standardizeVariablesApart(Hashtable<Variable, Variable> newVars) {
		// Create the operands of the new standardized operator
		ArrayList<Clause> newOperands = new ArrayList<Clause>();
		
		// Standardize each operand recursively
		for(int i = 0; i < this.operandCount(); i++) {
			newOperands.add((Clause) this.getOperand(i).standardizeVariablesApart(newVars));
		}
		
		// Create the new standardized operator
		AbstractOperator copy = this.create(newOperands);
		
		return copy;
	}

}
