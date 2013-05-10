package logicCircuitBuilder;

import java.awt.Color;

/**Output connectors are used to take output from devices. They are queried by the inputs to which they are connected
 * and they in turn query the device for the value of output
 * @author vega
 *
 */
public class Output extends Connector{
	boolean value;
	/**
	 * Creates an Output connector
	 * @param x X coordinate
	 * @param y Y coordinate
	 * @param device the parent device
	 */
	public Output(int x, int y,Device device) {
		super(x, y,Color.blue, device);
		value=false;
	}
	/**Next Input will get state from here
	 * @return the state
	 */
	public boolean getValue() {
		device.deviceFunction();
		value=device.outvalue;
		return value;
	}
}
