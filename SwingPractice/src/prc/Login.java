package swingPractice;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame{

	public Login() {
		JPanel panel = new JPanel();
		JLabel label = new JLabel("ID :  ");
		JLabel pswrd = new JLabel("PASSWORD :  ");
		
		JTextField txtId = new JTextField(10);
		JPasswordField txtPass = new JPasswordField(10); //��ȣȭ�Ǽ� ����
		//
		JButton logBtn = new JButton("�α���");
		
		
		
		
		
		//�ѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤ�
		panel.add(label);
		panel.add(txtId);
		
		panel.add(pswrd);
		panel.add(txtPass);
		panel.add(logBtn);
		
		add(panel);
		
		//�ѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤ�
		// �׼�
		logBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String id = "admin";
				String pass = "1234";
				
				if(id.equals(txtId.getText()) && pass.equals(txtPass.getText())) {
					JOptionPane.showMessageDialog(null, "�α��� ����");
				}else {
					JOptionPane.showMessageDialog(null, "�α��� ����\n�ùٸ� ���̵�� �н����带 �Է����ּ���.");
					
				}
			}
		});
		
		
		//�ѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤ�
		setVisible(true);
		setSize(600,400);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		
		
	}
	
	public static void main(String[] args) {
		new Login();
	}
	
	
	
}
