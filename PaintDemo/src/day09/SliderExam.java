package day09;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SliderExam extends JFrame {

	private JPanel contentPane;
	//추가
	int red, green, blue;
	private JSlider sliderR;
	private JSlider sliderG;
	private JSlider sliderB;
	private JPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SliderExam frame = new SliderExam();
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
	
	public SliderExam() {
		//DISPOSE_ON_CLOSE 현재 프레임만 닫음
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 467, 452);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 205));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Red");
		lblNewLabel.setBounds(37, 25, 57, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Green");
		lblNewLabel_1.setBounds(37, 80, 57, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Blue");
		lblNewLabel_2.setBounds(37, 122, 57, 15);
		contentPane.add(lblNewLabel_2);
		
		panel = new JPanel();
		panel.setBounds(37, 198, 339, 173);
		contentPane.add(panel);
		
		sliderR = new JSlider();
		sliderR.setBackground(new Color(240, 255, 255));
		sliderR.setMinorTickSpacing(10);
		sliderR.setMajorTickSpacing(40);
		sliderR.setPaintLabels(true);
		sliderR.setPaintTicks(true);
		sliderR.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				red = sliderR.getValue();
				panel.setBackground(new Color(red, green, blue));
			}
		});
		sliderR.setValue(0);
		sliderR.setMaximum(255);
		sliderR.setBounds(89, 16, 287, 46);
		contentPane.add(sliderR);
		
		sliderG = new JSlider();
		sliderG.setBackground(new Color(240, 255, 255));
		sliderG.setPaintLabels(true);
		sliderG.setMinorTickSpacing(10);
		sliderG.setMajorTickSpacing(40);
		sliderG.setPaintTicks(true);
		sliderG.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				green = sliderG.getValue();
				panel.setBackground(new Color(red,green,blue));
			}
		});
		sliderG.setValue(0);
		sliderG.setMaximum(255);
		sliderG.setBounds(90, 64, 287, 56);
		contentPane.add(sliderG);
		
		sliderB = new JSlider();
		sliderB.setBackground(new Color(240, 255, 255));
		sliderB.setMajorTickSpacing(40);
		sliderB.setMinorTickSpacing(10);
		sliderB.setPaintLabels(true);
		sliderB.setPaintTicks(true);
		sliderB.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				blue = sliderB.getValue();
				panel.setBackground(new Color(red,green,blue));
			}
		});
		sliderB.setValue(0);
		sliderB.setMaximum(255);
		sliderB.setBounds(89, 112, 287, 62);
		contentPane.add(sliderB);
		
	}
}
