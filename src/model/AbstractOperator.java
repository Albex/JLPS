/**
 * 
 */
package model;

import java.util.ArrayList;
import java.util.Hashtable;

/**
 * @author Albex
 *
 */
public abstract class AbstractOperator implements Goal, Cloneable {

	protected ArrayList<Goal> operands;
	
	/**
	 * 
	 */
	public AbstractOperator(Goal... operands) {
		Goal[] operandArray = operands;
		
		this.operands = new ArrayList<Goal>();
		
		for (int i = 0; i < operandArray.length; i++) {
			this.operands.add(operandArray[i]);
		}
	}
	
	public AbstractOperator(ArrayList<Goal> operands) {
		this.operands = operands;
	}
	
	public void setOperands(ArrayList<Goal> operands) {
		this.operands = operands;
	}
	
	/**
	 * @return
	 */
	public int operandCount() {
		return this.operands.size();
	}
	
	/**
	 * @param index
	 * @return
	 */
	public Goal getOperand(int index) {
		return this.operands.get(index);
	}
	
	/**
	 * @return
	 */
	public Goal getFirstOperand() {
		return this.operands.get(0);
	}
	
	/**
	 * @return
	 * @throws CloneNotSupportedException
	 */
	public AbstractOperator getOperatorTail() throws CloneNotSupportedException {
		ArrayList<Goal> tail = new ArrayList<Goal>(this.operands);
		tail.remove(0);
		AbstractOperator tailOperator = (AbstractOperator) this.clone();
		tailOperator.setOperands(tail);
		
		return tailOperator;
	}
	
	/**
	 * @return
	 */
	public boolean isEmpty() {
		return this.operands.isEmpty();
	}
	
	/* (non-Javadoc)
	 * @see model.PCExpression#replaceVariables(model.SubstitutionSet)
	 */
	@Override
	public PCExpression replaceVariables(SubstitutionSet s) throws CloneNotSupportedException {
		ArrayList<Goal> newOperands = new ArrayList<Goal>();
		for (int i = 0; i < this.operandCount(); i++) {
			newOperands.add((Goal) this.getOperand(i).replaceVariables(s));
		}
		AbstractOperator copy = (AbstractOperator) this.clone();
		copy.setOperands(newOperands);
		
		return copy;
	}

	/* (non-Javadoc)
	 * @see model.PCExpression#standardizeVariablesApart(java.util.Hashtable)
	 */
	@Override
	public PCExpression standardizeVariablesApart(Hashtable<Variable, Variable> newVars) throws CloneNotSupportedException {
		ArrayList<Goal> newOperands = new ArrayList<Goal>();
		for(int i = 0; i < this.operandCount(); i++) {
			newOperands.add((Goal) this.getOperand(i).standardizeVariablesApart(newVars));
		}
		AbstractOperator copy = (AbstractOperator) this.clone();
		copy.setOperands(newOperands);
		
		return copy;
	}

}
