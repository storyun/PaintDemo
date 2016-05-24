package day09;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
//항상 DafaultListModel에서의 기존 데이터 부터 갱신하고 JList를 갱신해준다.
//스크롤바를 이용할 때는 스크롤페인부터 붙이고, JList를 만든다. (view port에 붙여야 함)
public class ListExam extends JFrame {

	private JPanel contentPane;
	private JTextField tf;
	//변수 추가 - JList에 연결시킬 데이터 리스트(모델)
	//DefaultListModel : JList에 좀더 쉽게 데이터(배열)를 입력할 수 있게 도와주는 클래스 
	private DefaultListModel model;
	private JList list;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListExam frame = new ListExam();
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
	public ListExam() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		tf = new JTextField();
		//텍스트필드에 액션이벤트 추가 (앤터키 입력)
		tf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tf.getText().trim().equals("")){
					JOptionPane.showMessageDialog(ListExam.this, "텍스트를 입력하세요");
				}else{
					model.addElement(tf.getText());
				}
				list.setModel(model);
				tf.setText("");
				tf.requestFocus();
			}
		});
		panel.add(tf);
		tf.setColumns(10);
		
		JButton btnAdd = new JButton("추가");
		//버튼 클릭 이벤트 처리
		btnAdd.addActionListener(new ActionListener() {
			//버튼을 누르면 actionPerformed()가 자동으로 호출됨
			public void actionPerformed(ActionEvent e) {
				//TextField에 입력한 텍스트를 읽어서 모델에 추가
				if(tf.getText().trim().equals("")){
					JOptionPane.showMessageDialog(ListExam.this, "텍스트를 입력하세요");
				}else{
					model.addElement(tf.getText());
				}
				//모델을 이용하여 JList를 업데이트시킴
				list.setModel(model);
				tf.setText("");//텍스트 클리어
				//TextField에 입력포커스 이동
				tf.requestFocus();
			}
		});
		panel.add(btnAdd);
		
		JButton btnDelete = new JButton("삭제");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index=list.getSelectedIndex(); //JList에서 선택한 항목의 인덱스 (0부터)
				if(index != -1){ //선택한 항목이 없으면 -1
					model.remove(index); //데이터모델에서 삭제
					list.setModel(model); //데이터모델을 이용하여 JList를 갱신
				}
			}
		});
		panel.add(btnDelete);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		
		//리스트모델 생성
		model = new DefaultListModel<String>();
		//리스트에 데이터 추가
		model.addElement("서울");
		model.addElement("부산");
		model.addElement("인천");
		model.addElement("수원");
		
		list = new JList(model);
		//ScrollPane의 view port 영역에 JList를 배치
		scrollPane.setViewportView(list);
		
	}

}
