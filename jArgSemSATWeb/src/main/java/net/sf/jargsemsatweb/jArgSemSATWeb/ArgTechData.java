package net.sf.jargsemsatweb.jArgSemSATWeb;

import java.util.Arrays;
import java.util.Collection;
import java.util.Vector;

import net.sf.jargsemsat.jargsemsat.datastructures.DungAF;

public class ArgTechData {

	public static final String GROUNDED = "grounded";
	public static final String PREFERRED = "preferred";
	public static final String STABLE = "stable";
	public static final String SEMISTABLE = "semistable";

	String[] arguments = null;
	String[] attacks = null;
	String semantics = null;

	public String[] getArguments() {
		return arguments;
	}

	public void setArguments(String[] arguments) {
		this.arguments = arguments;
	}

	public String[] getAttacks() {
		return attacks;
	}

	public void setAttacks(String[] attacks) {
		this.attacks = attacks;
	}

	public String getSemantics() {
		return semantics;
	}

	public void setSemantics(String semantics) {
		this.semantics = semantics;
	}

	public String toString() {
		return this.semantics;
	}

	public ArgTechOutput BL() {
		if (this.arguments == null || this.attacks == null
				|| this.semantics == null)
			return null;

		if (this.arguments.length == 0)
			return null;

		if (!this.semantics.equalsIgnoreCase(GROUNDED)
				&& !this.semantics.equalsIgnoreCase(PREFERRED)
				&& !this.semantics.equalsIgnoreCase(SEMISTABLE)
				&& !this.semantics.equalsIgnoreCase(STABLE))
			return null;

		Collection<String> args = new Vector<String>(
				Arrays.asList(this.arguments));

		Collection<String[]> atts = new Vector<String[]>();

		for (int i = 0; i < this.attacks.length; i++) {
			if (this.attacks[i].charAt(0) != '(' || this.attacks[i]
					.charAt(this.attacks[i].length() - 1) != ')')
				return null;

			String [] splits = this.attacks[i].substring(1, this.attacks[i].length()-1).split(",");
			
			if (splits.length != 2)
				return null;
			
			if (!args.contains(splits[0]) && !args.contains(splits[1]))
				return null;
			
			atts.add(splits);
		}

		DungAF input = new DungAF(args, atts);
		
		if (this.semantics.equalsIgnoreCase(GROUNDED))
			return new ArgTechOutputGrounded(this.arguments, this.attacks, input.getGroundedExt());
		else if (this.semantics.equalsIgnoreCase(PREFERRED))
			return new ArgTechOutputPreferred(this.arguments, this.attacks, input.getPreferredExts());
		else if (this.semantics.equalsIgnoreCase(STABLE))
			return new ArgTechOutputStable(this.arguments, this.attacks, input.getStableExts());
		else if (this.semantics.equalsIgnoreCase(SEMISTABLE))
			return new ArgTechOutputSemiStable(this.arguments, this.attacks, input.getSemiStableExts());
		else
			return null;
		
	}

}
