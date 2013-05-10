package logicCircuitBuilder;

import java.awt.Component;

/**A NAND gate implements the boolean NAND function on 2 inputs
 * @author vega
 *
 */
public class NandGate extends Device {
	/**
	 * Creates a NAND Gate
	 * @param parent CircuitPanel
	 */
	public NandGate(Component parent) {
		super("NAND", 2, 1, parent);
		inputs[0]=new Input(0, 2, this);
		inputs[1]=new Input(0, 18, this);
		outputs[0]=new Output(75, 10,this);
	}

	@Override
	public void deviceFunction() {
		outvalue=(!(inputs[0].getValue()&&inputs[1].getValue()));

	}

}
