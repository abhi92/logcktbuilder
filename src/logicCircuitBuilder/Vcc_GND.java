package logicCircuitBuilder;

import java.awt.Component;
import java.awt.event.MouseEvent;

/**VCC_GND is a device which gives a toggleable HIGH/LOW output
 * @author vega
 *
 */
public class Vcc_GND extends Device {
	boolean state;
	/**
	 * Creates a toggleable VCC/GND device
	 * @param parent CircuitPanel
	 */
	public Vcc_GND(Component parent) {
		super("1", 0, 1, parent);
		state=true;
		outputs[0]=new Output(75, 10,this);
	}

	@Override
	public void deviceFunction() {
		outvalue=state;
	}

	/**
	 * Toggles VCC/GND
	 */
	@Override
	public void mouseClicked(MouseEvent arg0) {
		super.mouseClicked(arg0);
		state=!state;
		if(state)
			setText("1");
		else
			setText("0");
	}


}
