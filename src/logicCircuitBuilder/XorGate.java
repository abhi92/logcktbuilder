package logicCircuitBuilder;

import java.awt.Component;

/**A XOR gate implements the boolean Exclusive OR function for 2 inputs
 * @author vega
 *
 */
public class XorGate extends Device {
	/**
	 * Creates a XOR Gate
	 * @param parent
	 */
	public XorGate(Component parent) {
		super("XOR", 2, 1, parent);
		inputs[0]=new Input(0, 2, this);
		inputs[1]=new Input(0, 18, this);
		outputs[0]=new Output(75, 10,this);
	}

	@Override
	public void deviceFunction() {
		outvalue=(inputs[0].getValue()^inputs[1].getValue());

	}

}
