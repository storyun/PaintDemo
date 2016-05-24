package day09;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.border.EmptyBorder;

public class TreeExam extends JFrame {

	private JPanel contentPane;
	private JTree tree;
	//추가
	//1단계 노드 정의
	Object[] obj={"프로그램","시스템","디자인"};
	//0번 노드 교체
	Vector<Vector> node1=new Vector<Vector>(){
		public String toString() {
			return "Lesson";
		}
	};
	// Lesson의 하위 노드
	Vector<String> node2=new Vector<String>(){
		public String toString(){
			return "JAVA";
		}
	};
	Vector<String> node3=new Vector<String>(){
		public String toString(){
			return "Web";
		}
	};
	
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TreeExam frame = new TreeExam();
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
	public TreeExam() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		//트리의 데이터 구성
		node1.add(node2); //노드1에 node2 추가
		node1.add(node3);
		node2.add("C++"); //노드2에 C++추가
		node2.add("JAVA");
		node2.add("JSP");
		node3.add("XML");
		node3.add("CSS");
		// 프로그램 노드를 교체
		obj[0]=node1; //node1을 root node로 설정
		
		tree = new JTree(obj); //트리의 데이터 설정
		//트리의 루트 노드를 표시
		tree.setRootVisible(true);
		//ScrollPane의 view port 영역에 JTree를 붙임
		scrollPane.setViewportView(tree);
	}

}
