package net.sf.jargsemsatweb.jArgSemSATWeb;

import java.util.HashSet;

public class ArgTechOutputPreferred extends ArgTechOutput {

	 HashSet<HashSet<String>> preferred = null;

	public ArgTechOutputPreferred(String[] arguments, String[] attacks,  HashSet<HashSet<String>> preferred) {
		this.arguments = arguments;
		this.attacks = attacks;
		this.preferred = preferred;
	}

}
