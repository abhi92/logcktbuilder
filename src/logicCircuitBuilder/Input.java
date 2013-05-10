package logicCircuitBuilder;

import java.awt.Color;

/**Input connectors are used to give input to the gates
 * @author vega
 *
 */
public class Input extends Connector{
	Output out;
	boolean state;
	/**
	 * @return the output to which the input is connected to.
	 */
	public Output getOut() {
		return out;
	}
	/**
	 * @return the state of the Input by querying the output to which it is connected
	 */
	public boolean getValue() {
		state=out.getValue();
		return state;
	}

	/**
	 * Makes an Input connector
	 * @param x The x coordinate
	 * @param y The y coordinate
	 * @param device the parent device to which the Input belongs
	 */
	public Input(int x,int y, Device device) {
		super(x,y,Color.red, device);
		out=null;
	}

	/**
	 * Connects the Input
	 * @param out the output to which the input must be connected
	 */
	public void connectTo(Output out){
		this.out=out;		
	}
}
