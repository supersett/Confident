package swingPractice;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/*패널... 프레임안에 넣는것!
 * 
 * 
 * 
 */

public class SwingGUIAPP {

	
	
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		JLabel label = new JLabel("some text");
		JButton btn1 = new JButton("click this");
		JButton btn2 = new JButton("Exit");
		JTextArea textArea = new JTextArea();//1줄이상
		//JTextField //1줄
		JTextField txtField = new JTextField(200); //1줄씩 받을때 사용
		
		JPanel btnPanel = new JPanel();
		
		
		btnPanel.add(btn1);
		btnPanel.add(btn2);
		//
		panel.setLayout(new BorderLayout());//원하는 위치에 놔둠
		
		panel.add(label,BorderLayout.NORTH);
		panel.add(btnPanel,BorderLayout.WEST);
		panel.add(textArea,BorderLayout.CENTER);
		//
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				label.setText(textArea.getText());
			}
		});
		
		btn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		
		
		
		//
		frame.add(panel);//프레임에 패널을 집어넣어주는 시스템
		
		
		
		
		
		
		
		
		
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setPreferredSize(new Dimension(840,840/12*9));//유지되게끔해줌
		frame.setSize(840,840/12*9);
		frame.setLocationRelativeTo(null); // 자동으로 가운데에 나타나게 되어있음

		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
	}
	
	
}

