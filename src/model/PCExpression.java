/**
 * 
 */
package model;

import java.util.Hashtable;

/**
 * @author Albex
 *
 */
public interface PCExpression {
	
	public PCExpression standardizeVariablesApart(Hashtable<Variable, Variable> newVars) throws CloneNotSupportedException;

	public PCExpression replaceVariables(SubstitutionSet s) throws CloneNotSupportedException;
	
}
