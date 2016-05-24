package day09;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
//JTable에 데이터를 넣을 때는 제목은 일차원배열, 내용은 이차원배열로 해야 한다.
public class TableExam extends JFrame {

	private JPanel contentPane;
	private JTable table;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TableExam frame = new TableExam();
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
	public TableExam() {
		setTitle("JTable Test");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		//테이블 구성
		//표의 타이틀행(1차원 배열로 정의)
		String[] title={"번호","이름","입사일자"};
		//표의 데이터(2차원 배열로 정의)
		/*String[][] data={
				{"1","kim","2015-01-01"},
				{"2","park","2016-01-01"},
				{"3","hyen","2016-02-01"}
		};*/
		String[][] data = new String[9][3]; //10행 3열의 2차원 배열
		List<Employee> list = new ArrayList<Employee>();
		for(int i=1;i<=9;i++){
			list.add(new Employee(String.valueOf(i), "hyen"+i, "2013-03-0"+i));			
		}
		for(int i=0;i<list.size();i++){
			Employee emp = list.get(i);
			data[i][0]=emp.getNum();
			data[i][1]=emp.getName();
			data[i][2]=emp.getDate();
		}
		table = new JTable(data,title);//내용, 타이틀
		scrollPane.setViewportView(table);
	}

}
