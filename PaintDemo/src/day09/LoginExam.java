package day09;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class LoginExam extends JFrame {

	private JPanel contentPane;
	private JTextField userid;
	private JPasswordField pw;
	private JLabel lblResult;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel;
	//추가
	private Map<String,String> map;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginExam frame = new LoginExam();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginExam() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("아이디");
		lblNewLabel.setBounds(41, 28, 43, 15);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("비밀번호");
		lblNewLabel_1.setBounds(41, 63, 59, 15);
		contentPane.add(lblNewLabel_1);
		
		userid = new JTextField();
		userid.setBounds(112, 26, 116, 18);
		contentPane.add(userid);
		userid.setColumns(10);
		
		//해쉬맵에 데이터 입력
		map = new HashMap<String, String>();
		map.put("kim", "1234");
		map.put("hyen", "ming");
		map.put("ming", "hyen");
		map.put("lee", "2222");
		
		JButton btnLogin = new JButton("로그인");
		//버튼 클릭 이벤트 구현
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = userid.getText();
				//패스워드필드.getPassword() => 문자배열
				//String.valueOf(문자배열) => 스트링으로 변환
				String pass = String.valueOf(pw.getPassword());
				String result="";
				
				if(map.get(id).equals(pass)){
					//레이블.setForeground(색상) => 전경색(글자색)
					lblResult.setForeground(Color.pink);
					result = "hyen님 환영합니다";
				}else{
					lblResult.setForeground(Color.gray);
					result = "아이디 또는 비밀번호가 일치하지 않습니다";
				}
				lblResult.setText(result); 
			}
		});
		btnLogin.setBounds(240, 28, 76, 50);
		contentPane.add(btnLogin);
		
		pw = new JPasswordField();
		pw.setBounds(112, 60, 116, 18);
		contentPane.add(pw);
		
		lblResult = new JLabel("결과 출력");
		lblResult.setBounds(51, 105, 307, 15);
		contentPane.add(lblResult);
	}
}
