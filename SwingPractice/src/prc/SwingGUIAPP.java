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

/*�г�... �����Ӿȿ� �ִ°�!
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
		JTextArea textArea = new JTextArea();//1���̻�
		//JTextField //1��
		JTextField txtField = new JTextField(200); //1�پ� ������ ���
		
		JPanel btnPanel = new JPanel();
		
		
		btnPanel.add(btn1);
		btnPanel.add(btn2);
		//
		panel.setLayout(new BorderLayout());//���ϴ� ��ġ�� ����
		
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
		frame.add(panel);//�����ӿ� �г��� ����־��ִ� �ý���
		
		
		
		
		
		
		
		
		
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setPreferredSize(new Dimension(840,840/12*9));//�����ǰԲ�����
		frame.setSize(840,840/12*9);
		frame.setLocationRelativeTo(null); // �ڵ����� ����� ��Ÿ���� �Ǿ�����

		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
	}
	
	
}

