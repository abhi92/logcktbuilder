package logicCircuitBuilder;

import java.awt.Graphics2D;

/**Connection objects are the wires between the devices
 * They are used just for drawing the lines no logic is implemented through them
 * @author vega
 *
 */
public class Connection {
	Input input;
	Output output;

	/**
	 * Creates a connection joining the Input input and Outputd output
	 * @param output The output from which the connection is drawn
	 * @param input the input to which the connection is drawn
	 */
	public Connection(Output output, Input input) {
		this.output = output;
		this.input = input;
		output.addConnection(this);
		input.addConnection(this);
	}

	/**
	 * Paints the line between input and output connectors
	 * This is called by the paintComponent() method of the CircuitPanel
	 * @param g2d The Graphics2D object whic is used to paint the lines.
	 */
	public void paintConnection(Graphics2D g2d) {
		g2d.drawLine(output.getX(), output.getY(), input.getX(), input.getY());
	}

	/**
	 * Used to remove a connection when one input has 2 incident connections
	 * @return the input connector to which the connector is drawn.
	 */
	public Input getInput()
	{
		return input;
	}



}
