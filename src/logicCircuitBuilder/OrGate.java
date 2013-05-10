package logicCircuitBuilder;

import java.awt.Component;

/**An OR Gate implements the boolean OR function for 2 inputs
 * @author vega
 *
 */
public class OrGate extends Device {
	/**Creates a NOR Gate
	 * 
	 * @param parent CircuitPanel
	 */
	public OrGate(Component parent) {
		super("OR", 2, 1, parent);
		inputs[0]=new Input(0, 2, this);
		inputs[1]=new Input(0, 18, this);
		outputs[0]=new Output(75, 10,this);

	}

	@Override
	public void deviceFunction() {
		outvalue=(inputs[0].getValue()||inputs[1].getValue());

	}

}
