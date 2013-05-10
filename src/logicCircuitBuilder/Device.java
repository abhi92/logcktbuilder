package logicCircuitBuilder;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JLabel;
import javax.swing.border.LineBorder;
/**Device is any of the devices available to be implemented in the circuit.
 * The device queries its input which in turn queries the output connected to it.
 * @author vega
 *
 */
public abstract class Device extends JLabel implements MouseListener,MouseMotionListener {
	Component parent;
	static Output selectedOutput;//for connecting wires.
	private static final long serialVersionUID = 1L;
	int inno,outno;//number of outputs and inputs
	boolean outvalue;//the output value of the device
	int startDragX,startDragY;//for saving starting position of a drag 
	//so that offset wrt cursor can be maintained
	Input[] inputs;
	Output[] outputs;
	public static final int devwidth=90,devheight=30;
	/**
	 * The constants that are set as values for CircuitPanel.deviceAdded by the {@link DevicePanel}
	 */
	public static final int AND=0, OR=1, NOT=2, NAND=3, NOR=4, XOR=5, EXNOR=6, LED=7, VCC_OR_GND=8;

	/**
	 * Creates a device
	 * @param name The name of the device to be created
	 * @param inno the number of inputs in the device
	 * @param outno the number of outputs in the device
	 * @param parent the panel in which the device is created. Here the CircuitPanel is given. This allows
	 * 				the device to call the functions of the CircuitPanel.
	 */
	public Device(String name,int inno,int outno, Component parent) {
		super(name);
		this.parent=parent;
		setBorder(new LineBorder(Color.black, 1));
		inputs=new Input[inno];
		outputs=new Output[outno];
		addMouseListener(this);
		addMouseMotionListener(this);
	}

	/**
	 * Implements the logic of the device.
	 * Every device will override this function in order to implement its logic.
	 */
	public abstract void deviceFunction();

	/**
	 * Paints the input and output connectors of the device
	 */
	@Override
	protected void paintComponent(Graphics arg0) {
		for(Input in : inputs)
			in.paintConnector(this, (Graphics2D)arg0);
		for(Output out : outputs)
			out.paintConnector(this, (Graphics2D) arg0);
		super.paintComponent(arg0);
		parent.repaint();
	}

	/**
	 * Recognises mouse clicks on the input and output connectors and performs necessary functions
	 */
	@Override
	public void mouseClicked(MouseEvent arg0) {
		Point p=arg0.getPoint();
		if(selectedOutput!=null)
			for(Input in:inputs)
				if(in.contains(p))
				{
					System.out.println("Connected");
					for(Connection c:CircuitPanel.wires)
						if(c.getInput()==in)
						{
							CircuitPanel.wires.remove(c);
						}

					CircuitPanel.wires.add(new Connection(selectedOutput, in));
					in.connectTo(selectedOutput);
					selectedOutput=null;
					return;
				}
		for(Output out:outputs)
			if(out.contains(p))
			{
				System.out.println("Clicked on output");
				selectedOutput=out;
			}
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {

	}

	@Override
	public void mouseExited(MouseEvent arg0) {

	}

	@Override
	/**
	 * Sets the starting coordinates of the cursor relative to the Device coordinates so that the offset with
	 * respect to the cursor can be maintained. Also sets the cursor to a hand to indicate dragging.
	 */
	public void mousePressed(MouseEvent arg0) {
		//events for start of a drag that may or may not occur
		Point p=arg0.getPoint();
		startDragX = arg0.getX();
		startDragY = arg0.getY();
		setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));

	}

	/**
	 * Sets the cursor back to the default cursor
	 */
	@Override
	public void mouseReleased(MouseEvent arg0) {
		setCursor(Cursor.getDefaultCursor());

	}

	/**Implements the device drag operation The mouse coordinates are obtained and the device is
	 * set at the new location using the setLocation() function.
	 * 
	 */
	@Override
	public void mouseDragged(MouseEvent e) {
		int newX = getX() + (e.getX() - startDragX);
		int newY = getY() + (e.getY() - startDragY);
		setLocation(newX, newY);
		repaint();

	}

	/**
	 * Sets the cursor to a crosshair when it is over the input and output connectors for easy identification
	 * by the user. Else sets the cursor to the default cursor.
	 */
	@Override
	public void mouseMoved(MouseEvent arg0) {
		//for setting crosshair cursor inside the connectors so that they can be easily identified
		Point p=arg0.getPoint();
		for(Input in:inputs)
			if(in.contains(p))
			{
				setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
				return;
			}
		for(Output out:outputs)
			if(out.contains(p))
			{
				setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
				return;
			}
		setCursor(Cursor.getDefaultCursor());
	}
}
