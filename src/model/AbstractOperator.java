/**
 * 
 */
package model;

import java.util.ArrayList;
import java.util.Hashtable;

/**
 * This class is the abstract class that gathers all the operator classes. It
 * implements {@link Goal}.
 * 
 * @author Alexandre Camus
 * 
 */
public abstract class AbstractOperator implements Goal {

	protected ArrayList<Goal> operands;
	
	/**
	 * Constructor of the class.
	 * 
	 * @param operands
	 *            the operands of the operator in an array or as independent
	 *            variables.
	 */
	public AbstractOperator(Goal... operands) {
		Goal[] operandArray = operands;
		
		this.operands = new ArrayList<Goal>();
		
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
	public AbstractOperator(ArrayList<Goal> operands) {
		this.operands = operands;
	}
	
	/**
	 * Sets all the operands to the specified operands.
	 * 
	 * @param operands
	 *            the new operands in an {@code ArrayList} object.
	 */
	public void setOperands(ArrayList<Goal> operands) {
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
	public Goal getOperand(int index) {
		return this.operands.get(index);
	}
	
	/**
	 * Gets the first operand of the operator.
	 * 
	 * @return the first operand.
	 */
	public Goal getFirstOperand() {
		return this.operands.get(0);
	}
	
	/**
	 * Gets the tail of the operator. An operator is seen as its head (the first
	 * operand) and its tail (all the other operands).
	 * 
	 * @return the tail of the operator as an object of the same class.
	 */
	public AbstractOperator getOperatorTail() {
		ArrayList<Goal> tail = new ArrayList<Goal>(this.operands);
		tail.remove(0);
		AbstractOperator tailOperator = this.create(tail);
		
		return tailOperator;
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
	protected abstract AbstractOperator create(ArrayList<Goal> operands);
	
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
		ArrayList<Goal> newOperands = new ArrayList<Goal>();
		
		// Bind each operand recursively
		for (int i = 0; i < this.operandCount(); i++) {
			newOperands.add((Goal) this.getOperand(i).replaceVariables(s));
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
		ArrayList<Goal> newOperands = new ArrayList<Goal>();
		
		// Standardize each operand recursively
		for(int i = 0; i < this.operandCount(); i++) {
			newOperands.add((Goal) this.getOperand(i).standardizeVariablesApart(newVars));
		}
		
		// Create the new standardized operator
		AbstractOperator copy = this.create(newOperands);
		
		return copy;
	}

}
