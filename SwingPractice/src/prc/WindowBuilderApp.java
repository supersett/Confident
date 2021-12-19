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

//컴퍼넌트(Component)에서 발생된 이벤트(Event)에 대한 처리 방법
//1.컴퍼넌트에서는 다양한 이벤트 발생 - XXXEvent 인스턴스 생성(XXX : 이벤트명)
// => ex)JButton 컴퍼넌트를 누르거나 JTextField에서 Enter를 입력하면 ActionEvent 발생
//2.이벤트를 처리하기 위한 클래스(EventHandler 클래스) 선언
// => XXXEvent를 처리하기 위한 클래스는 XXXListener 인터페이스(XXXAdapter 클래스)를 상속받아 작성
// => ex)ActionEvent를 처리하기 위해서는 ActionListener 인터페이스를 상속받은 이벤트 처리 클래스 작성
// => 이벤트 처리 클래스는 XXXListener 인터페이스의 추상메소드를 오버라이드 선언 >> 이벤트 처리 메소드(이벤트 발생시 자동 호출)
//3.컴퍼넌트에서 이벤트가 발생될 경우 이벤트 처리 메소드가 호출되도록 이벤트 핸들러 클래스를 인스턴스로 등록
// => Component.addXXXListener(Listener listener) 메소드를 이용하여 컴퍼넌트의 이벤트 핸들러 등록

public class WindowBuilderApp extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	//이벤트 처리 메소드에서 사용될 컴퍼넌트를 저장하는 참조변수는 필드로 선언하여 사용
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
		red.setFont(new Font("나눔고딕코딩", Font.BOLD, 16));
		panel.add(red);
		
		green = new JButton("\uCD08\uB85D\uC0C9");
		green.setForeground(Color.GREEN);
		green.setFont(new Font("나눔고딕코딩", Font.BOLD, 16));
		panel.add(green);
		
		blue = new JButton("\uD30C\uB780\uC0C9");
		blue.setForeground(Color.BLUE);
		blue.setFont(new Font("나눔고딕코딩", Font.BOLD, 16));
		panel.add(blue);
		
		black = new JButton("\uAC80\uC815\uC0C9");
		black.setForeground(Color.BLACK);
		black.setFont(new Font("나눔고딕코딩", Font.BOLD, 16));
		panel.add(black);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		area = new JTextArea();
		area.setFocusable(false);
		area.setFont(new Font("나눔고딕코딩", Font.BOLD, 18));
		scrollPane.setViewportView(area);
		
		field = new JTextField();
		field.setFont(new Font("나눔고딕코딩", Font.BOLD, 18));
		contentPane.add(field, BorderLayout.SOUTH);
		field.setColumns(10);
		
		//컴퍼넌트에 ActionEvent가 발생될 경우 현재 사용중인 인스턴스의 선언된 actionPerformed() 
		//이벤트 처리 메소드 자동 호출 - 이벤트 핸들러 등록
		red.addActionListener(this);
		green.addActionListener(this);
		blue.addActionListener(this);
		black.addActionListener(this);
		field.addActionListener(this);
		
		//Component.setEnabled(boolean b) : 컴퍼넌트의 활성 또는 비활성화 처리
		// => false : 비활성화, true : 활성화
		black.setEnabled(false);
	}

	//ActionListener 인터페이스에 선언된 추상메소드
	// => 컴퍼넌트에서 ActionEvent가 발생될 경우 자동 호출
	// => ActionEvent 관련 정보는 자동으로 매개변수에 저장
	@Override
	public void actionPerformed(ActionEvent e) {
		//ActionEvent.getSource() : 이벤트가 발생된 Component 인스턴스를 반환하는 메소드
		// => Object 타입의 자료형으로 반환
		Object component=e.getSource();
		
		//모두 버튼에 대한 활성화 처리
		red.setEnabled(true);
		green.setEnabled(true);
		blue.setEnabled(true);
		black.setEnabled(true);
		
		//이벤트가 발생된 버튼만 비활성화 처리 - 명시적 객체 형변환 후 메소드 호출
		if(component instanceof JButton) {
			((JButton)component).setEnabled(false);
		}
		
		//컴퍼넌트와 이벤트가 발생된 컴퍼넌트를 비교하여 이벤트 처리
		if(component==red) {
			area.setForeground(Color.RED);
		} else if(component==green) {
			area.setForeground(Color.GREEN);
		} else if(component==blue) {
			area.setForeground(Color.BLUE);
		} else if(component==black) {
			area.setForeground(Color.BLACK);
		} else if(component==field) {
			//JTextField.getText() : JTextField 컴퍼넌트의 입력값을 반환하는 메소드
			String text=field.getText();
			
			if(!text.equals("")) {
				//JTextArea.append(String text) : JTextArea 컴퍼넌트에 문자열을 추가하는 메소드
				area.append("[홍길동]"+text+"\n");
				//JTextField.setText(String s) : JTextField 컴퍼넌트의 입력값을 변경하는 메소드
				field.setText("");
			}
		}
	}
}













