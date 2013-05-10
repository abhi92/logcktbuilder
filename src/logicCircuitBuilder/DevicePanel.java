package logicCircuitBuilder;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
/**DevicePanel is the panel on the west where the device buttons are placed.
 * Clicking on the button and clicking on the CircuitPanel adds the corresponding device at the click location
 * @author vega
 *
 */
public class DevicePanel extends JPanel implements ActionListener {
	JButton[] DeviceButtons;
	public DevicePanel() {
		DeviceButtons=new JButton[9];
		DeviceButtons[0]=new JButton("AND");
		DeviceButtons[1]=new JButton("OR");
		DeviceButtons[2]=new JButton("NOT");
		DeviceButtons[3]=new JButton("NAND");
		DeviceButtons[4]=new JButton("NOR");
		DeviceButtons[5]=new JButton("XOR");
		DeviceButtons[6]=new JButton("EXNOR");
		DeviceButtons[7]=new JButton("LED");
		DeviceButtons[8]=new JButton("VCC/GND");

		setLayout(new GridLayout(DeviceButtons.length,1));
		for(int i=0;i<DeviceButtons.length;i++){
			DeviceButtons[i].addActionListener(this);
			add(DeviceButtons[i]);			
		}		
	}

	/**
	 * Clicking on a device button sets the value of {@link CircuitPanel}.deviceAdded
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		String name=((JButton)arg0.getSource()).getText();
		if(name.equals("AND"))
			CircuitPanel.deviceAdded=Device.AND;
		else if(name.equals("OR"))
			CircuitPanel.deviceAdded=Device.OR;
		else if(name.equals("NOT"))
			CircuitPanel.deviceAdded=Device.NOT;
		else if(name.equals("NAND"))
			CircuitPanel.deviceAdded=Device.NAND;
		else if(name.equals("NOR"))
			CircuitPanel.deviceAdded=Device.NOR;
		else if(name.equals("XOR"))
			CircuitPanel.deviceAdded=Device.XOR;
		else if(name.equals("EXNOR"))
			CircuitPanel.deviceAdded=Device.EXNOR;
		else if(name.equals("LED"))
			CircuitPanel.deviceAdded=Device.LED;
		else if(name.equals("VCC/GND"))
			CircuitPanel.deviceAdded=Device.VCC_OR_GND;
	}
}
