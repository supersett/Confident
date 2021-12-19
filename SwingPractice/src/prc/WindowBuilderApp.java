package swingPractice;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

//���۳�Ʈ(Component)���� �߻��� �̺�Ʈ(Event)�� ���� ó�� ���
//1.���۳�Ʈ������ �پ��� �̺�Ʈ �߻� - XXXEvent �ν��Ͻ� ����(XXX : �̺�Ʈ��)
// => ex)JButton ���۳�Ʈ�� �����ų� JTextField���� Enter�� �Է��ϸ� ActionEvent �߻�
//2.�̺�Ʈ�� ó���ϱ� ���� Ŭ����(EventHandler Ŭ����) ����
// => XXXEvent�� ó���ϱ� ���� Ŭ������ XXXListener �������̽�(XXXAdapter Ŭ����)�� ��ӹ޾� �ۼ�
// => ex)ActionEvent�� ó���ϱ� ���ؼ��� ActionListener �������̽��� ��ӹ��� �̺�Ʈ ó�� Ŭ���� �ۼ�
// => �̺�Ʈ ó�� Ŭ������ XXXListener �������̽��� �߻�޼ҵ带 �������̵� ���� >> �̺�Ʈ ó�� �޼ҵ�(�̺�Ʈ �߻��� �ڵ� ȣ��)
//3.���۳�Ʈ���� �̺�Ʈ�� �߻��� ��� �̺�Ʈ ó�� �޼ҵ尡 ȣ��ǵ��� �̺�Ʈ �ڵ鷯 Ŭ������ �ν��Ͻ��� ���
// => Component.addXXXListener(Listener listener) �޼ҵ带 �̿��Ͽ� ���۳�Ʈ�� �̺�Ʈ �ڵ鷯 ���

public class WindowBuilderApp extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	//�̺�Ʈ ó�� �޼ҵ忡�� ���� ���۳�Ʈ�� �����ϴ� ���������� �ʵ�� �����Ͽ� ���
	private JButton red;
	private JButton green;
	private JButton blue;
	private JButton black;
	private JTextArea area;
	private JTextField field;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WindowBuilderApp frame = new WindowBuilderApp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public WindowBuilderApp() {
		setTitle("WindowBuilder");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		red = new JButton("\uBE68\uAC04\uC0C9");
		red.setForeground(Color.RED);
		red.setFont(new Font("��������ڵ�", Font.BOLD, 16));
		panel.add(red);
		
		green = new JButton("\uCD08\uB85D\uC0C9");
		green.setForeground(Color.GREEN);
		green.setFont(new Font("��������ڵ�", Font.BOLD, 16));
		panel.add(green);
		
		blue = new JButton("\uD30C\uB780\uC0C9");
		blue.setForeground(Color.BLUE);
		blue.setFont(new Font("��������ڵ�", Font.BOLD, 16));
		panel.add(blue);
		
		black = new JButton("\uAC80\uC815\uC0C9");
		black.setForeground(Color.BLACK);
		black.setFont(new Font("��������ڵ�", Font.BOLD, 16));
		panel.add(black);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		area = new JTextArea();
		area.setFocusable(false);
		area.setFont(new Font("��������ڵ�", Font.BOLD, 18));
		scrollPane.setViewportView(area);
		
		field = new JTextField();
		field.setFont(new Font("��������ڵ�", Font.BOLD, 18));
		contentPane.add(field, BorderLayout.SOUTH);
		field.setColumns(10);
		
		//���۳�Ʈ�� ActionEvent�� �߻��� ��� ���� ������� �ν��Ͻ��� ����� actionPerformed() 
		//�̺�Ʈ ó�� �޼ҵ� �ڵ� ȣ�� - �̺�Ʈ �ڵ鷯 ���
		red.addActionListener(this);
		green.addActionListener(this);
		blue.addActionListener(this);
		black.addActionListener(this);
		field.addActionListener(this);
		
		//Component.setEnabled(boolean b) : ���۳�Ʈ�� Ȱ�� �Ǵ� ��Ȱ��ȭ ó��
		// => false : ��Ȱ��ȭ, true : Ȱ��ȭ
		black.setEnabled(false);
	}

	//ActionListener �������̽��� ����� �߻�޼ҵ�
	// => ���۳�Ʈ���� ActionEvent�� �߻��� ��� �ڵ� ȣ��
	// => ActionEvent ���� ������ �ڵ����� �Ű������� ����
	@Override
	public void actionPerformed(ActionEvent e) {
		//ActionEvent.getSource() : �̺�Ʈ�� �߻��� Component �ν��Ͻ��� ��ȯ�ϴ� �޼ҵ�
		// => Object Ÿ���� �ڷ������� ��ȯ
		Object component=e.getSource();
		
		//��� ��ư�� ���� Ȱ��ȭ ó��
		red.setEnabled(true);
		green.setEnabled(true);
		blue.setEnabled(true);
		black.setEnabled(true);
		
		//�̺�Ʈ�� �߻��� ��ư�� ��Ȱ��ȭ ó�� - ����� ��ü ����ȯ �� �޼ҵ� ȣ��
		if(component instanceof JButton) {
			((JButton)component).setEnabled(false);
		}
		
		//���۳�Ʈ�� �̺�Ʈ�� �߻��� ���۳�Ʈ�� ���Ͽ� �̺�Ʈ ó��
		if(component==red) {
			area.setForeground(Color.RED);
		} else if(component==green) {
			area.setForeground(Color.GREEN);
		} else if(component==blue) {
			area.setForeground(Color.BLUE);
		} else if(component==black) {
			area.setForeground(Color.BLACK);
		} else if(component==field) {
			//JTextField.getText() : JTextField ���۳�Ʈ�� �Է°��� ��ȯ�ϴ� �޼ҵ�
			String text=field.getText();
			
			if(!text.equals("")) {
				//JTextArea.append(String text) : JTextArea ���۳�Ʈ�� ���ڿ��� �߰��ϴ� �޼ҵ�
				area.append("[ȫ�浿]"+text+"\n");
				//JTextField.setText(String s) : JTextField ���۳�Ʈ�� �Է°��� �����ϴ� �޼ҵ�
				field.setText("");
			}
		}
	}
}













