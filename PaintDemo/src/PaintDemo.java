import javax.swing.JFrame;


import ui.PaintForm;

public class PaintDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PaintForm pForm = new PaintForm();
		pForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pForm.setVisible(true);
		pForm.setResizable(false);
	}

}
