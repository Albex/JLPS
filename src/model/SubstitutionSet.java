/**
 * 
 */
package model;

import java.util.HashMap;

/**
 * @author Albex
 * 
 */
public class SubstitutionSet {

	private HashMap<Variable, Unifiable> bindings = new HashMap<Variable, Unifiable>();

	/**
	 * 
	 */
	public SubstitutionSet() {
	}

	public SubstitutionSet(SubstitutionSet s) {
		this.bindings = new HashMap<Variable, Unifiable>(s.bindings);
	}

	public void add(Variable v, Unifiable expr) {
		this.bindings.put(v, expr);
	}

	public void clear() {
		this.bindings.clear();
	}

	public Unifiable getBinding(Variable v) {
		return this.bindings.get(v);
	}

	public boolean isBound(Variable v) {
		return this.bindings.containsKey(v);
	}

	@Override
	public String toString() {
		return "Bindings:[" + this.bindings.toString() + "]";
	}

}
