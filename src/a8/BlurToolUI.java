package a8;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class BlurToolUI extends JPanel implements ChangeListener {
	
	protected static JSlider BlurSize_slider;
	protected static JSlider BlurDegree_slider;
	
	public BlurToolUI(){
		setLayout(new GridLayout(0, 1));
		
		JPanel BlurSize_slider_panel = new JPanel();
		JLabel BlurSize_label = new JLabel("BlurSize:");
		BlurSize_slider_panel.setLayout(new BorderLayout());
		BlurSize_slider_panel.add(BlurSize_label, BorderLayout.WEST);
		BlurSize_slider = new JSlider(0, 10, 5);
		BlurSize_slider.addChangeListener(this);
		BlurSize_slider_panel.add(BlurSize_slider, BorderLayout.CENTER);
		
		JPanel BlurDegree_slider_panel = new JPanel();
		JLabel BlurDegree_label = new JLabel("Blur Degree:");
		BlurDegree_slider_panel.setLayout(new BorderLayout());
		BlurDegree_slider_panel.add(BlurDegree_label, BorderLayout.WEST);
		BlurDegree_slider = new JSlider(0, 5, 0);
		BlurDegree_slider.addChangeListener(this);
		BlurDegree_slider_panel.add(BlurDegree_slider, BorderLayout.CENTER);
		
		add(BlurSize_slider_panel,BorderLayout.CENTER);
		add(BlurDegree_slider_panel,BorderLayout.CENTER);
		
		stateChanged(null);
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}


