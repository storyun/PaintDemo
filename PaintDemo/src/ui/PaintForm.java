package ui;

import java.awt.Dimension;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

import ui.panel.APanel;
import ui.panel.BPanel;
import ui.panel.CPanel;
import javax.swing.JMenuBar;
import java.awt.CardLayout;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JDesktopPane;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;

public class PaintForm extends JFrame implements ActionListener {
	
	private CardLayout cardLayout;
	private JPanel panel;
	
	private APanel aPanel;
	private BPanel bPanel;
	private CPanel cPanel;
	
	private JMenuItem menuItemA;
	private JMenuItem menuItemB;
	private JMenuItem menuItemC;
	private JMenuItem menuItem;
	private JMenuItem menuItem_1;
	
	public PaintForm() {
		super();
		this.setSize(new Dimension(850, 650));

		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("열기");
		mnFile.add(mntmNewMenuItem);
		
		menuItem = new JMenuItem("새 파일");
		mnFile.add(menuItem);
		
		menuItem_1 = new JMenuItem("저장하기");
		mnFile.add(menuItem_1);
		
		JMenu mnSelect = new JMenu("Select");
		menuBar.add(mnSelect);
		
		menuItemA = new JMenuItem("A");
		mnSelect.add(menuItemA);
		
		menuItemB = new JMenuItem("B");
		mnSelect.add(menuItemB);
		
		menuItemC = new JMenuItem("C");
		mnSelect.add(menuItemC);
		
		JMenu mnSimulation = new JMenu("Simulation");
		menuBar.add(mnSimulation);
		
		JMenuItem mntmPlay = new JMenuItem("Play");
		mnSimulation.add(mntmPlay);
		
		JMenuItem mntmPause = new JMenuItem("Pause");
		mnSimulation.add(mntmPause);
		
		menuItemA.addActionListener(this);
		menuItemB.addActionListener(this);
		menuItemC.addActionListener(this);
		
		cardLayout = new CardLayout(0,0);
		getContentPane().setLayout(cardLayout);
		
		aPanel = new APanel();
		bPanel = new BPanel();
		cPanel = new CPanel();
		
		getContentPane().add(aPanel, "A");
		getContentPane().add(bPanel, "B");
		getContentPane().add(cPanel, "C");
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand() == menuItemA.getText()) {
			cardLayout.show(this.getContentPane(), "A");
		}
		else if(e.getActionCommand() == menuItemB.getText()) {
			cardLayout.show(this.getContentPane(), "B");
		}
		else if(e.getActionCommand() == menuItemC.getText()) {
			cardLayout.show(this.getContentPane(), "C");
		}
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
