package chord.analyses.thread;

import joeq.Class.jq_Method;
import joeq.Compiler.Quad.Quad;
import joeq.Compiler.Quad.Operator.Invoke;
import chord.analyses.invk.DomI;
import chord.project.Chord;
import chord.project.analyses.ProgramRel;

@Chord(name="threadStartI", sign="I0:I0")
public class RelThreadStartI extends ProgramRel {
	@Override
	public void fill() {
		DomI domI = (DomI) doms[0];
		int numI = domI.size();
		for (int i = 0; i < numI; i++) {
			Quad q = domI.get(i);
			jq_Method m = Invoke.getMethod(q).getMethod();
			if (m.getName().toString().equals("start") &&
				m.getDesc().toString().equals("()V") &&
				m.getDeclaringClass().getName().equals("java.lang.Thread")) {
				add(i);
			}
		}
	}
}
