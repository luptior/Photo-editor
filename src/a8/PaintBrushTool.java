package a8;

import java.awt.event.MouseEvent;

import javax.swing.JPanel;

public class PaintBrushTool implements Tool {

	private PaintBrushToolUI ui;
	private ImageEditorModel model;
	protected static ImageEditorModel modelForColor;
	
	public PaintBrushTool(ImageEditorModel model) {
		this.model = model;
		this.modelForColor = model;
		ui = new PaintBrushToolUI();
	
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		double blendRed = (1-PaintBrushToolUI.opacity_slider.getValue()/100.0) * model.getPixel(e.getX(), e.getY()).getRed() + 
							 PaintBrushToolUI.opacity_slider.getValue()/100.0 * ui.getBrushColor().getRed() ;
		double blendGreen = (1-PaintBrushToolUI.opacity_slider.getValue()/100.0)*model.getPixel(e.getX(), e.getY()).getGreen() + 
				               PaintBrushToolUI.opacity_slider.getValue()/100.0*ui.getBrushColor().getGreen() ;
		double blendBlue = (1-PaintBrushToolUI.opacity_slider.getValue()/100.0)*model.getPixel(e.getX(), e.getY()).getBlue() + 
	               			PaintBrushToolUI.opacity_slider.getValue()/100.0*ui.getBrushColor().getBlue() ;
		Pixel blendBrushColor = new ColorPixel(blendRed,blendGreen,blendBlue);
		
		
		model.paintAt(e.getX(), e.getY(), blendBrushColor, PaintBrushToolUI.brush_slider.getValue());
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
	public void mouseDragged(MouseEvent e) {
		double blendRed = (1-PaintBrushToolUI.opacity_slider.getValue()/100.0)*model.getPixel(e.getX(), e.getY()).getRed() + 
				 				PaintBrushToolUI.opacity_slider.getValue()/100.0*ui.getBrushColor().getRed() ;
		double blendGreen = (1-PaintBrushToolUI.opacity_slider.getValue()/100.0)*model.getPixel(e.getX(), e.getY()).getGreen() + 
								PaintBrushToolUI.opacity_slider.getValue()/100.0*ui.getBrushColor().getGreen() ;
		double blendBlue = (1-PaintBrushToolUI.opacity_slider.getValue()/100.0)*model.getPixel(e.getX(), e.getY()).getBlue() + 
								PaintBrushToolUI.opacity_slider.getValue()/100.0*ui.getBrushColor().getBlue() ;
		Pixel blendBrushColor = new ColorPixel(blendRed,blendGreen,blendBlue);
		model.paintAt(e.getX(), e.getY(), blendBrushColor, PaintBrushToolUI.brush_slider.getValue());
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getName() {
		return "Paint Brush";
	}

	@Override
	public JPanel getUI() {
		return ui;
	}

}
