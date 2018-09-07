import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

//TripleShearRotate.java
//Allen Liu
//September 6, 2018
//A better approach at image rotation
//NOT FINISHED YET
public class TripleShearRotate {

	public static void main(String[] args) throws IOException {
		File input = new File("Algorithms/input.png");
		File a = new File("Algorithms/a.png");
		File b = new File("Algorithms/b.png");
		File output = new File("Algorithms/output.png");
		
		BufferedImage image = ImageIO.read(input);
		int width = image.getWidth();
		int height = image.getHeight();
		int centerX = width / 2;
		int centerY = height / 2;
		//Output
		BufferedImage aImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		BufferedImage bImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		BufferedImage newImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		
		double theta = Math.toRadians(30);
		
		for (int y = 0; y < height; ++y) {
			for (int x = 0; x < width; ++x) {
				//Set rotation point to center
				int transX = x - centerX;
				int transY = y - centerY;
				//Shear 1
				int firstX = (int) Math.round(transX - transY * Math.tan(theta / 2));
				//Shear 2
				int secondY = (int) Math.round((firstX * Math.sin(theta) + transY));
				//Shear 3
				int lastX =  (int) Math.round(firstX - secondY * Math.tan(theta / 2));
				
				try {
					aImage.setRGB(firstX + centerX, transY + centerY, image.getRGB(x, y));
				} catch (Exception e) {
				}
				
				try {
					bImage.setRGB(firstX + centerX, secondY + centerY, image.getRGB(x, y));
				} catch (Exception e) {
				}
				
				try {
					newImage.setRGB(lastX + centerX, secondY + centerY, image.getRGB(x, y));
				} catch (Exception e) {
				}
			}
		}
		ImageIO.write(aImage, "png", a);
		ImageIO.write(bImage, "png", b);
		ImageIO.write(newImage, "png", output);
	}

}
