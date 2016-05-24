package day09;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JProgressBar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ProgressExam extends JFrame {

	private JPanel contentPane;
	private JProgressBar progress;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProgressExam frame = new ProgressExam();
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
	public ProgressExam() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null); //절대좌표
		
		progress = new JProgressBar();
		//진행률 기본값
		progress.setValue(0);
		//진행률을 숫자로 표시
		progress.setStringPainted(true);
		progress.setBounds(32, 20, 221, 36);
		contentPane.add(progress);
		
		JButton btnStart = new JButton("시작");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/* 싱글스레드를 쓰면 안되는 이유.
				 * for(int i=0;i<=100;i++){
					//프로그레스바의 진행률 변경
					progress.setValue(i);
					try {
						Thread.sleep(20);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
				}
				메인스레드와 프로그레스스레드는 공존할 수 없다.
				실행을 시키면 메인스레드가 동작하고 있을 때 프로그레스스레드는 rock이 걸려있다가 메인스레드가 실행이끝나면 한번에 동작한다.
				*/
				
				Thread th = new Thread(new Runnable() {
					@Override
					public void run() {
						for(int i=0;i<=100;i++){
							//프로그레스바의 진행률 변경
							progress.setValue(i);
							try {
								Thread.sleep(20);
							} catch (InterruptedException e1) {
								e1.printStackTrace();
							}
						}
						JOptionPane.showMessageDialog(null, "완료되었습니다.");
					}
				});
				th.start();
			}
		});
		btnStart.setBounds(287, 20, 97, 36);
		contentPane.add(btnStart);
	}
}
