/**
 * 
 */
package model;

/**
 * This class represents a equality node in the tree of proof. A solution node
 * is a node in a tree of proof.
 * 
 * @author Alexandre Camus
 * 
 */
public class EqualSolutionNode extends AbstractSolutionNode {
	
	/**
	 * Constructor of the class.
	 * 
	 * @param clause
	 *            the simple sentence to be proved by this subtree.
	 * @param rules
	 *            the rules representing context of the proof.
	 * @param parentSolution
	 *            the solution of the parent node in the tree of proof.
	 */
	public EqualSolutionNode(Equal clause, RuleSet rules, SubstitutionSet parentSolution, AbstractSolutionNode parentNode) {
		super(clause, rules, parentSolution, parentNode);
	}
	
	/*protected void reset(SubstitutionSet newParentSolution, RuleSet newRuleSet) {
		super.reset(newParentSolution, newRuleSet);
	}*/

	/**
	 * Creates the next solution for the equality of the node. If no solution
	 * exists, it will create a solution. Otherwise it will get a different
	 * solution or return {@code null} if there no other different solution.
	 * 
	 * @return a {@code SubstitutionSet} object representing the bindings of the
	 *         next solution or {@code null} if there is no next solution.
	 * @see model.AbstractSolutionNode#nextSolution()
	 */
	@Override
	public SubstitutionSet nextSolution() {
		Unifiable v1 = ((Equal) getClause()).getOperand1();
		Unifiable v2 = ((Equal) getClause()).getOperand2();
		SubstitutionSet solution = this.getParentSolution();

		if (v1.equal(v2, solution)) {

			return solution;
		}
		
		return null;
	}

}
