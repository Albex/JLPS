/**
 * 
 */
package model;

/**
 * This class represents a simple sentence node in the tree of proof. A solution
 * node is a node in a tree of proof.
 * 
 * @author Alexandre Camus
 * 
 */
public class SimpleSentenceSolutionNode extends AbstractSolutionNode {

	private AbstractSolutionNode child = null;
	
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
	public SimpleSentenceSolutionNode(SimpleSentence clause, RuleSet rules, SubstitutionSet parentSolution) {
		super(clause, rules, parentSolution);
	}

	/**
	 * Creates the next solution for the simple sentence of the node. If no solution
	 * exists, it will create a solution. Otherwise it will get a different
	 * solution or return {@code null} if there no other different solution.
	 * 
	 * @return a {@code SubstitutionSet} object representing the bindings of the
	 *         next solution or {@code null} if there is no next solution.
	 * @see model.AbstractSolutionNode#nextSolution()
	 */
	@Override
	public SubstitutionSet nextSolution() {
		SubstitutionSet solution;
		
		// If there is a child in the proof tree, try to get an alternative solution
		if (this.child != null) {
			solution = this.child.nextSolution();
			if (solution != null) {
				setDeepestLeaf(this.child.getDeepestLeaf());
				
				return solution;
			}
		} 
		
		// If the previous try fails, this proof tree has no alternate solution.
		// Create a new one by deleting the current child.
		this.child = null;
		
		Rule rule;
		
		// Then try to find a new solution for the current node
		while (this.hasNextRule() == true) {
			// Get a rule
			rule = this.nextRule();
			
			SimpleSentence head = rule.getHead();
			
			// Unify its head
			solution = ((SimpleSentence) this.getClause()).unify(head, this.getParentSolution());
			
			// If there is a solution to the unification
			if (solution != null) {
				// Get the body of the rule
				Clause tail = rule.getBody();
				
				// If there is no body, solution is the whole solution
				if (tail == null) {
					setDeepestLeaf(this);
					
					return solution;
				}
				
				// Otherwise create a node for the body of the rule and get a new solution for this new node
				this.child = tail.getSolver(this.getRuleSet(), solution);
				SubstitutionSet childSolution = this.child.nextSolution();
				
				// If the new node has a solution return it
				if (childSolution != null) {
					setDeepestLeaf(this.child.getDeepestLeaf());
					
					return childSolution;
				}
			}
		}
		
		// If there is no solution for the current node after trying with every rule
		// Fail and return null
		setDeepestLeaf(this);
		
		return null;
	}
	
}
