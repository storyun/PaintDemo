package day09;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

// Canvas - 그래픽 작업이 가능한 컴포넌트
// 클래스 추가
class BallCanvas extends Canvas{
	//변수
	private int x,y;
	private int mx=2, my=3;
	private int width, height; //화면 사이즈를 저장할 변수
	private Image offImage; //백그라운드 영역(버퍼) - 그래픽영역에 출력할 이미지를 미리 만들어 놓을 변수
	private Graphics bg; //백그라운드 영역에 그래픽 출력 객체
	
	//생성자
	public BallCanvas(){
		//백그라운드 스레드 추가(좌표값 변경)
		//new Thread(run method를 구현한 객체)
		Thread th=new Thread(new Runnable() {
			@Override
			public void run() {
				while(true){
					x = x+mx; //x좌표값 변경
					y = y+my; //y좌표값 변경
					if( x > (width-20)|| x<0){ //좌우 벽처리
						mx = -mx; //x축 이동 방향 바꾸기
					}
					if( y > (height-20) || y<0){ //상하 벽처리
						my = -my; //y축 이동 방향 바꾸기
					}
					repaint(); //그래픽 갱신 요청 => paint()가 호출됨
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		th.start(); //백그라운드 스레드가 run method를 실행
	}
	
	//화면이 변경되기 전에 실행
	//repaint() => update() => paint()
	@Override
	public void update(Graphics g) {
		super.update(g);
		//백그라운드 그래픽 처리를 위한 버퍼 생성
		if(offImage == null){
			offImage = createImage(width, height);
			//버퍼에 그래픽 처리를 하기 위한 Graphics 객체 생성
			bg = offImage.getGraphics();
		}
		//백그라운드 버퍼에 그래픽 출력
		bg.clearRect(0, 0, width, height);//화면 지우기
		bg.setColor(Color.pink);
		//원 그리기(x좌표, y좌표, 가로길이, 세로길이)
		bg.fillOval(x, y, 20, 20);
	}
	
	//paint method
	public void paint(Graphics g) {
		//현재 실행중인 프레임의 가로, 세로 사이즈
		width = getWidth();
		height = getHeight();
		g.setColor(Color.pink);
		/*원 그리기 (x좌표, y좌표, 가로길이, 세로길이)
		g.fillOval(x,y,20,20);*/
		
		/*백그라운드 이미지를 메인UI에 복사함
		drawImage(이미지, x좌표, y좌표, 이미지관찰자객체) - 이미지관찰자는 이미지 회전, resize등의 작업을 할 경우에만 필요함*/
		g.drawImage(offImage, 0, 0, null);
	}
}

public class CanvasExam extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CanvasExam frame = new CanvasExam();
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
	public CanvasExam() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		//프레임에 캔버스 추가
		BallCanvas canvas = new BallCanvas();
		contentPane.add(canvas);
		
		
	}

}
