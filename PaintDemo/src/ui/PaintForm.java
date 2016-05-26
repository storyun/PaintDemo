package ui;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

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
import javax.swing.JFileChooser;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JPopupMenu;

import model.Shape;
import model.ShapeList;

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
	private JMenuItem mntmOpen;
	private JMenuItem mntmNewFile;
	private JMenuItem mntmSave;
	
	private JFileChooser fileChooser;
	
	private ShapeList shapeList;
	
	public PaintForm() {
		super();
		this.setSize(new Dimension(850, 650));

		// 변수 초기화
		shapeList = new ShapeList();
		
		// UI구성
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		mntmOpen = new JMenuItem("열기");
		mnFile.add(mntmOpen);
		
		mntmNewFile = new JMenuItem("새 파일");
		mnFile.add(mntmNewFile);
		
		mntmSave = new JMenuItem("저장하기");
		mnFile.add(mntmSave);
		
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
		
		mntmOpen.addActionListener(this);
		mntmNewFile.addActionListener(this);
		mntmSave.addActionListener(this);
		
		
		cardLayout = new CardLayout(0,0);
		getContentPane().setLayout(cardLayout);
		
		aPanel = new APanel();
		bPanel = new BPanel();
		cPanel = new CPanel(shapeList);
		
		getContentPane().add(aPanel, "A");
		getContentPane().add(bPanel, "B");
		getContentPane().add(cPanel, "C");
		
		fileChooser = new JFileChooser();
		
		
		cardLayout.show(this.getContentPane(), "C");
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
		else if(e.getActionCommand() == mntmSave.getText()) {
			if( fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
				String path = "";
				path = fileChooser.getSelectedFile().toString();
				// 파일 저장함수 추가
				outfile(path,shapeList);
				cPanel.canvasRepaint();
			}
		}
		else if(e.getActionCommand() == mntmOpen.getText()) {
			if( fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
				String path = "";
				path = fileChooser.getSelectedFile().toString();
				// 파일 오픈 함수 추가 
				shapeList = getfile(path);

				cPanel.canvasRepaint();
			}
		}
		else if(e.getActionCommand() == mntmNewFile.getText()) {
			shapeList.clear();
			
			cPanel.canvasRepaint();
		}
	}
	
	
	public void outfile(String path, ShapeList sl)
	{
		try {
			FileOutputStream fin = new FileOutputStream(path);
			BufferedOutputStream bin = new BufferedOutputStream(fin);
			ObjectOutputStream oin = new ObjectOutputStream(bin);
			
			oin.writeObject(sl);
			
			oin.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ShapeList getfile(String path)
	{
		ShapeList sl = new ShapeList();
		try {
			FileInputStream fin = new FileInputStream(path);
			BufferedInputStream bin = new BufferedInputStream(fin);
			ObjectInputStream oin = new ObjectInputStream(bin);
			
			sl = (ShapeList)oin.readObject();
			
			System.out.println(sl.get(1));
			oin.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sl;
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
