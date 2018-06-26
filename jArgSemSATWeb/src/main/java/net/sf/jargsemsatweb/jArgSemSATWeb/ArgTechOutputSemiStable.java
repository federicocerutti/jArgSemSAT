package net.sf.jargsemsatweb.jArgSemSATWeb;

import java.util.HashSet;

public class ArgTechOutputSemiStable extends ArgTechOutput {

	HashSet<HashSet<String>> semistable = null;

	public ArgTechOutputSemiStable(String[] arguments, String[] attacks,
			HashSet<HashSet<String>> semistable) {
		this.arguments = arguments;
		this.attacks = attacks;
		this.semistable = semistable;
	}

}
