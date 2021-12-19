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
		JPasswordField txtPass = new JPasswordField(10); //암호화되서 보임
		//
		JButton logBtn = new JButton("로그인");
		
		
		
		
		
		//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
		panel.add(label);
		panel.add(txtId);
		
		panel.add(pswrd);
		panel.add(txtPass);
		panel.add(logBtn);
		
		add(panel);
		
		//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
		// 액션
		logBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String id = "admin";
				String pass = "1234";
				
				if(id.equals(txtId.getText()) && pass.equals(txtPass.getText())) {
					JOptionPane.showMessageDialog(null, "로그인 성공");
				}else {
					JOptionPane.showMessageDialog(null, "로그인 실패\n올바른 아이디와 패스워드를 입력해주세요.");
					
				}
			}
		});
		
		
		//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
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
