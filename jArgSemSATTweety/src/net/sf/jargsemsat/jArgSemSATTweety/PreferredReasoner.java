package net.sf.jargsemsat.jArgSemSATTweety;

import java.util.Vector;

import net.sf.jargsemsat.jargsemsat.alg.PreferredSemantics;
import net.sf.jargsemsat.jargsemsat.datastructures.DungAF;
import net.sf.jargsemsat.jargsemsat.datastructures.Encoding;
import net.sf.jargsemsat.jargsemsat.datastructures.Labelling;
import net.sf.tweety.arg.dung.DungTheory;
import net.sf.tweety.arg.dung.semantics.Extension;
import net.sf.tweety.commons.BeliefBase;

public class PreferredReasoner
		extends
			net.sf.tweety.arg.dung.PreferredReasoner {
	public PreferredReasoner(BeliefBase beliefBase) {
		super(beliefBase);
	}

	public PreferredReasoner(BeliefBase beliefBase, int inferenceType) {
		super(beliefBase, inferenceType);
	}

	protected java.util.Set<Extension> computeExtensions() {
		if (this.getKnowledgBase().getClass() != DungTheory.class)
			throw new RuntimeException("Working only with DungTheory objects");

		DungTheory kb = (DungTheory) this.getKnowledgBase();

		DungAF af = DungTheoryToDungAF.fromDungTheory(kb);

		Vector<Labelling> ret = new Vector<Labelling>();

		PreferredSemantics.extensions(ret, af, Encoding.defaultEncoding(), null,
				false);

		return DungTheoryToDungAF.DungAFToExtensions(kb, ret);

	}

}
