package a8;

public class ImageEditorModel {

	private Picture original;
	private ObservablePicture current;
	protected static boolean useOwnPicture = false;
	
	public ImageEditorModel(Picture p) {
		if(useOwnPicture){
			original = ImageEditorController.f;
		}else{original = p;}
			current = original.copy().createObservable();
	}

	public ObservablePicture getCurrent() {
		return current;
	}

	public Pixel getPixel(int x, int y) {
		return current.getPixel(x, y);
	}

	public void paintAt(int x, int y, Pixel brushColor, int brush_size) {
		current.suspendObservable();
		
		for (int xpos=x-brush_size+1; xpos <=x+brush_size-1; xpos++) {
			for (int ypos=y-brush_size+1; ypos <=y+brush_size-1; ypos++) {
				if (xpos >= 0 &&
					xpos < current.getWidth() &&
					ypos >= 0 &&
					ypos < current.getHeight()) {
					current.setPixel(xpos, ypos, brushColor);
				}
			}
		}
		current.resumeObservable();
	}
	
	public void blurAt(int x, int y, int blur_size, int blur_degree) {
		current.suspendObservable();
		
		Picture forBlur = Blur(original.extract(x-blur_size, y-blur_size, blur_size*2, blur_size*2),blur_degree);
		
		for (int xpos=x-blur_size+1; xpos <=x+blur_size-1; xpos++) {
			for (int ypos=y-blur_size+1; ypos <=y+blur_size-1; ypos++) {
				if (xpos >= 0 &&
					xpos < current.getWidth() &&
					ypos >= 0 &&
					ypos < current.getHeight()) {
					current.setPixel(xpos, ypos, forBlur.getPixel(xpos-(x-blur_size+1), ypos-(y-blur_size+1)));
				}
			}
		}
		current.resumeObservable();
	}
	
	public Picture Blur(Picture p, int d) {

		if (d == 0) {
			return p;
		} else {

			Picture Blured = new PictureImpl(p.getWidth(), p.getHeight());

			for (int i = 0; i < p.getWidth(); i++) {
				for (int j = 0; j < p.getHeight(); j++) {

					int east = Math.max(i - d, 0);
					int west = Math.min(i + d, p.getWidth());
					int north = Math.max(j - d, 0);
					int south = Math.min(j + d, p.getHeight());

					double redT = 0, greenT = 0, blueT = 0, counter = 0;

					for (int ii = east; ii < west; ii++) {
						for (int jj = north; jj < south; jj++) {
							redT = redT + p.getPixel(ii, jj).getRed();
							greenT = greenT + p.getPixel(ii, jj).getGreen();
							blueT = blueT + p.getPixel(ii, jj).getBlue();
							counter++;
						}
					}

					double r = redT / counter;
					double g = greenT / counter;
					double b = blueT / counter;
					Pixel newP = new ColorPixel(r, g, b);

					Blured.setPixel(i, j, newP);
				}
			}
			return Blured;
		}
	}
}
