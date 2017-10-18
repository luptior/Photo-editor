package a8;

import java.awt.BorderLayout;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ImageEditorView extends JPanel {

	private JFrame main_frame;
	static PictureView frame_view;
	private ImageEditorModel model;
	private ToolChooserWidget chooser_widget;
	protected static JButton choosePic;
	protected static JTextField urlPic;
	private JPanel tool_ui_panel;
	private JPanel edit_ui_panel;
	private JPanel tool_ui;
	
	public ImageEditorView(JFrame main_frame, ImageEditorModel model) {
		this.main_frame = main_frame;
		
		setLayout(new BorderLayout());
		
		frame_view = new PictureView(model.getCurrent());
		
		add(frame_view, BorderLayout.CENTER);
		
		edit_ui_panel = new JPanel();
		edit_ui_panel.setLayout(new BorderLayout());
		
		JPanel choose = new JPanel();
		choosePic = new JButton("choose picture");
		urlPic = new JTextField(20);
		choose.add(urlPic, BorderLayout.WEST);
		choose.add(choosePic, BorderLayout.CENTER);
		
		tool_ui_panel = new JPanel();
		tool_ui_panel.setLayout(new BorderLayout());
		
		chooser_widget = new ToolChooserWidget();
		tool_ui_panel.add(chooser_widget, BorderLayout.NORTH);
		edit_ui_panel.add(choose,BorderLayout.NORTH);
		edit_ui_panel.add(tool_ui_panel, BorderLayout.SOUTH);
		
		add(edit_ui_panel,BorderLayout.SOUTH);
		
		tool_ui = null;
	}

	public void addToolChoiceListener(ToolChoiceListener l) {
		chooser_widget.addToolChoiceListener(l);
	}
	
	public String getCurrentToolName() {
		return chooser_widget.getCurrentToolName();
	}

	public void installToolUI(JPanel ui) {
		if (tool_ui != null) {
			tool_ui_panel.remove(tool_ui);
		}
		tool_ui = ui;
		tool_ui_panel.add(tool_ui, BorderLayout.CENTER);
		validate();
		main_frame.pack();
	}
	
	@Override
	public void addMouseMotionListener(MouseMotionListener l) {
		frame_view.addMouseMotionListener(l);
	}
	
	@Override
	public void removeMouseMotionListener(MouseMotionListener l) {
		frame_view.removeMouseMotionListener(l);
	}

	@Override
	public void addMouseListener(MouseListener l) {
		frame_view.addMouseListener(l);
	}
	
	public void removeMouseListener(MouseListener l) {
		frame_view.removeMouseListener(l);
	}
	

}
