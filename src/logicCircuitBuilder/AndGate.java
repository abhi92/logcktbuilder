package logicCircuitBuilder;

import java.awt.Component;


/**An AND Gate does the boolean AND operation on 2 inputs
 * @author vega
 *
 */
public class AndGate extends Device {

	/**
	 * Creates an ANDGate
	 * @param parent It is the CircuitPanel where the device is added
	 */
	public AndGate(Component parent) {
		super("AND",2,1, parent);
		inputs[0]=new Input(0, 2, this);
		inputs[1]=new Input(0, 18, this);
		outputs[0]=new Output(75, 10,this);
	}

	/**
	 * Implements the AND function on the 2 inputs and sets the value of outvalue.
	 */
	@Override
	public void deviceFunction() {
		outvalue=(inputs[0].getValue()&&inputs[1].getValue());		
	}

}
