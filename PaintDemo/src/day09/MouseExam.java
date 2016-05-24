package day09;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JApplet;

public class MouseExam extends JApplet implements MouseListener, MouseMotionListener, KeyListener{
	private int x,y;
	private Image img; //이미지객체
	private int imgWidth, imgHeight; //이미지의 가로, 세로 길이
	private Image offImage;
	private Graphics bg;
	
	public void init() { //애플릿을 초기화시키는 코드
		//이미지 객체 생성 ( 현재 실행중인 클래스와 같은 경로
		img=Toolkit.getDefaultToolkit().getImage(getClass().getResource("duke4.gif"));
		offImage = createImage(300,300);
		bg= offImage.getGraphics();
		//마우스 이벤트 기능 추가
		addMouseListener(this);
		addMouseMotionListener(this);//마우스 동작(move, 드래그)
		//키이벤트 기능 추가
		addKeyListener(this);
		setFocusable(true); //키입력을 위한 입력포커스를 받을 수 있는 기능 (포커스기능을 사용할 수 있도록 설정)
		requestFocus(); //입력포커스를 요청함 (활성화)
		setSize(300,300);// 애플릿의 화면 사이즈
	}
	
	/*@Override
	public void update(Graphics g) {
		super.update(g);
		
		bg.clearRect(0, 0, 300, 300);
		bg.drawImage(img, x, y, null);
	}*/
	
	
	@Override
	public void paint(Graphics g) {//애플릿이 화면에 출력될 때
		super.paint(g);
		imgWidth = img.getWidth(null); //이미지의 가로사이즈
		imgHeight = img.getHeight(null); //이미지의 세로사이즈
		bg.setColor(getBackground());
		bg.clearRect(0, 0, 300, 300);
		bg.drawImage(img, x, y, null);
		g.drawImage(offImage, 0, 0, null);
	}
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		//마우스를 클릭하면 MouseEvent 인스턴스가 생성되고 참고변수 e에 정보가 저장됨
		x=e.getX(); //클릭했을 때의 좌표값
		y=e.getY();
		repaint(); //그래픽 갱신
	}
	@Override
	public void mousePressed(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}

	
	@Override
	public void mouseDragged(MouseEvent e) {}
	@Override
	public void mouseMoved(MouseEvent e) {
		x = e.getX();
		y = e.getY();
		repaint();
		//마우스를 움직여도 윈도우밖으로 나가지 않도록 해보기
	}

	
	@Override
	public void keyTyped(KeyEvent e) {}
	@Override
	public void keyPressed(KeyEvent e) {
		//getKeyChar() 입력한 문자
		//getKeyCode() 문자의 코드(숫자)
		System.out.println(e.getKeyChar()+","+e.getKeyCode());
		switch(e.getKeyCode()){//입력한 key의 코드값
		case KeyEvent.VK_RIGHT://오른쪽 화살표
			x=Math.min(300-imgWidth, x+5); //x좌표 증가
			repaint(); //그래픽 갱신 요청
			break;
		case KeyEvent.VK_LEFT:
			x=Math.max(0, x-5);
			repaint();
			break;
		case KeyEvent.VK_UP:
			y=Math.max(0, y-5);
			repaint();
			break;
		case KeyEvent.VK_DOWN:
			y=Math.min(300-(imgWidth+12), y+5);
			repaint();
			break;
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {}
}