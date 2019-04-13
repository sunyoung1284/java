package kopoAwtProject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class mainView {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainView window = new mainView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public mainView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnRegionMasterView = new JButton("\uC9C0\uC5ED\uC124\uC815");
		btnRegionMasterView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				regionMgmtView regionView = new regionMgmtView();
				regionView.rgView();
			}
		});
		btnRegionMasterView.setBounds(146, 113, 157, 27);
		frame.getContentPane().add(btnRegionMasterView);
		
		JButton btnSelloutView = new JButton("\uD310\uB9E4\uB7C9 \uC124\uC815");
		btnSelloutView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selloutMgmtView selloutView = new selloutMgmtView();
				selloutView.selloutView();
				
			}
		});
		btnSelloutView.setBounds(146, 175, 157, 27);
		frame.getContentPane().add(btnSelloutView);
	}

}
