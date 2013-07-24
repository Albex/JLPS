/**
 * 
 */
package model;

/**
 * @author Albex
 *
 */
public interface Unifiable extends PCExpression {

	public SubstitutionSet unify(Unifiable exp, SubstitutionSet s);

	public String getName();
	
}
