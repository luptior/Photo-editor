package a8;

import java.awt.event.MouseEvent;

import javax.swing.JPanel;

public class PixelInspectorTool implements Tool {

	private PixelInspectorUI ui;
	private ImageEditorModel model;
	
	public PixelInspectorTool(ImageEditorModel model) {
		this.model = model;
		ui = new PixelInspectorUI();
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		Picture magnifying_glass = new PictureImpl(50,50);

		for(int i =0; i < 5; i ++){
			for(int j=0; j< 5; j ++){
				for(int ii=0; ii < 10; ii++){
					for (int jj=0; jj < 10; jj++){
						magnifying_glass.setPixel(i*10+ii, j*10+jj, model.getPixel((e.getX()-2+i), (e.getY()-2)+j));
				}
				}
			}
		}
		
		PixelInspectorUI.picture_view.setPicture(magnifying_glass.createObservable());
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		try {
			ui.setInfo(e.getX(), e.getY(), model.getPixel(e.getX(), e.getY()));
		}
		catch (Exception ex) {
			// Click may have been out of bounds. Do nothing in this case.
		}
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

	@Override
	public String getName() {
		return "Pixel Inspector";
	}

	@Override
	public JPanel getUI() {
		return ui;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		try {
			ui.setInfo(e.getX(), e.getY(), model.getPixel(e.getX(), e.getY()));
		}
		catch (Exception ex) {
			// Click may have been out of bounds. Do nothing in this case.
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
