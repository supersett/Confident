package swingPractice;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Managing extends JFrame{

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Managing window = new Managing();
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
	
	public Managing() {
		getContentPane().setLayout(null);
		
		
		
		JPanel endPage = new JPanel();
		endPage.setBounds(0, 0, 434, 261);
		getContentPane().add(endPage);
		endPage.setLayout(null);
		
		JButton buttonBefore = new JButton("이전으로");
		buttonBefore.setBounds(325, 213, 97, 23);
		endPage.add(buttonBefore);
		buttonBefore.setVisible(true);
		
		JPanel startPage = new JPanel();
		startPage.setBounds(0, 0, 434, 261);
		getContentPane().add(startPage);
		startPage.setLayout(null);
		
		JButton buttonNext = new JButton("다음으로");
		buttonNext.setBounds(29, 209, 97, 23);
		buttonNext.setVisible(true);
		startPage.add(buttonNext);
		
		
		buttonNext.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e) {
				endPage.setVisible(true);
				startPage.setVisible(false);
			}
			
		});
		initialize();
		
		endPage.setVisible(false);
		
		buttonBefore.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				endPage.setVisible(false);
				startPage.setVisible(true);
			}
			
		});
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("로그인시스템");
		frame.setBounds(100, 100, 800, 600);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
