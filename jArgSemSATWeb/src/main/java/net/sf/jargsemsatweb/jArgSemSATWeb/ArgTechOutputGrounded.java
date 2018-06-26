package net.sf.jargsemsatweb.jArgSemSATWeb;

import java.util.HashSet;

public class ArgTechOutputGrounded extends ArgTechOutput {

	HashSet<String> grounded = null;

	public ArgTechOutputGrounded(String[] arguments, String[] attacks, HashSet<String> grounded) {
		this.arguments = arguments;
		this.attacks = attacks;
		this.grounded = grounded;
	} 
	
	
}
