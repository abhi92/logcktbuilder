package logicCircuitBuilder;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;

/**Main class for the Logic Circuit Builder program.
 * It makes the JFrame and has the main() function.
 * @author vega
 *
 */
public class LogicCircuitBuilder {
	/**
	 * The main class
	 * @param args No arguments are accepted
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable()
		{
			@Override
			public void run()
			{
				LogicCircuitBuilderFrame frame = new LogicCircuitBuilderFrame();
				frame.setSize(800, 600);
				frame.setExtendedState(Frame.MAXIMIZED_BOTH);
				frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);//closing handled by windowClosing
				frame.setVisible(true);
				frame.showInstructions();
			}
		});
	}
}
class LogicCircuitBuilderFrame extends JFrame
{
	LogicCircuitBuilderFrame()
	{
		addWindowListener(new WindowAdapter() 
		{
			@Override
			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);
				showCloseWarning();
			}
		});
		setLocationRelativeTo(null);
		setTitle("Logic Circuit Builder v1.0");
		final JMenu fileMenu = new JMenu("File");
		fileMenu.setMnemonic('F');

		JMenuItem New = fileMenu.add("New");
		New.setAccelerator(KeyStroke.getKeyStroke("ctrl N"));
		New.setMnemonic('N');
		New.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				remove(eastPanel);
				eastPanel=new CircuitPanel();
				add(eastPanel,BorderLayout.CENTER);
				validate();
			}
		});
		JMenuItem Exit = fileMenu.add("Exit");
		Exit.setMnemonic('X');
		Exit.setAccelerator(KeyStroke.getKeyStroke("ctrl X"));
		Exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				showCloseWarning();

			}
		});
		JMenu helpMenu=new JMenu("Help");
		helpMenu.setMnemonic('H');
		JMenuItem Instructions=new JMenuItem("Instructions");
		Instructions.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				showInstructions();

			}
		});
		Instructions.setMnemonic('I');
		Instructions.setAccelerator(KeyStroke.getKeyStroke("F1"));
		helpMenu.add(Instructions);
		JMenuItem About=new JMenuItem("About");
		About.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String about="Made by Abhijith V Mohan-10400EN001\n& Prakhar Jain-10400EN002\n"
						+"IDD 2nd Year, Computer Science, IT-BHU";
				JOptionPane.showMessageDialog(eastPanel,about,"About Logic Circuit Simulator v.1.0",JOptionPane.INFORMATION_MESSAGE);
			}
		});
		About.setMnemonic('A');
		helpMenu.add(About);

		JMenuBar menubar = new JMenuBar();
		setJMenuBar(menubar);		
		menubar.add(fileMenu);
		menubar.add(helpMenu);
		westPanel = new DevicePanel();
		eastPanel = new CircuitPanel();
		setLayout(new BorderLayout());
		add(westPanel, BorderLayout.WEST);
		add(eastPanel, BorderLayout.CENTER);
	}
	/**
	 * Shows the instructions Dialog Box
	 */
	public void showInstructions(){
		String instructions="-Click on device name in the left toolbar\n"+
				"-Click on Circuit Area to the right to add the device\n"+
				"-Click on input connector and connect them to output of another device\n"+
				"-Please don't make any loop structure--sequential circuits are unsupported as of now\n"+
				"-Click on Simulate after circuit is complete\n";


		JOptionPane.showMessageDialog(eastPanel,instructions,"Instructions",JOptionPane.INFORMATION_MESSAGE);
	}
	/**
	 * Shows a confirmation dialog box whether to exit
	 */
	public void showCloseWarning(){
		String message="Are you sure you want to exit?";
		int choice=JOptionPane.showConfirmDialog(eastPanel, message, "Confirm exit", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		if(choice==JOptionPane.YES_OPTION)
			System.exit(0);
	}
	JPanel westPanel, eastPanel;
}


