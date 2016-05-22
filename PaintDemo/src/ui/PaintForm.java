package ui;

import java.awt.Dimension;

import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

import ui.panel.APanel;
import ui.panel.BPanel;
import ui.panel.CPanel;

public class PaintForm extends JFrame implements MouseListener {
	
	private CPanel cPanel;
	
	public PaintForm() {
		super();
		this.setSize(new Dimension(2400, 600));
		getContentPane().setLayout(new GridLayout(0, 3, 0, 0));
		
		APanel panel_1 = new APanel();
		getContentPane().add(panel_1);
		
		BPanel panel_2 = new BPanel();
		getContentPane().add(panel_2);
		
		CPanel panel = new CPanel();
		getContentPane().add(panel);

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
