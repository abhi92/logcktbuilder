package logicCircuitBuilder;

import java.awt.Component;

import javax.swing.Icon;

/**LED is used to see the output of the circuit. The simulate button on the circuitpanel will 
 * call the deviceFunction() method of the LED to simulate the circuit
 * @author vega
 *
 */
public class LedDevice extends Device {
	boolean state=false;//to denote on/off state

	/**
	 * makes an LED
	 * @param parent CircuitPanel
	 */
	public LedDevice(Component parent) {
		super("0", 1, 0, parent);
		inputs[0]=new Input(0, 10, this);
	}
	/**
	 * Sets the state of the LED by querying its input.
	 */
	@Override
	public void deviceFunction() {
		if(inputs[0].getValue())
			setText("1");
		else
			setText("0");
	}

}
