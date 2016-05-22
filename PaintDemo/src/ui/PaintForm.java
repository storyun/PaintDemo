package ui;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

import ui.panel.CPanel;

import java.awt.CardLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class PaintForm extends JFrame implements MouseListener {
	
	private CPanel cPanel;
	
	public PaintForm() {
		super();
		this.setSize(new Dimension(850, 650));
		getContentPane().setLayout(new CardLayout(0, 0));
	
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
