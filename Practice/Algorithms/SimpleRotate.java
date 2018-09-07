import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

//SimpleRotate.java
//Allen Liu
//September 6, 2018
//A test for a naive approach at image rotation
public class SimpleRotate {

	public static void main(String[] args) throws IOException {
		File input = new File("Algorithms/input.png");
		File output = new File("Algorithms/output.png");
		
		BufferedImage image = ImageIO.read(input);
		int width = image.getWidth();
		int height = image.getHeight();
		int centerX = width / 2;
		int centerY = height / 2;
		//Output
		BufferedImage newImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		
		double theta = 45 * (Math.PI / 180);
		
		for (int y = 0; y < height; ++y) {
			for (int x = 0; x < width; ++x) {
				//Set rotation point to center
				int transX = x - centerX;
				int transY = y - centerY;
				//Rotates
				int newX = (int) (transX * Math.cos(theta) - transY * Math.sin(theta)) + centerX;
				int newY = (int) (transX * Math.sin(theta) + transY * Math.cos(theta)) + centerY;
				try {
					newImage.setRGB(newX, newY, image.getRGB(x, y));
				} catch (Exception e) {
				}
			}
		}
		
		ImageIO.write(newImage, "png", output);
	}

}
