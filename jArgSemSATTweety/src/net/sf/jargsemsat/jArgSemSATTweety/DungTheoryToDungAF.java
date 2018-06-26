package net.sf.jargsemsat.jArgSemSATTweety;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Vector;

import net.sf.jargsemsat.jargsemsat.datastructures.DungAF;
import net.sf.jargsemsat.jargsemsat.datastructures.Labelling;
import net.sf.tweety.arg.dung.DungTheory;
import net.sf.tweety.arg.dung.semantics.Extension;
import net.sf.tweety.arg.dung.syntax.Argument;
import net.sf.tweety.graphs.Edge;

class DungTheoryToDungAF {

	static DungAF fromDungTheory(DungTheory kb) {
		Collection<String> arguments = new Vector<String>();
		Collection<String[]> attacks = new Vector<String[]>();

		Iterator<Argument> it = kb.getNodes().iterator();
		while (it.hasNext()) {
			arguments.add(it.next().getName());
		}
		
		Iterator<? extends Edge<? extends Argument>> itt = kb.getEdges().iterator();
		while (itt.hasNext()){
			Edge<? extends Argument> current = itt.next();
			attacks.add(new String []{current.getNodeA().getName(), current.getNodeB().getName()} );
		}
		
		return new DungAF(arguments, attacks);
	}
	
	static java.util.Set<Extension> DungAFToExtensions(DungTheory kb, Vector<Labelling> exts){
		java.util.Set<Extension> ret = new HashSet<Extension>();
		
		Iterator<Labelling> it = exts.iterator();
		while(it.hasNext()){
			Extension e = new Extension();
			Iterator<String> arg = it.next().inargs().iterator();
			
			while(arg.hasNext()){
				e.add(new Argument(arg.next()));
			}
			ret.add(e);
		}
		return ret;
	}

}
