/**
 * 
 */
package model;

/**
 * @author Albex
 *
 */
public interface Goal extends PCExpression {

	public AbstractSolutionNode getSolver(RuleSet rules, SubstitutionSet parentSolution);
	
}
