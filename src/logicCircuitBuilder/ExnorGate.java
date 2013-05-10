package logicCircuitBuilder;

import java.awt.Component;

/**EXNOR Gate implements the boolean complemented Exclusive OR (equivalence) function for 2 inputs
 * @author vega
 *
 */
public class ExnorGate extends Device {
	/**
	 * Makes an EXNOR gate
	 * @param parent CircuitPanel object
	 */
	public ExnorGate(Component parent) {
		super("EXNOR", 2, 1, parent);
		inputs[0]=new Input(0, 2, this);
		inputs[1]=new Input(0, 18, this);
		outputs[0]=new Output(75,10, this);
	}

	@Override
	public void deviceFunction() {
		outvalue=(!(inputs[0].getValue()^inputs[1].getValue()));

	}

}
