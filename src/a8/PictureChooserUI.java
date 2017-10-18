package a8;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class PictureChooserUI implements ActionListener{
	
	protected static Picture p;
	
	public PictureChooserUI(){
		JButton choosePic = new JButton("choose picture");
		choosePic.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
