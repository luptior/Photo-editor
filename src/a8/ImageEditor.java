package a8;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class ImageEditor {
	public static void main(String[] args) throws IOException {
		
		Picture f = PictureImpl.readFromURL("http://screenrant.com/wp-content/uploads/Henry-Cavill-Superman.jpg");

		JFrame main_frame = new JFrame();
		main_frame.setTitle("Assignment 8 Image Editor");
		main_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ImageEditorModel model = new ImageEditorModel(f);

		ImageEditorView view = new ImageEditorView(main_frame, model);
 		ImageEditorController controller = new ImageEditorController(view, model);
		
		JPanel top_panel = new JPanel();
		top_panel.setLayout(new BorderLayout());
		top_panel.add(view, BorderLayout.CENTER);
		main_frame.setContentPane(top_panel);

		main_frame.pack();
		main_frame.setVisible(true);
	}
}