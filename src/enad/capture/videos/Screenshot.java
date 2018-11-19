package enad.capture.videos;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/*Capture de l'écran*/

public class Screenshot {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {

			Robot robot = new Robot();

			// dimension de l'écran

			Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();

			// capture d'écran

			BufferedImage bi = robot.createScreenCapture(new Rectangle(dimension.width, dimension.height));

			// enregistrer l'image

			ImageIO.write(bi, "jpg", new File("captures/screenushot.jpg"));

			System.out.println("done");

		} catch (AWTException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
