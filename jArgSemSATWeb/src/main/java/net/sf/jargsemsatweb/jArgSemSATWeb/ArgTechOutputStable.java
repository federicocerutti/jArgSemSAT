package net.sf.jargsemsatweb.jArgSemSATWeb;

import java.util.HashSet;

public class ArgTechOutputStable extends ArgTechOutput {

	HashSet<HashSet<String> > stable = null;
	
	public ArgTechOutputStable(String[] arguments, String[] attacks,  HashSet<HashSet<String>> stable) {
		this.arguments = arguments;
		this.attacks = attacks;
		this.stable = stable;
	}
	
}
