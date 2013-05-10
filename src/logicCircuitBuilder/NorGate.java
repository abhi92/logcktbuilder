package logicCircuitBuilder;

import java.awt.Component;

/**A NOR gate implements the boolean NOR function for 2 inputs
 * @author vega
 *
 */
public class NorGate extends Device {
	/**
	 * Creates a NOR gate
	 * @param parent CircuitPanel
	 */
	public NorGate(Component parent) {
		super("NOR", 2, 1, parent);
		inputs[0]=new Input(0, 2, this);
		inputs[1]=new Input(0, 18, this);
		outputs[0]=new Output(75, 10,this);
	}

	@Override
	public void deviceFunction() {
		outvalue=(!(inputs[0].getValue()||inputs[1].getValue()));
	}

}
