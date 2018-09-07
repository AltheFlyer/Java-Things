import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class ImageReader {

	public static void main(String[] args) throws Exception {
		//Set/Get files to be read and written to
		File input = new File("Java Things/colortest.png");
		File output = new File("Java Things/output.png");
		
		//Get image to work with
		BufferedImage image = ImageIO.read(input);
		
		//Print out each pixel as R, G, B
		for (int y = 0; y <image.getHeight(); ++y) {
			for (int x = 0; x < image.getWidth(); ++x) { 
				Color a = new Color(image.getRGB(x, y));
				System.out.printf("%d, %d, %d\n", a.getRed(), a.getBlue(), a.getGreen());
			}
		}
		
		//Create Graphics2D to edit image
		Graphics2D draw = image.createGraphics();
		
		//Yellow
		draw.setColor(new Color(255, 255, 1));
		//Draws small rectangle
		draw.fillRect(0, 0, 5, 5);
		//Clear from memory
		draw.dispose();
		
		//Write edits made above to output file as png
		ImageIO.write(image, "png", output);
		
		System.out.println("drawn");
	}

}
