package swingPractice;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PracticeBeforeAfter {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PracticeBeforeAfter window = new PracticeBeforeAfter();
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
	public PracticeBeforeAfter() {
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
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 261);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnNext = new JButton("\uB2E4\uC74C");
		
		btnNext.setBounds(29, 207, 97, 23);
		panel.add(btnNext);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 434, 261);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnBefore = new JButton("\uC774\uC804");
		
		btnBefore.setBounds(325, 207, 97, 23);
		panel_1.add(btnBefore);
		
		
		panel.setVisible(true);
		panel_1.setVisible(false);
		
		btnBefore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_1.setVisible(false);
				panel.setVisible(true);
				
			}
		});
		
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_1.setVisible(true);
				panel.setVisible(false);
			}
		});
		
		
		
		
	}
}
