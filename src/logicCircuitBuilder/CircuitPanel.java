package logicCircuitBuilder;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

/**CircuitPanel is the panel where the circuit will be built.
 * @author vega
 *
 */
public class CircuitPanel extends JPanel implements MouseListener {
	static ArrayList<LedDevice> leds;
	static ArrayList<Connection> wires;
	static int deviceAdded;
	static boolean isConnecting=false;
	public CircuitPanel() {
		setLayout(null);
		setBackground(Color.white);
		leds=new ArrayList<LedDevice>();
		wires=new ArrayList<Connection>();
		deviceAdded=-1;
		addMouseListener(this);
		JButton simulate=new JButton("Simulate");
		simulate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				for(LedDevice led:leds)
					led.deviceFunction();
			}
		});
		simulate.setBounds(new Rectangle(0,0,100,30));
		add(simulate);

	}
	/**
	 * Adds the devices depending on the value of the variable deviceAdded.
	 */
	@Override
	public void mouseClicked(MouseEvent arg0) {
		Point P=arg0.getPoint();
		if(deviceAdded==-1)
			return;
		Device device;
		//		device=new AndGate();
		switch (deviceAdded) {
		case Device.AND:
			device=new AndGate(this);			
			break;
		case Device.OR:
			device=new OrGate(this);
			break;
		case Device.NOT:
			device=new NotGate(this);
			break;
		case Device.NAND:
			device=new NandGate(this);
			break;
		case Device.NOR:
			device=new NorGate(this);
			break;
		case Device.XOR:
			device=new XorGate(this);
			break;
		case Device.EXNOR:
			device=new ExnorGate(this);
			break;
		case Device.LED:
			device=new LedDevice(this);
			leds.add((LedDevice)device);
			break;
		case Device.VCC_OR_GND:
			device=new Vcc_GND(this);
			break;
		default:
			device=new AndGate(this);
			break;
		}
		device.setHorizontalAlignment(0);
		add(device);
		device.setBounds(P.x, P.y, Device.devwidth, Device.devheight);
		deviceAdded=-1;
		this.repaint();

	}


	@Override
	public void mouseEntered(MouseEvent arg0) {


	}
	@Override
	public void mouseExited(MouseEvent arg0) {

	}


	@Override
	public void mousePressed(MouseEvent arg0) {

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {

	}

	/**
	 * Paints the connections between the devices by calling the paintConnection method
	 * of the {@link Connection} class for each of the wires
	 */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		for(Connection c:wires)
			c.paintConnection((Graphics2D)g);
	}


}
