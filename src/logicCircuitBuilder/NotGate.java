package logicCircuitBuilder;

import java.awt.Component;

/**A NOT gate implements the boolean NOT function.
 * @author vega
 *
 */
public class NotGate extends Device{
	/**
	 * Creates a NotGate
	 * @param parent CircuitPanel
	 */
	public NotGate(Component parent) {
		super("NOT",1,1, parent);
		inputs[0]=new Input(0, 10, this);
		outputs[0]=new Output(75, 10,this);
	}

	@Override
	public void deviceFunction() {
		outvalue=(!inputs[0].getValue());

	}

}
