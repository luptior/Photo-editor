package a8;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class PixelInspectorUI extends JPanel implements ActionListener,MouseListener{

	private JLabel x_label;
	private JLabel y_label;
	private JLabel pixel_info;
	private JButton getColor_button;
	private Pixel colorStore;
	protected static PictureView picture_view;
	protected static Pixel colorForBrush;
	protected static boolean ifUseChosenColor;
	
	public PixelInspectorUI() {
		x_label = new JLabel("X: ");
		y_label = new JLabel("Y: ");
		pixel_info = new JLabel("(r,g,b)");
		getColor_button = new JButton("Get Color");
		getColor_button.addActionListener(this);

		ifUseChosenColor = false;
		
		JPanel index = new JPanel();
		index.setLayout(new GridLayout(4,1));
		index.add(x_label);
		index.add(y_label);
		index.add(pixel_info);
		index.add(getColor_button);
		
		add(index, BorderLayout.WEST);
		
		picture_view = new PictureView(new ObservablePictureImpl(new PictureImpl(50,50)));
		picture_view.setPreferredSize(new Dimension(50,50));
		add(picture_view, BorderLayout.EAST);
		picture_view.addMouseListener(this);
	}
	
	public void setInfo(int x, int y, Pixel p) {
		colorStore = p;
		x_label.setText("X: " + x);
		y_label.setText("Y: " + y);
		pixel_info.setText(String.format("(%3.2f, %3.2f, %3.2f)", p.getRed(), p.getBlue(), p.getGreen()));		
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		try{
			colorForBrush = colorStore;
			ifUseChosenColor = true;
		}catch(RuntimeException e1){
			throw new RuntimeException("No pixel selected.");
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		
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
