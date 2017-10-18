package a8;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class PictureImpl extends AnyPicture {
	
	private Pixel[][] pixels;
	
	private static final Pixel INITIAL_PIXEL = new GrayPixel(1.0);
	
	public PictureImpl(int width, int height) {
		pixels = new Pixel[width][height];
		for (int x=0; x<width; x++) {
			for (int y=0; y<height; y++) {
				pixels[x][y] = INITIAL_PIXEL;
			}
		}
	}

	@Override
	public void setPixel(int x, int y, Pixel p) {
		if (p == null) {
			throw new RuntimeException("Pixel p is null");
		}
		if (x < 0 || x >= getWidth()) {
			throw new RuntimeException("x is out of bounds");
		}
		if (y < 0 || y >= getHeight()) {
			throw new RuntimeException("y is out of bounds");
		}
		pixels[x][y] = p;
	}

	@Override
	public Pixel getPixel(int x, int y) {
		if (x < 0 || x >= getWidth()) {
			throw new RuntimeException("x is out of bounds");
		}
		if (y < 0 || y >= getHeight()) {
			throw new RuntimeException("y is out of bounds");
		}
		return pixels[x][y];
	}

	@Override
	public int getWidth() {
		return pixels.length;
	}

	@Override
	public int getHeight() {
		return pixels[0].length;
	}

	public static Picture readFromURL(String url) throws IOException {
		BufferedImage bi = ImageIO.read(new URL(url));
		Picture picture = new PictureImpl(bi.getWidth(), bi.getHeight());
		for (int x=0; x<bi.getWidth(); x++) {
			for (int y=0; y<bi.getHeight(); y++) {
				picture.setPixel(x, y, ColorPixel.rgbToPixel(bi.getRGB(x, y)));
			}
		}
		return picture;
	}

}
